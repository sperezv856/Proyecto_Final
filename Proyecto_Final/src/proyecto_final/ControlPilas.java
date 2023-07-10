package proyecto_final;

import java.util.Scanner;

/**
 *
 * @author josep
 */
public class ControlPilas {
    public String BusquedaEntrePilas(ManejoGuia guia, ManejoJustificaciones justificacion){
        Scanner scanner = new Scanner(System.in);
        int numeroGuia =0;
        String resultado = "El número de guía no se encontró en ninguna pila.";
        Guia guiaEncontrada = guia.BuscarPilaGuia(numeroGuia);
        if (guiaEncontrada != null) {
            resultado = "El numero de guia se encontro en la pila de Guias";
            return resultado;
        }
        ObjetoJustificaciones justificacionEncontrada = justificacion.BuscarJustificaciones(numeroGuia);
        if (justificacionEncontrada != null) {
            resultado = "El numero de guia se encontro en la pila de Justificaciones";
            return resultado;
        }
        return resultado;
    }    
}
