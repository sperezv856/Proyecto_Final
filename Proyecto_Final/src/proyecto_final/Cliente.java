package proyecto_final;

/**
 *
 * @author josep
 */
public class Cliente extends Persona{
    private String email;
    private String direccion;
    private int celular;

    public Cliente(String email, String direccion, int celular, int cedula, String NombreCompleto, String estado) {
        super(cedula, NombreCompleto, estado);
        this.email = email;
        this.direccion = direccion;
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }
    
}
