/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.facade;

import com.centroatencion.entities.Genero;
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
public class GeneroFacade extends AbstractFacade<Genero> {

    @PersistenceContext(unitName = "CentroAtencionPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GeneroFacade() {
        super(Genero.class);
    }
    
    @Override
    public List<Genero> findAll() {
       Query query = getEntityManager().createNamedQuery("Genero.findAll");
       query.setHint("eclipselink.refresh", true);
       List<Genero> resultList = query.getResultList();
       return resultList;
    }
    
}
