package teaching.tests.exercicio;

public interface Estacionamento {

	public void registraEntrada(String placa);
	public void registraSaida(String placa);
	public double valorDevido(String placa);
	public int vagasLivres();

	public void precoHora(double preco);
	public void capacidadeMaxima(int numeroDeVagas);

}
