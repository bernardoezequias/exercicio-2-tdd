package processadorBoletos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Fatura {
    List<Pagamento> pagamentos;
    private String name;
    private Date date;
    private double valorTotal;
    private String tipo;
    public Fatura(String name, Date date, double valorTotal) {
        if (valorTotal <= 0) {
          throw new IllegalArgumentException();
        }
        this.date = date;
        this.name = name;
        this.valorTotal = valorTotal;
        this.tipo = "NÃO PAGA";
        this.pagamentos = new ArrayList<>();
    }

    public List<Pagamento> getPagamentos() {
        return pagamentos;
    }

    public String getPagamento() {
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void addPagamento(Pagamento pagamento) {
        pagamentos.add(pagamento);
    }
}
