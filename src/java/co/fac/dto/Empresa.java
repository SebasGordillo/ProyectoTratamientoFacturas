
package co.fac.dto;

/**
 *
 * @author Sebas Gordillo
 */


public class Empresa {
  private String usuario;
  private String contrasena;
  private String direccion;
  private int telefono;
  private int nit;
  

    public Empresa() {
    }
    
     public Empresa(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public Empresa(String usuario, String contrasena, String direccion, int telefono, int nit) {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.direccion = direccion;
        this.telefono = telefono;
        this.nit = nit;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

   
    
    
    
    
    

    @Override
    public String toString() {
        return "Empresa{" + "usuario=" + usuario + ", contrasena=" + contrasena + '}';
    }


    
}
