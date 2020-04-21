/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.managedbean.grupotaxonomico;

import com.centroatencion.entities.Grupotaxonomico;
import com.centroatencion.facade.GrupotaxonomicoFacade;
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
@Named("agregarGrupoTaxonomicoController")
@SessionScoped
public class AgregarGrupoTaxonomicoController implements Serializable{
    
   @EJB
   private GrupotaxonomicoFacade grupoTaxonomicoEJB;
    private String nombre; 
    private String abreviatura;
    
    
    
    public AgregarGrupoTaxonomicoController() 
    {
        
    }
    
    public String getNombre() 
    {
        return nombre;
    }
    public String getAbreviatura()
    {
        return abreviatura;
    }
    
    public void setAbreviatura(String abreviatura)
    {
        this.abreviatura=abreviatura;
    }

    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }
    
    public void abrirVentanaAgregarGrupoTaxonomico()
    {
       PrimeFaces pf = PrimeFaces.current();        
       FacesContext context = FacesContext.getCurrentInstance();
       Application application = context.getApplication();
       ViewHandler viewHandler = application.getViewHandler();
       UIViewRoot viewRoot = viewHandler.createView(context, context.getViewRoot().getViewId());
       context.setViewRoot(viewRoot);       
       context.renderResponse();
       pf.executeScript("PF('AgregarGrupoTaxonomico').show()");
    }
    
   public void registrarGrupoTaxonomico(GrupoTaxonomicoController grupoTaxonomicoController)
   {
        Grupotaxonomico grupoTaxonomico = new Grupotaxonomico();
        grupoTaxonomico.setGruptaxNombre(nombre);
        grupoTaxonomico.setGrupotaxAbreviatura(abreviatura);
        grupoTaxonomicoEJB.create(grupoTaxonomico);
        nombre="";
        grupoTaxonomicoController.updateListaGrupoTaxonomicoes();
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
