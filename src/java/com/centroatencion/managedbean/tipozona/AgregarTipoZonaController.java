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
@ManagedBean(name="agregarTipoZonaController")
@ViewScoped
public class AgregarTipoZonaController implements Serializable
{
    @EJB
    private TipozonaubicacionFacade tipozonaubicacionEJB;
    
    private String nombre;
    
    
    public AgregarTipoZonaController() 
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
    
    public void abrirVentanaAgregarTipoZonaUbicacion()
    {
       PrimeFaces pf = PrimeFaces.current();
       pf.executeScript("PF('AgregarTipoZonaUbicacion').show()");
    }
    
   public void registrarTipoZonaUbicacion(TipoZonaController tipoZonaUbicacionController)
   {
        Tipozonaubicacion tipoZonaUbicacion = new Tipozonaubicacion();
        tipoZonaUbicacion.setTzuNombre(nombre);
        tipozonaubicacionEJB.create(tipoZonaUbicacion);
        nombre="";
        tipoZonaUbicacionController.updateListaTipoZonaUbicacion();
        PrimeFaces pf = PrimeFaces.current();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Registro Exitoso."));
        pf.executeScript("PF('mensajeRegistroExitoso').show()");
       
   }
}
