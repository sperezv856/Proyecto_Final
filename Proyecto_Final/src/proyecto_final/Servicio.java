package proyecto_final;

import java.util.Date;

/**
 *
 * @author josep
 */
public class Servicio extends Sistema{
    private Date fechaServicio;
    private String observaciones;
    private String instrucciones;
    private int cedula;
    private int idTipoProducto;

    public Servicio(Date fechaServicio, String observaciones, String instrucciones, int cedula, int idTipoProducto, int idServicio) {
        super(idServicio);
        this.fechaServicio = fechaServicio;
        this.observaciones = observaciones;
        this.instrucciones = instrucciones;
        this.cedula = cedula;
        this.idTipoProducto = idTipoProducto;
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

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public int getIdTipoProducto() {
        return idTipoProducto;
    }

    public void setIdTipoProducto(int idTipoProducto) {
        this.idTipoProducto = idTipoProducto;
    }
}
