/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.facade;

import com.centroatencion.entities.Desarrollobiologico;
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
public class DesarrollobiologicoFacade extends AbstractFacade<Desarrollobiologico> {

    @PersistenceContext(unitName = "CentroAtencionPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DesarrollobiologicoFacade() {
        super(Desarrollobiologico.class);
    }
    
    
    @Override
    public List<Desarrollobiologico> findAll() {
       Query query = getEntityManager().createNamedQuery("Desarrollobiologico.findAll");
       query.setHint("eclipselink.refresh", true);
       List<Desarrollobiologico> resultList = query.getResultList();
       return resultList;
    }
    
}
