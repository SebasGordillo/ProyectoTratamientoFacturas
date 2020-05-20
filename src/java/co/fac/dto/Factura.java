package co.fac.dto;

import java.util.Date;

/**
 *
 * @author Sebas Gordillo
 */
public class Factura {

    private int idFactura;
    private Date fecha;
    private int hora;
    private Cliente Cliente;
    private double valor;
    private Zona Zona;

    public Factura() {
    }

    public Factura(int idFactura, Date fecha, int hora, Cliente Cliente, double valor, Zona Zona) {
        this.idFactura = idFactura;
        this.fecha = fecha;
        this.hora = hora;
        this.Cliente = Cliente;
        this.valor = valor;
        this.Zona = Zona;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    
    

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public Cliente getCliente() {
        return Cliente;
    }

    public void setCliente(Cliente Cliente) {
        this.Cliente = Cliente;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Zona getZona() {
        return Zona;
    }

    public void setZona(Zona Zona) {
        this.Zona = Zona;
    }

    @Override
    public String toString() {
        return "Factura{" + "fecha=" + fecha + ", hora=" + hora + ", Cliente=" + Cliente + ", valor=" + valor + ", Zona=" + Zona + '}';
    }
    
    
}
