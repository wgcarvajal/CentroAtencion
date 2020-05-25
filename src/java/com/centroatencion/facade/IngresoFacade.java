/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.facade;

import com.centroatencion.entities.Ingreso;
import com.centroatencion.entities.Persona;
import com.centroatencion.entities.Subproducto;
import java.util.List;
import java.util.Vector;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author aranda
 */
@Stateless
public class IngresoFacade extends AbstractFacade<Ingreso> {

    @PersistenceContext(unitName = "CentroAtencionPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public IngresoFacade() {
        super(Ingreso.class);
    }
    
    public long findMaxConsecutivo()
    {
        Query query = getEntityManager().createNamedQuery("Ingreso.findMaxConsecutivo");
        query.setHint("eclipselink.refresh", true);
        long restul = (long)query.getSingleResult();
        return restul;
    }
    
    
    public List findAllIngresos()
    {
        Query query = getEntityManager().createNamedQuery("Ingreso.findAllIngresos");
        query.setHint("eclipselink.refresh", true);
        return query.getResultList();
    }
    
    public Object[] findIngresoByIngId(long ingId)
    {
        Query query = getEntityManager().createNamedQuery("Ingreso.findIngresoByIngId");
        query.setHint("eclipselink.refresh", true);
        query.setParameter("ingId", ingId);
        return (Object[])query.getSingleResult();
    }
    
    public List<Ingreso> findTransladosByIngId(long ingId)
    {
        Query query = getEntityManager().createNamedQuery("Ingreso.findTransladosByIngId");
        query.setHint("eclipselink.refresh", true);
        query.setParameter("ingId", ingId);
        return query.getResultList();
    }
    
    public List<Subproducto> findSubproductos(long ingId)
    {
        Query query = getEntityManager().createNamedQuery("Ingreso.findSubproductos");
        query.setHint("eclipselink.refresh", true);
        query.setParameter("ingId", ingId);
        return query.getResultList();
    }
    
}
