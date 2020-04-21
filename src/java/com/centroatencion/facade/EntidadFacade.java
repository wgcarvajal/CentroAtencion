/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.facade;

import com.centroatencion.entities.Entidad;
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
public class EntidadFacade extends AbstractFacade<Entidad> {

    @PersistenceContext(unitName = "CentroAtencionPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EntidadFacade() {
        super(Entidad.class);
    }
    
    
    public List<Entidad> findByDepartamento(Long depId) {
        
        Query query = getEntityManager().createNamedQuery("Entidad.findByMunicipioDepartamento");
        query.setParameter("depId", depId);
        List<Entidad> resultList = query.getResultList();
        
        query = getEntityManager().createNamedQuery("Entidad.findByVeredaDepartamento");
        query.setParameter("depId", depId);
        List<Entidad> secondResultList = query.getResultList();
        
        resultList.addAll(secondResultList);
        return resultList;
    }
}
