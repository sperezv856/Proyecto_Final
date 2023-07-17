/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_final1;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author josep
 */
/*Clase para el objeto guia, primeramente se genera lo necesario para crear el objeto con 
su contructor y Getter y Setter*/
public class Guia {

    Scanner scanner = new Scanner(System.in);
    private ManejoCliente cliente;
    private Servicio servicio;
    private DetalleServicio detalle;
    private ManejoProductos producto;
    private Ruta ubicacionPaquete;

    public Guia(ManejoCliente cliente, Servicio servicio, DetalleServicio detalle, ManejoProductos producto) {
        this.cliente = cliente;
        this.servicio = servicio;
        this.detalle = detalle;
        this.producto = producto;
    }

    public ManejoCliente getCliente() {
        return cliente;
    }

    public void setCliente(ManejoCliente cliente) {
        this.cliente = cliente;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public DetalleServicio getDetalle() {
        return detalle;
    }

    public void setDetalle(DetalleServicio detalle) {
        this.detalle = detalle;
    }

    public ManejoProductos getProducto() {
        return producto;
    }

    public void setProducto(ManejoProductos producto) {
        this.producto = producto;
    }

    public Ruta getUbicacionPaquete() {
        return ubicacionPaquete;
    }

    public void setUbicacionPaquete(Ruta ubicacionPaquete) {
        this.ubicacionPaquete = ubicacionPaquete;
    }

    /*En el siguiente metodo se pretende crear una guia completa con todos los
    componentes necesarios, Cliente, Servicio, Detalle de servicio y Producto. 
    Por esta razon debemos generar un objeto Guia con todos los objetos mencionados*/
    public Guia CrearGuia() {
        setCliente(buscarCliente(cliente));
        setServicio(servicio.crearServicio());
        setDetalle(detalle.crearDetalle());
        setProducto(buscarProducto(producto));

        Guia guia = new Guia(cliente, servicio, detalle, producto);
        return guia;
    }
    /*Esta funcion solicita al usuario seleccionar el producto de una lista previamente creada
    una vez seleccionado envia el Objeto para generar la guia.
    Nota: Estoy evaluando si esta funcion deberia de ir aca o en la clase de Producto*/
    public ManejoProductos buscarProducto(ManejoProductos producto) {
        System.out.println("Ingrese el codigo de producto a seleccionar. ");
        int cdp = scanner.nextInt();
        producto.buscarProducto(cdp);
        return producto;
    }
    /*Esta funcion solicita al usuario seleccionar el producto de una lista previamente creada
    una vez seleccionado envia el Objeto para generar la guia.
    Nota: Estoy evaluando si esta funcion deberia de ir aca o en la clase de Producto*/
    public ManejoCliente buscarCliente(ManejoCliente cliente) {
        System.out.println("Ingrese el numero de cedula a seleccionar. ");
        int ced = scanner.nextInt();
        cliente.buscarCliente(ced);
        return cliente;
    }

    /*Este metodo es el punto 15 mostrar la ruta del paquete */
    public void mostrarRuta() {
        ubicacionPaquete.mostrarRuta();
    }
}
