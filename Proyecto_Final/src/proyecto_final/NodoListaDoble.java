package proyecto_final;

/**
 *
 * @author josep
 */
public class NodoListaDoble {
    private Gestor gestor;
    private NodoListaDoble siguiente;
    private NodoListaDoble anterior;

    public NodoListaDoble() {
    }

    public Gestor getGestor() {
        return gestor;
    }

    public void setGestor(Gestor gestor) {
        this.gestor = gestor;
    }

    public NodoListaDoble getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoListaDoble siguiente) {
        this.siguiente = siguiente;
    }

    public NodoListaDoble getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoListaDoble anterior) {
        this.anterior = anterior;
    }
}
