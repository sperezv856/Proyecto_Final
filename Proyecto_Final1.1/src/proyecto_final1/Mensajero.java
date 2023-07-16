/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_final1;

/**
 *
 * @author josep
 */
/*Clase dedicada para crear el objeto Mensajero que tiene herencia de Persona,
Se incluyen los Getter y Setter necesarios*/
public class Mensajero extends Persona{
    private int CodigoMensajero;
    private String Nacionalidad;
    private int Telefono;

    public Mensajero(int CodigoMensajero, String Nacionalidad, int Telefono, int cedula, String NombreCompleto, String estado) {
        super(cedula, NombreCompleto, estado);
        this.CodigoMensajero = CodigoMensajero;
        this.Nacionalidad = Nacionalidad;
        this.Telefono = Telefono;
    }

    public int getCodigoMensajero() {
        return CodigoMensajero;
    }

    public void setCodigoMensajero(int CodigoMensajero) {
        this.CodigoMensajero = CodigoMensajero;
    }

    public String getNacionalidad() {
        return Nacionalidad;
    }

    public void setNacionalidad(String Nacionalidad) {
        this.Nacionalidad = Nacionalidad;
    }

    public int getTelefono() {
        return Telefono;
    }

    public void setTelefono(int Telefono) {
        this.Telefono = Telefono;
    }
    
}
