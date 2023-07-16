package proyecto_final1;

/**
 *
 * @author josep
 */
// Clase para generar un objeto Ruta con sus Getter y Setter
public class Ruta {
    private String provincia;
    private String canton;
    private String rutaNombre;

    public Ruta(String provincia, String canton, String rutaNombre) {
        this.provincia = provincia;
        this.canton = canton;
        this.rutaNombre = rutaNombre;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public String getRutaNombre() {
        return rutaNombre;
    }

    public void setRutaNombre(String rutaNombre) {
        this.rutaNombre = rutaNombre;
    }
    public void mostrarRuta(){
        System.out.println("La provincia es; " + provincia);
        System.out.println("El canton es; " + canton);
        System.out.println("La ruta es; " + rutaNombre);
    }
}
