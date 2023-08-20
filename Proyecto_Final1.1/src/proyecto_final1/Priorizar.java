package proyecto_final1;

/**
 *
 * @author josep
 */
public class Priorizar {

    NodoListaDoble primero;
    NodoListaDoble ultimo;

    public Priorizar() {
        primero = null;
        ultimo = null;
    }

    public NodoListaDoble getPrimero() {
        return primero;
    }

    public void setPrimero(NodoListaDoble primero) {
        this.primero = primero;
    }

    public NodoListaDoble getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoListaDoble ultimo) {
        this.ultimo = ultimo;
    }

    public void ingresarAlInicio(Guia guia) {
        NodoListaDoble nodoNuevo = new NodoListaDoble();
        nodoNuevo.setGuia(guia);
        if (getPrimero() == null) {
            setPrimero(nodoNuevo);
            nodoNuevo.setSiguiente(null);
            nodoNuevo.setAnterior(null);
            setUltimo(getPrimero());
        } else {
            nodoNuevo.setSiguiente(getPrimero());
            getPrimero().setAnterior(nodoNuevo);
            nodoNuevo.setAnterior(null);
            setPrimero(nodoNuevo);
        }
    }

    public void ingresarAlFinal(Guia guia) {
        NodoListaDoble nodoNuevo = new NodoListaDoble();
        nodoNuevo.setGuia(guia);
        if (getUltimo() == null) {
            setPrimero(nodoNuevo);
            nodoNuevo.setSiguiente(null);
            nodoNuevo.setAnterior(null);
            setUltimo(nodoNuevo);
        } else {
            getUltimo().setSiguiente(nodoNuevo);
            nodoNuevo.setAnterior(getUltimo());
            nodoNuevo.setSiguiente(null);
            setUltimo(nodoNuevo);
        }
    }

    public void buscar(Guia guia) {
        NodoListaDoble actual = getPrimero();
        while (actual != null) {
            if (actual.getGuia() == guia) {
                System.out.println("Guia encontrada");
                return;
            }
            actual = actual.getSiguiente();
        }
        System.out.println("Guia no encontrada");
    }

    public Guia buscarPorId(int idGuia) {
        NodoListaDoble actual = getPrimero();
        while (actual != null) {
            if (actual.getGuia().getDetalle().getIdGuia() == idGuia) {
                System.out.println("Guia encontrada");
                return actual.getGuia();
            }
            actual = actual.getSiguiente();
        }
        System.out.println("Guia no encontrada");
        return null;
    }

    public void eliminar(Guia guia) {
        NodoListaDoble actual = getPrimero();
        NodoListaDoble anterior = null;
        while (actual != null) {
            if (actual.getGuia() == guia) {
                if (actual == getPrimero()) {
                    setPrimero(getPrimero().getSiguiente());
                } else {
                    anterior.setSiguiente(actual.getSiguiente());
                    if (actual.getSiguiente() != null) {
                        actual.getSiguiente().setAnterior(anterior);
                    }
                }
                System.out.println("Guia eliminada");
                return;
            }
            System.out.println("Guia no encontrada");
        }

    }

    public Guia eliminarPorId(int idGuia) {
        NodoListaDoble actual = getPrimero();
        NodoListaDoble anterior = null;
        while (actual != null) {
            if (actual.getGuia().getDetalle().getIdGuia() == idGuia) {
                if (actual == getPrimero()) {
                    setPrimero(getPrimero().getSiguiente());
                    if (getPrimero() != null) {
                        getPrimero().setAnterior(null);
                    }
                } else {
                    anterior.setSiguiente(actual.getSiguiente());
                    if (actual.getSiguiente() != null) {
                        actual.getSiguiente().setAnterior(anterior);
                    }
                }
                System.out.println("Guia eliminada");
                return actual.getGuia();
            }
            anterior = actual;
            actual = actual.getSiguiente();
        }
        System.out.println("Guia no encontrada");
        return null;
    }

    public void mostrarElementosPriorizados() {
        System.out.println("Servicios priorizados:");
        NodoListaDoble actual = getPrimero();
        while (actual != null) {
            System.out.println(actual.getGuia().toString());
            // Puedes mostrar más atributos de la guía según tus necesidades
            actual = actual.getSiguiente();
        }
    }
}
