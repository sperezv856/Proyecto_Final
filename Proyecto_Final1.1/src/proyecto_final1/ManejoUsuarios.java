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
    /*public void IngresarDatosIniciales(){
        Cliente cliente1 = new Cliente("jose.p.munoz85@gmail.com", "San Juan, Tibas", 87026720, 112350023, "Jose Pablo Munoz", "Activo");
        Usuario usuario1 = new ClienteUsuario(cliente1, "jopamu", "Metal112");
        AgregarUsuario(usuario1);
        Gestor gestor1 = new Gestor("Administrador", "Gerente", 12345424, "Rolando Vega", "Activo");
        Usuario usuario2 = new GestorUsuario(gestor1, "admin", "admin123");
        AgregarUsuario(usuario2);
        Mensajero mensajero1 = new Mensajero(1, "Costarricense", 78141231, 154121421, "Julian Delgado","Activo");
        Usuario usuario3 = new MensajeroUsuario(mensajero1, "judelga", "456");
        AgregarUsuario(usuario3);
    }*/
}
