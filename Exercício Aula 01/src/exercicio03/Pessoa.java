package exercicio03;

import java.util.Date;

public class Pessoa {

    public String nome;             // Visível publicamente

    protected Date dataNascimento;  // Visível para esta classe e suas subclasses

    String rg;                      // Visível para as classes do mesmo pacote (exercicio03)

    private int cpf;                // Visível somente para esta classe

}
