/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.managedbean.grupotaxonomico;

import com.centroatencion.entities.Grupotaxonomico;
import com.centroatencion.facade.GrupotaxonomicoFacade;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Wilson Carvajal
 */
@Named("grupoTaxonomicoController")
@SessionScoped
public class GrupoTaxonomicoController implements Serializable  {
    
    @EJB
    private GrupotaxonomicoFacade grupoTaxonomicoEJB;
    
    private String grupoTaxonomico;
    private List<Grupotaxonomico> listaGrupoTaxonomicoes;
    
    public GrupoTaxonomicoController()
    {
        
    }
    
    public String getGrupoTaxonomico()
    {
        return grupoTaxonomico;
    }
    
    public void setGrupoTaxonomico(String grupoTaxonomico)
    {
        this.grupoTaxonomico=grupoTaxonomico;
    }
    
    public List<Grupotaxonomico> getListaGrupoTaxonomicoes()
    {
        if(listaGrupoTaxonomicoes==null)
        {
            listaGrupoTaxonomicoes = grupoTaxonomicoEJB.findAll();
        }
        return listaGrupoTaxonomicoes;
    }
    
    public void searchByNombreGrupoTaxonomico()
    {
        this.listaGrupoTaxonomicoes=grupoTaxonomicoEJB.searchByNombreGrupoTaxonomico(this.grupoTaxonomico);
    }
    
    public void updateListaGrupoTaxonomicoes()
    {
        if(grupoTaxonomico!=null && !grupoTaxonomico.isEmpty())
        {
            searchByNombreGrupoTaxonomico();
        }
        else
        {
            listaGrupoTaxonomicoes = grupoTaxonomicoEJB.findAll();
        }
        
    }
    
}
