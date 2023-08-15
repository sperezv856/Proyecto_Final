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
public class ManejoGestor {
    Scanner scanner = new Scanner(System.in);
    private NodoListaSimple ultimo;
    private NodoListaSimple primero;
    
    public ManejoGestor(){
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
    public Gestor crearGestor() {
        System.out.println("Indique el numero de cedula: ");
        int cedula = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Indique el nombre completo: ");
        String nombre = scanner.nextLine();
        System.out.println("Indique el tipo de Gestor (Gestor / Administrador / Contacto): ");
        String tipoGestor = scanner.nextLine();
        System.out.println("Indique la funcion: ");
        String funcion = scanner.nextLine();
        System.out.println("Indique el estado (Activo / Inactivo): ");
        String estado = scanner.nextLine();
        Gestor gestor = new Gestor(tipoGestor, funcion, cedula, nombre, estado);
        gestor.setCedula(cedula);
        gestor.setNombreCompleto(nombre);
        gestor.setTipoGestor(tipoGestor);
        gestor.setFunciones(funcion);
        gestor.setEstado(estado);
        return gestor;
    }
    public void IngresarGestor(Gestor gestor) {
        NodoListaSimple nodoNuevo = new NodoListaSimple();
        nodoNuevo.setGestor(gestor);
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
    public Gestor buscarGestor(int ced) {
        NodoListaSimple actual = new NodoListaSimple();
        actual = getPrimero();
        while (actual != null) {
            if (actual.getGestor().getCedula()== ced) {
                System.out.println("Gestor Encontrado");
                System.out.println("Cedula: " + actual.getGestor().getCedula());
                System.out.println("Nombre: " + actual.getGestor().getNombreCompleto());
                System.out.println("Tipo de gestor: " + actual.getGestor().getTipoGestor());
                System.out.println("Funcion : " + actual.getGestor().getFunciones());
                System.out.println("Estado: " + actual.getGestor().getEstado());
                
                return actual.getGestor();
            }
            actual = actual.getSiguiente();
        }
        System.out.println("Gestor no encontrado");
        return null;
    }
    public void EliminarGestor(int ced) {
        NodoListaSimple actual = new NodoListaSimple();
        NodoListaSimple anterior = new NodoListaSimple();
        actual = getPrimero();
        anterior = null;
        while (actual != null) {
            if (actual.getGestor().getCedula()== ced) {
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
    public void ModificarGestor(int ced) {
        NodoListaSimple actual = getPrimero();
        while (actual != null) {
            if (actual.getGestor().getCedula()== ced) {
                System.out.println("Ingrese la nueva cedula: ");
                int nuevoID = scanner.nextInt();
                actual.getGestor().setCedula(nuevoID);
                System.out.println("Ingrese el nuevo nombre: ");
                String nuevoNombre = scanner.nextLine();
                actual.getGestor().setNombreCompleto(nuevoNombre);
                System.out.println("Ingrese el nuevo Tipo de Gestor: ");
                String nuevoTipo = scanner.nextLine();
                actual.getGestor().setTipoGestor(nuevoTipo);
                System.out.println("Ingrese el nuevo Estado (Activo / Inactivo): ");
                String nuevoEstado = scanner.nextLine();
                actual.getGestor().setEstado(nuevoEstado);
                
                System.out.println("Gestor modificado correctamente");
            }
            actual = actual.getSiguiente();
        }
        System.out.println("Gestor no encontrado");
    }
    public void MostrarGestor() {
        NodoListaSimple aux = getPrimero();
        while (aux != null) {            
            Gestor gestor = aux.getGestor();
            System.out.println("Cedula: " + aux.getGestor().getCedula()+ " Nombre completo: " 
                    + aux.getGestor().getNombreCompleto() + " Tipo: " + aux.getGestor().getTipoGestor()
                    + " Funcion: " + aux.getGestor().getFunciones()+ " Estado: " + aux.getGestor().getEstado());
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
