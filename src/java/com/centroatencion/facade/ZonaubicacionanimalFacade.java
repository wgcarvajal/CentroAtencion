/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.facade;

import com.centroatencion.entities.Zonaubicacionanimal;
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
public class ZonaubicacionanimalFacade extends AbstractFacade<Zonaubicacionanimal> {

    @PersistenceContext(unitName = "CentroAtencionPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ZonaubicacionanimalFacade() {
        super(Zonaubicacionanimal.class);
    }
    
    public List<Zonaubicacionanimal>findByEntidadId(Integer entId)
    {
        Query query = getEntityManager().createNamedQuery("Zonaubicacionanimal.findByEntidadId");
        query.setParameter("entId", entId);
        List<Zonaubicacionanimal> resultList = query.getResultList();
        return resultList;
    }
    
}
