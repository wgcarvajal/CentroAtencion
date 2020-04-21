/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.managedbean.zonaubicacionanimal;

import com.centroatencion.entities.Entidad;
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

@ManagedBean(name="agregarZonaController")
@ViewScoped
public class AgregarZonaController implements Serializable
{
    @EJB
    private TipozonaubicacionFacade tipozonaubicacionEJB;
    @EJB
    private ZonaubicacionanimalFacade zonaubicacionanimalEJB;
    private Entidad entidad;
    private List<Tipozonaubicacion> listaTipoZonaubicacion;
    private Integer tipozonaubicacionIdSelected;
    private String nombre;
    private String descripcion;
    private String area;
    
    public AgregarZonaController()
    {
        
    }
    
    public List<Tipozonaubicacion> getListaTipoZonaubicacion() {
        return listaTipoZonaubicacion;
    }

    public void setListaTipoZonaubicacion(List<Tipozonaubicacion> listaTipoZonaubicacion) {
        this.listaTipoZonaubicacion = listaTipoZonaubicacion;
    }

    public Integer getTipozonaubicacionIdSelected() {
        return tipozonaubicacionIdSelected;
    }

    public void setTipozonaubicacionIdSelected(Integer tipozonaubicacionIdSelected) {
        this.tipozonaubicacionIdSelected = tipozonaubicacionIdSelected;
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
    
    public void abrirVentanaAgregarZona(Entidad entidad)
    {
       this.entidad = entidad;
       listaTipoZonaubicacion = tipozonaubicacionEJB.findAll();
       PrimeFaces pf = PrimeFaces.current();
       pf.executeScript("PF('AgregarZona').show()");
       
    }
    
    public void registrarZona(VerEditarEntidadController verEditarEntidadController)
   {
       if(tipozonaubicacionIdSelected==null || tipozonaubicacionIdSelected.equals(0))
       {
            FacesContext.getCurrentInstance().addMessage("form:tipo", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Campo obligatorio", "Campo obligatorio"));
       }
       else
       {
        Tipozonaubicacion tipozonaubicacion = tipozonaubicacionEJB.find(tipozonaubicacionIdSelected);
        Zonaubicacionanimal zona = new Zonaubicacionanimal();
        zona.setTipozonaubicacionId(tipozonaubicacion);
        zona.setZonubianNombre(nombre);
        zona.setZonubianDescripcion(descripcion);
        zona.setEntidadId(entidad);
        //zona.setZonaubianArea(area);
        zonaubicacionanimalEJB.create(zona);
        nombre="";
        descripcion ="";
        area = "";
        tipozonaubicacionIdSelected = 0;
        verEditarEntidadController.updateListaZona();
        PrimeFaces pf = PrimeFaces.current();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Registro Exitoso."));
        pf.executeScript("PF('mensajeRegistroExitoso').show()");
       }
   }
}
