/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.managedbean.departamento;

import com.centroatencion.entities.Departamento;
import com.centroatencion.facade.DepartamentoFacade;
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
@Named("agregarDepartamentoController")
@SessionScoped
public class AgregarDepartamentoController implements Serializable{
    
   @EJB
   private DepartamentoFacade departamentoEJB;
    private String nombre;  
    
    
    
    public AgregarDepartamentoController() 
    {
        
    }
    
    public String getNombre() 
    {
        return nombre;
    }

    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }
    
    public void abrirVentanaAgregarDepartamento()
    {
       PrimeFaces pf = PrimeFaces.current();        
       FacesContext context = FacesContext.getCurrentInstance();
       Application application = context.getApplication();
       ViewHandler viewHandler = application.getViewHandler();
       UIViewRoot viewRoot = viewHandler.createView(context, context.getViewRoot().getViewId());
       context.setViewRoot(viewRoot);       
       context.renderResponse();
       pf.executeScript("PF('AgregarDepartamento').show()");
    }
    
   public void registrarDepartamento(DepartamentoController departamentoController)
   {
        Departamento departamento = new Departamento();
        departamento.setDepNombre(nombre);
        departamentoEJB.create(departamento);
        nombre="";
        departamentoController.updateListaDepartamentos();
        PrimeFaces pf = PrimeFaces.current();
        FacesContext context = FacesContext.getCurrentInstance();
        Application application = context.getApplication();
        ViewHandler viewHandler = application.getViewHandler();
        UIViewRoot viewRoot = viewHandler.createView(context, context.getViewRoot().getViewId());
        context.setViewRoot(viewRoot);       
        context.renderResponse();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Registro Exitoso."));
        pf.executeScript("PF('mensajeRegistroExitoso').show()");
   }
    
}
