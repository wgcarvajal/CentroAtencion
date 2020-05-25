/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.facade;

import com.centroatencion.entities.Entidadterritorial;
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
public class EntidadterritorialFacade extends AbstractFacade<Entidadterritorial> {

    @PersistenceContext(unitName = "CentroAtencionPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EntidadterritorialFacade() {
        super(Entidadterritorial.class);
    }
    
    public List<Entidadterritorial> findAllByDireccionterritorial(int dirterId) {
        Query query = getEntityManager().createNamedQuery("Entidadterritorial.findAllByDireccionterritorial");
        query.setHint("eclipselink.refresh", true);
        query.setParameter("dirterId", dirterId);
        return query.getResultList();
    }
    public List<Entidadterritorial> findAllByDireccionterritorialWithoutCurrentEntidadterritorial(int dirterId,int entterId) {
        Query query = getEntityManager().createNamedQuery("Entidadterritorial.findAllByDireccionterritorialWithoutCurrentEntidadterritorial");
        query.setHint("eclipselink.refresh", true);
        query.setParameter("dirterId", dirterId);
        query.setParameter("entterId", entterId);
        return query.getResultList();
    }
    
}
