package proyecto_final;

/**
 *
 * @author josep
 */
public class NodoListaSimple {
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
    
    
}
