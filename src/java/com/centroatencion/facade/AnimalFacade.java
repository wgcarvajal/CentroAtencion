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
 * @author Wilson Carvajal
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
        query.setHint("eclipselink.refresh", true);
        query.setParameter("anNombre", "%" + anNombre + "%");
        List<Animal> resultList = query.getResultList();
        return resultList;
    }
    
    public List<Animal> searchByFamilia(String faNombre) {
        Query query = getEntityManager().createNamedQuery("Animal.searchByFamilia");
        query.setHint("eclipselink.refresh", true);
        query.setParameter("faNombre", "%" + faNombre + "%");
        List<Animal> resultList = query.getResultList();
        return resultList;
    }
    
    public List<Animal> searchByGrupoTaxonomico(String gruptaxNombre) {
        Query query = getEntityManager().createNamedQuery("Animal.searchByGrupoTaxonomico");
        query.setHint("eclipselink.refresh", true);
        query.setParameter("gruptaxNombre", "%" + gruptaxNombre + "%");
        List<Animal> resultList = query.getResultList();
        return resultList;
    }
    
    public boolean existeNombre(String anNombre)
    {
        Query query = getEntityManager().createNamedQuery("Animal.findByAnNombre");
        query.setHint("eclipselink.refresh", true);
        query.setParameter("anNombre",  anNombre);
        List<Animal> resultList = query.getResultList();
        return resultList!=null && resultList.size()>0;
    }
    
    public boolean existeEspecie(String anEspNombre)
    {
        Query query = getEntityManager().createNamedQuery("Animal.findByAnEspNombre");
        query.setHint("eclipselink.refresh", true);
        query.setParameter("anEspNombre",  anEspNombre);
        List<Animal> resultList = query.getResultList();
        return resultList!=null && resultList.size()>0;
    }
    
    @Override
    public List<Animal> findAll() {
       Query query = getEntityManager().createNamedQuery("Animal.findAll");
       query.setHint("eclipselink.refresh", true);
       List<Animal> resultList = query.getResultList();
       return resultList;
    }
    
    public List<Animal> findByFamilia(Integer faId) {
        Query query = getEntityManager().createNamedQuery("Animal.findByFamilia");
        query.setHint("eclipselink.refresh", true);
        query.setParameter("faId", faId);
        List<Animal> resultList = query.getResultList();
        return resultList;
    }
    
    public List<Object[]> findFamiliaJoinOrden(long anId)
    {
        Query query = getEntityManager().createNamedQuery("Animal.findFamiliaJoinOrden");
        query.setHint("eclipselink.refresh", true);
        query.setParameter("anId", anId);
        List<Object[]> resultList = query.getResultList();
        return resultList;
    }
}
