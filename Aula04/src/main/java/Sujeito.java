import java.io.Serializable;

public class Sujeito implements Serializable {

    private long id;
    private boolean isMasculino;
    private int idade;
    private String grupoSanguineo;
    private String sintomas;
    private boolean intervencao;
    private boolean obito;

    public Sujeito(long id, boolean isMasculino, int idade, String grupoSanguineo, String sintomas, boolean intervencao, boolean obito) {
        this.id = id;
        this.isMasculino = isMasculino;
        this.idade = idade;
        this.grupoSanguineo = grupoSanguineo;
        this.sintomas = sintomas;
        this.intervencao = intervencao;
        this.obito = obito;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isMasculino() {
        return isMasculino;
    }

    public void setMasculino(boolean masculino) {
        isMasculino = masculino;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public boolean isIntervencao() {
        return intervencao;
    }

    public void setIntervencao(boolean intervencao) {
        this.intervencao = intervencao;
    }

    public boolean isObito() {
        return obito;
    }

    public void setObito(boolean obito) {
        this.obito = obito;
    }

    @Override
    public String toString() {
        return "Sujeito{" +
                "id=" + id +
                ", isMasculino=" + isMasculino +
                ", idade=" + idade +
                ", grupoSanguineo='" + grupoSanguineo + '\'' +
                ", sintomas='" + sintomas + '\'' +
                ", intervencao=" + intervencao +
                ", obito=" + obito +
                '}';
    }
}
