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
                            opcion = scanner.nextInt();

                            switch (opcion) {
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

                    } else if (usuarioAutenticado instanceof MensajeroUsuario) {

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
                    } else if(tipoCuenta.equalsIgnoreCase("Mensajero")){
                        
                    }else if(tipoCuenta.equalsIgnoreCase("Gestor")){
                                                
                    }
                    

            }

        } while (opcion != 3);
    }
}
