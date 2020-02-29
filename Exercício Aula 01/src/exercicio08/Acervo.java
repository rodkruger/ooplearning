package exercicio08;

abstract public class Acervo {

    private String autor;

    private String titulo;

    private double custoDiario;

    public Acervo() {

    }

    public Acervo(String autor, String titulo) {
        this.autor = autor;
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getCustoDiario() {
        return custoDiario;
    }

    public void setCustoDiario(double custoDiario) {
        this.custoDiario = custoDiario;
    }

    abstract public String getTipo();
}
