package proyecto_final1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author josep
 */
public class ManejoUsuarios {
    private List<Usuario> usuarios;
    
    public ManejoUsuarios(){
        usuarios = new ArrayList<>();
    }
    public void AgregarUsuario(Usuario usuario){
        usuarios.add(usuario);
    }
    public Usuario autenticar(String userName, String password){
        for (Usuario usuario : usuarios) {
            if (usuario.getUserName().equals(userName) && usuario.getPassword().equals(password)) {
                return usuario;
            }
        }
        return null;
    }
}
