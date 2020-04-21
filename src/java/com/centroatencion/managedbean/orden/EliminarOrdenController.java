/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.managedbean.orden;

import com.centroatencion.entities.Orden;
import com.centroatencion.facade.OrdenFacade;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.primefaces.PrimeFaces;


@Named("eliminarOrdenController")
@SessionScoped
public class EliminarOrdenController implements Serializable{
    
    private Orden ordenSeleccionado;
    private OrdenController ordenController;
    @EJB
    private OrdenFacade ordenEJB; 
    
    public EliminarOrdenController() 
    {
    }
    
    public void ventanaEliminarOrden(Orden ordenSeleccionado, OrdenController ordenController)
    { 
        this.ordenSeleccionado=ordenSeleccionado;
        this.ordenController=ordenController;
        PrimeFaces pf = PrimeFaces.current();  
        pf.executeScript("PF('eliminarOrden').show()");
    }
    
    public void eliminarOrden()
    {
        PrimeFaces pf = PrimeFaces.current(); 
        if(this.ordenSeleccionado!=null)
        {
            if(this.ordenSeleccionado.getFamiliaList().isEmpty())
            {
                this.ordenEJB.remove(ordenSeleccionado);
                ordenController.updateListaOrdenes();
                pf.executeScript("PF('eliminarOrden').hide()");  
                pf.executeScript("PF('eliminacionCorrecta').show()");
            }
            else
            {
                pf.executeScript("PF('eliminarOrden').hide()");
                pf.executeScript("PF('noSePuedeEliminar').show()");
            }
        }
    }
}
