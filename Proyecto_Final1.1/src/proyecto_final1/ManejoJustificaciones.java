import java.util.Date;
import java.util.Scanner;

public class ManejoJustificaciones {
    Scanner scanner = new Scanner(System.in);
    private Justificaciones vectorPila[];
    private int cima;

    public ManejoJustificaciones(int tamano) {
        vectorPila = new Justificaciones[tamano];
        cima = 0;
    }

    // ... (resto del código)

    public Justificaciones crearJustificacion(Justificaciones justificaciones) {
        try {
            System.out.println("Indique el numero de id:");
            int idJustificacion = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Ingrese las observaciones:");
            String observaciones = scanner.nextLine();
            Date fecha = new Date();
            justificaciones = new Justificaciones(idJustificacion, observaciones, fecha);
            justificaciones.setIdJustificacion(idJustificacion);
            justificaciones.setObservaciones(observaciones);
            justificaciones.setFecha(fecha);
        } catch (Exception e) {
            System.out.println("Error al crear justificación: " + e.getMessage());
        }
        return justificaciones;
    }

    public void push(Justificaciones justificacion) {
        try {
            if (pilaLlena(tamano()) == false) {
                vectorPila[getCima()] = justificacion;
                setCima(getCima() + 1);
            } else {
                System.out.println("La pila esta llena. ");
            }
        } catch (Exception e) {
            System.out.println("Error al hacer push: " + e.getMessage());
        }
    }

    public Justificaciones popJustificaciones() {
        Justificaciones eliminar = null;
        try {
            if (getCima() == 0) {
                System.out.println("La pila esta vacia. ");
            } else {
                setCima(getCima() - 1);
                eliminar = vectorPila[getCima()];
            }
        } catch (Exception e) {
            System.out.println("Error al hacer pop: " + e.getMessage());
        }
        return eliminar;
    }

    // ... (resto del código)

    public void LimpiarJustificaciones() {
        try {
            while (!pilaVacia()) {
                popJustificaciones();
            }
            System.out.println("Justificaciones eliminadas");
        } catch (Exception e) {
            System.out.println("Error al limpiar justificaciones: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Puedes agregar tu código de prueba aquí si lo deseas
    }
}
