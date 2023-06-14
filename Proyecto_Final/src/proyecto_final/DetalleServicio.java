package proyecto_final;

/**
 *
 * @author josep
 */
public class DetalleServicio extends Sistema{
    private int monto;
    private String observaciones;
    private String estado;

    public DetalleServicio(int monto, String observaciones, String estado, int idServicio) {
        super(idServicio);
        this.monto = monto;
        this.observaciones = observaciones;
        this.estado = estado;
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
    
    
}
