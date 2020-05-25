/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.facade;

import com.centroatencion.entities.Departamento;
import com.centroatencion.entities.Municipio;
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
public class MunicipioFacade extends AbstractFacade<Municipio> {

    @PersistenceContext(unitName = "CentroAtencionPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MunicipioFacade() {
        super(Municipio.class);
    }
    
    
    public List<Municipio> findByDepartamento(Long departamentoId) {
        Query query = getEntityManager().createNamedQuery("Municipio.findByDepartamento");
        query.setHint("eclipselink.refresh", true);
        query.setParameter("departamentoId", departamentoId);
        List<Municipio> resultList = query.getResultList();
        return resultList;
    }
    
    public List<Municipio> findByDepartamentoAndNombre(Long departamentoId,String munNombre) {
        Query query = getEntityManager().createNamedQuery("Municipio.findByDepartamentoAndNombre");
        query.setHint("eclipselink.refresh", true);
        query.setParameter("departamentoId", departamentoId);
        query.setParameter("munNombre", "%" + munNombre + "%");
        List<Municipio> resultList = query.getResultList();
        return resultList;
    }
    
    public Departamento findDepartamentoById(Long munId) {
        Query query = getEntityManager().createNamedQuery("Municipio.findDepartamentoById");
        query.setHint("eclipselink.refresh", true);
        query.setParameter("munId", munId);
        Departamento departamento = (Departamento)query.getSingleResult();
        return departamento;
    }
    
}
