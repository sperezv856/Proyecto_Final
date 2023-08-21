package proyecto_final1;

import java.util.Scanner;

/**
 *
 * @author josep
 */
public class ManejoCliente {

    Scanner scanner = new Scanner(System.in);
    private NodoListaSimple ultimo;
    private NodoListaSimple primero;

    public ManejoCliente() {
        primero = null;
        ultimo = null;
    }

    public NodoListaSimple getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoListaSimple ultimo) {
        this.ultimo = ultimo;
    }

    public NodoListaSimple getPrimero() {
        return primero;
    }

    public void setPrimero(NodoListaSimple primero) {
        this.primero = primero;
    }

    public boolean Vacia() {
        if (getPrimero() == null) {
            return true;
        } else {
            return false;
        }
    }

    public void inicializarLista() {
        primero = null;
        ultimo = null;
    }

    /*Esta funcion solicita al usuario los datos necesarios para crear el objeto Cliente*/
    public Cliente crearCliente() {
        System.out.println("Indique el numero de cedula: ");
        int cedula = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Indique el nombre completo: ");
        String nombre = scanner.nextLine();
        System.out.println("Indique el correo electronico: ");
        String email = scanner.nextLine();
        System.out.println("Indique el telefono: ");
        int telefono = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Indique la direccion: ");
        String direccion = scanner.nextLine();
        System.out.println("Indique el estado (Activo / Inactivo): ");
        String estado = scanner.nextLine();
        Cliente cliente = new Cliente(email, direccion, telefono, cedula, nombre, estado);
        cliente.setCedula(cedula);
        cliente.setNombreCompleto(nombre);
        cliente.setEmail(email);
        cliente.setCelular(telefono);
        cliente.setDireccion(direccion);
        cliente.setEstado(estado);
        return cliente;
    }

    public void IngresarCliente(Cliente cliente) {
        NodoListaSimple nodoNuevo = new NodoListaSimple();
        nodoNuevo.setCliente(cliente);
        if (getPrimero() == null) {
            setPrimero(nodoNuevo);
            setUltimo(nodoNuevo);
            nodoNuevo.setSiguiente(null);
        } else {
            getUltimo().setSiguiente(nodoNuevo);
            nodoNuevo.setSiguiente(null);
            setUltimo(nodoNuevo);
        }

    }

    public Cliente buscarCliente(int ced) {
        NodoListaSimple actual = new NodoListaSimple();
        actual = getPrimero();
        while (actual != null) {
            if (actual.getCliente().getCedula() == ced) {
                System.out.println("Cliente Encontrado");
                System.out.println("Cedula: " + actual.getCliente().getCedula());
                System.out.println("Nombre: " + actual.getCliente().getNombreCompleto());
                System.out.println("Telefono: " + actual.getCliente().getCelular());
                System.out.println("Email: " + actual.getCliente().getEmail());
                System.out.println("Direccion: " + actual.getCliente().getDireccion());
                System.out.println("Estado: " + actual.getCliente().getEstado());

                return actual.getCliente();
            }
            actual = actual.getSiguiente();
        }
        System.out.println("Cliente no encontrado");
        return null;
    }

    public void EliminarCliente(int ced) {
        NodoListaSimple actual = new NodoListaSimple();
        NodoListaSimple anterior = new NodoListaSimple();
        actual = getPrimero();
        anterior = null;
        while (actual != null) {
            if (actual.getCliente().getCedula() == ced) {
                if (actual == getPrimero()) {
                    setPrimero(getPrimero().getSiguiente());
                } else {
                    anterior.setSiguiente(actual.getSiguiente());
                }
            }
            anterior = actual;
            actual = actual.getSiguiente();
        }
    }

    public void ModificarCliente(int ced) {
        NodoListaSimple actual = getPrimero();
        while (actual != null) {
            if (actual.getCliente().getCedula() == ced) {
                boolean continuar = true;
                while (continuar) {
                    System.out.println(" -------------- Opciones -----------------");
                    System.out.println("1. Modificar nombre. ");
                    System.out.println("2. Modificar cedula. ");
                    System.out.println("3. Modificar correo electronico");
                    System.out.println("4. Modificar Telefono");
                    System.out.println("5. Modificar Direccion");
                    System.out.println("6. Modificar Estado");
                    System.out.println("7. Salir");
                    System.out.println("Seleccione una opcion: ");
                    int opcion = scanner.nextInt();
                    switch (opcion) {
                        case 1:
                            System.out.println("Ingrese el nuevo nombre: ");
                            String nuevoNombre = scanner.nextLine();
                            actual.getCliente().setNombreCompleto(nuevoNombre);
                            break;
                        case 2:
                            System.out.println("Ingrese la nueva cedula: ");
                            int nuevoID = scanner.nextInt();
                            actual.getCliente().setCedula(nuevoID);
                            break;
                        case 3:
                            System.out.println("Ingrese el nuevo Email: ");
                            String nuevoEmail = scanner.nextLine();
                            actual.getCliente().setEmail(nuevoEmail);
                            break;
                        case 4:
                            System.out.println("Ingrese el nuevo Telefono: ");
                            int nuevoTelefono = scanner.nextInt();
                            actual.getCliente().setCelular(nuevoTelefono);
                            break;
                        case 5:
                            System.out.println("Ingrese la nueva direccion: ");
                            String nuevaDireccion = scanner.nextLine();
                            actual.getCliente().setDireccion(nuevaDireccion);
                            break;
                        case 6:
                            System.out.println("Ingrese el nuevo Estado (Activo / Inactivo): ");
                            String nuevoEstado = scanner.nextLine();
                            actual.getCliente().setEstado(nuevoEstado);
                            break;
                        case 7:
                            System.out.println("Finalizando los cambios");
                            continuar= false;
                            break;
                    }
                }

                System.out.println("Cliente modificado correctamente");
            }
            actual = actual.getSiguiente();
        }
        System.out.println("Cliente no encontrado");
    }

    public void MostrarClientes() {
        NodoListaSimple aux = getPrimero();
        while (aux != null) {
            Cliente cliente = aux.getCliente();
            System.out.println("Cedula: " + aux.getCliente().getCedula() + " Nombre completo: "
                    + aux.getCliente().getNombreCompleto() + " Telefono: " + aux.getCliente().getCelular()
                    + " Email: " + aux.getCliente().getEmail() + " Direccion: " + aux.getCliente().getDireccion()
                    + " Estado: " + aux.getCliente().getEstado());
            aux = aux.getSiguiente();
        }

    }

    public void IngresarDatosIniciales() {
        Cliente cliente1 = new Cliente("lilyka71@gmail.com", "San Antonio, Escazu", 87234175, 123456789, "Vanessa Moya Alfaro", "Activo");
        IngresarCliente(cliente1);
        Cliente cliente2 = new Cliente("jose.solis@hotmail.com", "Barva, Heredia", 7384455, 345124841, "Jose Antonio Solis", "Activo");
        IngresarCliente(cliente2);
    }

}
