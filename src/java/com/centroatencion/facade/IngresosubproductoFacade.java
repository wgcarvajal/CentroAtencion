/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.facade;

import com.centroatencion.entities.Ingresosubproducto;
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
public class IngresosubproductoFacade extends AbstractFacade<Ingresosubproducto> {

    @PersistenceContext(unitName = "CentroAtencionPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public IngresosubproductoFacade() {
        super(Ingresosubproducto.class);
    }
    
    @Override
    public List<Ingresosubproducto> findAll() {
       Query query = getEntityManager().createNamedQuery("Ingresosubproducto.findAll");
       query.setHint("eclipselink.refresh", true);
        List<Ingresosubproducto> resultList = query.getResultList();
        return resultList;
    }
    
}
