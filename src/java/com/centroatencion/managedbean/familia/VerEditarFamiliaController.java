/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.managedbean.familia;

import com.centroatencion.entities.Familia;
import com.centroatencion.entities.Orden;
import com.centroatencion.facade.FamiliaFacade;
import com.centroatencion.facade.OrdenFacade;
import com.centroatencion.managedbean.util.Util;
import java.io.Serializable;
import java.util.List;
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
    @EJB
    private OrdenFacade ordenEJB;
    private Familia familia;
    private boolean campoNombre;
    private boolean campoDescripcion;
    private boolean campoOrden;
    private String nombre;
    private String descripcion;
    private FamiliaController familiaController;
    private Orden orden;
    
    private List<Orden> listaOrden;

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

    public boolean isCampoOrden() {
        return campoOrden;
    }

    public void setCampoOrden(boolean campoOrden) {
        this.campoOrden = campoOrden;
    }

    public List<Orden> getListaOrden() {
        return listaOrden;
    }

    public void setListaOrden(List<Orden> listaOrden) {
        this.listaOrden = listaOrden;
    }

    public Orden getOrden() {
        return orden;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }
    
    public void familiaSeleccionado(Familia familia, FamiliaController mgb) {
        this.familiaController = mgb;
        this.familia = familia;
        this.campoNombre = true;
        this.campoDescripcion = true;
        this.campoOrden = true;
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
        nombre = Util.formatText(nombre);
        if(!nombre.equals(this.familia.getFaNombre()))
        {
            if(!familiaEJB.existeNombre(nombre))
            {
                this.campoNombre = true;
                this.familia.setFaNombre(nombre);
                this.familiaEJB.edit(this.familia);
                familiaController.updateListaFamilia();
                this.nombre = "";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info. Campo Nombre Actualizado.", ""));
            }
            else
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error. Familia ya existe.", ""));
            }
        }
        else
        {
            this.campoNombre = true;
            this.nombre = "";
        }
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
    
    public void mostrarModificarOrden() {
        this.campoOrden = false;
        this.orden = this.familia.getOrId();
        this.listaOrden = ordenEJB.findAll();
    }

    public void cancelarActualizarOrden() {
        this.campoOrden = true;
        this.orden = null;
        this.listaOrden=null;
    }

    public void actualizarOrden() {
        if(!this.orden.getOrId().equals(this.familia.getOrId().getOrId()))
        {
            this.familia.setOrId(orden);
            this.familiaEJB.edit(this.familia);
            familiaController.updateListaFamilia();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info. Campo Nombre Actualizado.", ""));
        }
        this.campoOrden = true;
        this.orden = null;
        this.listaOrden=null;
    }
    
}
