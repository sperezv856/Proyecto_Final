
package proyecto_final;

/**
 *
 * @author josep
 */
public class Pila {
    private int vectorPila[];
    private int cima;
  
    public Pila(int tamano){
        vectorPila = new int [tamano];
        cima = 0 ;
    }    
    
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
            System.out.println("La pila esta vacia");
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
