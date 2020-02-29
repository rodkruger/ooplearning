package exercicio06;

public class Retangulo {

    public int largura;
    public int altura;

    public void printArea() {
        System.out.println(largura * altura);
    }

    static public void main(String[] args) {
        Retangulo r = new Retangulo();
        r.altura = 20;
        r.largura = 30;
        r.printArea();

        r = new Retangulo();
        r.altura = 40;
        r.largura = 10;
        r.printArea();
    }
}
