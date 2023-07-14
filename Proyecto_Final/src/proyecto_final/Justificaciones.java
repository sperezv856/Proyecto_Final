package proyecto_final;

import java.util.Date;

/**
 *
 * @author josep
 */
/*Clase necesaria para crear el objeto Justificaciones con sus respectivos Getter
Setter y constructor*/
public class Justificaciones {
    private int idJustificacion;
    private String observaciones;
    private Date fecha;

    public Justificaciones(int idJustificacion, String observaciones, Date fecha) {
        this.idJustificacion = idJustificacion;
        this.observaciones = observaciones;
        this.fecha = fecha;
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
       
}
