package junit5Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import processadorBoletos.Boleto;
import processadorBoletos.Fatura;
import processadorBoletos.ProcessadorBoletos;

@Tag("BillProcess")
public class Atividade4 {

    private ProcessadorBoletos processador;
    private Fatura fatura;

    @BeforeEach
    void setup() {
        processador = new ProcessadorBoletos();
    }

    @AfterEach
    void afterSetup() {
        processador = null;
        fatura = null;
    }

    @Test
    @DisplayName("Teste para criar Fatura com valor negativo")
    @Tag("Create")
    public void testCriarFaturaNegativa() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Fatura("Joao", new Date(), -1500.00);
        });
    }

    @Test
    @DisplayName("Teste para criar Fatura com valor zero")
    @Tag("Create")
    public void testCriarFaturaZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Fatura("Joao", new Date(), 0);
        });
    }

    @Test
    @DisplayName("Teste para criar Fatura com valor positivo")
    @Tag("Create")
    public void testCriarFaturaValorPositivo() {
        fatura = new Fatura("Joao", new Date(), 1500);
        assertEquals(1500, fatura.getValorTotal());
    }

    @Test
    @DisplayName("Teste para processar Boletos com valor menor que a Fatura")
    @Tag("BillProcess")
    public void testProcessarBoletosValorMenorQueFatura() {
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
    @DisplayName("Teste para processar Boletos com valor igual à Fatura")
    @Tag("BillProcess")
    public void testProcessarBoletosValorIgualFatura() {
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
    @DisplayName("Teste para processar Boletos com valor maior que a Fatura")
    @Tag("BillProcess")
    public void testProcessarBoletosValorMaiorFatura() {
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
    @DisplayName("Teste para criar Boleto com valor negativo")
    @Tag("Create")
    public void testCriarBoletoNegativo() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Boleto("1", new Date(), -1000.00);
        });
    }

    @Test
    @DisplayName("Teste para criar Boleto com valor zero")
    @Tag("Create")
    public void testCriarBoletoZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Boleto("1", new Date(), 0);
        });
    }

    @Test
    @DisplayName("Teste para criar Boleto com valor positivo")
    @Tag("Create")
    public void testCriarBoletoPositivo() {
        Boleto boleto = new Boleto("1", new Date(), 1000.00);
        assertEquals("1", boleto.getCodigo());
    }
}
