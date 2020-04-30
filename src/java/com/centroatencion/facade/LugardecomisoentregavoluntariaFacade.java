/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.facade;

import com.centroatencion.entities.Lugardecomisoentregavoluntaria;
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
public class LugardecomisoentregavoluntariaFacade extends AbstractFacade<Lugardecomisoentregavoluntaria> {

    @PersistenceContext(unitName = "CentroAtencionPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LugardecomisoentregavoluntariaFacade() {
        super(Lugardecomisoentregavoluntaria.class);
    }

    @Override
    public List<Lugardecomisoentregavoluntaria> findAll() {
        Query query = getEntityManager().createNamedQuery("Lugardecomisoentregavoluntaria.findAll");
        List<Lugardecomisoentregavoluntaria> resultList = query.getResultList();
        return resultList;
    }
    
    
}
