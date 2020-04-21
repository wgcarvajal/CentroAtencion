/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.managedbean.municipio;

import com.centroatencion.entities.Municipio;
import com.centroatencion.facade.MunicipioFacade;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Wilson Carvajal
 */
@ManagedBean(name="eliminarMunicipioController")
@ViewScoped
public class EliminarMunicipioController implements Serializable{
    
    private Municipio municipioSeleccionado;
    private MunicipioController municipioController;
    @EJB
    private MunicipioFacade municipioEJB; 
    
    public EliminarMunicipioController() 
    {
    }
    
    public void ventanaEliminarMunicipio(Municipio municipioSeleccionado, MunicipioController municipioController)
    { 
        this.municipioSeleccionado=municipioSeleccionado;
        this.municipioController=municipioController;
        PrimeFaces pf = PrimeFaces.current();  
        pf.executeScript("PF('eliminarMunicipio').show()");
    }
    
    public void eliminarMunicipio()
    {
        PrimeFaces pf = PrimeFaces.current(); 
        if(this.municipioSeleccionado!=null)
        {
            if(this.municipioSeleccionado.getVeredaList().isEmpty() && 
                    this.municipioSeleccionado.getEntidadList().isEmpty() && 
                    this.municipioSeleccionado.getIngresoList().isEmpty() &&
                    this.municipioSeleccionado.getPersonaList().isEmpty())
            {
                this.municipioEJB.remove(municipioSeleccionado);
                municipioController.updateListaMunicipio();
                pf.executeScript("PF('eliminarMunicipio').hide()");  
                pf.executeScript("PF('eliminacionCorrecta').show()");
            }
            else
            {
                pf.executeScript("PF('eliminarMunicipio').hide()");
                pf.executeScript("PF('noSePuedeEliminar').show()");
            }
        }
    }
}
