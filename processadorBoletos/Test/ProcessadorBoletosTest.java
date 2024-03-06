import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProcessadorBoletoTest {

    private ProcessadorBoletos processador;
    private Fatura fatura;


    @BeforeEach
    void setup() {
        //will be used for instantiate some objects before tests
        processador = new ProcessadorBoletos();
        fatura = new Fatura("Joao", new Date(), 1500.00);
    }

    @Test
    public void testPagamentoCriado() {
        Boleto boleto = new Boleto("1", new Date(), 400.00);
        List<Boleto> boletos = new ArrayList<>();
        boletos.add(boleto);

        processador.processarBoletos(boletos, fatura);

        assertEquals(1, fatura.getPagamentos().size());
        Pagamento pagamento = fatura.getPagamentos().get(0);
        assertEquals(400.00, pagamento.getValorPago());
        assertEquals("BOLETO", pagamento.getTipo());
    }

    @Test
    public void testFaturaPaga() {
        Boleto boleto1 = new Boleto("1", new Date(), 500.00);
        Boleto boleto2 = new Boleto("2", new Date(), 400.00);
        Boleto boleto3 = new Boleto("3", new Date(), 600.00);
        List<Boleto> boletos = new ArrayList<>();
        boletos.add(boleto1);
        boletos.add(boleto2);
        boletos.add(boleto3);

        processador.processarBoletos(boletos, fatura);

        assertEquals("PAGA", fatura.getTipo());
    }

    @Test
    public void testFaturaNaoPaga() {
        Boleto boleto1 = new Boleto("1", new Date(), 500.00);
        Boleto boleto2 = new Boleto("2", new Date(), 400.00);
        List<Boleto> boletos = new ArrayList<>();
        boletos.add(boleto1);
        boletos.add(boleto2);

        processador.processarBoletos(boletos, fatura);

        assertEquals("NÃO PAGA", fatura.getTipo());
    }


}