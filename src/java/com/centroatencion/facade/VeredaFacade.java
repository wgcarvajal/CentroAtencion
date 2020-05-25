/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.facade;

import com.centroatencion.entities.Vereda;
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
public class VeredaFacade extends AbstractFacade<Vereda> {

    @PersistenceContext(unitName = "CentroAtencionPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VeredaFacade() {
        super(Vereda.class);
    }
    
    public List<Vereda> findByMunicipio(Long municipioId) {
        Query query = getEntityManager().createNamedQuery("Vereda.findByMunicipio");
        query.setHint("eclipselink.refresh", true);
        query.setParameter("municipioId", municipioId);
        List<Vereda> resultList = query.getResultList();
        return resultList;
    }
    
    public Object[] findMuncipioDepartamentoById(Long verId) {
        Query query = getEntityManager().createNamedQuery("Vereda.findMuncipioDepartamentoById");
        query.setHint("eclipselink.refresh", true);
        query.setParameter("verId", verId);
        Object[] object = (Object[])query.getSingleResult();
        return object;
    }
    
    public List<Vereda> findByMunicipioAndNombre(Long municipioId,String verNombre) {
        Query query = getEntityManager().createNamedQuery("Vereda.findByMunicipioAndNombre");
        query.setHint("eclipselink.refresh", true);
        query.setParameter("municipioId", municipioId);
        query.setParameter("verNombre", "%" + verNombre + "%");
        List<Vereda> resultList = query.getResultList();
        return resultList;
    }
    
}
