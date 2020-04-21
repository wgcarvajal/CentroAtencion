/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.managedbean.especie;

import com.centroatencion.entities.Especie;
import com.centroatencion.facade.EspecieFacade;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Wilson Carvajal
 */
@ManagedBean(name="eliminarEspecieController")
@ViewScoped
public class EliminarEspecieController implements Serializable{
    
    private Especie especieSeleccionado;
    private EspecieController especieController;
    @EJB
    private EspecieFacade especieEJB; 
    
    
    public EliminarEspecieController() 
    {
    }
    
    public void ventanaEliminarEspecie(Especie especieSeleccionado, EspecieController especieController)
    { 
        this.especieSeleccionado=especieSeleccionado;
        this.especieController=especieController;
        PrimeFaces pf = PrimeFaces.current();  
        pf.executeScript("PF('eliminarEspecie').show()");
    }
    
    public void eliminarEspecie()
    {
        PrimeFaces pf = PrimeFaces.current(); 
        if(this.especieSeleccionado !=null)
        {
            if(this.especieSeleccionado.getAnimalList().isEmpty())
            {
                this.especieEJB.remove(especieSeleccionado);
                especieController.updateListaEspecies();
                pf.executeScript("PF('eliminarEspecie').hide()");  
                pf.executeScript("PF('eliminacionCorrecta').show()");
            }
            else
            {
                pf.executeScript("PF('eliminarEspecie').hide()");
                pf.executeScript("PF('noSePuedeEliminar').show()");
            }
        }
    }
}
