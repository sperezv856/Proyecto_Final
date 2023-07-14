package proyecto_final;

import java.util.Scanner;

/**
 *
 * @author josep
 */
/*Clase para el manejo de los productos por medio de una lista Simple, incluye
Getter y Setter*/
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
    // Metodo para el ingreso de un nuevo objeto TipoProducto
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
    // Metodo para busqueda de un objeto TipoProducto por medio de el codigo de producto llamado cdp
    public TipoProducto buscarProducto(int cdp) {
        NodoListaSimple actual = new NodoListaSimple();
        actual = getPrimero();
        while (actual != null) {
            if (actual.getProducto().getIdTipoProducto()== cdp) {
                System.out.println("Producto Encontrado");
                System.out.println("Id de producto: " + actual.getProducto().getIdTipoProducto());
                System.out.println("Observacion: " + actual.getProducto().getObservaciones());
                System.out.println("Monto: " + actual.getProducto().getMonto());
                System.out.println("Estado: " + actual.getProducto().getEstado());
                return actual.getProducto();
            }
            actual = actual.getSiguiente();
        }
        System.out.println("Producto no encontrado");
        return null;
    }
    // Metodo para eliminar un objeto TipoProducto por medio de el codigo de producto llamado cdp
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
    // Metodo para modificar un objeto TipoProducto por medio de el codigo de producto llamado cdp
    // Se deberia crear un submenu para solicitar al usuario cual parametro desea modificar
    public void ModificarProducto(int cdp) {
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

