package proyecto_final1;

/**
 *
 * @author josep
 */
/*Clase para generar el objeto Gestor, este Hereda argumentos de Persona. 
Se incluyen Getter y Setter*/
public class Gestor extends Persona{
    private String tipoGestor;
    private String funciones;

    public Gestor(String tipoGestor, String funciones, int cedula, String NombreCompleto, String estado) {
        super(cedula, NombreCompleto, estado);
        this.tipoGestor = tipoGestor;
        this.funciones = funciones;
    }

    public String getTipoGestor() {
        return tipoGestor;
    }

    public void setTipoGestor(String tipoGestor) {
        this.tipoGestor = tipoGestor;
    }

    public String getFunciones() {
        return funciones;
    }

    public void setFunciones(String funciones) {
        this.funciones = funciones;
    }
        
}
