package proyecto_final1;

/**
 *
 * @author josep
 */
//Clase de herencia utilizada por el Gestor, Cliente y Mensajero, con Getter y Setter
public class Persona {
    private int cedula;
    private String NombreCompleto;
    private String estado;

    public Persona(int cedula, String NombreCompleto, String estado) {
        this.cedula = cedula;
        this.NombreCompleto = NombreCompleto;
        this.estado = estado;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombreCompleto() {
        return NombreCompleto;
    }

    public void setNombreCompleto(String NombreCompleto) {
        this.NombreCompleto = NombreCompleto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
