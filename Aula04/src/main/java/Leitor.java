import java.io.*;
import java.util.*;

public class Leitor {

    static Map<Long, Sujeito> sujeitos = new HashMap<>();
    static Map<String, List<Sujeito>> sujeitosPorGrupoSanguineo = new HashMap<>();

    public static void main(String[] args) {

        carregaSujeitos();
        escreveResultado();
        escreveBinario();

    }

    private static void escreveBinario() {
        try {
            BufferedOutputStream persistencia = new BufferedOutputStream(new FileOutputStream("persistencia.bin"));
            ObjectOutputStream objectOut = new ObjectOutputStream(persistencia);
            objectOut.writeObject(sujeitosPorGrupoSanguineo);
            objectOut.flush();
            objectOut.close();

            System.out.println("Arquivo binário gravado com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro durante escrita do arquivo binário");
            e.printStackTrace();
        }
    }

    private static void escreveResultado() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("resultado.txt"));
            StringBuilder strB = new StringBuilder();

            strB.append("RESULTADO EXECUCAO ");
            strB.append(Calendar.getInstance().getTime());
            strB.append("\n");

            for (String grupoSanguineo : sujeitosPorGrupoSanguineo.keySet()) {
                strB.append(grupoSanguineo);
                strB.append(": ");
                strB.append(sujeitosPorGrupoSanguineo.get(grupoSanguineo).size());
                strB.append("\n");
            }

            writer.append(strB);
            writer.flush();
            writer.close();

            System.out.println("Arquivo texto escrito com sucesso!");

        } catch (IOException e) {
            System.err.println("Erro durante escrita do arquivo texto");
            e.printStackTrace();
        }
    }

    private static void carregaSujeitos() {
        File arquivoTreinamento = new File("treinamento.csv");
        System.out.println(arquivoTreinamento.getAbsolutePath());
        System.out.println(arquivoTreinamento.exists());
        System.out.println(arquivoTreinamento.isDirectory());

        try {
            BufferedReader reader = new BufferedReader(new FileReader(arquivoTreinamento));
            String line = reader.readLine();
            System.out.println("Cabeçalho: " + line);

            line = reader.readLine();
            while (line != null) {
                Sujeito s = criarSujeito(line);
                sujeitos.put(s.getId(), s);

                List<Sujeito> listaDoGrupoSanguineo = sujeitosPorGrupoSanguineo.get(s.getGrupoSanguineo());
                if (listaDoGrupoSanguineo == null) {
                    listaDoGrupoSanguineo = new ArrayList<>();
                    sujeitosPorGrupoSanguineo.put(s.getGrupoSanguineo(), listaDoGrupoSanguineo);
                }

                listaDoGrupoSanguineo.add(s);

                line = reader.readLine();
            }

            System.out.println(sujeitos);
            System.out.println(sujeitosPorGrupoSanguineo);
            System.out.println("Carregado todo o arquivo");

        } catch (FileNotFoundException e) {
            System.err.println("Erro durante abertura do arquivo");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Erro durante leitura do arquivo");
            e.printStackTrace();
        }
    }

    private static Sujeito criarSujeito(String line) {
        String[] valores = line.split(";");
        Long id = Long.valueOf(valores[0]);
        boolean isMasculino = "M".equals(valores[1]);
        int idade = Integer.valueOf(valores[2]);
        String grupoSanguineo = valores[3];
        String sintomas = valores[4];
        boolean intervencao = "SIM".equals(valores[5]);
        boolean obito = "SIM".equals(valores[6]);

        return new Sujeito(id, isMasculino, idade, grupoSanguineo, sintomas, intervencao, obito);
    }


}
