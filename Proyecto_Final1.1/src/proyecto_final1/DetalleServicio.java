package proyecto_final1;

import java.util.Scanner;

/**
 *
 * @author josep
 */
/*Clase detalle de Servicio, aca se genera la clase principal
por medio de un objeto llamado DetalleServicio. Ademas se incluyen sus respectivos
Getter y Setter*/
public class DetalleServicio{
    Scanner scanner = new Scanner(System.in);
    private int idGuia;
    private int monto;
    private String observaciones;
    private String estado;

    public DetalleServicio(int idGuia, int monto, String observaciones, String estado) {
        this.idGuia = idGuia;
        this.monto = monto;
        this.observaciones = observaciones;
        this.estado = estado;
    }

    public int getIdGuia() {
        return idGuia;
    }

    public void setIdGuia(int idGuia) {
        this.idGuia = idGuia;
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
    /*Esta funcion solicita al usuario los datos necesarios para crear el objeto Detalle de servicio
    Nota: Estoy evaluando si esta funcion deberia de ir aca o en la clase de DetalleServicio*/
    public DetalleServicio crearDetalle() {
        System.out.println("Indique el numero de guia para el servicio: ");
        int idGuia = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Indique el monto del servicio: ");
        int monto = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Indique las observaciones del servicio: ");
        String observaciones = scanner.nextLine();
        System.out.println("Indique el estado del servicio (Generada / En transito / Entregada / No entregada): ");
        String estado = scanner.nextLine();
        DetalleServicio detalle = new DetalleServicio(idGuia, monto, observaciones, estado);
        detalle.setIdGuia(idGuia);
        detalle.setObservaciones(observaciones);
        detalle.setMonto(monto);
        detalle.setEstado(estado);
        return detalle;
    }
    
}
