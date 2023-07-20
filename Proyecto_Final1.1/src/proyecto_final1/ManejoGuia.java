package proyecto_final1;

import java.util.Scanner;

/**
 *
 * @author Susana Vargas López
 */
/*ManejoGuia es una clase que ejecuta todas las funciones o metodos correspondientes
a el manejo de la Pila de Guias. Se incluye constructor, Getter y setter*/
public class ManejoGuia {

    Scanner scanner = new Scanner(System.in);
    private boolean estadoServicio = false;
    private Guia guia;
    private Guia vectorPila[];
    private int cima;

    public ManejoGuia(int tamano) {
        vectorPila = new Guia[tamano];
        cima = 0;
    }

    public Guia[] getVectorPila() {
        return vectorPila;
    }

    public void setVectorPila(Guia[] vectorPila) {
        this.vectorPila = vectorPila;
    }

    public int getCima() {
        return cima;
    }

    public void setCima(int cima) {
        this.cima = cima;
    }

    public int tamano() {
        return getVectorPila().length;
    }

    public Guia getGuia() {
        return guia;
    }

    public void setGuia(Guia guia) {
        this.guia = guia;
    }

    public boolean isEstadoServicio() {
        return estadoServicio;
    }

    public void setEstadoServicio(boolean estadoServicio) {
        this.estadoServicio = estadoServicio;
    }

    public boolean pilaVacia() {
        if (getCima() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean pilaLlena(int tamano) {
        if (getCima() == tamano) {
            return true;
        } else {
            return false;
        }
    }

    /*Este metodo hace el push del objeto Guia completo a la pila */
    public void push(Guia guia) {
        if (pilaLlena(tamano()) == false) {
            vectorPila[getCima()] = guia;
            setCima(getCima() + 1);
        } else {
            System.out.println("La pila esta llena. ");
        }
    }

    /*Este metodo hace el pop del objeto Guia completo a la pila */
    public Guia popGuia() {
        Guia eliminar = null;
        if (getCima() == 0) {
            System.out.println("La pila esta vacia. ");
        } else {
            setCima(getCima() - 1);
            eliminar = vectorPila[getCima()];
        }
        return eliminar;
    }

    /*Este metodo muestra la pila completa de Guia sin perder los valores de la
    pila original*/
    public void MostrarPilaGuia() {
        Guia aux = null;
        ManejoGuia pilaBackup = new ManejoGuia(tamano());
        while (pilaVacia() == false) {
            aux = popGuia();
            System.out.println(aux.toString());
            if (pilaBackup.pilaLlena(tamano()) == false) {
                pilaBackup.push(aux);
            }
        }
        while (pilaBackup.pilaVacia() == false) {
            aux = pilaBackup.popGuia();
            push(aux);
        }
    }

    /*Este metodo busca en la pila completa de Guia por medio del idGuia
    sin perder los valores de la pila original*/
    public Guia BuscarPilaGuia(int idGuia) {
        int cont = 0;
        Guia aux = null;
        Guia guiaEncontrada = null;
        ManejoGuia pilaBackup = new ManejoGuia(tamano());
        while (pilaVacia() == false) {
            aux = popGuia();
            cont++;
            if (aux.getDetalle().getIdGuia() == idGuia) {
                guiaEncontrada = aux;
                System.out.println("Se encontro la guia solicitada en la posicion # " + cont + " Fue ingresada el: " + aux.getServicio().getFechaServicio().toString());
            }
            if (pilaBackup.pilaLlena(tamano()) == false) {
                pilaBackup.push(aux);
            }
        }
        while (pilaBackup.pilaVacia() == false) {
            aux = pilaBackup.popGuia();
            push(aux);
        }
        return guiaEncontrada;
    }

    /*Este metodo muestra la cantidad de elementos presente en la pila Guia*/
    public void mostrarCantElementos() {
        System.out.println("La cantidad de guias agregadas es de: " + getCima());
    }

    public boolean estadoServicio() {
        System.out.println("Desea colocar Sin servicio el sistema de Guias?: (y / n)");
        String opcion = scanner.nextLine();
        if (opcion.equals("y")) {
            setEstadoServicio(true);
        } else {
            setEstadoServicio(false);
        }
        return estadoServicio;
    }
    public void LimpiarGuia() {
        while (!pilaVacia()) {            
            popGuia();
        }
    }
    public void RevisarDetalle (){
        System.out.println("Ingrese el numero de servicio a revisar: ");
        int id = scanner.nextInt();
        Guia detalle = BuscarPilaGuia(id);
        
        System.out.println("Detalle del servicio: Id: "+ detalle.getDetalle().getIdGuia() 
                +" Observaciones: " +detalle.getDetalle().getObservaciones()
                + " Monto: " +detalle.getDetalle().getMonto()+" Estado: "
                +detalle.getDetalle().getEstado());
    }
}
