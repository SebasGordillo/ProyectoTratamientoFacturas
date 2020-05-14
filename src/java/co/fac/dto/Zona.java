package co.fac.dto;

/**
 *
 * @author Sebas Gordillo
 */
public class Zona {

    private String localidad;

    public Zona() {
    }

    public Zona(String localidad) {
        this.localidad = localidad;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    @Override
    public String toString() {
        return "Zona{" + "localidad=" + localidad + '}';
    }
    
    

}
