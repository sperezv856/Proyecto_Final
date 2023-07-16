package proyecto_final;

import java.util.Scanner;

/**
 *
 * @author josep
 */
public class Menus {

    int opcion = 0;
    Scanner scanner = new Scanner(System.in);

    public void MostrarOpcionesPrincipal() {
        System.out.println("-------- MENÚ PRINCIPAL -------");
        System.out.println("----- Programa de mensajeria -----");
        System.out.println("1. Ingresar Cliente");
        System.out.println("2. Menu Guia");
        System.out.println("3. Menu Servicio");
        System.out.println("4. Menu Ruta");
        System.out.println("5. Menu Producto");
        System.out.println("6. Menu Justificaciones");
        System.out.println("6. Menu Gestor");
        System.out.println("7. Menu controles");
        System.out.println("8. Salir");
        System.out.println("Seleccione una opcion: ");
    }

    public void EscogerOpcionPrincipal() {
        do {
            Scanner scanner = new Scanner(System.in);
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    String email = null,
                     direccion = null,
                     NombreCompleto = null,
                     estado = null;
                    int telefono = 0,
                     cedula = 0;
                    Cliente cliente = new Cliente(email, direccion, telefono, cedula, NombreCompleto, estado);
                    cliente.crearCliente();
                    break;
                /*case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;*/
                default:
                    System.out.println("Opcion incorrecta, intente de nuevo.");
            }
        } while (opcion != 8);
    }

    public void MostrarMenuCliente() {
        System.out.println("-------- MENÚ CLIENTE -------");
        System.out.println("----- Programa de mensajeria -----");
        System.out.println("1. Menu Cliente");
        System.out.println("2. Menu Guia");
        System.out.println("3. Menu Servicio");
        System.out.println("4. Menu Ruta");
        System.out.println("5. Menu Producto");
        System.out.println("6. Menu Justificaciones");
        System.out.println("6. Menu Gestor");
        System.out.println("7. Menu controles");
        System.out.println("8. Salir");
        System.out.println("Seleccione una opcion: ");
    }
}
