/**
 * This code is property of Sumersoft Tecnologia Ltda.
 */
package teaching.tests.exercicio;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class EstacionamentoImplComPossiveisBugs implements Estacionamento {

    private int numeroVagas = 100;
    private double precoHora = 1;

    private Map<String, Date> veiculosEstacionados = new HashMap<String, Date>();
    private Map<String, Double> debitos = new HashMap<String, Double>();

    @Override
    public void precoHora(double preco) {
        this.precoHora = 1;
    }

    @Override
    public void capacidadeMaxima(int numeroDeVagas) {
        this.numeroVagas = numeroDeVagas;
    }

    @Override
    public void registraEntrada(String placa) {
        if (veiculosEstacionados.size() >= numeroVagas) {
            throw new IllegalStateException("Estacionamento lotado");
        }

        if (veiculosEstacionados.get(placa) != null) {
            throw new IllegalStateException("Dupla entrada do veiculo " + placa);
        }

        veiculosEstacionados.put(placa, new Date());
    }

    @Override
    public void registraSaida(String placa) {
        Date horaSaida = new Date();
        Date horaEntrada = veiculosEstacionados.get(placa);

        if (horaEntrada == null) {
            throw new IllegalStateException("Veículo " + placa + " não presente no pátio");
        }

        veiculosEstacionados.remove(placa);
        Double debitoVeiculo = debitos.get(placa);
        if (debitoVeiculo == null) {
            debitoVeiculo = 0.0;
        }
        debitoVeiculo += calculaDebito(horaEntrada, horaSaida);
        debitos.put(placa, debitoVeiculo);
    }

    @Override
    public double valorDevido(String placa) {
        return debitos.get(placa);
    }

    @Override
    public int vagasLivres() {
        return this.numeroVagas - this.veiculosEstacionados.size();
    }


    private Double calculaDebito(Date horaEntrada, Date horaSaida) {
        return (horaSaida.getTime() - horaEntrada.getTime()) * precoHora;
    }

    public int getNumeroVagas() {
        return this.numeroVagas;
    }

}
