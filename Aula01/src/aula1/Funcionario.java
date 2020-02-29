package aula1;

import java.util.Date;

public class Funcionario {

    static int quantidadeFuncionarios = 0;

    protected String nome;

    private Date nascimento;

    public Funcionario() {

    }

    public Funcionario(String nome) {
        this.nome = nome;
        nascimento = new Date();
        quantidadeFuncionarios++;
    }

    public void exemploExcecao() {

        try {

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }

    }

    class FuncionarioComissionado extends Funcionario {
        public FuncionarioComissionado() {

        }
    }

    public static void main(String[] args) {
        Funcionario f1 = new Funcionario("Fernanda");
        Funcionario f2 = new Funcionario("Maria");
    }
}
