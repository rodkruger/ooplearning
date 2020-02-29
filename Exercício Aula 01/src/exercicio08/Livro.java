package exercicio08;

public class Livro extends Acervo {

    public Livro() {
        super();
    }

    public Livro(String autor, String titulo) {
        super(autor, titulo);
    }

    @Override
    public String getTipo() {
        return "Livro";
    }

}
