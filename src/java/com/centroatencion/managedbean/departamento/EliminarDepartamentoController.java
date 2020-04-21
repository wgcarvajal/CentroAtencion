/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.managedbean.departamento;

import com.centroatencion.entities.Departamento;
import com.centroatencion.facade.DepartamentoFacade;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.primefaces.PrimeFaces;


@Named("eliminarDepartamentoController")
@SessionScoped
public class EliminarDepartamentoController implements Serializable{
    
    private Departamento departamentoSeleccionado;
    private DepartamentoController departamentoController;
    @EJB
    private DepartamentoFacade departamentoEJB; 
    
    public EliminarDepartamentoController() 
    {
    }
    
    public void ventanaEliminarDepartamento(Departamento departamentoSeleccionado, DepartamentoController departamentoController)
    { 
        this.departamentoSeleccionado=departamentoSeleccionado;
        this.departamentoController=departamentoController;
        PrimeFaces pf = PrimeFaces.current();  
        pf.executeScript("PF('eliminarDepartamento').show()");
    }
    
    public void eliminarDepartamento()
    {
        PrimeFaces pf = PrimeFaces.current(); 
        if(this.departamentoSeleccionado!=null)
        {
            if(this.departamentoSeleccionado.getMunicipioList().isEmpty())
            {
                this.departamentoEJB.remove(departamentoSeleccionado);
                departamentoController.updateListaDepartamentos();
                pf.executeScript("PF('eliminarDepartamento').hide()");  
                pf.executeScript("PF('eliminacionCorrecta').show()");
            }
            else
            {
                pf.executeScript("PF('eliminarDepartamento').hide()");
                pf.executeScript("PF('noSePuedeEliminar').show()");
            }
        }
    }
}
