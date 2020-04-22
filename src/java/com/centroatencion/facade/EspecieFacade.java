/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.facade;

import com.centroatencion.entities.Especie;
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
public class EspecieFacade extends AbstractFacade<Especie> {

    @PersistenceContext(unitName = "CentroAtencionPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EspecieFacade() {
        super(Especie.class);
    }
    
    public List<Especie> findByFamilia(Integer faId) {
        Query query = getEntityManager().createNamedQuery("Especie.findByFamilia");
        query.setParameter("faId", faId);
        List<Especie> resultList = query.getResultList();
        return resultList;
    }
    
    public List<Especie> findByFamiliaAndNombre(Integer faId,String espNombre) {
        Query query;
        if(faId == 0)
        {
            query = getEntityManager().createNamedQuery("Especie.findByLikeEspNombre");
        }
        else
        {
            query = getEntityManager().createNamedQuery("Especie.findByFamiliaAndNombre");
            query.setParameter("faId", faId);
        }
        query.setParameter("espNombre", "%" + espNombre + "%");
        List<Especie> resultList = query.getResultList();
        return resultList;
    }
    
    public List findByIdInnerJoinFamiliaAndOrden(Integer espId) {
        Query query = getEntityManager().createNamedQuery("Especie.findByIdInnerJoinFamiliaAndOrden");
        query.setParameter("espId", espId);
        List resultList = query.getResultList();
        return resultList;
    }
    
    @Override
    public List<Especie> findAll() {
       Query query = getEntityManager().createNamedQuery("Especie.findAll");
        List<Especie> resultList = query.getResultList();
        return resultList;
    }
    
    public boolean existeNombre(String espNombre)
    {
        Query query = getEntityManager().createNamedQuery("Especie.findByEspNombre");
        query.setParameter("espNombre",  espNombre);
        List<Especie> resultList = query.getResultList();
        return resultList!=null && resultList.size()>0;
    }
}
