/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.facade;

import com.centroatencion.entities.Persona;
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
public class PersonaFacade extends AbstractFacade<Persona> {

    @PersistenceContext(unitName = "CentroAtencionPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonaFacade() {
        super(Persona.class);
    }
    
    public Object findByUsuNombreUsuario(String usuNombreUsuario)
    {
        Query query = getEntityManager().createNamedQuery("Usuario.findByUsuNombreUsuario");
        query.setHint("eclipselink.refresh", true);
        query.setParameter("usuNombreUsuario", usuNombreUsuario);
        Object object = query.getSingleResult();
        return object;
    }
    
    public Persona findPersonaByNombreUsuario(String usuNombreUsuario)
    {
        Query query = getEntityManager().createNamedQuery("Persona.findByUsuNombreUsuario");
        query.setHint("eclipselink.refresh", true);
        query.setParameter("usuNombreUsuario", usuNombreUsuario);
        Persona object = (Persona)query.getSingleResult();
        return object;
    }
    
}
