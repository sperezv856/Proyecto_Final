package proyecto_final;

import java.util.Date;

/**
 *
 * @author josep
 */
public class Servicio{
    private int IdServicio;
    private Date fechaServicio;
    private String observaciones;
    private String instrucciones;

    public Servicio(Date fechaServicio, String observaciones, String instrucciones, int cedula, int idTipoProducto, int IdServicio) {
        this.IdServicio = IdServicio;
        this.fechaServicio = fechaServicio;
        this.observaciones = observaciones;
        this.instrucciones = instrucciones;
    }

    public int getIdServicio() {
        return IdServicio;
    }

    public void setIdServicio(int IdServicio) {
        this.IdServicio = IdServicio;
    }

    public Date getFechaServicio() {
        return fechaServicio;
    }

    public void setFechaServicio(Date fechaServicio) {
        this.fechaServicio = fechaServicio;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getInstrucciones() {
        return instrucciones;
    }

    public void setInstrucciones(String instrucciones) {
        this.instrucciones = instrucciones;
    }
}
