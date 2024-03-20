package processadorBoletos;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProcessorFunctionalTest {
    ProcessadorBoletos processador;
    Fatura fatura;


    @BeforeEach
    void setup() {
        //will be used for instantiate some objects before tests
        processador = new ProcessadorBoletos();
    }

    @Test
    public void testFaturaNegativa() {
        fatura = new Fatura("Joao", new Date(), -1500.00);
        throw new IllegalArgumentException("processadorBoletos.Fatura com valor negativo");
    }

    @Test
    public void testFaturaZero() {
        fatura = new Fatura("Joao", new Date(), 0);
        throw new IllegalArgumentException("processadorBoletos.Fatura com valor zero");
    }

    @Test
    public void testFaturaValorPositivo() {
        fatura = new Fatura("Joao", new Date(), 1500);
        assertEquals(fatura.getValorTotal(), 1500);
    }

    @Test
    public void testBoletosPagosValorMenorQueFatura() {
        fatura = new Fatura("Joao", new Date(), 1500);
        Boleto boleto1 = new Boleto("1", new Date(), 500.00);
        Boleto boleto2 = new Boleto("2", new Date(), 400.00);
        List<Boleto> boletos = new ArrayList<>();
        boletos.add(boleto1);
        boletos.add(boleto2);

        processador.processarBoletos(boletos, fatura);

        assertEquals("NÃO PAGA", fatura.getTipo());
    }

    @Test
    public void testBoletosPagosValorIgualFatura() {
        fatura = new Fatura("Joao", new Date(), 1500);
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
    public void testBoletosPagosValorMaiorFatura() {
        fatura = new Fatura("Joao", new Date(), 1500);
        Boleto boleto1 = new Boleto("1", new Date(), 1000.00);
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
    public void testBoletoNegativo() {
        Boleto boleto = new Boleto("1", new Date(), -1000.00);
        throw new IllegalArgumentException("processadorBoletos.Boleto com valor negativo");
    }

    @Test
    public void testBoletoZero() {
        Boleto boleto = new Boleto("1", new Date(), 0);
        throw new IllegalArgumentException("processadorBoletos.Boleto com valor Zero");
    }

    @Test
    public void testBoletoPositivo() {
        Boleto boleto = new Boleto("1", new Date(), 1000.00);
        assertEquals(boleto.getCodigo(), "1");
    }
}
