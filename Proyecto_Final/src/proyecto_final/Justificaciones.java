package proyecto_final;

/**
 *
 * @author josep
 */
public class Justificaciones {
    private int idJustificacion;
    private String observaciones;
    private String fecha;
    private int idGuia;

    public Justificaciones(int idJustificacion, String observaciones, String fecha, int idGuia) {
        this.idJustificacion = idJustificacion;
        this.observaciones = observaciones;
        this.fecha = fecha;
        this.idGuia = idGuia;
    }

    public int getIdJustificacion() {
        return idJustificacion;
    }

    public void setIdJustificacion(int idJustificacion) {
        this.idJustificacion = idJustificacion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getIdGuia() {
        return idGuia;
    }

    public void setIdGuia(int idGuia) {
        this.idGuia = idGuia;
    }
    
    
}
