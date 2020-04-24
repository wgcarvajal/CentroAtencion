/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.managedbean.orden;

import com.centroatencion.entities.Orden;
import com.centroatencion.facade.OrdenFacade;
import com.centroatencion.managedbean.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Wilson Carvajal
 */
@Named("agregarOrdenController")
@SessionScoped
public class AgregarOrdenController implements Serializable{
    
   @EJB
   private OrdenFacade ordenEJB;
    private String nombre; 
    private String descripcion;
    
    
    
    public AgregarOrdenController() 
    {
        
    }
    
    public String getNombre() 
    {
        return nombre;
    }
    public String getDescripcion()
    {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion)
    {
        this.descripcion=descripcion;
    }

    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }
    
    public void abrirVentanaAgregarOrden()
    {
       PrimeFaces pf = PrimeFaces.current();        
       FacesContext context = FacesContext.getCurrentInstance();
       Application application = context.getApplication();
       ViewHandler viewHandler = application.getViewHandler();
       UIViewRoot viewRoot = viewHandler.createView(context, context.getViewRoot().getViewId());
       context.setViewRoot(viewRoot);       
       context.renderResponse();
       this.nombre = null;
       pf.executeScript("PF('AgregarOrden').show()");
    }
    
   public void registrarOrden(OrdenController ordenController)
   {
        nombre = Util.formatText(nombre);
        PrimeFaces pf = PrimeFaces.current();
        if (!ordenEJB.existeNombre(nombre)) {
           Orden orden = new Orden();
           orden.setOrNombre(nombre);
           if (descripcion != null && !descripcion.isEmpty()) {
               orden.setOrDescripcion(descripcion);
           }
           ordenEJB.create(orden);
           nombre = "";
           ordenController.updateListaOrdenes();
           FacesContext context = FacesContext.getCurrentInstance();
           Application application = context.getApplication();
           ViewHandler viewHandler = application.getViewHandler();
           UIViewRoot viewRoot = viewHandler.createView(context, context.getViewRoot().getViewId());
           context.setViewRoot(viewRoot);
           context.renderResponse();
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Registro Exitoso."));
       } else {
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Orden ya existe."));
       }
       pf.executeScript("PF('mensajeRegistroExitoso').show()");
   }
    
}
