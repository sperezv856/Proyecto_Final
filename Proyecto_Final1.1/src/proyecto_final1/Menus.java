package proyecto_final1;

import java.util.Scanner;

/**
 *
 * @author josep
 */
public class Menus {

    int opcion = 0;
    Scanner scanner = new Scanner(System.in);
    ManejoCliente manejoCliente = new ManejoCliente();
    

    public static void MostrarOpcionesPrincipal() {
        System.out.println("-------- MENÚ PRINCIPAL -------");
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

    public void EscogerOpcionPrincipal() {
        manejoCliente.inicializarLista();
        do {
            MostrarOpcionesPrincipal();
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1 -> {
                    EscogerOpcionCliente();
                }

                default -> System.out.println("Opcion incorrecta, intente de nuevo.");
            }
        } while (opcion != 8);
    }

    public void MostrarMenuCliente() {
        System.out.println("-------- MENÚ CLIENTE -------");
        System.out.println("----- Programa de mensajeria -----");
        System.out.println("1. Ingresar Cliente");
        System.out.println("2. Buscar Cliente");
        System.out.println("3. Eliminar Cliente");
        System.out.println("4. Modificar Cliente");
        System.out.println("5. Mostrar lista de Clientes");
        System.out.println("6. Regresar al menu anterior");
        System.out.println("Seleccione una opcion: ");
    }
    public void EscogerOpcionCliente() {
        manejoCliente.inicializarLista();
        do {
            MostrarMenuCliente();
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1 -> {
                    
                    manejoCliente.IngresarCliente();
                    break;
                }
                case 2 -> {
                    System.out.println("Ingrese el numero de cedula a buscar: ");
                    int ced = scanner.nextInt();
                    manejoCliente.buscarCliente(ced);
                    break;
                }
                case 3 -> {
                    System.out.println("Ingrese el numero de cedula a eliminar: ");
                    int ced = scanner.nextInt();
                    manejoCliente.EliminarCliente(ced);
                    break;
                }
                case 4 -> {
                    System.out.println("Ingrese el numero de cedula a modificar: ");
                    int ced = scanner.nextInt();
                    manejoCliente.ModificarCliente(ced);
                    break;
                }
                

                default -> System.out.println("Opcion incorrecta, intente de nuevo.");
            }
        } while (opcion != 6);
    }
}
