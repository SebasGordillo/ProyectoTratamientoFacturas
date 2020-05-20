/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.fac.bean;

import co.fac.dao.OperEmpresa;
import co.fac.dto.Empresa;
import java.io.Serializable;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Sebas
 */
@ManagedBean
@ViewScoped
public class BeanLogin implements Serializable {

    private String usuario;
    private String contrasena;

    public BeanLogin() {
    }

    public String iniciarSesion() {

        String redireccion=null;
        if (usuario.isEmpty() || contrasena.isEmpty()) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "", "Datos incompletos"));

        } else {
            
            System.out.println("Entro al else");

            Empresa e = new Empresa();
            e.setUsuario(usuario);
            e.setContrasena(contrasena);

            OperEmpresa oper = new OperEmpresa();
            int rta = oper.iniciarSesion(e);
            System.out.println("rta " + rta);

            //Lo encontro
            if (rta == 1) {

                System.out.println("Usuario:" + e.toString());

                //Hay que dejarlo para mantener la sesion activa
                //  Map session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
                //session.put("Sesion", e);
                //FacesContext.getCurrentInstance().addMessage(null,
                  //      new FacesMessage(FacesMessage.SEVERITY_INFO, "Atención", "Inicio de sesión exitoso."));

                redireccion = "irRegistrar";

            } else {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_FATAL, "Atención", "Usuario o contraseña incorrectos."));
                System.out.println("Usuario:" + e.toString());
                
                
            }
        }
        
        return redireccion;
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

    public String irRegistro() {
        //System.out.println("Si redirecciono");
        return "irIndex";
    }
    
    public String atras(){
        return "irLogin";
    }
}
