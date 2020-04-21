/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.managedbean.zonaubicacionanimal;

import com.centroatencion.entities.Tipozonaubicacion;
import com.centroatencion.entities.Zonaubicacionanimal;
import com.centroatencion.facade.TipozonaubicacionFacade;
import com.centroatencion.facade.ZonaubicacionanimalFacade;
import com.centroatencion.managedbean.entidad.VerEditarEntidadController;
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
@ManagedBean(name="verEditarZonaController")
@ViewScoped
public class VerEditarZonaController implements Serializable
{
    
    @EJB
    private ZonaubicacionanimalFacade zonaEJB;
    @EJB
    private TipozonaubicacionFacade tipoZonaEJB;
    
    private Zonaubicacionanimal ZonaSelected;
    private Integer tipozonaubicacionIdSelected;
    private boolean campoNombre;
    private String nombre;
    private boolean campoTipo;
    private boolean campoDescripcion;
    private String descripcion;
    private boolean campoArea;
    private String area;
    private List<Tipozonaubicacion> listaTipoZonaubicacion;
    private VerEditarEntidadController verEditarEntidadController;

    //private ValidarEdicionUsuarios validarEdicionUsuario;

    public VerEditarZonaController() {
        
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    

    public boolean isCampoNombre() {
        return campoNombre;
    }

    public boolean isCampoTipo() {
        return campoTipo;
    }

    public void setCampoTipo(boolean campoTipo) {
        this.campoTipo = campoTipo;
    }

    
    public void setCampoNombre(boolean campoNombre) {
        this.campoNombre = campoNombre;
    }

    public Zonaubicacionanimal getZonaSelected() {
        return ZonaSelected;
    }

    public void setZonaSelected(Zonaubicacionanimal ZonaSelected) {
        this.ZonaSelected = ZonaSelected;
    }

    public Integer getTipozonaubicacionIdSelected() {
        return tipozonaubicacionIdSelected;
    }

    public void setTipozonaubicacionIdSelected(Integer tipozonaubicacionIdSelected) {
        this.tipozonaubicacionIdSelected = tipozonaubicacionIdSelected;
    }

    public List<Tipozonaubicacion> getListaTipoZonaubicacion() {
        return listaTipoZonaubicacion;
    }

    public void setListaTipoZonaubicacion(List<Tipozonaubicacion> listaTipoZonaubicacion) {
        this.listaTipoZonaubicacion = listaTipoZonaubicacion;
    }

    public boolean isCampoDescripcion() {
        return campoDescripcion;
    }

    public void setCampoDescripcion(boolean campoDescripcion) {
        this.campoDescripcion = campoDescripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isCampoArea() {
        return campoArea;
    }

    public void setCampoArea(boolean campoArea) {
        this.campoArea = campoArea;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
    
    
    public void zonaSeleccionado(Zonaubicacionanimal Zona, VerEditarEntidadController mgb) {
        this.verEditarEntidadController = mgb;
        this.ZonaSelected = Zona;
        this.campoNombre = true;
        this.campoTipo = true;
        this.campoDescripcion = true;
        this.campoArea = true;
        this.tipozonaubicacionIdSelected = 0;
        PrimeFaces pf = PrimeFaces.current(); 
        pf.executeScript("PF('verEditarZona').show()");

    }
    
    public void mostrarModificarNombre() {
        this.campoNombre = false;
        this.nombre = this.ZonaSelected.getZonubianNombre();
    }

    public void cancelarActualizarNombre() {
        this.campoNombre = true;
        this.nombre = "";
    }

    public void actualizarNombre() {
        this.campoNombre = true;
        this.ZonaSelected.setZonubianNombre(nombre);
        this.zonaEJB.edit(this.ZonaSelected);
        verEditarEntidadController.updateListaZona();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info. Campo Nombre Actualizado.", ""));
    }
    
    public void mostrarModificarTipo() {
        this.campoTipo = false;
        this.tipozonaubicacionIdSelected = this.ZonaSelected.getTipozonaubicacionId().getTzuId();
        this.listaTipoZonaubicacion = tipoZonaEJB.findAll();
    }

    public void cancelarActualizarTipo() {
        this.campoTipo = true;
        this.tipozonaubicacionIdSelected = 0;
    }

    public void actualizarTipo() {
        if(tipozonaubicacionIdSelected.equals(0))
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Seleccione un tipo de zona", "Seleccione un tipo de zona"));
        }
        else
        {
            this.campoTipo = true;
            Tipozonaubicacion tipoZonaUbicacion = tipoZonaEJB.find(tipozonaubicacionIdSelected);
            this.ZonaSelected.setTipozonaubicacionId(tipoZonaUbicacion);
            this.zonaEJB.edit(this.ZonaSelected);
            verEditarEntidadController.updateListaZona();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info. Campo tipo Actualizado.", ""));
        }
    }
    
    
    public void mostrarModificarDescripcion() {
        this.campoDescripcion = false;
        this.descripcion = this.ZonaSelected.getZonubianDescripcion();
    }

    public void cancelarActualizarDescripcion() {
        this.campoDescripcion = true;
        this.descripcion = "";
    }

    public void actualizarDescripcion() {
        this.campoDescripcion = true;
        this.ZonaSelected.setZonubianDescripcion(descripcion);
        this.zonaEJB.edit(this.ZonaSelected);
        verEditarEntidadController.updateListaZona();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info. Campo descripción Actualizado.", ""));
    }
}

