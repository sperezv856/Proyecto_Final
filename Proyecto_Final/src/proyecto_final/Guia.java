/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_final;

import java.util.Date;
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
    public Cliente crearCliente(){
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
    public Servicio crearServicio(){
        Date fecha = new Date();
        System.out.println("Indique el Id del servicio: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingrese las observaciones: ");
        String observaciones = scanner.nextLine();
        System.out.println("Ingrese las instrucciones del servicio: ");
        String instrucciones = scanner.nextLine();
        Servicio servicio = new Servicio(fecha, observaciones, instrucciones, id);
        servicio.setFechaServicio(fecha);
        servicio.setIdServicio(id);
        servicio.setObservaciones(observaciones);
        servicio.setInstrucciones(instrucciones);
        
        return servicio;
    }
    public DetalleServicio crearDetalle(){
        System.out.println("Indique el monto del servicio: ");
        int monto = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Indique las observaciones del servicio: ");
        String observaciones = scanner.nextLine();
        System.out.println("Indique el estado del servicio (Generada / En transito / Entregada / No entregada): ");
        String estado = scanner.nextLine();
        DetalleServicio detalle = new DetalleServicio(monto, observaciones, estado);
        detalle.setObservaciones(observaciones);
        detalle.setMonto(monto);
        detalle.setEstado(estado);
        return detalle;
    } 
}
