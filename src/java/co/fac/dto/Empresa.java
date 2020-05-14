
package co.fac.dto;

/**
 *
 * @author Sebas Gordillo
 */


public class Empresa {
  private String usuario;
  private int contrasena;

    public Empresa() {
    }

    public Empresa(String usuario, int contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getContrasena() {
        return contrasena;
    }

    public void setContrasena(int contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public String toString() {
        return "Empresa{" + "usuario=" + usuario + ", contrasena=" + contrasena + '}';
    }


    
}
