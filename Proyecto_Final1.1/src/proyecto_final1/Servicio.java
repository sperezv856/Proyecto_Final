package proyecto_final1;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author josep
 */
// Clase para generar el objeto Servicio con sus Getter y Setter
public class Servicio{
    Scanner scanner = new Scanner(System.in);
    private int IdServicio;
    private Date fechaServicio;
    private String observaciones;
    private String instrucciones;

    public Servicio(Date fechaServicio, String observaciones, String instrucciones, int IdServicio) {
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
     /*Esta funcion solicita al usuario los datos necesarios para crear el objeto Servicio
    Nota: Estoy evaluando si esta funcion deberia de ir aca o en la clase de Servicio*/
    public Servicio crearServicio() {
        Date fecha = new Date();
        System.out.println("Indique el Id del servicio: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingrese las observaciones: ");
        String observaciones = scanner.nextLine();
        System.out.println("Ingrese las instrucciones del servicio: ");
        String instrucciones = scanner.nextLine();
        Servicio servicio = new Servicio(fecha, observaciones, instrucciones, id);
        servicio.setFechaServicio(fecha);
        servicio.setIdServicio(id);
        servicio.setObservaciones(observaciones);
        servicio.setInstrucciones(instrucciones);

        return servicio;
    }

    @Override
    public String toString() {
        return "Id de servicio: "+ getIdServicio()+ " Fecha de servicio: "+ getFechaServicio()+ " Observaciones: "+ getObservaciones() + " Instrucciones: "+ getInstrucciones();
    }
    
}
