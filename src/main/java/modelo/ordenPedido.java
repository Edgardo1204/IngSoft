package modelo;

//@author Jesus

import java.util.Date;


public class ordenPedido {
    private String folioP;
    private String cliente;
    private String telefono;
    private Date fecha;
    private String pedido[];

    public String getFolioP() {
        return folioP;
    }

    public void setFolioP(String folioP) {
        this.folioP = folioP;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String[] getPedido() {
        return pedido;
    }

    public void setPedido(String[] pedido) {
        this.pedido = pedido;
    }
    
    

}
