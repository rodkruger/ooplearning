import org.junit.Before;
import org.junit.Test;
import teaching.tests.exercicio.EstacionamentoImplComPossiveisBugs;

import static org.junit.Assert.assertEquals;


public class EstacionamentoTest {

    private EstacionamentoImplComPossiveisBugs estacionamento;

    private int idxVeiculo;

    private String veiculos[] = new String[]{
            "HZS-5652", "EDJ-0010", "JTF-7910", "MYR-0010", "MVN-5309", "HZU-3844", "HZX-3844", "LAU-5150",
            "KEQ-1635", "KGJ-9203", "MZW-7528", "KJZ-3610", "NBA-0719", "HZM-6805", "NAX-7971", "MWL-4853",
            "FVO-3401", "NEY-2314", "IAH-2820", "ANT-5867", "MVM-0280", "MVX-3296", "HPX-7913", "KAR-2706",
            "LTF-2270", "NCI-4686", "NEI-3220", "MNI-2179", "NAX-9600", "MOF-1878", "MUI-6351", "NAR-2720",
            "AZS-5652", "BDJ-0010", "CTF-7910", "DYR-0010", "FVN-5309", "GZU-3844", "HZU-3944", "GAU-5150",
            "AEQ-1635", "BGJ-9203", "CZW-7528", "DJZ-3610", "FBA-0719", "GZM-6805", "HAX-7971", "GWL-4853",
            "AVO-3401", "BEY-2314", "CAH-2820", "DNT-5867", "FVM-0280", "GVX-3296", "HPX-7919", "GAR-2706",
            "ATF-2270", "BCI-4686", "CEI-3220", "DNI-2179", "FAX-9600", "GOF-1878", "HUI-6351", "GAR-2720",
            "HZS-5650", "IDJ-0010", "JTF-7915", "KYR-0010", "LVN-5309", "MZU-3844", "NZU-3844", "OAU-5150",
            "HEQ-1635", "IGJ-9203", "JZW-7528", "KJZ-3614", "LBA-0719", "MZM-6805", "NAX-7970", "OWL-4853",
            "HVO-3401", "IEY-2314", "JAH-2820", "KNT-5867", "LVM-0280", "MVX-3290", "NPX-7913", "OAR-2706",
            "HTF-2270", "ICI-4686", "JEI-3220", "KNI-2179", "LAX-9600", "MOF-1870", "NUI-6351", "OAR-2720",
            "PZS-5652", "QDJ-0010", "RTF-7910", "SYR-0010", "TVN-5309", "UZU-3844", "VZU-3844", "XAU-5150",
            "PEQ-1635", "QGJ-9203", "RZW-7528", "SJZ-3610", "TBA-0719", "UZM-6805", "VAX-7971", "XWL-4853",
            "PVO-3401", "QEY-2314", "RAH-2820", "SNT-5867", "TVM-0280", "UVX-3296", "VPX-7913", "XAR-2706",
            "PTF-2270", "QCI-4686", "REI-3220", "SNI-2179", "TAX-9600", "UOF-1878", "VUI-6351", "XAR-2720",
            "WTF-2270", "ZCI-4686", "REI-1220", "SNI-3179", "TAX-4600", "UOF-5878", "VUI-7351", "XAR-8720"
    };

    @Before
    public void setUp() {
        this.estacionamento = new EstacionamentoImplComPossiveisBugs();

        this.estacionamento.precoHora(20);
    }

    @Test
    public void entradaSaidaSimples() {
        this.estacionamento.registraEntrada("ABC-1234");

        /*
         * encontrado um bug nesta parte
         * assertEquals(4, this.estacionamento.vagasLivres());
         */

        assertEquals(99, this.estacionamento.vagasLivres());

        this.estacionamento.registraSaida("ABC-1234");

        assertEquals(100, this.estacionamento.vagasLivres());
    }

    @Test
    public void multiplasEntradas() {

        entrarVeiculos(10);
        assertEquals((100 - 10), this.estacionamento.vagasLivres());

        entrarVeiculos(25);
        assertEquals((100 - 10 - 25), this.estacionamento.vagasLivres());

        entrarVeiculos(50);
        assertEquals((100 - 10 - 25 - 50), this.estacionamento.vagasLivres());

        entrarVeiculos(15);
        assertEquals((100 - 10 - 25 - 50 - 15), this.estacionamento.vagasLivres());

        // Estacionamento lotado!

        sairVeiculos(10);
        assertEquals((10), this.estacionamento.vagasLivres());

        sairVeiculos(25);
        assertEquals((10 + 25), this.estacionamento.vagasLivres());

        sairVeiculos(50);
        assertEquals((10 + 25 + 50), this.estacionamento.vagasLivres());

        sairVeiculos(15);
        assertEquals((10 + 25 + 50 + 15), this.estacionamento.vagasLivres());

        // Estacionamento vazio!
        assertEquals(100, this.estacionamento.vagasLivres());
    }

    @Test
    public void duplaEntrada() {

        try {
            this.estacionamento.registraEntrada(this.veiculos[0]);
            this.estacionamento.registraEntrada(this.veiculos[0]);
        } catch (IllegalStateException e) {
            assertEquals("Dupla entrada do veiculo " + this.veiculos[0], e.getMessage());
        }

    }

    @Test
    public void veiculoNaoPresente() {

        try {
            this.estacionamento.registraEntrada(this.veiculos[0]);
            this.estacionamento.registraEntrada(this.veiculos[1]);
            this.estacionamento.registraEntrada(this.veiculos[2]);
            this.estacionamento.registraSaida(this.veiculos[3]);
        } catch (IllegalStateException e) {
            assertEquals("Veículo " + this.veiculos[3] + " não presente no pátio", e.getMessage());
        }

    }

    @Test
    public void calcularValor() {
        try {
            this.estacionamento.registraEntrada(this.veiculos[0]);
            Thread.sleep(30000);
            this.estacionamento.registraSaida(this.veiculos[0]);
            assertEquals(30000.0, this.estacionamento.valorDevido(this.veiculos[0]), 1.0);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void alterarCapacidadeMaxima() {

        this.estacionamento.capacidadeMaxima(5);
        assertEquals(5, this.estacionamento.getNumeroVagas());

        entrarVeiculos(5);
        assertEquals(0, this.estacionamento.vagasLivres());

        this.estacionamento.capacidadeMaxima(20);
        assertEquals(20, this.estacionamento.getNumeroVagas());
        assertEquals(15, this.estacionamento.vagasLivres());

        entrarVeiculos(15);
        assertEquals(0, this.estacionamento.vagasLivres());

        sairVeiculos(20);
        assertEquals(20, this.estacionamento.vagasLivres());

    }


    @Test
    public void estacionamentoLotado() {

        this.estacionamento.capacidadeMaxima(5);
        entrarVeiculos(5);
        assertEquals(0, this.estacionamento.vagasLivres());

        try {
            entrarVeiculos(1);
        } catch (IllegalStateException e) {
            assertEquals("Estacionamento lotado", e.getMessage());
        }
    }

    protected void entrarVeiculos(int numVeiculos) {
        for (int i = 0; i < numVeiculos; i++) {
            this.estacionamento.registraEntrada(this.veiculos[idxVeiculo]);
            idxVeiculo++;
        }
    }

    protected void sairVeiculos(int numVeiculos) {
        for (int i = 0; i < numVeiculos; i++) {
            this.estacionamento.registraSaida(this.veiculos[idxVeiculo - 1]);
            idxVeiculo--;
        }
    }
}
