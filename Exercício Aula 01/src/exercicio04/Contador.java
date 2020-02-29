package exercicio04;

public class Contador {

    public static void main(String args[]) {
        Object[] objetos = null;
        Contador contador = new Contador();

        contador.contar(objetos);

        objetos = new Object[]{
                "Objeto 1", "Objeto 2", "Objeto 3", "Objeto 4", "Objeto 5", "Objeto 6"
        };

        contador.contar(objetos);
    }

    public void contar(Object[] objetos) {

        try {
            int contador = 0;

            for (int i = 0; i < objetos.length; i++) {
                contador++;
            }

            System.out.println(("Há " + contador + " items na lista"));
        } catch (Exception e) {
            System.out.println("Lista inválida: " + e.getMessage());
        }

    }

}
