/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.facade;

import com.centroatencion.entities.Familia;
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
public class FamiliaFacade extends AbstractFacade<Familia> {

    @PersistenceContext(unitName = "CentroAtencionPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FamiliaFacade() {
        super(Familia.class);
    }
    
    public List<Familia> findByOrden(int orId) {
        Query query = getEntityManager().createNamedQuery("Familia.findByOrden");
        query.setParameter("orId", orId);
        List<Familia> resultList = query.getResultList();
        return resultList;
    }
    
    public List<Familia> findByOrdenAndNombre(int orId,String faNombre) {
        Query query = getEntityManager().createNamedQuery("Familia.findByOrdenAndNombre");
        query.setParameter("orId", orId);
        query.setParameter("faNombre", "%" + faNombre + "%");
        List<Familia> resultList = query.getResultList();
        return resultList;
    }
}
