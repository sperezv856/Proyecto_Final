package proyecto_final1;

/**
 *
 * @author josep
 */
public class Usuario {
    private String UserName;
    private String Password;

    public Usuario(String UserName, String Password) {
        this.UserName = UserName;
        this.Password = Password;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
}
