/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.managedbean.direccionterritorial;

import com.centroatencion.entities.Direcctionterritorial;
import com.centroatencion.facade.DirecctionterritorialFacade;
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
@ManagedBean(name="eliminarDireccionTerritorialController")
@ViewScoped
public class EliminarDireccionTerritorialController implements Serializable{
    
    private Direcctionterritorial direccionTerritorialSeleccionado;
    private DireccionTerritorialController direccionTerritorialController;
    @EJB
    private DirecctionterritorialFacade direccionTerritorialEJB; 
    
    
    public EliminarDireccionTerritorialController() 
    {
    }
    
    public void ventanaEliminarDireccionTerritorial(Direcctionterritorial direccionTerritorialSeleccionado, DireccionTerritorialController direccionTerritorialController)
    { 
        this.direccionTerritorialSeleccionado=direccionTerritorialSeleccionado;
        this.direccionTerritorialController=direccionTerritorialController;
        PrimeFaces pf = PrimeFaces.current();  
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Está seguro que desea eliminar la dirección territorial? ",null));
        pf.executeScript("PF('eliminarDireccionTerritorial').show()");
    }
    
    public void eliminarDireccionTerritorial()
    {
        PrimeFaces pf = PrimeFaces.current(); 
        if(this.direccionTerritorialSeleccionado !=null)
        {
            if(this.direccionTerritorialSeleccionado.getEntidadList().isEmpty())
            {
                this.direccionTerritorialEJB.remove(direccionTerritorialSeleccionado);
                direccionTerritorialController.updateListaDireccionTerritorial();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Se ha eliminado la DireccionTerritorial.",null));
                pf.executeScript("PF('eliminarDireccionTerritorial').hide()");  
                pf.executeScript("PF('eliminacionCorrecta').show()");
            }
            else
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "La Dirección territorial tiene registros asociados.",null));
                pf.executeScript("PF('eliminarDireccionTerritorial').hide()");
                pf.executeScript("PF('noSePuedeEliminar').show()");
            }
        }
    }
}
