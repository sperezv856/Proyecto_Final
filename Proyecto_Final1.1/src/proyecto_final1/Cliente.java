package proyecto_final1;

import java.util.Scanner;

/**
 *
 * @author josep
 */
/*Clase de cliente que hereda parametros de la clase persona, se incluyen todos los 
Getter y Setter necesarios asi como el constructor*/
public class Cliente extends Persona{
    Scanner scanner = new Scanner(System.in);
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
    /*Esta funcion solicita al usuario los datos necesarios para crear el objeto Cliente*/
    public Cliente crearCliente() {
        System.out.println("Indique el numero de cedula: ");
        int cedula = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Indique el nombre completo: ");
        String nombre = scanner.nextLine();
        System.out.println("Indique el correo electronico: ");
        String email = scanner.nextLine();
        System.out.println("Indique el telefono: ");
        int telefono = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Indique la direccion: ");
        String direccion = scanner.nextLine();
        System.out.println("Indique el estado (Activo / Inactivo): ");
        String estado = scanner.nextLine();
        Cliente cliente = new Cliente(email, direccion, telefono, cedula, nombre, estado);
        cliente.setCedula(cedula);
        cliente.setNombreCompleto(nombre);
        cliente.setEmail(email);
        cliente.setCelular(telefono);
        cliente.setDireccion(direccion);
        cliente.setEstado(estado);

        return cliente;
    }
}
