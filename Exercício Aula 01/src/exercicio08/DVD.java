package exercicio08;

public class DVD extends Acervo {

    private double duracao;

    public DVD() {
        super();
    }

    public DVD(String autor, String titulo) {
        super(autor, titulo);
    }

    @Override
    public String getTipo() {
        return "DVD";
    }

}
