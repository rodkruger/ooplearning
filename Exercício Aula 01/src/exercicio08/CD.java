package exercicio08;

public class CD extends Acervo {

    private double duracao;

    public CD() {
        super();
    }

    public CD(String autor, String titulo) {
        super(autor, titulo);
    }

    @Override
    public String getTipo() {
        return "CD";
    }

}
