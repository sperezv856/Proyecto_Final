package proyecto_final1;

/**
 *
 * @author josep
 */
public class ManejoArbol {

    NodoArbol raiz;
    int cant;
    int altura;

    public ManejoArbol() {
        raiz = null;
    }

    public NodoArbol getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoArbol raiz) {
        this.raiz = raiz;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public void insertar(ObjetoJustificaciones objetoJustificaciones) {
        raiz = insertarRecursivo(raiz, objetoJustificaciones);
    }

    private NodoArbol insertarRecursivo(NodoArbol nodo, ObjetoJustificaciones objetoJustificaciones) {
        if (nodo == null) {
            return new NodoArbol(objetoJustificaciones, null, null);
        }
        int idServicioActual = nodo.getObjetoJustificaciones().getGuia().getServicio().getIdServicio();
        int idServicioNuevo = objetoJustificaciones.getGuia().getServicio().getIdServicio();
        if (idServicioNuevo < idServicioActual) {
            nodo.setIzquierda(insertarRecursivo(nodo.getIzquierda(), objetoJustificaciones));
        } else {
            nodo.setDerecha(insertarRecursivo(nodo.getDerecha(), objetoJustificaciones));
        }
        return nodo;
    }

    public void MostrarEnOrden(NodoArbol nodo) {
        if (nodo != null) {
            MostrarEnOrden(nodo.getIzquierda());
            System.out.println(nodo.toString());
            MostrarEnOrden(nodo.getDerecha());
        }
    }

    public boolean eliminar(ObjetoJustificaciones objetoJustificaciones) {
        NodoArbol aux = raiz;
        NodoArbol padre = raiz;
        boolean esHijoIzquierdo = true;
        while (aux.objetoJustificaciones.getGuia().getServicio().getIdServicio() != objetoJustificaciones.getGuia().getServicio().getIdServicio()) {
            padre = aux;
            if (objetoJustificaciones.getGuia().getServicio().getIdServicio() < aux.objetoJustificaciones.getGuia().getServicio().getIdServicio()) {
                esHijoIzquierdo = true;
                aux = aux.getIzquierda();
            } else {
                esHijoIzquierdo = false;
                aux = aux.getDerecha();
            }
            if (aux == null) {
                return false;
            }
        }
        if (aux.getIzquierda() == null && aux.getDerecha() == null) {
            if (aux == raiz) {
                raiz = null;
            } else if (esHijoIzquierdo) {
                padre.setIzquierda(null);
            } else {
                padre.setDerecha(null);
            }
        } else if (aux.getDerecha() == null) {
            if (aux == raiz) {
                raiz = aux.getIzquierda();
            } else if (esHijoIzquierdo) {
                padre.setIzquierda(aux.getIzquierda());
            } else {
                padre.setDerecha(aux.getIzquierda());
            }
        } else if (aux.getIzquierda() == null) {
            if (aux == raiz) {
                raiz = aux.getDerecha();
            } else if (esHijoIzquierdo) {
                padre.setIzquierda(aux.getDerecha());
            } else {
                padre.setDerecha(aux.getDerecha());
            }
        } else {
            NodoArbol reemplazo = obtenerNodoReemplazo(aux);
            if (aux == raiz) {
                raiz = reemplazo;
            } else if (esHijoIzquierdo){
                padre.setIzquierda(reemplazo);
            }else {
                padre.setDerecha(reemplazo);
            }
            reemplazo.setIzquierda(aux.getIzquierda());
        }
        return true;
    }
    private NodoArbol obtenerNodoReemplazo (NodoArbol nodo){
        NodoArbol reemplazoPadre = nodo;
        NodoArbol reemplazo = nodo;
        NodoArbol aux = nodo.getDerecha();
        while (aux != null) {            
            reemplazoPadre = reemplazo;
            reemplazo = aux;
            aux = aux.getIzquierda();
        }
        if (reemplazo != nodo.getDerecha()) {
            reemplazo.setIzquierda(reemplazo.getDerecha());
            reemplazo.setDerecha(nodo.getDerecha());
        }
        return reemplazo;
    }
    private void cantidad(NodoArbol nodo){
        if (nodo != null) {
            cant++;
            cantidad(nodo.getIzquierda());
            cantidad(nodo.getDerecha());
        }
    }
    public int cantidad(){
        cant = 0;
        cantidad(raiz);
        return cant;
    }
    private void cantidadNodosHoja(NodoArbol nodo){
        if (nodo != null) {
            if (nodo.getIzquierda()== null && nodo.getDerecha()== null) {
                cant++;
                cantidadNodosHoja(nodo.getIzquierda());
                cantidadNodosHoja(nodo.getDerecha());
            }
        }
    }
    public int cantidadNodosHoja(){
        cant= 0;
        cantidadNodosHoja(raiz);
        return cant;
    }
    private void retornarAltura(NodoArbol nodo, int nivel){
        if (nodo != null) {
            retornarAltura(nodo.getIzquierda(), nivel+1);
            if (nivel > altura) {
                altura = nivel;
                retornarAltura(nodo.getDerecha(), nivel+1);
            }
        }
    }
    public int retornarAltura(){
        altura = 0;
        retornarAltura(raiz, 1);
        return altura;
    }

}
