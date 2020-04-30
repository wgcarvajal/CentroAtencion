/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.facade;

import com.centroatencion.entities.Subproducto;
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
public class SubproductoFacade extends AbstractFacade<Subproducto> {

    @PersistenceContext(unitName = "CentroAtencionPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SubproductoFacade() {
        super(Subproducto.class);
    }
    
    @Override
    public List<Subproducto> findAll() {
       Query query = getEntityManager().createNamedQuery("Subproducto.findAll");
        List<Subproducto> resultList = query.getResultList();
        return resultList;
    }
    
}
