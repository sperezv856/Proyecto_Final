package proyecto_final1;

/**
 *
 * @author josep
 */
public class ClienteUsuario extends Usuario{
    private Cliente cliente;

    public ClienteUsuario(Cliente cliente, String UserName, String Password) {
        super(UserName, Password);
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
   
}
