/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.facade;

import com.centroatencion.entities.Ingresodocumento;
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
public class IngresodocumentoFacade extends AbstractFacade<Ingresodocumento> {

    @PersistenceContext(unitName = "CentroAtencionPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public IngresodocumentoFacade() {
        super(Ingresodocumento.class);
    }
    
    public List<Ingresodocumento> findByIngId(long ingId)
    {
        Query query = getEntityManager().createNamedQuery("Ingresodocumento.findByIngId");
        query.setHint("eclipselink.refresh", true);
        query.setParameter("ingId", ingId);
        return query.getResultList();
        
    }
}
