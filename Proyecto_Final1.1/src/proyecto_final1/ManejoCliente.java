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
    
    public ManejoCliente(){
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
    public void inicializarLista(){
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
    public void IngresarCliente() {
        Cliente cliente = crearCliente();
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
            if (actual.getCliente().getCedula()== ced) {
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
        System.out.println("Producto no encontrado");
        return null;
    }
    public void EliminarCliente(int ced) {
        NodoListaSimple actual = new NodoListaSimple();
        NodoListaSimple anterior = new NodoListaSimple();
        actual = getPrimero();
        anterior = null;
        while (actual != null) {
            if (actual.getCliente().getCedula()== ced) {
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
            if (actual.getCliente().getCedula()== ced) {
                System.out.println("Ingrese la nueva cedula: ");
                int nuevoID = scanner.nextInt();
                actual.getCliente().setCedula(nuevoID);
                System.out.println("Ingrese el nuevo nombre: ");
                String nuevoNombre = scanner.nextLine();
                actual.getCliente().setNombreCompleto(nuevoNombre);
                System.out.println("Ingrese el nuevo Telefono: ");
                int nuevoTelefono = scanner.nextInt();
                actual.getCliente().setCelular(nuevoTelefono);
                System.out.println("Ingrese el nuevo Email: ");
                String nuevoEmail = scanner.nextLine();
                actual.getCliente().setEmail(nuevoEmail);
                System.out.println("Ingrese la nueva direccion: ");
                String nuevaDireccion = scanner.nextLine();
                actual.getCliente().setDireccion(nuevaDireccion);
                System.out.println("Ingrese el nuevo Estado (Activo / Inactivo): ");
                String nuevoEstado = scanner.nextLine();
                actual.getCliente().setEstado(nuevoEstado);
                
                System.out.println("Cliente modificado correctamente");
            }
            actual = actual.getSiguiente();
        }
        System.out.println("Ruta no encontrada");
    }
    
}
