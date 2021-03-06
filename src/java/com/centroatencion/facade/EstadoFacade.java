/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.facade;

import com.centroatencion.entities.Estado;
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
public class EstadoFacade extends AbstractFacade<Estado> {

    @PersistenceContext(unitName = "CentroAtencionPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadoFacade() {
        super(Estado.class);
    }
    
    public Estado findCurrentEstado(long ingId)
    {
        Query query = getEntityManager().createNamedQuery("Estado.findCurrentEstado");
        query.setParameter("ingId", ingId);
        List<Estado> estadoList = query.getResultList();
        return estadoList!=null && !estadoList.isEmpty()?estadoList.get(0):null;
    }
    
}
