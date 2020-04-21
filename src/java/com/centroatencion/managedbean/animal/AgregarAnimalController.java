/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.managedbean.animal;

import com.centroatencion.entities.Animal;
import com.centroatencion.entities.Especie;
import com.centroatencion.entities.Grupotaxonomico;
import com.centroatencion.facade.AnimalFacade;
import com.centroatencion.facade.EspecieFacade;
import com.centroatencion.facade.GrupotaxonomicoFacade;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Wilson Carvajal
 */
@ManagedBean(name="agregarAnimalController")
@ViewScoped
public class AgregarAnimalController implements Serializable{
    
   @EJB
   private AnimalFacade animalEJB;
   @EJB
   private EspecieFacade especieEJB;
   @EJB
   private GrupotaxonomicoFacade grupoTaxonomicoEJB;
   
   private Grupotaxonomico grupotaxonomicoSelected;
   private Especie especieSelected;
   private List<Especie> listaEspecies;
   private List<Grupotaxonomico> listaGrupoTaxonomicos;
   
   private String nombre; 
   private String descripcion;
    
    
    
    public AgregarAnimalController() 
    {
        
    }
    
    public String getNombre() 
    {
        return nombre;
    }
    public String getDescripcion()
    {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion)
    {
        this.descripcion=descripcion;
    }

    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }
    
    /**
     * @return the listaEspecies
     */
    public List<Especie> getListaEspecies() {
        listaEspecies = especieEJB.findAll();
        return listaEspecies;
    }

    /**
     * @param listaEspecies the listaEspecies to set
     */
    public void setListaEspecies(List<Especie> listaEspecies) {
        this.listaEspecies = listaEspecies;
    }

    /**
     * @return the listaGrupoTaxonomicos
     */
    public List<Grupotaxonomico> getListaGrupoTaxonomicos() {
        listaGrupoTaxonomicos = grupoTaxonomicoEJB.findAll();
        return listaGrupoTaxonomicos;
    }

    /**
     * @param listaGrupoTaxonomicos the listaGrupoTaxonomicos to set
     */
    public void setListaGrupoTaxonomicos(List<Grupotaxonomico> listaGrupoTaxonomicos) {
        this.listaGrupoTaxonomicos = listaGrupoTaxonomicos;
    }
    
    /**
     * @return the grupotaxonomicoSelected
     */
    public Grupotaxonomico getGrupotaxonomicoSelected() {
        return grupotaxonomicoSelected;
    }

    /**
     * @param grupotaxonomicoSelected the grupotaxonomicoSelected to set
     */
    public void setGrupotaxonomicoSelected(Grupotaxonomico grupotaxonomicoSelected) {
        this.grupotaxonomicoSelected = grupotaxonomicoSelected;
    }

    /**
     * @return the especieSelected
     */
    public Especie getEspecieSelected() {
        return especieSelected;
    }

    /**
     * @param especieSelected the especieSelected to set
     */
    public void setEspecieSelected(Especie especieSelected) {
        this.especieSelected = especieSelected;
    }
    
    public void abrirVentanaAgregarAnimal()
    {
       PrimeFaces pf = PrimeFaces.current();
       pf.executeScript("PF('AgregarAnimal').show()");
    }
    
   public void registrarAnimal(AnimalController animalController)
   {
        Animal animal = new Animal();
        animal.setAnNombre(nombre);
        animal.setEspId(especieSelected);
        animal.setGrupotaxonomicoId(grupotaxonomicoSelected);
        if(descripcion!=null && !descripcion.equals(""))
        {
            animal.setAnDescripcion(descripcion);
        }
        animalEJB.create(animal);
        nombre="";
        descripcion="";
        especieSelected = null;
        grupotaxonomicoSelected = null;
        animalController.updateListaAnimales();
        PrimeFaces pf = PrimeFaces.current();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Registro Exitoso."));
        pf.executeScript("PF('mensajeRegistroExitoso').show()");
   }
}
