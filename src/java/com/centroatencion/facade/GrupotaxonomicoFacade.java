/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.facade;

import com.centroatencion.entities.Grupotaxonomico;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author aranda
 */
@Stateless
public class GrupotaxonomicoFacade extends AbstractFacade<Grupotaxonomico> {

    @PersistenceContext(unitName = "CentroAtencionPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GrupotaxonomicoFacade() {
        super(Grupotaxonomico.class);
    }
    
    public List<Grupotaxonomico> searchByNombreGrupoTaxonomico(String gruptaxNombre) {
        Query query = getEntityManager().createNamedQuery("Grupotaxonomico.searchByNombreGrupoTaxonomico");
        query.setParameter("gruptaxNombre", "%" + gruptaxNombre + "%");
        List<Grupotaxonomico> resultList = query.getResultList();
        return resultList;
    }
}
