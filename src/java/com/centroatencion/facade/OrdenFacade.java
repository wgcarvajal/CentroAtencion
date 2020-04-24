/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.facade;

import com.centroatencion.entities.Orden;
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
public class OrdenFacade extends AbstractFacade<Orden> {

    @PersistenceContext(unitName = "CentroAtencionPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrdenFacade() {
        super(Orden.class);
    }
    
    public List<Orden> searchByNombreOrden(String orNombre) {
        Query query = getEntityManager().createNamedQuery("Orden.findByNombreOrden");
        query.setParameter("orNombre", "%" + orNombre + "%");
        List<Orden> resultList = query.getResultList();
        return resultList;
    }
    
    public boolean existeNombre(String orNombre)
    {
        Query query = getEntityManager().createNamedQuery("Orden.findByOrNombre");
        query.setParameter("orNombre",  orNombre);
        List<Orden> resultList = query.getResultList();
        return resultList!=null && resultList.size()>0;
    }
    
    @Override
    public List<Orden> findAll() {
       Query query = getEntityManager().createNamedQuery("Orden.findAll");
        List<Orden> resultList = query.getResultList();
        return resultList;
    }
    
}
