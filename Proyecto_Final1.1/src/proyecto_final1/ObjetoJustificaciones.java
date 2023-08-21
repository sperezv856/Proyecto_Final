package proyecto_final1;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author josep
 */
/*Esta clase es la encargada de crear un objeto llamado ObjetoJustificaciones, su
funcion principal es crear un solo objeto final juntando los objetos de Guia (con sus
subobjetos que lo componen, con el objeto Justificaciones, tambien incluyen sus Getter
y Setter correspondientes*/
public class ObjetoJustificaciones {
    Scanner scanner = new Scanner(System.in);
    private Guia guia;
    private Justificaciones justificaciones;
    private ManejoJustificaciones manejoJustificaciones;
    private ManejoGuia manejoGuia;
    private Priorizar priorizar;
    private ObjetoGestor objetoGestor;

    public ObjetoJustificaciones(ObjetoGestor objetoGestor, Justificaciones justificaciones) {
        this.objetoGestor = objetoGestor;
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
    //En este metodo juntamos la parte de Guia con las justificaciones
    public ObjetoJustificaciones CrearEntrada(ObjetoGestor objetoGestor){
        System.out.println("Ingrese el Id de la justificacion:");
        int idJustificacion = scanner.nextInt();
        scanner.nextLine();
        justificaciones = manejoJustificaciones.BuscarJustificaciones(idJustificacion);
        Date fecha = new Date();
        ObjetoJustificaciones objetoJustificaciones = new ObjetoJustificaciones(objetoGestor, justificaciones);
        objetoJustificaciones.justificaciones.setFecha(fecha);
        objetoJustificaciones.getGuia().getDetalle().setEstado("No entregada");
        return objetoJustificaciones;
    }
}
