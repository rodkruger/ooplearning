package exercicio08;

public class Biblioteca {

    private Acervo[] acervo;

    public Biblioteca(Acervo[] acervo) {
        this.acervo = acervo;
    }

    public void comprar(Acervo item, Leitor leitor) {
        // calcular custo e efetuar a compra
    }

    public void locar(Acervo item, Leitor leitor) {
        // calcular custo e efetuar a locação
    }

    public void devolver(Acervo item, Leitor leitor) {
        // calcular custo e efetuar a devolução
    }

    public void listarAcervo() {
        for (Acervo item : this.acervo) {
            System.out.println("Título: " + item.getTitulo() + "; Autor: " + item.getAutor() + "; Tipo: " + item.getTipo());
        }
    }

    public static void main(String args[]) {
        Biblioteca b = new Biblioteca(new Acervo[]{
                new Livro("Charles Duwig", "O poder do hábito"),
                new CD("Iron Maiden", "Brave New World"),
                new DVD("George Lucas", "Star Wars - Episode V: The Empire Strikes Back"),
        });

        b.listarAcervo();
    }
}