/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.managedbean.familia;

import com.centroatencion.entities.Familia;
import com.centroatencion.facade.FamiliaFacade;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Wilson Carvajal
 */
@ManagedBean(name="eliminarFamiliaController")
@ViewScoped
public class EliminarFamiliaController implements Serializable{
    
    private Familia familiaSeleccionado;
    private FamiliaController familiaController;
    @EJB
    private FamiliaFacade familiaEJB; 
    
    public EliminarFamiliaController() 
    {
    }
    
    public void ventanaEliminarFamilia(Familia familiaSeleccionado, FamiliaController familiaController)
    { 
        this.familiaSeleccionado=familiaSeleccionado;
        this.familiaController=familiaController;
        PrimeFaces pf = PrimeFaces.current();  
        pf.executeScript("PF('eliminarFamilia').show()");
    }
    
    public void eliminarFamilia()
    {
        PrimeFaces pf = PrimeFaces.current(); 
        if(this.familiaSeleccionado!=null)
        {
            if(this.familiaSeleccionado.getEspecieList().isEmpty())
            {
                this.familiaEJB.remove(familiaSeleccionado);
                familiaController.updateListaFamilia();
                pf.executeScript("PF('eliminarFamilia').hide()");  
                pf.executeScript("PF('eliminacionCorrecta').show()");
            }
            else
            {
                pf.executeScript("PF('eliminarFamilia').hide()");
                pf.executeScript("PF('noSePuedeEliminar').show()");
            }
        }
    }
}
