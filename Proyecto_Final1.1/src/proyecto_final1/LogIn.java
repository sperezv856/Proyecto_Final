package proyecto_final1;

import java.util.Scanner;

/**
 *
 * @author josep
 */
public class LogIn {

    public void LogIn() {
        ManejoUsuarios manejoUsuarios = new ManejoUsuarios();
        int opcion = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("-------- SISTEMA DE MENSAJERIA -------");
        System.out.println("------------ LOG IN -----------------");
        System.out.println("1. Ingresar al sistema");
        System.out.println("2. Crear usuario");
        System.out.println("3. Salir");
        System.out.println("Seleccione una opcion: ");
        opcion = scanner.nextInt();
        do {

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el nombre de usuario: ");
                    String username = scanner.next();
                    System.out.println("Ingrese su contraseña: ");
                    String password = scanner.next();
                    Usuario usuarioAutenticado = manejoUsuarios.autenticar(username, password);
                    if (usuarioAutenticado instanceof ClienteUsuario) {
                        ClienteUsuario clienteAutenticado = (ClienteUsuario) usuarioAutenticado;
                        Cliente clienteAsociado = clienteAutenticado.getCliente();
                        System.out.println("Bienvenido, " + clienteAsociado.getNombreCompleto());
                        boolean continuar = true;
                        while (continuar) {
                            System.out.println("\n -------------- Opciones -----------------");
                            System.out.println("1. Ver informacion personal. ");
                            System.out.println("2. Realizar una accion");
                            System.out.println("3. Salir");
                            System.out.println("Seleccione una opcion: ");
                            int opcion2 = scanner.nextInt();

                            switch (opcion2) {
                                case 1:
                                    System.out.println("-----------Informacion Personal---------------");
                                    System.out.println("Nombre completo: " + clienteAsociado.getNombreCompleto());
                                    System.out.println("Cedula: " + clienteAsociado.getCedula());
                                    System.out.println("Email: " + clienteAsociado.getEmail());
                                    System.out.println("Telefono: " + clienteAsociado.getCelular());
                                    System.out.println("Estado: " + clienteAsociado.getEstado());
                                    break;
                                case 2:

                                    break;
                                case 3:
                                    continuar = false;

                                    break;
                            }

                        }
                    } else if (usuarioAutenticado instanceof GestorUsuario) {
                        GestorUsuario clienteAutenticado = (GestorUsuario) usuarioAutenticado;
                        Gestor gestorAsociado = clienteAutenticado.getGestor();
                        System.out.println("Bienvenido, " + gestorAsociado.getNombreCompleto());
                        boolean continuar = true;
                        while (continuar) {
                            System.out.println("\n -------------- Opciones -----------------");
                            System.out.println("1. Ver informacion personal. ");
                            System.out.println("2. Realizar una accion");
                            System.out.println("3. Salir");
                            System.out.println("Seleccione una opcion: ");
                            int opcion3 = scanner.nextInt();

                            switch (opcion3) {
                                case 1:
                                    System.out.println("-----------Informacion Personal---------------");
                                    System.out.println("Nombre completo: " + gestorAsociado.getNombreCompleto());
                                    System.out.println("Cedula: " + gestorAsociado.getCedula());
                                    System.out.println("Tipo de gestor: " + gestorAsociado.getTipoGestor());
                                    System.out.println("Funcion: " + gestorAsociado.getFunciones());
                                    System.out.println("Estado: " + gestorAsociado.getEstado());
                                    break;
                                case 2:

                                    break;
                                case 3:
                                    continuar = false;

                                    break;

                            }
                        }

                    } else if (usuarioAutenticado instanceof MensajeroUsuario) {
                        MensajeroUsuario clienteAutenticado = (MensajeroUsuario) usuarioAutenticado;
                        Mensajero mensajeroAsociado = clienteAutenticado.getMensajero();
                        System.out.println("Bienvenido, " + mensajeroAsociado.getNombreCompleto());
                        boolean continuar = true;
                        while (continuar) {
                            System.out.println("\n -------------- Opciones -----------------");
                            System.out.println("1. Ver informacion personal. ");
                            System.out.println("2. Realizar una accion");
                            System.out.println("3. Salir");
                            System.out.println("Seleccione una opcion: ");
                            int opcion4 = scanner.nextInt();

                            switch (opcion4) {
                                case 1:
                                    System.out.println("-----------Informacion Personal---------------");
                                    System.out.println("Nombre completo: " + mensajeroAsociado.getNombreCompleto());
                                    System.out.println("Cedula: " + mensajeroAsociado.getCedula());
                                    System.out.println("Nacionalidad: " + mensajeroAsociado.getNacionalidad());
                                    System.out.println("Codigo Mensajero: " + mensajeroAsociado.getCodigoMensajero());
                                    System.out.println("Telefono: " + mensajeroAsociado.getTelefono());
                                    System.out.println("Estado: " + mensajeroAsociado.getEstado());
                                    break;
                                case 2:

                                    break;
                                case 3:
                                    continuar = false;

                                    break;

                            }
                        }
                    } else {
                        System.out.println("Usuario no registrado.");
                    }
                    break;
                case 2:
                    System.out.println("Que tipo de cuenta desea crear? (Cliente, Gestor, Mensajero): ");
                    String tipoCuenta = scanner.next();
                    System.out.println("Ingrese el nombre de usuario: ");
                    username = scanner.next();
                    System.out.println("Ingrese su contraseña: ");
                    password = scanner.next();
                    if (tipoCuenta.equalsIgnoreCase("Cliente")) {
                        ManejoCliente manejocliente = new ManejoCliente();
                        Cliente cliente = manejocliente.crearCliente();
                        manejocliente.IngresarCliente(cliente);
                        ClienteUsuario clienteUsuario = new ClienteUsuario(cliente, username, password);
                        manejoUsuarios.AgregarUsuario(clienteUsuario);
                       break; 
                    } else if (tipoCuenta.equalsIgnoreCase("Mensajero")) {
                        ManejoMensajero manejoMensajero = new ManejoMensajero();
                        Mensajero mensajero = manejoMensajero.crearMensajero();
                        manejoMensajero.IngresarMensajero(mensajero);
                        MensajeroUsuario mensajeroUsuario = new MensajeroUsuario(mensajero, username, password);
                        manejoUsuarios.AgregarUsuario(mensajeroUsuario);
                        break;
                    } else if (tipoCuenta.equalsIgnoreCase("Gestor")) {
                        ManejoGestor manejoGestor = new ManejoGestor();
                        Gestor gestor = manejoGestor.crearGestor();
                        manejoGestor.IngresarGestor(gestor);
                        GestorUsuario gestorUsuario = new GestorUsuario(gestor, username, password);
                        manejoUsuarios.AgregarUsuario(gestorUsuario);
                        break;
                    } else{
                        System.out.println("Opcion no valida");
                    }
                    break;
                case 3:
                    System.out.println("Saliendo");
                    break;
            }
            

        } while (opcion != 3);
    }
}
