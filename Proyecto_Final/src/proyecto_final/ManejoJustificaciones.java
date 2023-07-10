package proyecto_final;

/**
 *
 * @author josep
 */
public class ManejoJustificaciones {
    private ObjetoJustificaciones vectorPila [];
    private int cima;
    
    public ManejoJustificaciones(int tamano){
        vectorPila = new ObjetoJustificaciones[tamano];
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
    public void push (ObjetoJustificaciones justificacion){
        if (pilaLlena(tamano())== false) {
            vectorPila[getCima()] = justificacion;
            setCima(getCima()+1);
        } else {
            System.out.println("La pila esta llena. ");
        }
    }
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
    public void mostrarCantElementos(){
        System.out.println("La cantidad de justificaciones agregadas es de: "+ getCima());
    }
}
