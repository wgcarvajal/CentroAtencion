/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.managedbean.entidad;

import com.centroatencion.entities.Entidad;
import com.centroatencion.facade.EntidadFacade;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Wilson Carvajal
 */
@ManagedBean(name="eliminarEntidadController")
@ViewScoped
public class EliminarEntidadController implements Serializable{
    
    private Entidad entidadSeleccionado;
    private EntidadController entidadController;
    @EJB
    private EntidadFacade entidadEJB; 
    
    public EliminarEntidadController() 
    {
    }
    
    public void ventanaEliminarEntidad(Entidad entidadSeleccionado, EntidadController entidadController)
    { 
        this.entidadSeleccionado=entidadSeleccionado;
        this.entidadController=entidadController;
        PrimeFaces pf = PrimeFaces.current();  
        pf.executeScript("PF('eliminarEntidad').show()");
    }
    
    public void eliminarEntidad()
    {
        PrimeFaces pf = PrimeFaces.current(); 
        if(this.entidadSeleccionado!=null)
        {
            if(this.entidadSeleccionado.getIngresoList().isEmpty())
            {
                this.entidadEJB.remove(entidadSeleccionado);
                entidadController.updateListaEntidad();
                pf.executeScript("PF('eliminarEntidad').hide()");  
                pf.executeScript("PF('eliminacionCorrecta').show()");
            }
            else
            {
                pf.executeScript("PF('eliminarEntidad').hide()");
                pf.executeScript("PF('noSePuedeEliminar').show()");
            }
        }
    }
}
