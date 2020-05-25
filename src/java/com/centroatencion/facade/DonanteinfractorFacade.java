/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.facade;

import com.centroatencion.entities.Donanteinfractor;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Wilson Carvajal
 */
@Stateless
public class DonanteinfractorFacade extends AbstractFacade<Donanteinfractor> {

    @PersistenceContext(unitName = "CentroAtencionPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DonanteinfractorFacade() {
        super(Donanteinfractor.class);
    }
    
    public Donanteinfractor findByDoninIdentifiacion(String doninIdentifiacion)
    {
        Query query = getEntityManager().createNamedQuery("Donanteinfractor.findByDoninIdentifiacion");
        query.setHint("eclipselink.refresh", true);
        query.setParameter("doninIdentifiacion", doninIdentifiacion);
        Donanteinfractor object = (Donanteinfractor)query.getSingleResult();
        return object;
    }
}
