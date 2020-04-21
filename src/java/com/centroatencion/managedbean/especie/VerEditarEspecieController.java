/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.managedbean.especie;

import com.centroatencion.entities.Especie;
import com.centroatencion.facade.EspecieFacade;
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
@ManagedBean(name="verEditarEspecieController")
@ViewScoped
public class VerEditarEspecieController implements Serializable{
    
    @EJB
    private EspecieFacade especieEJB;
   
    private Especie especie;
    private boolean campoNombre;
    private String nombre;
    private boolean campoDescripcion;
    private String descripcion;
    private EspecieController especieController;

    //private ValidarEdicionUsuarios validarEdicionUsuario;

    public VerEditarEspecieController() {
        
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

    public Especie getEspecie()
    {
        return especie;
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

    public void especieSeleccionado(Especie especie, EspecieController mgb) {
        this.especieController = mgb;
        this.especie = especie;
        this.campoNombre = true;
        this.campoDescripcion = true;
        PrimeFaces pf = PrimeFaces.current();  
        pf.executeScript("PF('verEditarEspecie').show()");

    }
    public void mostrarModificarNombre() {
        this.campoNombre = false;
        this.nombre = this.especie.getEspNombre();
    }

    public void cancelarActualizarNombre() {
        this.campoNombre = true;
        this.nombre = "";
    }

    public void actualizarNombre() {
        this.campoNombre = true;
        this.especie.setEspNombre(nombre);
        this.especieEJB.edit(this.especie);
        especieController.updateListaEspecies();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info. Campo Nombre Actualizado.", ""));
    }
    
    public void mostrarModificarDescripcion() {
        this.campoDescripcion = false;
        this.descripcion = this.especie.getEspDescripcion();
    }

    public void cancelarActualizarDescripcion() {
        this.campoDescripcion = true;
        this.descripcion = "";
    }

    public void actualizarDescripcion() {
        this.campoDescripcion = true;
        this.especie.setEspDescripcion(descripcion);
        this.especieEJB.edit(this.especie);
        especieController.updateListaEspecies();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info. Campo Nombre Actualizado.", ""));
    }
    
}
