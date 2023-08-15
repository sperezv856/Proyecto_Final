package proyecto_final1;

/**
 *
 * @author josep
 */
public class MensajeroUsuario extends Usuario{
    private Mensajero mensajero;

    public MensajeroUsuario(Mensajero mensajero, String UserName, String Password) {
        super(UserName, Password);
        this.mensajero = mensajero;
    }

    public Mensajero getMensajero() {
        return mensajero;
    }

    public void setMensajero(Mensajero mensajero) {
        this.mensajero = mensajero;
    }
    
}
