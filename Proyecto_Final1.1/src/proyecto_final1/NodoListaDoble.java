package proyecto_final1;

/**
 *
 * @author josep
 */
//Clase para crear los nodos de la lista Doble, con Getter y Setter
public class NodoListaDoble {
    private ObjetoGestor objetoGestor;
    private NodoListaDoble siguiente;
    private NodoListaDoble anterior;

    public NodoListaDoble() {
    }

    public ObjetoGestor getObjetoGestor() {
        return objetoGestor;
    }

    public void setObjetoGestor(ObjetoGestor objetoGestor) {
        this.objetoGestor = objetoGestor;
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
