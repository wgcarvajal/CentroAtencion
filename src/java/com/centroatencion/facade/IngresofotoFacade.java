/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.facade;

import com.centroatencion.entities.Ingresofoto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Wilson Carvajal
 */
@Stateless
public class IngresofotoFacade extends AbstractFacade<Ingresofoto> {

    @PersistenceContext(unitName = "CentroAtencionPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public IngresofotoFacade() {
        super(Ingresofoto.class);
    }
    
    public List<Ingresofoto> findByIngId(long ingId)
    {
        Query query = getEntityManager().createNamedQuery("Ingresofoto.findByIngId");
        query.setHint("eclipselink.refresh", true);
        query.setParameter("ingId", ingId);
        return query.getResultList();
        
    }
}
