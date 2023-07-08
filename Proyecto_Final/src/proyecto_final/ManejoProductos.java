package proyecto_final;

import java.util.Scanner;

/**
 *
 * @author josep
 */
public class ManejoProductos {

    Scanner scanner = new Scanner(System.in);
    private NodoListaSimple ultimo;
    private NodoListaSimple primero;

    public ManejoProductos() {
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

    public void IngresarProducto(TipoProducto producto) {
        NodoListaSimple nodoNuevo = new NodoListaSimple();
        nodoNuevo.setProducto(producto);
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

    public void BuscarRuta(int cdp) {
        NodoListaSimple actual = new NodoListaSimple();
        actual = getPrimero();
        while (actual != null) {
            if (actual.getProducto().getIdTipoProducto()== cdp) {
                System.out.println("Producto Encontrado");
                System.out.println("Id de producto: " + actual.getProducto().getIdTipoProducto());
                System.out.println("Provincia: " + actual.getRuta().getProvincia());
                System.out.println("Canton: " + actual.getRuta().getCanton());
            }
            actual = actual.getSiguiente();
        }
        System.out.println("Ruta no encontrada");
    }

    public void EliminarRuta(String rutn) {
        NodoListaSimple actual = new NodoListaSimple();
        NodoListaSimple anterior = new NodoListaSimple();
        actual = getPrimero();
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

    public void ModificarRuta(String rutn) {
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
                System.out.println("Ruta modificada correctamente");
            }
            actual = actual.getSiguiente();
        }
        System.out.println("Ruta no encontrada");
    }

}

