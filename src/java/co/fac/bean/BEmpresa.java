package co.fac.bean;

import co.fac.dao.OperEmpresa;
import co.fac.dto.Empresa;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Esteban
 */
@ManagedBean
@ViewScoped
public class BEmpresa implements Serializable {

    private String usuario;
    private String contrasena;
    private String direccion;
    private int telefono;
    private int nit;

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

    public BEmpresa() {
    }
      public String lista() {
        return "listaEmpresa";
    }

    public void insertarEmpresa() {

        if (usuario == null || usuario.isEmpty() || direccion == null || direccion.isEmpty() || contrasena == null || telefono == 0 || nit == 0) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Atención", "Datos Nulos Revise"));
            return;
        }

        Empresa em = new Empresa();
        em.setUsuario(usuario);
        em.setContrasena(contrasena);
        em.setDireccion(direccion);
        em.setTelefono(telefono);
        em.setNit(nit);
         
        OperEmpresa operEm = new OperEmpresa();
        int rta = operEm.insertar(em);
        System.out.println("rta " + rta);
        if (rta > 0) {
            //this.mensaje = "Inserto "+r;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Atención", "Se registro la empresa"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", "llave repetida"));
        }

    }

    public void borrarEmpresa() {

        Empresa emi = new Empresa();
        emi.setUsuario(usuario);
        emi.setContrasena(contrasena);
        emi.setDireccion(direccion);
        emi.setTelefono(telefono);
        emi.setNit(nit);
        OperEmpresa operEm = new OperEmpresa();
        int rtas = operEm.borrar(emi);
        System.out.println("rta " + rtas);
        if (rtas > 0) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Atención", "Se eliminado con exito"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", "No existe llave"));
        }
    }
    
    public void limpiar(){
        this.usuario="";
        this.contrasena= "";
        this.direccion ="";
        this.nit=0;
        this.telefono=0;
    }
            

}
