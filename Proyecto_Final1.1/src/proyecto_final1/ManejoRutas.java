package proyecto_final1;

import java.util.Scanner;

/**
 *
 * @author josep
 */
/*Clase para hacer el manejo de las rutas por medio de una lista Simple,
Se incluyen Getter y Setter*/
public class ManejoRutas {

    Scanner scanner = new Scanner(System.in);
    private NodoListaSimple ultimo;
    private NodoListaSimple primero;

    public ManejoRutas() {
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

    public Ruta crearRuta() {
        System.out.println("Indique el nombre de la Ruta: ");
        String nombre = scanner.nextLine();
        System.out.println("Indique la Provincia: ");
        String provincia = scanner.nextLine();
        System.out.println("Indique el Canton: ");
        String canton = scanner.nextLine();
        Ruta ruta = new Ruta(provincia, canton, nombre);
        ruta.setRutaNombre(nombre);
        ruta.setProvincia(provincia);
        ruta.setCanton(canton);
        return ruta;
    }

    //Metodo para ingresar un nuevo objeto Ruta a la lista
    public void IngresarRuta(Ruta ruta) {
        NodoListaSimple nodoNuevo = new NodoListaSimple();
        nodoNuevo.setRuta(ruta);
        if (getPrimero() == null) {
            setPrimero(nodoNuevo);
            getPrimero().setSiguiente(nodoNuevo);
            setUltimo(getPrimero());
        } else {
            getUltimo().setSiguiente(nodoNuevo);
            nodoNuevo.setSiguiente(null);
            setUltimo(nodoNuevo);
        }
    }

    //Metodo para buscar un objeto Ruta por medio del nombre de la ruta llamado rutn
    public void BuscarRuta(String rutn) {
        NodoListaSimple actual = new NodoListaSimple();
        actual = getPrimero();
        while (actual != null) {
            if (actual.getRuta().getRutaNombre().equals(rutn)) {
                System.out.println("Ruta Encontrada");
                System.out.println("Nombre de ruta: " + actual.getRuta().getRutaNombre());
                System.out.println("Provincia: " + actual.getRuta().getProvincia());
                System.out.println("Canton: " + actual.getRuta().getCanton());
            }
            actual = actual.getSiguiente();
        }
        System.out.println("Ruta no encontrada");
    }

    //Metodo para eliminar un objeto Ruta por medio del nombre de la ruta llamado rutn
    public void EliminarRuta(String rutn) {
        NodoListaSimple actual = new NodoListaSimple();
        NodoListaSimple anterior = new NodoListaSimple();
        actual = getPrimero();
        anterior = null;
        while (actual != null) {
            if (actual.getRuta().getRutaNombre().equals(rutn)) {
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

    //Metodo para modificar un objeto Ruta por medio del nombre de la ruta llamado rutn
    // Se deberia crear un submenu para solicitar al usuario cual parametro desea modificar
    public void ModificarRuta(String rutn) {
        NodoListaSimple actual = getPrimero();
        while (actual != null) {
            if (actual.getRuta().getRutaNombre().equals(rutn)) {
                boolean continuar = true;
                while (continuar) {
                    System.out.println(" -------------- Opciones -----------------");
                    System.out.println("1. Modificar nombre. ");
                    System.out.println("2. Modificar Provincia. ");
                    System.out.println("3. Modificar Canton");
                    System.out.println("4. Salir");
                    System.out.println("Seleccione una opcion: ");
                    int opcion = scanner.nextInt();
                    switch (opcion) {
                        case 1:
                            System.out.println("Ingrese el nuevo nombre: ");
                            String nuevoNombre = scanner.nextLine();
                            actual.getRuta().setRutaNombre(nuevoNombre);
                            break;
                        case 2:
                            System.out.println("Ingrese ls nueva Provincia: ");
                            String nuevoProvincia = scanner.nextLine();
                            actual.getRuta().setProvincia(nuevoProvincia);
                            break;
                        case 3:
                            System.out.println("Ingrese el nuevo Canton: ");
                            String nuevoCanton = scanner.nextLine();
                            actual.getRuta().setCanton(nuevoCanton);
                            break;
                        case 4:
                            System.out.println("Finalizando los cambios ");
                            continuar = false;
                            break;
                    }
                }
                System.out.println("Ruta nmodificada correctamente");
            }
            actual = actual.getSiguiente();
        }
        System.out.println("Ruta no encontrada");
    }

    public void MostrarRuta() {
        NodoListaSimple aux1 = getPrimero();
        while (aux1 != null) {
            Ruta ruta = aux1.getRuta();
            System.out.println("Nombre de ruta : " + aux1.getRuta().getRutaNombre() + " Provincia: "
                    + aux1.getRuta().getProvincia() + " Canton: " + aux1.getRuta().getCanton());
            aux1 = aux1.getSiguiente();
        }
    }

}
