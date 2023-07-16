package proyecto_final1;

/**
 *
 * @author Susana Vargas López
 */
/*ManejoGuia es una clase que ejecuta todas las funciones o metodos correspondientes
a el manejo de la Pila de Justificaciones. Se incluye constructor, Getter y setter*/
public class ManejoJustificaciones {
    private ObjetoJustificaciones vectorPila [];
    private int cima;
    
    public ManejoJustificaciones(int tamano){
        vectorPila = new ObjetoJustificaciones[tamano];
        tamano = 15;
        cima =0;
    }

    public ObjetoJustificaciones[] getVectorPila() {
        return vectorPila;
    }

    public void setVectorPila(ObjetoJustificaciones[] vectorPila) {
        this.vectorPila = vectorPila;
    }

    public int getCima() {
        return cima;
    }

    public void setCima(int cima) {
        this.cima = cima;
    }
    public int tamano(){
        return getVectorPila().length;
    }
    public boolean pilaVacia (){
        if (getCima()== 0) {
            return true;
        } else {
            return false;
        }
    }
    public boolean pilaLlena (int tamano){
        if (getCima()== tamano) {
            return true;
        } else {
            return false;
        }
    }
    /*Este metodo hace el push del objeto ObjetoJustificaciones completo a la pila */
    public void push (ObjetoJustificaciones justificacion){
        if (pilaLlena(tamano())== false) {
            vectorPila[getCima()] = justificacion;
            setCima(getCima()+1);
        } else {
            System.out.println("La pila esta llena. ");
        }
    }
    /*Este metodo hace el pop del objeto ObjetoJustificaciones completo a la pila */
    public ObjetoJustificaciones popJustificaciones (){
        ObjetoJustificaciones eliminar = null;
        if (getCima()==0) {
            System.out.println("La pila esta vacia. ");
        } else {
            setCima(getCima()-1);
            eliminar = vectorPila[getCima()];
        }
        return eliminar;
    }
    /*Este metodo muestra la pila completa de ObjetoJustificaciones sin perder los valores de la
    pila original*/
    public void MostrarPilaObjetoJustificaciones (ObjetoJustificaciones justificacion){
        ObjetoJustificaciones aux = null;
        ManejoJustificaciones pilaBackup = new ManejoJustificaciones(tamano());
        while (pilaVacia() == false) {            
            aux = popJustificaciones();
            System.out.println(aux);
            if (pilaBackup.pilaLlena(tamano()) == false) {
                pilaBackup.push(aux);
            }
        }
        while (pilaBackup.pilaVacia()== false) {            
            aux = pilaBackup.popJustificaciones();
            push(aux);
        }
    }
    /*Este metodo busca en la pila completa de Justificaciones por medio del idJustificacion
    sin perder los valores de la pila original*/
    public ObjetoJustificaciones BuscarJustificaciones(int idJustificacion){
        int cont = 0;
        ObjetoJustificaciones aux = null;
        ObjetoJustificaciones justificacionEncontrada = null;
        ManejoJustificaciones pilaBackup = new ManejoJustificaciones(tamano());
        while (pilaVacia() == false) {            
            aux = popJustificaciones();
            cont ++;
            if (aux.getJustificaciones().getIdJustificacion() == idJustificacion) {
                justificacionEncontrada = aux;
                System.out.println("Se encontro la justificacion solicitada en la posicion # "+ cont+" Fue ingresada el: "+aux.getJustificaciones().getFecha().toString());
            }
            if (pilaBackup.pilaLlena(tamano())== false) {
                pilaBackup.push(aux);
            }
        }
        while (pilaBackup.pilaVacia()== false) {            
            aux = pilaBackup.popJustificaciones();
            push(aux);
        }
        return justificacionEncontrada;
    }
    /*Este metodo muestra la cantidad de elementos presente en la pila Justificaciones*/
    public void mostrarCantElementos(){
        System.out.println("La cantidad de justificaciones agregadas es de: "+ getCima());
    }
    /*En el metodo recolector se comprueba si la pila se encuentra Llena (15 posiciones), 
    si esto es asi tiene una funcion para pasar todos los elementos a una pila de Back Up,
    pero a la hora de regresarlos hace pop de los 10 primeros y regresa solo los ultimos 5*/
    public void recolector(){
        if (pilaLlena(tamano())== true) {
            ObjetoJustificaciones aux = null;
            ManejoJustificaciones pilaBackup = new ManejoJustificaciones(tamano());
            while (pilaVacia() == false) {                
                aux = popJustificaciones();
                if (pilaBackup.pilaLlena(tamano())== false) {
                    pilaBackup.push(aux);
                }
            }
            for (int i = 0; i < 10; i++) {
                pilaBackup.popJustificaciones();
            }
            while (pilaBackup.pilaVacia()== false) {                
                aux = pilaBackup.popJustificaciones();
                push(aux);
            }
        }
    }
}
