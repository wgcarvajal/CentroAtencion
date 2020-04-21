/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.managedbean.tipozona;

import com.centroatencion.entities.Tipozonaubicacion;
import com.centroatencion.facade.TipozonaubicacionFacade;
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
@ManagedBean(name="verEditarTipoZonaController")
@ViewScoped
public class VerEditarTipoZonaController implements Serializable
{
    
    @EJB
    private TipozonaubicacionFacade tipoZonaUbicacionEJB;
    
    private Tipozonaubicacion tipoZonaUbicacion;
    private boolean campoNombre;
    private String nombre;
    private TipoZonaController tipoZonaUbicacionController;

    //private ValidarEdicionUsuarios validarEdicionUsuario;

    public VerEditarTipoZonaController() {
        
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
   

    public Tipozonaubicacion getTipoZonaUbicacion() {
        return tipoZonaUbicacion;
    }

    public void setTipoZonaUbicacion(Tipozonaubicacion tipoZonaUbicacion) {
        this.tipoZonaUbicacion = tipoZonaUbicacion;
    }

    public boolean isCampoNombre() {
        return campoNombre;
    }

    
    public void setCampoNombre(boolean campoNombre) {
        this.campoNombre = campoNombre;
    }
    
    
    public void tipoZonaUbicacionSeleccionado(Tipozonaubicacion tipoZonaUbicacion, TipoZonaController mgb) {
        this.tipoZonaUbicacionController = mgb;
        this.tipoZonaUbicacion = tipoZonaUbicacion;
        this.campoNombre = true;
        PrimeFaces pf = PrimeFaces.current(); 
        pf.executeScript("PF('verEditarTipoZonaUbicacion').show()");

    }
    
    public void mostrarModificarNombre() {
        this.campoNombre = false;
        this.nombre = this.tipoZonaUbicacion.getTzuNombre();
    }

    public void cancelarActualizarNombre() {
        this.campoNombre = true;
        this.nombre = "";
    }

    public void actualizarNombre() {
        this.campoNombre = true;
        this.tipoZonaUbicacion.setTzuNombre(nombre);
        this.tipoZonaUbicacionEJB.edit(this.tipoZonaUbicacion);
        tipoZonaUbicacionController.updateListaTipoZonaUbicacion();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info. Campo Nombre Actualizado.", ""));
    }
}
