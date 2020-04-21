/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.managedbean.zonaubicacionanimal;

import com.centroatencion.entities.Entidad;
import com.centroatencion.entities.Zonaubicacionanimal;
import com.centroatencion.facade.EntidadFacade;
import com.centroatencion.facade.ZonaubicacionanimalFacade;
import com.centroatencion.managedbean.entidad.EntidadController;
import com.centroatencion.managedbean.entidad.VerEditarEntidadController;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Wilson Carvajal
 */
@ManagedBean(name="eliminarZonaController")
@ViewScoped
public class EliminarZonaController implements Serializable{
    
    private Zonaubicacionanimal zonaSeleccionado;
    private VerEditarEntidadController verEditarEntidadController;
    @EJB
    private ZonaubicacionanimalFacade zonaEJB; 
    
    public EliminarZonaController() 
    {
    }
    
    public void ventanaEliminarZona(Zonaubicacionanimal zona, VerEditarEntidadController verEditarEntidadController)
    { 
        this.zonaSeleccionado=zona;
        this.verEditarEntidadController=verEditarEntidadController;
        PrimeFaces pf = PrimeFaces.current();  
        pf.executeScript("PF('eliminarZona').show()");
    }
    
    public void eliminarZona()
    {
        PrimeFaces pf = PrimeFaces.current(); 
        if(this.zonaSeleccionado!=null)
        {
            if(this.zonaSeleccionado.getAsignazonaList().isEmpty())
            {
                this.zonaEJB.remove(zonaSeleccionado);
                verEditarEntidadController.updateListaZona();
                pf.executeScript("PF('eliminarZona').hide()");  
                pf.executeScript("PF('eliminacionCorrecta').show()");
            }
            else
            {
                pf.executeScript("PF('eliminarZona').hide()");
                pf.executeScript("PF('noSePuedeEliminar').show()");
            }
        }
    }
}
