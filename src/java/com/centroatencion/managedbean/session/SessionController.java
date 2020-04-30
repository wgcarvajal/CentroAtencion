/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.managedbean.session;

import com.centroatencion.entities.Usuariogrupo;
import com.centroatencion.facade.UsuariogrupoFacade;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import org.primefaces.PrimeFaces;

/**
 *
 * @author geovanny
 */
@Named("sessionController")
@SessionScoped
public class SessionController implements Serializable {

    
    @EJB
    private UsuariogrupoFacade usuarioGrupoEJB;
    String nombreDeUsuario;    
    String contrasena;
    
    private Boolean haySesion;
    
    public SessionController()
    {
        haySesion=false;
    }

    public Boolean getHaySesion() {
        return haySesion;
    }

    public void setHaySesion(Boolean haySesion) {
        this.haySesion = haySesion;
    }
    
    
    
    public String getNombreDeUsuario()
    {
        return nombreDeUsuario;
    }

    public void setNombreDeUsuario(String nombreDeUsuario) 
    {
        this.nombreDeUsuario = nombreDeUsuario;
    }

    public String getContrasena() 
    {
        return contrasena;
    }

    public void setContrasena(String contrasena)
    {
        this.contrasena = contrasena;
    }
       
    public void login()throws IOException, ServletException 
    {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpServletRequest req = (HttpServletRequest) fc.getExternalContext().getRequest();        
        if (req.getUserPrincipal() == null) {
            try 
            {
                req.login(this.nombreDeUsuario, this.contrasena);
                req.getServletContext().log("Autenticacion exitosa");
                haySesion = true;
                go(this.nombreDeUsuario);
                
            } 
            catch (ServletException e) 
            {
                fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Nombre de usuario o contraseña incorrectos", "Nombre de usuario o contraseña incorrectos"));
                PrimeFaces.current().ajax().update("formularioInicioSession");                
            }
        } 
        else 
        {
            req.getServletContext().log("El usuario ya estaba logueado:  ");
            go(req.getUserPrincipal().getName());
        }
    }
    
    
    private void go(String nombreDeUsuario) throws IOException
    {
        Usuariogrupo usuarioGrupo =usuarioGrupoEJB.findByNombreusuario(nombreDeUsuario);
        if(usuarioGrupo.getNombreusuario().equalsIgnoreCase("admin"))   
          FacesContext.getCurrentInstance().getExternalContext().redirect("faces/admin/main.xhtml");
        else
          FacesContext.getCurrentInstance().getExternalContext().redirect("faces/user/main.xhtml");
    }
    
    public void logout() throws IOException, ServletException 
    {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpServletRequest req = (HttpServletRequest) fc.getExternalContext().getRequest();
        try {
            req.logout();            
            req.getSession().invalidate();
            fc.getExternalContext().invalidateSession();
            FacesContext.getCurrentInstance().getExternalContext().redirect("/CentroAtencion");

        } catch (ServletException e) {            
            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "FAILED", "Logout failed on backend"));            
        }
        
    }
    
    public boolean esusuarioConSession()
    {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpServletRequest req = (HttpServletRequest) fc.getExternalContext().getRequest();       
        if (req.getUserPrincipal() == null) 
        {
            return false;
            
        }
        else
        {
            return true;
        }
        
    }
    
    public String nombreUsuario()
    {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpServletRequest req = (HttpServletRequest) fc.getExternalContext().getRequest();       
        if (req.getUserPrincipal() == null) 
        {
            return "";
        }
        else
        {
            return req.getUserPrincipal().getName();
        }
    }
    
}
