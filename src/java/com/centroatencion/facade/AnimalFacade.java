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
    
    public List<Animal> searchByFamilia(String faNombre) {
        Query query = getEntityManager().createNamedQuery("Animal.searchByFamilia");
        query.setParameter("faNombre", "%" + faNombre + "%");
        List<Animal> resultList = query.getResultList();
        return resultList;
    }
    
    public List<Animal> searchByGrupoTaxonomico(String gruptaxNombre) {
        Query query = getEntityManager().createNamedQuery("Animal.searchByGrupoTaxonomico");
        query.setParameter("gruptaxNombre", "%" + gruptaxNombre + "%");
        List<Animal> resultList = query.getResultList();
        return resultList;
    }
    
    public boolean existeNombre(String anNombre)
    {
        Query query = getEntityManager().createNamedQuery("Animal.findByAnNombre");
        query.setParameter("anNombre",  anNombre);
        List<Animal> resultList = query.getResultList();
        return resultList!=null && resultList.size()>0;
    }
    
    public boolean existeEspecie(String anEspNombre)
    {
        Query query = getEntityManager().createNamedQuery("Animal.findByAnEspNombre");
        query.setParameter("anEspNombre",  anEspNombre);
        List<Animal> resultList = query.getResultList();
        return resultList!=null && resultList.size()>0;
    }
    
    @Override
    public List<Animal> findAll() {
       Query query = getEntityManager().createNamedQuery("Animal.findAll");
        List<Animal> resultList = query.getResultList();
        return resultList;
    }
    
    public List<Animal> findByFamilia(Integer faId) {
        Query query = getEntityManager().createNamedQuery("Animal.findByFamilia");
        query.setParameter("faId", faId);
        List<Animal> resultList = query.getResultList();
        return resultList;
    }
}
