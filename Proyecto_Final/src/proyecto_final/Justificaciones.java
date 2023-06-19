package proyecto_final;

import java.util.Date;

/**
 *
 * @author josep
 */
public class Justificaciones {
    private int idJustificacion;
    private String observaciones;
    private Date fecha;
    private int idGuia;

    public Justificaciones(int idJustificacion, String observaciones, Date fecha, int idGuia) {
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getIdGuia() {
        return idGuia;
    }

    public void setIdGuia(int idGuia) {
        this.idGuia = idGuia;
    }
    
    
}
