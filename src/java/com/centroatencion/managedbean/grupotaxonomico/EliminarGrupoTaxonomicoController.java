/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.managedbean.grupotaxonomico;

import com.centroatencion.entities.Grupotaxonomico;
import com.centroatencion.facade.GrupotaxonomicoFacade;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.primefaces.PrimeFaces;


@Named("eliminarGrupoTaxonomicoController")
@SessionScoped
public class EliminarGrupoTaxonomicoController implements Serializable{
    
    private Grupotaxonomico grupoTaxonomicoSeleccionado;
    private GrupoTaxonomicoController grupoTaxonomicoController;
    @EJB
    private GrupotaxonomicoFacade grupoTaxonomicoEJB; 
    
    public EliminarGrupoTaxonomicoController() 
    {
    }
    
    public void ventanaEliminarGrupoTaxonomico(Grupotaxonomico grupoTaxonomicoSeleccionado, GrupoTaxonomicoController grupoTaxonomicoController)
    { 
        this.grupoTaxonomicoSeleccionado=grupoTaxonomicoSeleccionado;
        this.grupoTaxonomicoController=grupoTaxonomicoController;
        PrimeFaces pf = PrimeFaces.current();  
        pf.executeScript("PF('eliminarGrupoTaxonomico').show()");
    }
    
    public void eliminarGrupoTaxonomico()
    {
        PrimeFaces pf = PrimeFaces.current(); 
        if(this.grupoTaxonomicoSeleccionado!=null)
        {
            if(this.grupoTaxonomicoSeleccionado.getAnimalList().isEmpty())
            {
                this.grupoTaxonomicoEJB.remove(grupoTaxonomicoSeleccionado);
                grupoTaxonomicoController.updateListaGrupoTaxonomicoes();
                pf.executeScript("PF('eliminarGrupoTaxonomico').hide()");  
                pf.executeScript("PF('eliminacionCorrecta').show()");
            }
            else
            {
                pf.executeScript("PF('eliminarGrupoTaxonomico').hide()");
                pf.executeScript("PF('noSePuedeEliminar').show()");
            }
        }
    }
}
