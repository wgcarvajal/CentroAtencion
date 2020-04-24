/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.managedbean.vereda;

import com.centroatencion.entities.Vereda;
import com.centroatencion.facade.VeredaFacade;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Wilson Carvajal
 */
@ManagedBean(name="eliminarVeredaController")
@ViewScoped
public class EliminarVeredaController implements Serializable{
    
    private Vereda veredaSeleccionado;
    private VeredaController veredaController;
    @EJB
    private VeredaFacade veredaEJB; 
    
    
    public EliminarVeredaController() 
    {
    }
    
    public void ventanaEliminarVereda(Vereda veredaSeleccionado, VeredaController veredaController)
    { 
        this.veredaSeleccionado=veredaSeleccionado;
        this.veredaController=veredaController;
        PrimeFaces pf = PrimeFaces.current();  
        pf.executeScript("PF('eliminarVereda').show()");
    }
    
    public void eliminarVereda()
    {
        PrimeFaces pf = PrimeFaces.current(); 
        if(this.veredaSeleccionado !=null)
        {
            if(this.veredaSeleccionado.getPersonaList().isEmpty())
            {
                this.veredaEJB.remove(veredaSeleccionado);
                veredaController.updateListaVeredas();
                pf.executeScript("PF('eliminarVereda').hide()");  
                pf.executeScript("PF('eliminacionCorrecta').show()");
            }
            else
            {
                pf.executeScript("PF('eliminarVereda').hide()");
                pf.executeScript("PF('noSePuedeEliminar').show()");
            }
        }
    }
}
