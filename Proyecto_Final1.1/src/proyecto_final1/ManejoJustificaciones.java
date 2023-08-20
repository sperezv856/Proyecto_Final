package proyecto_final1;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Susana Vargas López
 */
/*ManejoGuia es una clase que ejecuta todas las funciones o metodos correspondientes
a el manejo de la Pila de Justificaciones. Se incluye constructor, Getter y setter*/
public class ManejoJustificaciones {
    Scanner scanner = new Scanner(System.in);
    private Justificaciones vectorPila [];
    private int cima;
    
    public ManejoJustificaciones(int tamano){
        vectorPila = new Justificaciones[tamano];
        cima =0;
    }

    public Justificaciones[] getVectorPila() {
        return vectorPila;
    }

    public void setVectorPila(Justificaciones[] vectorPila) {
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
    public Justificaciones crearJustificacion(){
        System.out.println("Indique el numero de id:");
        int idJustificacion = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingrese las observaciones:");
        String observaciones = scanner.nextLine();
        Date fecha = new Date();
        Justificaciones justificaciones = new Justificaciones(idJustificacion, observaciones, fecha);
        justificaciones.setIdJustificacion(idJustificacion);
        justificaciones.setObservaciones(observaciones);
        justificaciones.setFecha(fecha);
        return justificaciones;
    }
    /*Este metodo hace el push del objeto Justificaciones completo a la pila */
    public void push (Justificaciones justificacion){
        if (pilaLlena(tamano())== false) {
            vectorPila[getCima()] = justificacion;
            setCima(getCima()+1);
        } else {
            System.out.println("La pila esta llena. ");
        }
    }
    /*Este metodo hace el pop del objeto Justificaciones completo a la pila */
    public Justificaciones popJustificaciones (){
        Justificaciones eliminar = null;
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
    public void MostrarPilaObjetoJustificaciones (Justificaciones justificacion){
        Justificaciones aux = null;
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
    public Justificaciones BuscarJustificaciones(int idJustificacion){
        int cont = 0;
        Justificaciones aux = null;
        Justificaciones justificacionEncontrada = null;
        ManejoJustificaciones pilaBackup = new ManejoJustificaciones(tamano());
        while (pilaVacia() == false) {            
            aux = popJustificaciones();
            cont ++;
            if (aux.getIdJustificacion() == idJustificacion) {
                justificacionEncontrada = aux;
                System.out.println("Se encontro la justificacion solicitada en la posicion # "+ cont+" Fue ingresada el: "+aux.getFecha().toString());
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
            Justificaciones aux = null;
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
    public void LimpiarJustificaciones() {
        while (!pilaVacia()) {            
            popJustificaciones();
        }
        System.out.println("Justificaciones eliminadas");
    }

}
