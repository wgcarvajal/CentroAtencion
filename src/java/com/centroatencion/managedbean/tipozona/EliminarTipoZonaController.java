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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Wilson Carvajal
 */
@ManagedBean(name="eliminarTipoZonaController")
@ViewScoped
public class EliminarTipoZonaController implements Serializable{
    
    private Tipozonaubicacion tipoZonaUbicacionSeleccionado;
    private TipoZonaController tipoZonaUbicacionController;
    @EJB
    private TipozonaubicacionFacade tipoZonaUbicacionEJB; 
    
    public EliminarTipoZonaController() 
    {
    }
    
    public void ventanaEliminarTipoZonaUbicacion(Tipozonaubicacion tipoZonaUbicacionSeleccionado, TipoZonaController tipoZonaUbicacionController)
    { 
        this.tipoZonaUbicacionSeleccionado=tipoZonaUbicacionSeleccionado;
        this.tipoZonaUbicacionController=tipoZonaUbicacionController;
        PrimeFaces pf = PrimeFaces.current();  
        pf.executeScript("PF('eliminarTipoZonaUbicacion').show()");
    }
    
    public void eliminarTipoZonaUbicacion()
    {
        PrimeFaces pf = PrimeFaces.current(); 
        if(this.tipoZonaUbicacionSeleccionado!=null)
        {
            if(this.tipoZonaUbicacionSeleccionado.getZonaubicacionanimalList().isEmpty())
            {
                this.tipoZonaUbicacionEJB.remove(tipoZonaUbicacionSeleccionado);
                tipoZonaUbicacionController.updateListaTipoZonaUbicacion();
                pf.executeScript("PF('eliminarTipoZonaUbicacion').hide()");  
                pf.executeScript("PF('eliminacionCorrecta').show()");
            }
            else
            {
                pf.executeScript("PF('eliminarTipoZonaUbicacion').hide()");
                pf.executeScript("PF('noSePuedeEliminar').show()");
            }
        }
    }
}
