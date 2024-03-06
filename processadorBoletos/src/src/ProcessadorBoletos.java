import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProcessadorBoletos {
    public ProcessadorBoletos(){}

    public void processarBoletos(List<Boleto> boletos, Fatura fatura) {
        int valorTotal = 0;

        for(Boleto boleto : boletos){
            valorTotal += boleto.getValorPago();
            Pagamento pagamento = new Pagamento(boleto.getValorPago(), new Date(), "BOLETO");
            fatura.addPagamento(pagamento);
        }

        if (valorTotal >= fatura.getValorTotal()) {
            fatura.setTipo("PAGA");
        }
    }
}
