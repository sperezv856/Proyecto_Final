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

    public void ingresarAlInicio(ObjetoGestor objetoGestor) {
        NodoListaDoble nodoNuevo = new NodoListaDoble();
        nodoNuevo.setObjetoGestor(objetoGestor);
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

    public void ingresarAlFinal(ObjetoGestor objetoGestor) {
        NodoListaDoble nodoNuevo = new NodoListaDoble();
        nodoNuevo.setObjetoGestor(objetoGestor);
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

    public void buscar(ObjetoGestor objetoGestor) {
        NodoListaDoble actual = getPrimero();
        while (actual != null) {
            if (actual.getObjetoGestor() == objetoGestor) {
                System.out.println("Guia encontrada");
                return;
            }
            actual = actual.getSiguiente();
        }
        System.out.println("Guia no encontrada");
    }

    public ObjetoGestor buscarPorId(int idGuia) {
        NodoListaDoble actual = getPrimero();
        while (actual != null) {
            if (actual.getObjetoGestor().getGuia().getDetalle().getIdGuia() == idGuia) {
                System.out.println("Guia encontrada");
                return actual.getObjetoGestor();
            }
            actual = actual.getSiguiente();
        }
        System.out.println("Guia no encontrada");
        return null;
    }

    public void eliminar(ObjetoGestor objetoGestor) {
        NodoListaDoble actual = getPrimero();
        NodoListaDoble anterior = null;
        while (actual != null) {
            if (actual.getObjetoGestor() == objetoGestor) {
                if (actual == getPrimero()) {
                    setPrimero(getPrimero().getSiguiente());
                } else {
                    anterior.setSiguiente(actual.getSiguiente());
                    if (actual.getSiguiente() != null) {
                        actual.getSiguiente().setAnterior(anterior);
                    }
                }
                System.out.println("Servicio eliminado");
                return;
            }
            System.out.println("Servicio no encontrado");
        }

    }

    public ObjetoGestor eliminarPorId(int idGuia) {
        NodoListaDoble actual = getPrimero();
        NodoListaDoble anterior = null;
        while (actual != null) {
            if (actual.getObjetoGestor().getGuia().getDetalle().getIdGuia() == idGuia) {
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
                return actual.getObjetoGestor();
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
            System.out.println(actual.getObjetoGestor().toString());
            // Puedes mostrar más atributos de la guía según tus necesidades
            actual = actual.getSiguiente();
        }
    }

    public void mostrarRuta(int idGuia) {
        NodoListaDoble actual = getPrimero();
        while (actual != null) {
            if (actual.getObjetoGestor().getGuia().getDetalle().getIdGuia() == idGuia) {
                Ruta ruta = actual.getObjetoGestor().getRuta();
                if (ruta != null) {
                    System.out.println(" IdGuia" + idGuia);
                    System.out.println("Nombre de ruta: " + ruta.getRutaNombre() + " Provincia: " + ruta.getProvincia()
                            + " Canton: " + ruta.getCanton());
                } else {
                    System.out.println("No se encontro la ruta para la Guia solicitada");
                }
                return;
            }
            actual = actual.getSiguiente();
        }
    }

    public void ordenarPorNombreDeRuta() {
        NodoListaDoble actual, siguiente;
        boolean intercambio;

        do {
            actual = getPrimero();
            intercambio = false;

            while (actual != null && actual.getSiguiente() != null) {
                siguiente = actual.getSiguiente();

                if (actual.getObjetoGestor().getRuta()!= null
                        && siguiente.getObjetoGestor().getRuta() != null
                        && actual.getObjetoGestor().getRuta().getRutaNombre().compareTo(siguiente.getObjetoGestor().getRuta().getRutaNombre()) > 0) {

                    intercambiar(actual, siguiente);
                    intercambio = true;
                }

                actual = siguiente;
            }
        } while (intercambio);
    }

    private void intercambiar(NodoListaDoble nodo1, NodoListaDoble nodo2) {
        ObjetoGestor aux = nodo1.getObjetoGestor();
        nodo1.setObjetoGestor(nodo2.getObjetoGestor());
        nodo2.setObjetoGestor(aux);
    }
}
