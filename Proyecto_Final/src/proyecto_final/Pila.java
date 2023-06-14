
package proyecto_final;

/**
 *
 * @author josep
 */
public class Pila {
    private int vectorPila[];
    private int cima;

    public Pila(int[] vectorPila, int cima) {
        this.vectorPila = vectorPila;
        this.cima = cima;
    }

    public int[] getVectorPila() {
        return vectorPila;
    }

    public void setVectorPila(int[] vectorPila) {
        this.vectorPila = vectorPila;
    }

    public int getCima() {
        return cima;
    }

    public void setCima(int cima) {
        this.cima = cima;
    }
    
    public Pila(int tamano){
        vectorPila = new int [tamano];
        cima = 0 ;
    }
    
    /*public void inicializaPila (int tamano){
        vectorPila = new int[tamano];
    }*/
    
    public void push (int dato) {
    	if(pilaLlena(tamano())==false) {
	        vectorPila[cima] = dato;
	        cima++;
    	} else {
    		System.out.println("La pila esta llena");
    	}
    }
    
    public int pop(){
        int eliminar = 0;
        if (cima == 0){
            System.out.println("pila vacia");
        } else{
            eliminar = vectorPila[cima - 1];
            cima --;
        }
        return eliminar;
    }
    
    public int tamano(){
        return vectorPila.length;
    }
    
    public boolean pilaVacia (){
        if (cima == 0){
            return true;
        } else{
            return false;
        }
    }
    
    public boolean pilaLlena(int tamano){
        if (cima == tamano ){
            return true;
        } else{
            return false;
        }
    }
    
    public void mostrarPila() {
        int copiaCima = cima;
        while(pilaVacia()==false){
            System.out.println(pop());
        }
        cima = copiaCima;
    }
    
    public void extFondo() {
    	int copiaCima = cima;
        int aux = 0;
        while(pilaVacia()==false){
            aux = pop();
        }
        System.out.println(aux);
        cima = copiaCima;
    }
    
    public void pasarDatos() {
    	int copiaCima = cima;
        int aux = 0;
        Pila pilaDos = new Pila(tamano());
        while(pilaVacia()==false) {
            aux = pop();
            if(pilaDos.pilaLlena(tamano())==false)
                pilaDos.push(aux);
            else
                System.out.println("Esta llena");
        }
        pilaDos.mostrarPila();
        cima = copiaCima;
    }
}
