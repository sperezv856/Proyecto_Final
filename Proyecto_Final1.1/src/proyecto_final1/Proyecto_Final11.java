package proyecto_final1;

/**
 *
 * @author josep
 */
public class Proyecto_Final11 {
<<<<<<< Updated upstream
=======

    public static ManejoUsuarios manejoUsuarios;
    public static ManejoCliente manejoCliente;
    public static ManejoMensajero manejoMensajero;
    public static ManejoGestor manejoGestor;

    public static void main(String[] args) {

        LogIn logIn = new LogIn();
        logIn.LogIn();
        Menus menus = Menus.getInstance();
        menus.IniciarDatos();
        menus.EscogerOpcionPrincipal();
    }
>>>>>>> Stashed changes

    public static void main(String[] args) {
        Menus menu = new Menus();
        menu.EscogerOpcionPrincipal();

        
    }
    
}
