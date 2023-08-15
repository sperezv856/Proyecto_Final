/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_final1;

import java.util.Scanner;

/**
 *
 * @author josep
 */
public class ManejoMensajero {
    Scanner scanner = new Scanner(System.in);
    private NodoListaSimple ultimo;
    private NodoListaSimple primero;
    
    public ManejoMensajero(){
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
    public Mensajero crearMensajero() {
        System.out.println("Indique el numero de cedula: ");
        int cedula = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Indique el nombre completo: ");
        String nombre = scanner.nextLine();
        System.out.println("Indique el codigo de mensajero: ");
        int codigoMensajero = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Indique el numero telefonico: ");
        int telefono = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Indique la Nacionalidad: ");
        String nacionalidad = scanner.nextLine();
        System.out.println("Indique el estado (Activo / Inactivo): ");
        String estado = scanner.nextLine();
        Mensajero mensajero = new Mensajero(codigoMensajero, nacionalidad, telefono, cedula, nombre, estado);
        mensajero.setCodigoMensajero(codigoMensajero);
        mensajero.setCedula(cedula);
        mensajero.setNombreCompleto(nombre);
        mensajero.setNacionalidad(nacionalidad);
        mensajero.setTelefono(telefono);
        mensajero.setEstado(estado);
        return mensajero;
    }
    public void IngresarMensajero(Mensajero mensajero) {
        NodoListaSimple nodoNuevo = new NodoListaSimple();
        nodoNuevo.setMensajero(mensajero);
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
    public Mensajero buscarMensajero(int ced) {
        NodoListaSimple actual = new NodoListaSimple();
        actual = getPrimero();
        while (actual != null) {
            if (actual.getMensajero().getCedula()== ced) {
                System.out.println("Mensajero Encontrado");
                System.out.println("Cedula: " + actual.getMensajero().getCedula());
                System.out.println("Nombre: " + actual.getMensajero().getNombreCompleto());
                System.out.println("Codigo de Mensajero: " + actual.getMensajero().getCodigoMensajero());
                System.out.println("Nacionalidad : " + actual.getMensajero().getNacionalidad());
                System.out.println("Telefono : " + actual.getMensajero().getTelefono());
                System.out.println("Estado: " + actual.getMensajero().getEstado());
                
                return actual.getMensajero();
            }
            actual = actual.getSiguiente();
        }
        System.out.println("Mensajero no encontrado");
        return null;
    }
    public void EliminarMensajero(int ced) {
        NodoListaSimple actual = new NodoListaSimple();
        NodoListaSimple anterior = new NodoListaSimple();
        actual = getPrimero();
        anterior = null;
        while (actual != null) {
            if (actual.getMensajero().getCedula()== ced) {
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
    public void ModificarMensajero(int ced) {
        NodoListaSimple actual = getPrimero();
        while (actual != null) {
            if (actual.getMensajero().getCedula()== ced) {
                System.out.println("Ingrese la nueva cedula: ");
                int nuevoID = scanner.nextInt();
                actual.getMensajero().setCedula(nuevoID);
                System.out.println("Ingrese el nuevo nombre: ");
                String nuevoNombre = scanner.nextLine();
                actual.getMensajero().setNombreCompleto(nuevoNombre);
                System.out.println("Ingrese el Codigo de Mensajero: ");
                int nuevoCodigo = scanner.nextInt();
                actual.getMensajero().setCodigoMensajero(nuevoCodigo);
                System.out.println("Ingrese el Telefono: ");
                int nuevotelefono = scanner.nextInt();
                actual.getMensajero().setTelefono(nuevotelefono);
                System.out.println("Ingrese la nueva Nacionalidad: ");
                String nuevoNacion = scanner.nextLine();
                actual.getMensajero().setNacionalidad(nuevoNacion);
                System.out.println("Ingrese el nuevo Estado (Activo / Inactivo): ");
                String nuevoEstado = scanner.nextLine();
                actual.getMensajero().setEstado(nuevoEstado);
                
                System.out.println("Mensajero modificado correctamente");
            }
            actual = actual.getSiguiente();
        }
        System.out.println("Mensajero no encontrado");
    }
    public void MostrarMensajero() {
        NodoListaSimple aux = getPrimero();
        while (aux != null) {            
            Mensajero mensajero = aux.getMensajero();
            System.out.println("Cedula: " + aux.getMensajero().getCedula()+ " Codigo mensajero: "+ aux.getMensajero().getCodigoMensajero()+" Nombre completo: " 
                    + aux.getMensajero().getNombreCompleto() + " Nacionalidad: " + aux.getMensajero().getNacionalidad()
                    + " Telefono: " + aux.getMensajero().getTelefono()+ " Estado: " + aux.getMensajero().getEstado());
            aux = aux.getSiguiente();
        }
        
    }
    /*public void IngresarDatosIniciales (){
        Cliente cliente1 = new Cliente("jose.p.munoz85@gmail.com", "San Juan, Tibas", 87026720, 112350023, "Jose Pablo Munoz", "Activo");
        IngresarCliente(cliente1);
        Cliente cliente2 = new Cliente("lilyka71@gmail.com", "San Antonio, Escazu", 87234175, 123456789, "Vanessa Moya Alfaro", "Activo");
        IngresarCliente(cliente2);
        Cliente cliente3 = new Cliente("jose.solis@hotmail.com", "Barva, Heredia", 7384455, 345124841, "Jose Antonio Solis", "Activo");
        IngresarCliente(cliente3);
    }
    
}*/



}
