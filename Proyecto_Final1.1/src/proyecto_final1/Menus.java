package proyecto_final1;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author josep
 */
public class Menus {

    int opcion = 0;
    Scanner scanner = new Scanner(System.in);
    private Date fechaServicio = null;
    private String observaciones = null, instrucciones = null, estado = null;
    private int IdServicio = 0, idGuia =0, monto= 0;
    ManejoCliente manejoCliente = new ManejoCliente();
    ManejoProductos manejoProductos = new ManejoProductos();
    Servicio servicio =  new Servicio(fechaServicio, observaciones, instrucciones, IdServicio);
    DetalleServicio detalle = new DetalleServicio(idGuia, monto, observaciones, estado);
   
    Guia guia = new Guia(manejoCliente, servicio, detalle, manejoProductos);
    ManejoGuia manejoGuia = new ManejoGuia(30);
    

    public static void MostrarOpcionesPrincipal() {
        System.out.println("-------- MENÚ PRINCIPAL -------");
        System.out.println("----- Programa de mensajeria -----");
        System.out.println("1. Menu Cliente");
        System.out.println("2. Menu Producto");
        System.out.println("3. Menu Guia");
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
        manejoProductos.inicializarLista();
        do {
            MostrarOpcionesPrincipal();
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1 -> {
                    EscogerOpcionCliente();
                }
                case 2 -> {
                    EscogerOpcionProductos();
                }
                case 3 -> {
                    EscogerOpcionGuia();
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
                case 5 -> {
                    manejoCliente.MostrarClientes();
                    break;
                }
                

                default -> System.out.println("Opcion incorrecta, intente de nuevo.");
            }
        } while (opcion != 6);
    }
    public void MostrarMenuProducto() {
        System.out.println("-------- MENÚ PRODUCTO -------");
        System.out.println("----- Programa de mensajeria -----");
        System.out.println("1. Ingresar Producto");
        System.out.println("2. Buscar Producto");
        System.out.println("3. Eliminar Producto");
        System.out.println("4. Modificar Producto");
        System.out.println("5. Mostrar lista de Productos");
        System.out.println("6. Regresar al menu anterior");
        System.out.println("Seleccione una opcion: ");
    }
    public void EscogerOpcionProductos() {
        do {
            MostrarMenuProducto();
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1 -> {
                    
                    manejoProductos.IngresarProducto();
                    break;
                }
                case 2 -> {
                    System.out.println("Ingrese el numero de id a buscar: ");
                    int cdp = scanner.nextInt();
                    manejoProductos.buscarProducto(cdp);
                    break;
                }
                case 3 -> {
                    System.out.println("Ingrese el numero de id a eliminar: ");
                    int cdp = scanner.nextInt();
                    manejoProductos.EliminarProducto(cdp);
                    break;
                }
                case 4 -> {
                    System.out.println("Ingrese el numero de id a modificar: ");
                    int cdp = scanner.nextInt();
                    manejoProductos.ModificarProducto(cdp);
                    break;
                }
                case 5 -> {
                    manejoProductos.MostrarProductos();
                    break;
                }
                

                default -> System.out.println("Opcion incorrecta, intente de nuevo.");
            }
        } while (opcion != 6);
    }
    public void MostrarMenuGuia() {
        System.out.println("-------- MENÚ Guia -------");
        System.out.println("----- Programa de mensajeria -----");
        System.out.println("1. Ingresar Guia");
        System.out.println("2. Eliminar Guia");
        System.out.println("3. Mostrar las Guias");
        System.out.println("4. Buscar Guia");
        System.out.println("5. Mostrar la cantidad de guias");
        System.out.println("6. Regresar al menu anterior");
        System.out.println("Seleccione una opcion: ");
    }
    public void EscogerOpcionGuia() {
        do {
            MostrarMenuGuia();
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1 -> {
                    guia.CrearGuia();
                    manejoGuia.push(guia);
                    break;
                }
                case 2 -> {
                    manejoGuia.popGuia();
                    break;
                }
                case 3 -> {
                    manejoGuia.MostrarPilaGuia();
                    break;
                }
                case 4 -> {
                    System.out.println("Ingrese el numero de Guia a buscar: ");
                    int idGuia = scanner.nextInt();
                    manejoGuia.BuscarPilaGuia(idGuia);
                    break;
                }
                case 5 -> {
                    manejoGuia.mostrarCantElementos();
                    break;
                }
                

                default -> System.out.println("Opcion incorrecta, intente de nuevo.");
            }
        } while (opcion != 6);
    }
}

    

