package proyecto_final1;

/**
 *
 * @author josep
 */
/*Clase para crear los nodos de la lista Doble, con Getter y Setter, aca se tienen
que asignar 2 tipos distintos de objetos admisibles, Tipo de Producto y Ruta, debido 
a que se van a utilizar listas con distintos tipos de objetos*/
public class NodoListaSimple {
    private Cliente cliente;
    private TipoProducto producto;
    private Ruta ruta;
    private NodoListaSimple siguiente;

    public NodoListaSimple() {
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

    public NodoListaSimple getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoListaSimple siguiente) {
        this.siguiente = siguiente;
    }

    public TipoProducto getProducto() {
        return producto;
    }

    public void setProducto(TipoProducto producto) {
        this.producto = producto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
}
