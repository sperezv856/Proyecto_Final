package proyecto_final1;

/**
 *
 * @author josep
 */
public class NodoArbol {

    ObjetoJustificaciones objetoJustificaciones;
    NodoArbol izquierda;
    NodoArbol derecha;

    public NodoArbol(ObjetoJustificaciones objetoJustificaciones, NodoArbol izquierda, NodoArbol derecha) {
        this.objetoJustificaciones = objetoJustificaciones;
        this.izquierda = izquierda;
        this.derecha = derecha;
    }

    public ObjetoJustificaciones getObjetoJustificaciones() {
        return objetoJustificaciones;
    }

    public void setObjetoJustificaciones(ObjetoJustificaciones objetoJustificaciones) {
        this.objetoJustificaciones = objetoJustificaciones;
    }

    public NodoArbol getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(NodoArbol izquierda) {
        this.izquierda = izquierda;
    }

    public NodoArbol getDerecha() {
        return derecha;
    }

    public void setDerecha(NodoArbol derecha) {
        this.derecha = derecha;
    }


}

