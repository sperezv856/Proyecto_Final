/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_final;

import java.util.Scanner;

/**
 *
 * @author josep
 */
public class Guia {
    Scanner scanner = new Scanner(System.in);
    private int IdGuia;
    
    public void CrearGuia(Cliente cliente, Servicio servicio, DetalleServicio detalle, TipoProducto producto){
        
    }
    public void CrearGuia(){
        
    }
    public void CrearCliente(Cliente cliente){
        System.out.println("Indique el numero de cedula: ");
        int cedula = scanner.nextInt();
        cliente.setCedula(cedula);
        System.out.println("Indique el nombre completo: ");
        String nombre = scanner.nextLine();
        cliente.setNombreCompleto(nombre);
        System.out.println("Indique el correo electronico: ");
        String email = scanner.nextLine();
        cliente.setEmail(email);
        System.out.println("Indique el telefono: ");
        int telefono = scanner.nextInt();
        cliente.setCelular(telefono);
        System.out.println("Indique la direccion: ");
        String direccion = scanner.nextLine();
        cliente.setDireccion(direccion);
        System.out.println("Indique el estado (Activo/Inactivo): ");
        String estado = scanner.nextLine();
        cliente.setEstado(estado);
    }
    public void CrearServicio(Servicio servicio){
        
    }
}
