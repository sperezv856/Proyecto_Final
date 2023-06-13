package proyecto_final;

/**
 *
 * @author josep
 */
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
    
}
