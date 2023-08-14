package proyecto_final1;

/**
 *
 * @author josep
 */
public class Proyecto_Final11 {
  
    public static void main(String[] args) {
        LogIn logIn = new LogIn();
        logIn.LogIn();
        Menus menus = Menus.getInstance();
        menus.IniciarDatos();
        menus.EscogerOpcionPrincipal();
    }

}
