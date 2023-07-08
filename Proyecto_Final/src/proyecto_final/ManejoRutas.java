package proyecto_final;

import java.util.Scanner;

/**
 *
 * @author josep
 */
public class ManejoRutas {
    Scanner scanner = new Scanner(System.in);
    private NodoListaSimple ultimo;
    private NodoListaSimple primero;

    public ManejoRutas() {
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

    public void IngresarRuta(Ruta ruta) {
        NodoListaSimple nodoNuevo = new NodoListaSimple();
        nodoNuevo.setRuta(ruta);
        if (getPrimero() == null) {
            setPrimero(nodoNuevo);
            getPrimero().setSiguiente(nodoNuevo);
            setUltimo(getPrimero());
        } else {
            getUltimo().setSiguiente(nodoNuevo);
            nodoNuevo.setSiguiente(null);
            setUltimo(nodoNuevo);
        }
    }

    public void BuscarRuta(String rutn) {
        NodoListaSimple actual = new NodoListaSimple();
        actual = getPrimero();
        while (actual != null) {
            if (actual.getRuta().getRutaNombre().equals(rutn)) {
                System.out.println("Ruta Encontrada");
                System.out.println("Nombre de ruta: " + actual.getRuta().getRutaNombre());
                System.out.println("Provincia: " + actual.getRuta().getProvincia());
                System.out.println("Canton: " + actual.getRuta().getCanton());
            }
            actual = actual.getSiguiente();
        }
        System.out.println("Ruta no encontrada");
    }
    public void EliminarRuta(String rutn){
        NodoListaSimple actual = new NodoListaSimple();
        NodoListaSimple anterior = new NodoListaSimple();
        actual= getPrimero();
        anterior = null;
        while (actual != null) {            
            if (actual.getRuta().getRutaNombre().equals(rutn)) {
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
    public void ModificarRuta(String rutn){
        NodoListaSimple actual = getPrimero();
        while (actual != null) {            
            if (actual.getRuta().getRutaNombre().equals(rutn)) {
                System.out.println("Ingrese el nuevo nombre de ruta: ");
                String nuevoNombre = scanner.nextLine();
                actual.getRuta().setRutaNombre(nuevoNombre);
                System.out.println("Ingrese la nueva Provincia: ");
                String nuevaProvincia = scanner.nextLine();
                actual.getRuta().setProvincia(nuevaProvincia);
                System.out.println("Ingrese el nuevo Canton: ");
                String nuevoCanton = scanner.nextLine();
                actual.getRuta().setCanton(nuevoCanton);
            }
            actual = actual.getSiguiente();
            System.out.println("Ruta modificada correctamente");
        }
    
    }

}
