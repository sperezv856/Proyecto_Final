package proyecto_final;

import java.util.Scanner;

/**
 *
 * @author josep
 */
/*Esta clase realiza el manejo de las pilas para poder buscar un resultado en cualquiera
de las dos pilas creadas y devolver un mensaje que indique en que posicion se encontro
y a que pila pertenece*/
public class ControlPilas {
    public String BusquedaEntrePilas(ManejoGuia guia, ManejoJustificaciones justificacion){
        Scanner scanner = new Scanner(System.in);
        int numeroGuia =0;
        String resultado = "El número de guía no se encontró en ninguna pila.";
        Guia guiaEncontrada = guia.BuscarPilaGuia(numeroGuia); //Esta linea llama a la funcion que devuelve la posicion de la guia encontrada
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
