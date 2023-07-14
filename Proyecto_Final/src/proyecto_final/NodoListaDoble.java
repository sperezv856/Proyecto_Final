package proyecto_final;

/**
 *
 * @author josep
 */
//Clase para crear los nodos de la lista Doble, con Getter y Setter
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
