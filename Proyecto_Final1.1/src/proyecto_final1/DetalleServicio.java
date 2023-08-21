package proyecto_final1;

import java.util.Scanner;

/**
 *
 * @author josep
 */
/*Clase detalle de Servicio, aca se genera la clase principal
por medio de un objeto llamado DetalleServicio. Ademas se incluyen sus respectivos
Getter y Setter*/
public class DetalleServicio {

    Scanner scanner = new Scanner(System.in);
    private int idGuia;
    private double monto;
    private String observaciones;
    private String estado;
    int detMonto = 0;

    public DetalleServicio(int idGuia, double monto, String observaciones, String estado) {
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

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
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
        boolean continuar = true;
        do {
            System.out.println(" -------------- Opciones -----------------");
            System.out.println("1. Servicio Premium. ");
            System.out.println("2. Servicio Standard. ");
            System.out.println("3. Servicio Economico");
            System.out.println("4. Salir");
            System.out.println("Seleccione una opcion: ");
            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    detMonto = 50000;
                    continuar = false;
                    break;
                case 2:
                    detMonto = 30000;
                    continuar = false;
                    break;
                case 3:
                    detMonto = 25000;
                    continuar = false;
                    break;
                case 4:
                    System.out.println("Regresando");
                    continuar = false;
                    break;

            }
        } while (continuar);
        System.out.println("Monto del servicio: " + detMonto);

        scanner.nextLine();
        System.out.println("Indique las observaciones del servicio: ");
        String observaciones = scanner.nextLine();
        System.out.println("Estado de Guia: Generada");
        String estado = "Generada";
        DetalleServicio detalle = new DetalleServicio(idGuia, detMonto, observaciones, estado);
        detalle.setIdGuia(idGuia);
        detalle.setObservaciones(observaciones);
        detalle.setMonto(detMonto);
        detalle.setEstado(estado);
        return detalle;
    }

    @Override
    public String toString() {
        return "Id Guia: "+ getIdGuia()+ " Observaciones: "+getObservaciones()+ " Monto: "+ getMonto()+ " Estado del servicio: "+ getEstado();
    }

}
