package proyecto_final1;

/**
 *
 * @author josep
 */
public class GestorUsuario extends Usuario{
    private Gestor gestor;

    public GestorUsuario(Gestor gestor, String UserName, String Password) {
        super(UserName, Password);
        this.gestor = gestor;
    }

    public Gestor getGestor() {
        return gestor;
    }

    public void setGestor(Gestor gestor) {
        this.gestor = gestor;
    }
    
}
