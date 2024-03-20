package processadorBoletos;

import java.util.Date;

public class Boleto {
    private String codigo;
    private Date date;
    private double valorPago;
    public Boleto(String codigo, Date date, double valorPago) {
        this.codigo = codigo;
        this.date = date;
        this.valorPago = valorPago;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }
}
