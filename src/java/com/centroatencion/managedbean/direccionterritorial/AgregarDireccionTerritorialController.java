/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.managedbean.direccionterritorial;

import com.centroatencion.entities.Direcctionterritorial;
import com.centroatencion.facade.DirecctionterritorialFacade;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Wilson Carvajal
 */
@ManagedBean(name="agregarDireccionTerritorialController")
@ViewScoped
public class AgregarDireccionTerritorialController implements Serializable{
    
    @EJB
    private DirecctionterritorialFacade direccionTerritorialEJB;
    private String nombre;
    private String abreviatura;
    
    public AgregarDireccionTerritorialController() 
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
    
    public String getAbreviatura() 
    {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) 
    {
        this.abreviatura = abreviatura;
    }
    
    public void abrirVentanaAgregarDireccionTerritorial()
    {
       PrimeFaces pf = PrimeFaces.current();
       pf.executeScript("PF('AgregarDireccionTerritorial').show()");
    }
    
   public void registrarDireccionTerritorial(DireccionTerritorialController direccionTerritorialController)
   {
        Direcctionterritorial direccionTerritorial = new Direcctionterritorial();
        direccionTerritorial.setDirterAbreviatura(abreviatura);
        direccionTerritorial.setDirterNombre(nombre);
        direccionTerritorialEJB.create(direccionTerritorial);
        nombre="";
        abreviatura="";
        direccionTerritorialController.updateListaDireccionTerritorial();
        PrimeFaces pf = PrimeFaces.current();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Registro Exitoso."));
        pf.executeScript("PF('mensajeRegistroExitoso').show()");
   }
    
}
