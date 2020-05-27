/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.facade;

import com.centroatencion.entities.Asignacargo;
import com.centroatencion.entities.Cargo;
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
public class AsignacargoFacade extends AbstractFacade<Asignacargo> {

    @PersistenceContext(unitName = "CentroAtencionPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AsignacargoFacade() {
        super(Asignacargo.class);
    }
    
    public Cargo currentCargo(long perId) {
        Query query = getEntityManager().createNamedQuery("Asignacargo.currentCargo");
        query.setHint("eclipselink.refresh", true);
        query.setParameter("perId", perId);
        List<Cargo> resultList = query.getResultList();
        return resultList!=null && !resultList.isEmpty()?resultList.get(0):null;
    }
    
    
}
