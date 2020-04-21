/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.managedbean.orden;

import com.centroatencion.entities.Orden;
import com.centroatencion.facade.OrdenFacade;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Wilson Carvajal
 */
@Named("verEditarOrdenController")
@SessionScoped
public class VerEditarOrdenController implements Serializable{
    @EJB
    private OrdenFacade ordenEJB;
   
    private Orden orden;
    private boolean campoNombre;
    private boolean campoDescripcion;
    private String nombre;
    private String descripcion;
    private OrdenController ordenController;

    //private ValidarEdicionUsuarios validarEdicionUsuario;

    public VerEditarOrdenController() {
        
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

    public Orden getOrden()
    {
        return orden;
    }

    public boolean isCampoNombre() {
        return campoNombre;
    }
    public boolean isCampoDescripcion() {
        return campoDescripcion;
    }
    public void setCampoDescripcin(boolean campoDescripcion) {
        this.campoDescripcion = campoDescripcion;
    }

    public void setCampoNombre(boolean campoNombre) {
        this.campoNombre = campoNombre;
    }

    public void ordenSeleccionado(Orden orden, OrdenController mgb) {
        this.ordenController = mgb;
        this.orden = orden;
        this.campoNombre = true;
        this.campoDescripcion = true;
        PrimeFaces pf = PrimeFaces.current();  
        pf.executeScript("PF('verEditarOrden').show()");

    }
    public void mostrarModificarNombre() {
        this.campoNombre = false;
        this.nombre = this.orden.getOrNombre();
    }

    public void cancelarActualizarNombre() {
        this.campoNombre = true;
        this.nombre = "";
    }

    public void actualizarNombre() {
        this.campoNombre = true;
        this.orden.setOrNombre(nombre);
        this.ordenEJB.edit(this.orden);
        ordenController.updateListaOrdenes();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info. Campo Nombre Actualizado.", ""));
    }
    
    public void mostrarModificarDescripcion() {
        this.campoDescripcion = false;
        this.descripcion = this.orden.getOrDescripcion();
    }

    public void cancelarActualizarDescripcion() {
        this.campoDescripcion = true;
        this.descripcion = "";
    }

    public void actualizarDescripcion() {
        this.campoDescripcion = true;
        this.orden.setOrDescripcion(descripcion);
        this.ordenEJB.edit(this.orden);
        ordenController.updateListaOrdenes();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info. Campo Descripcion Actualizado.", ""));
    }
}
