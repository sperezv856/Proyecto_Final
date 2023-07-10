package proyecto_final;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author josep
 */
public class ObjetoJustificaciones {
    Scanner scanner = new Scanner(System.in);
    private Guia guia;
    private Justificaciones justificaciones;

    public ObjetoJustificaciones(Guia guia, Justificaciones justificaciones) {
        this.guia = guia;
        this.justificaciones = justificaciones;
    }

    public Guia getGuia() {
        return guia;
    }

    public void setGuia(Guia guia) {
        this.guia = guia;
    }

    public Justificaciones getJustificaciones() {
        return justificaciones;
    }

    public void setJustificaciones(Justificaciones justificaciones) {
        this.justificaciones = justificaciones;
    }
    public void CrearEntrada(){
        setJustificaciones(crearJustificacion());
        ObjetoJustificaciones objetoJustificaciones = new ObjetoJustificaciones(guia, justificaciones);
    }
    public Justificaciones crearJustificacion(){
        Date fecha = new Date();
        System.out.println("Indique el numero de ID de la justificacion: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Agregue las observaciones : ");
        String obs = scanner.nextLine();
        Justificaciones justificacion = new Justificaciones(id, obs, fecha);
        justificacion.setIdJustificacion(id);
        justificacion.setObservaciones(obs);
        justificacion.setFecha(fecha);
        return justificacion;
    }
}
