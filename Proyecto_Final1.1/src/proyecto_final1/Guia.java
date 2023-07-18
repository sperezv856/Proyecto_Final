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
    private Cliente cliente;
    private Servicio servicio;
    private DetalleServicio detalle;
    private TipoProducto producto;
    private Ruta ubicacionPaquete;

    public Guia(Cliente cliente, Servicio servicio, DetalleServicio detalle, TipoProducto producto) {
        this.cliente = cliente;
        this.servicio = servicio;
        this.detalle = detalle;
        this.producto = producto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
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

    public TipoProducto getProducto() {
        return producto;
    }

    public void setProducto(TipoProducto producto) {
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
     public Guia CrearGuia(ManejoCliente manejoCliente, Servicio servicio, DetalleServicio detalle, ManejoProductos manejoProductos) {
        Cliente cliente = buscarCliente(manejoCliente);
        servicio = servicio.crearServicio();
        detalle = detalle.crearDetalle();
        TipoProducto producto = buscarProducto(manejoProductos);

        Guia guia = new Guia(cliente, servicio, detalle, producto);
        return guia;
    }
    public static Cliente buscarCliente(ManejoCliente manejoCliente) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el numero de cedula a seleccionar. ");
        int ced = scanner.nextInt();
        return manejoCliente.buscarCliente(ced);
    }
    public static TipoProducto buscarProducto(ManejoProductos manejoProductos) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el codigo de producto a seleccionar. ");
        int cdp = scanner.nextInt();
        return manejoProductos.buscarProducto(cdp);
    }
    /*Este metodo es el punto 15 mostrar la ruta del paquete */
    public void mostrarRuta() {
        ubicacionPaquete.mostrarRuta();
    }
     @Override
    public String toString() {
        // Personalizamos la representación en cadena de Guia
        return "Cliente: Cedula: "+ getCliente().getCedula()+ " Nombre Completo: "
                + getCliente().getNombreCompleto()+" Email: "+ getCliente().getEmail() 
                + " Telefono: "+ getCliente().getCelular()+" Direccion: "
                + getCliente().getDireccion()+" Estado: "+getCliente().getEstado() 
                + " Servicio: Id de servicio: " + getServicio().getIdServicio() 
                + " Fecha: "+ getServicio().getFechaServicio() + " Observaciones: "
                + getServicio().getObservaciones()+" Instrucciones: "+ getServicio().getInstrucciones() 
                + " Detalle del servicio: ID de Guia: "+ getDetalle().getIdGuia() 
                + " Observaciones del servicio "+ getDetalle().getObservaciones() 
                + " Monto: "+ getDetalle().getMonto()+" Estado de servicio: " + getDetalle().getEstado() 
                + " Producto: Id del producto: " + getProducto().getIdTipoProducto() 
                + " Observaciones: " + getProducto().getObservaciones() + " Monto " 
                + getProducto().getMonto()+ " Estado del producto: " + getProducto().getEstado();
    }
}
