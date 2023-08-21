package proyecto_final1;

import java.util.Scanner;

/**
 *
 * @author josep
 */
public class ObjetoGestor {
    Scanner scanner = new Scanner(System.in);
    private Guia guia;
    private Ruta ruta;
    private Mensajero mensajero;
    private ManejoGuia manejoGuia;
    private ManejoRutas manejoRutas;
    private ManejoMensajero manejoMensajero;

    public ObjetoGestor(Guia guia, Ruta ruta, Mensajero mensajero) {
        this.guia = guia;
        this.ruta = ruta;
        this.mensajero = mensajero;
    }

    public Guia getGuia() {
        return guia;
    }

    public void setGuia(Guia guia) {
        this.guia = guia;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

    public Mensajero getMensajero() {
        return mensajero;
    }

    public void setMensajero(Mensajero mensajero) {
        this.mensajero = mensajero;
    }
    public ObjetoGestor CrearEntrada(Guia guia){
        System.out.println("Ingrese el nombre de la ruta a asignar: ");
        String nombreRuta = scanner.nextLine();
        System.out.println("Ingrese el Codigo de mensajero a asignar: ");
        int codigoMensajero = scanner.nextInt();
        scanner.nextLine();
        ruta = manejoRutas.BuscarRuta(nombreRuta);
        mensajero = manejoMensajero.buscarMensajero(codigoMensajero);
        ObjetoGestor objetoGestor = new ObjetoGestor(guia, ruta, mensajero);
        return objetoGestor;
    }
}
