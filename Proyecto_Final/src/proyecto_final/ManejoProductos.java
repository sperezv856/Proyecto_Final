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

    public void BuscarProducto(int cdp) {
        NodoListaSimple actual = new NodoListaSimple();
        actual = getPrimero();
        while (actual != null) {
            if (actual.getProducto().getIdTipoProducto()== cdp) {
                System.out.println("Producto Encontrado");
                System.out.println("Id de producto: " + actual.getProducto().getIdTipoProducto());
                System.out.println("Observacion: " + actual.getProducto().getObservaciones());
                System.out.println("Monto: " + actual.getProducto().getMonto());
                System.out.println("Estado: " + actual.getProducto().getEstado());
            }
            actual = actual.getSiguiente();
        }
        System.out.println("Producto no encontrado");
    }

    public void EliminarProducto(int cdp) {
        NodoListaSimple actual = new NodoListaSimple();
        NodoListaSimple anterior = new NodoListaSimple();
        actual = getPrimero();
        anterior = null;
        while (actual != null) {
            if (actual.getProducto().getIdTipoProducto()== cdp) {
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

    public void ModificarRuta(int cdp) {
        NodoListaSimple actual = getPrimero();
        while (actual != null) {
            if (actual.getProducto().getIdTipoProducto()== cdp) {
                System.out.println("Ingrese el nuevo ID del producto: ");
                int nuevoID = scanner.nextInt();
                actual.getProducto().setIdTipoProducto(nuevoID);
                System.out.println("Ingrese las nuevas observaciones: ");
                String nuevaObservacion = scanner.nextLine();
                actual.getProducto().setObservaciones(nuevaObservacion);
                System.out.println("Ingrese el nuevo Monto: ");
                int nuevoMonto = scanner.nextInt();
                actual.getProducto().setMonto(nuevoMonto);
                String nuevoEstado = scanner.nextLine();
                actual.getProducto().setEstado(nuevoEstado);
                System.out.println("Producto modificado correctamente");
            }
            actual = actual.getSiguiente();
        }
        System.out.println("Ruta no encontrada");
    }

}

