/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.facade;

import com.centroatencion.entities.Usuariogrupo;
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
public class UsuariogrupoFacade extends AbstractFacade<Usuariogrupo> {

    @PersistenceContext(unitName = "CentroAtencionPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuariogrupoFacade() {
        super(Usuariogrupo.class);
    }
    
    public Usuariogrupo findByNombreusuario(String nombreusuario)
    {
        Query query = getEntityManager().createNamedQuery("Usuariogrupo.findByNombreusuario");
        query.setHint("eclipselink.refresh", true);
        query.setParameter("nombreusuario",nombreusuario);
        List<Usuariogrupo> resultList = query.getResultList();
        return (resultList!= null && !resultList.isEmpty())?resultList.get(0):null;
    }
    
}
