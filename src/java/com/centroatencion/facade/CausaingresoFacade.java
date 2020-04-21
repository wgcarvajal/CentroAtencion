/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.facade;

import com.centroatencion.entities.Causaingreso;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author aranda
 */
@Stateless
public class CausaingresoFacade extends AbstractFacade<Causaingreso> {

    @PersistenceContext(unitName = "CentroAtencionPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CausaingresoFacade() {
        super(Causaingreso.class);
    }
    
}
