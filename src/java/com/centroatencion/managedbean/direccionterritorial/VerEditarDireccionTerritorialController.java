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
@ManagedBean(name="verEditarDireccionTerritorialController")
@ViewScoped
public class VerEditarDireccionTerritorialController implements Serializable{
    
    @EJB
    private DirecctionterritorialFacade direccionTerritorialEJB;
   
    private Direcctionterritorial direccionTerritorial;
    private boolean campoNombre;
    private String nombre;
    private boolean campoAbreviatura;
    private String abreviatura;
    private DireccionTerritorialController direccionTerritorialController;

    //private ValidarEdicionUsuarios validarEdicionUsuario;

    public VerEditarDireccionTerritorialController() {
        
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public Direcctionterritorial getDireccionTerritorial()
    {
        return direccionTerritorial;
    }

    public boolean isCampoNombre() {
        return campoNombre;
    }

    public void setCampoNombre(boolean campoNombre) {
        this.campoNombre = campoNombre;
    }
    
    public boolean isCampoAbreviatura() {
        return campoAbreviatura;
    }

    public void setCampoAbreviatura(boolean campoAbreviatura) {
        this.campoAbreviatura = campoAbreviatura;
    }

    public void direccionTerritorialSeleccionado(Direcctionterritorial direccionTerritorial, DireccionTerritorialController mgb) {
        this.direccionTerritorialController = mgb;
        this.direccionTerritorial = direccionTerritorial;
        this.campoNombre = true;
        this.campoAbreviatura = true;
        PrimeFaces pf = PrimeFaces.current();  
        pf.executeScript("PF('verEditarDireccionTerritorial').show()");

    }
    public void mostrarModificarNombre() {
        this.campoNombre = false;
        this.nombre = this.direccionTerritorial.getDirterNombre();
    }

    public void cancelarActualizarNombre() {
        this.campoNombre = true;
        this.nombre = "";
    }

    public void actualizarNombre() {
        this.campoNombre = true;
        this.direccionTerritorial.setDirterNombre(nombre);
        this.direccionTerritorialEJB.edit(this.direccionTerritorial);
        direccionTerritorialController.updateListaDireccionTerritorial();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info. Campo Nombre Actualizado.", ""));
    }
    
    public void mostrarModificarAbreviatura() {
        this.campoAbreviatura = false;
        this.abreviatura = this.direccionTerritorial.getDirterAbreviatura();
    }

    public void cancelarActualizarAbreviatura() {
        this.campoAbreviatura = true;
        this.abreviatura = "";
    }

    public void actualizarAbreviatura() {
        this.campoAbreviatura = true;
        this.direccionTerritorial.setDirterAbreviatura(abreviatura);
        this.direccionTerritorialEJB.edit(this.direccionTerritorial);
        direccionTerritorialController.updateListaDireccionTerritorial();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info. Campo Nombre Actualizado.", ""));
    }
    
}
