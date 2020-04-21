/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.facade;

import com.centroatencion.entities.Departamento;
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
public class DepartamentoFacade extends AbstractFacade<Departamento> {

    @PersistenceContext(unitName = "CentroAtencionPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DepartamentoFacade() {
        super(Departamento.class);
    }
    
    public List<Departamento> searchByNombreDepartamento(String depNombre) {
        Query query = getEntityManager().createNamedQuery("Departamento.findByNombreDepartamento");
        query.setParameter("depNombre", "%" + depNombre + "%");
        List<Departamento> resultList = query.getResultList();
        return resultList;
    }
    
}
