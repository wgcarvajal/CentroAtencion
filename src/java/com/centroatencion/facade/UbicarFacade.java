/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.facade;

import com.centroatencion.entities.Ubicar;
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
public class UbicarFacade extends AbstractFacade<Ubicar> {

    @PersistenceContext(unitName = "CentroAtencionPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UbicarFacade() {
        super(Ubicar.class);
    }
    
    public List<Ubicar> searchByIngresoId(long ingId) {
        Query query = getEntityManager().createNamedQuery("Ubicar.searchByIngresoId");
        query.setHint("eclipselink.refresh", true);
        query.setParameter("ingId", ingId);
        return query.getResultList();
    }
    
    public List<Ubicar> searchByIngresoIdDesc(long ingId) {
        Query query = getEntityManager().createNamedQuery("Ubicar.searchByIngresoIdDesc");
        query.setHint("eclipselink.refresh", true);
        query.setParameter("ingId", ingId);
        return query.getResultList();
    }
    
    public boolean existByIngresoId(long ingId) {
        Query query = getEntityManager().createNamedQuery("Ubicar.existByIngresoId");
        query.setHint("eclipselink.refresh", true);
        query.setParameter("ingId", ingId);
        List result = query.getResultList();
        return result!=null && !result.isEmpty();
    }
    
}
