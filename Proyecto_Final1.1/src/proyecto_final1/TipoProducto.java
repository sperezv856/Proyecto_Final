package proyecto_final1;

/**
 *
 * @author josep
 */
//Clase para generar el objeto TipoProducto con sus Getter y Setter
public class TipoProducto {
    private int idTipoProducto;
    private int monto;
    private String observaciones;
    private String estado;

    public TipoProducto(int idTipoProducto, int monto, String observaciones, String estado) {
        this.idTipoProducto = idTipoProducto;
        this.monto = monto;
        this.observaciones = observaciones;
        this.estado = estado;
    }

    public int getIdTipoProducto() {
        return idTipoProducto;
    }

    public void setIdTipoProducto(int idTipoProducto) {
        this.idTipoProducto = idTipoProducto;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Id del producto: "+ getIdTipoProducto()+" Observaciones: "+getObservaciones()+" Monto: "+getMonto() +" Estado: "+ getEstado();
    }
 
}
