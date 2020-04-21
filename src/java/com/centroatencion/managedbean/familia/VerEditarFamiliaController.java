/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.managedbean.familia;

import com.centroatencion.entities.Familia;
import com.centroatencion.facade.FamiliaFacade;
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
@ManagedBean(name="verEditarFamiliaController")
@ViewScoped
public class VerEditarFamiliaController implements Serializable{
    
    @EJB
    private FamiliaFacade familiaEJB;
   
    private Familia familia;
    private boolean campoNombre;
    private boolean campoDescripcion;
    private String nombre;
    private String descripcion;
    private FamiliaController familiaController;

    //private ValidarEdicionUsuarios validarEdicionUsuario;

    public VerEditarFamiliaController() {
        
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Familia getFamilia()
    {
        return familia;
    }

    public boolean isCampoNombre() {
        return campoNombre;
    }

    public void setCampoNombre(boolean campoNombre) {
        this.campoNombre = campoNombre;
    }
    
    public boolean isCampoDescripcion() {
        return campoDescripcion;
    }

    public void setCampoDescripcion(boolean campoDescripcion) {
        this.campoDescripcion = campoDescripcion;
    }

    public void familiaSeleccionado(Familia familia, FamiliaController mgb) {
        this.familiaController = mgb;
        this.familia = familia;
        this.campoNombre = true;
        this.campoDescripcion = true;
        PrimeFaces pf = PrimeFaces.current();  
        pf.executeScript("PF('verEditarFamilia').show()");

    }
    public void mostrarModificarNombre() {
        this.campoNombre = false;
        this.nombre = this.familia.getFaNombre();
    }

    public void cancelarActualizarNombre() {
        this.campoNombre = true;
        this.nombre = "";
    }

    public void actualizarNombre() {
        this.campoNombre = true;
        this.familia.setFaNombre(nombre);
        this.familiaEJB.edit(this.familia);
        familiaController.updateListaFamilia();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info. Campo Nombre Actualizado.", ""));
    }
    
    public void mostrarModificarDescripcion() {
        this.campoDescripcion = false;
        this.descripcion = this.familia.getFaDescripcion();
    }

    public void cancelarActualizarDescripcion() {
        this.campoDescripcion = true;
        this.descripcion = "";
    }

    public void actualizarDescripcion() {
        this.campoDescripcion = true;
        this.familia.setFaDescripcion(descripcion);
        this.familiaEJB.edit(this.familia);
        familiaController.updateListaFamilia();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info. Campo Descripción Actualizado.", ""));
    }
    
}
