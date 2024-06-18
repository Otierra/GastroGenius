package Gestion.Modelo;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ModeloReporte {
    private String fecha; 
    private int idOrden;
    private List<ModeloPedido> pedidos; 
    private double total; 

    public ModeloReporte(String fecha, int idOrden, List<ModeloPedido> pedidos, double total) {
        this.fecha = fecha;
        this.idOrden = idOrden;
        this.pedidos = pedidos;
        this.total = total;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public List<ModeloPedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<ModeloPedido> pedidos) {
        this.pedidos = pedidos;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    // Método para convertir la fecha de String a Date
    public Date getFechaAsDate() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.parse(fecha);
    }

    // Método para establecer la fecha como Date
    public void setFechaAsDate(Date fecha) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.fecha = dateFormat.format(fecha);
    }

    @Override
    public String toString() {
        return "ModeloReporte{" +
                "fecha='" + fecha + '\'' +
                ", idOrden=" + idOrden +
                ", pedidos=" + pedidos +
                ", total=" + total +
                '}';
    }
}
