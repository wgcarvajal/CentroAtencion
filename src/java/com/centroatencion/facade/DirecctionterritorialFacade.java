/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.facade;

import com.centroatencion.entities.Direcctionterritorial;
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
public class DirecctionterritorialFacade extends AbstractFacade<Direcctionterritorial> {

    @PersistenceContext(unitName = "CentroAtencionPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DirecctionterritorialFacade() {
        super(Direcctionterritorial.class);
    }
    
    public List<Direcctionterritorial> findAllWithoutCurrentDireccionterritorial(int dirterId) {
        Query query = getEntityManager().createNamedQuery("Direcctionterritorial.findAllWithoutCurrentDireccionterritorial");
        query.setHint("eclipselink.refresh", true);
        query.setParameter("dirterId", dirterId);
        return query.getResultList();
    }
    
}
