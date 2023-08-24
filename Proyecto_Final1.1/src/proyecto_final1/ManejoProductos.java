package proyecto_final1;

import java.util.Scanner;

/**
 *
 * @author josep
 */
/*Clase para el manejo de los productos por medio de una lista Simple, incluye
Getter y Setter*/
public class ManejoProductos {

    Scanner scanner = new Scanner(System.in);
    private NodoListaSimple ultimo;
    private NodoListaSimple primero;

    public ManejoProductos() {
        primero = null;
        ultimo = null;
    }

    public NodoListaSimple getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoListaSimple ultimo) {
        this.ultimo = ultimo;
    }

    public NodoListaSimple getPrimero() {
        return primero;
    }

    public void setPrimero(NodoListaSimple primero) {
        this.primero = primero;
    }

    public boolean Vacia() {
        if (getPrimero() == null) {
            return true;
        } else {
            return false;
        }
    }

    public void inicializarLista() {
        primero = null;
        ultimo = null;
    }

    public TipoProducto crearProducto() {
        try {
            System.out.println("Indique el ID del producto: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Indique las observaciones del producto: ");
            String observaciones = scanner.nextLine();
            System.out.println("Indique el Monto del producto: ");
            int monto = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Indique el Estado del producto: ");
            String estado = scanner.nextLine();
            TipoProducto producto = new TipoProducto(id, monto, observaciones, estado);
            producto.setIdTipoProducto(id);
            producto.setObservaciones(observaciones);
            producto.setMonto(monto);
            producto.setEstado(estado);
            return producto;
            } catch (InputMismatchException e) {
            System.out.println("Error: Ingreso inválido. Asegúrate de ingresar valores correctos.");
            scanner.nextLine(); 
            return null;
        }
    }
    }
    // Metodo para el ingreso de un nuevo objeto TipoProducto

    public void IngresarProducto(TipoProducto producto) {
        try {
            NodoListaSimple nodoNuevo = new NodoListaSimple();
            nodoNuevo.setProducto(producto);
        if (getPrimero() == null) {
            setPrimero(nodoNuevo);
            setUltimo(nodoNuevo);
            nodoNuevo.setSiguiente(null);
        } else {
            getUltimo().setSiguiente(nodoNuevo);
            nodoNuevo.setSiguiente(null);
            setUltimo(nodoNuevo);
            } catch (Exception e) {
            System.out.println("Error al ingresar el producto: " + e.getMessage());
        }
    
        }
    }
        

    // Metodo para busqueda de un objeto TipoProducto por medio de el codigo de producto llamado cdp
    public TipoProducto buscarProducto(int cdp) {
        NodoListaSimple actual = new NodoListaSimple();
        actual = getPrimero();
        while (actual != null) {
            if (actual.getProducto().getIdTipoProducto() == cdp) {
                System.out.println("Producto Encontrado");
                System.out.println("Id de producto: " + actual.getProducto().getIdTipoProducto());
                System.out.println("Observacion: " + actual.getProducto().getObservaciones());
                System.out.println("Monto: " + actual.getProducto().getMonto());
                System.out.println("Estado: " + actual.getProducto().getEstado());
                return actual.getProducto();
                
            }
            actual = actual.getSiguiente();
        }
        System.out.println("Producto no encontrado");
        return null;
    }

    // Metodo para eliminar un objeto TipoProducto por medio de el codigo de producto llamado cdp
    public void EliminarProducto(int cdp) {
        NodoListaSimple actual = new NodoListaSimple();
        NodoListaSimple anterior = new NodoListaSimple();
        actual = getPrimero();
        anterior = null;
        while (actual != null) {
            if (actual.getProducto().getIdTipoProducto() == cdp) {
                if (actual == getPrimero()) {
                    setPrimero(getPrimero().getSiguiente());
                } else {
                    anterior.setSiguiente(actual.getSiguiente());
                }
            }
            anterior = actual;
            actual = actual.getSiguiente();
        }
    }

    // Metodo para modificar un objeto TipoProducto por medio de el codigo de producto llamado cdp
    // Se deberia crear un submenu para solicitar al usuario cual parametro desea modificar
    public void ModificarProducto(int cdp) {
        NodoListaSimple actual = getPrimero();
        while (actual != null) {
            if (actual.getProducto().getIdTipoProducto() == cdp) {
                boolean continuar = true;
                while (continuar) {
                    System.out.println(" -------------- Opciones -----------------");
                    System.out.println("1. Modificar el ID del producto. ");
                    System.out.println("2. Modificar las observaciones. ");
                    System.out.println("3. Modificar el Monto");
                    System.out.println("4. Modificar el Estado");
                    System.out.println("5. Salir");
                    System.out.println("Seleccione una opcion: ");
                    int opcion = scanner.nextInt();
                    switch (opcion) {
                        case 1:
                            System.out.println("Ingrese el nuevo ID del producto: ");
                            int nuevoID = scanner.nextInt();
                            actual.getProducto().setIdTipoProducto(nuevoID);
                            break;
                        case 2:
                            System.out.println("Ingrese las nuevas observaciones: ");
                            String nuevaObservacion = scanner.nextLine();
                            actual.getProducto().setObservaciones(nuevaObservacion);
                            break;
                        case 3:
                            System.out.println("Ingrese el nuevo Monto: ");
                            int nuevoMonto = scanner.nextInt();
                            actual.getProducto().setMonto(nuevoMonto);
                            break;
                        case 4:
                            String nuevoEstado = scanner.nextLine();
                            actual.getProducto().setEstado(nuevoEstado);
                            System.out.println("Producto modificado correctamente");
                            break;
                        case 5:
                            System.out.println("Finalizando los cambios");
                            continuar = false;
                            break;
                    }
                }
                System.out.println("Producto modificado correctamente");
            
            }
            actual = actual.getSiguiente();
        }
        System.out.println("Producto no encontrado");
    }

    public void MostrarProductos() {
        NodoListaSimple aux1 = getPrimero();
        while (aux1 != null) {
            TipoProducto producto = aux1.getProducto();
            System.out.println("Id Producto : " + aux1.getProducto().getIdTipoProducto() + " Observaciones: "
                    + aux1.getProducto().getObservaciones() + " Monto: " + aux1.getProducto().getMonto()
                    + " Estado: " + aux1.getProducto().getEstado());
            aux1 = aux1.getSiguiente();
        }

    }

    public void IngresarDatosIniciales() {
        TipoProducto producto1 = new TipoProducto(001, 35000, "Tennis Puma", "Activo");
        IngresarProducto(producto1);
        TipoProducto producto2 = new TipoProducto(002, 55000, "Gameboy", "Activo");
        IngresarProducto(producto2);
        TipoProducto producto3 = new TipoProducto(003, 150000, "Monitor LCD", "Activo");
        IngresarProducto(producto3);

    }
}
