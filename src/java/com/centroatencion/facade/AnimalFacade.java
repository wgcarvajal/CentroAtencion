/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.facade;

import com.centroatencion.entities.Animal;
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
public class AnimalFacade extends AbstractFacade<Animal> {

    @PersistenceContext(unitName = "CentroAtencionPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AnimalFacade() {
        super(Animal.class);
    }
    
    
    public List<Animal> searchByNombreAnimal(String anNombre) {
        Query query = getEntityManager().createNamedQuery("Animal.searchByNombreAnimal");
        query.setParameter("anNombre", "%" + anNombre + "%");
        List<Animal> resultList = query.getResultList();
        return resultList;
    }
    
    public List<Animal> searchByEspecie(String espNombre) {
        Query query = getEntityManager().createNamedQuery("Animal.searchByEspecie");
        query.setParameter("espNombre", "%" + espNombre + "%");
        List<Animal> resultList = query.getResultList();
        return resultList;
    }
    
    public List<Animal> searchByGrupoTaxonomico(String gruptaxNombre) {
        Query query = getEntityManager().createNamedQuery("Animal.searchByGrupoTaxonomico");
        query.setParameter("gruptaxNombre", "%" + gruptaxNombre + "%");
        List<Animal> resultList = query.getResultList();
        return resultList;
    }
}
