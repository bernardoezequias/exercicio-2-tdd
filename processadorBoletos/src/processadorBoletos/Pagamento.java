package processadorBoletos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pagamento {
    private double valorPago;
    private Date date;
    private String tipo;
    public Pagamento(double valorPago, Date date, String tipo) {
        this.valorPago = valorPago;
        this.date = date;
        this.tipo = tipo;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
