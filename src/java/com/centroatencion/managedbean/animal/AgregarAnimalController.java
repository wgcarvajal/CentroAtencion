/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.managedbean.animal;

import com.centroatencion.entities.Animal;
import com.centroatencion.entities.Familia;
import com.centroatencion.entities.Grupotaxonomico;
import com.centroatencion.facade.AnimalFacade;
import com.centroatencion.facade.FamiliaFacade;
import com.centroatencion.facade.GrupotaxonomicoFacade;
import com.centroatencion.managedbean.util.Util;
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
   private FamiliaFacade familiaEJB;
   @EJB
   private GrupotaxonomicoFacade grupoTaxonomicoEJB;
   
   private Grupotaxonomico grupotaxonomicoSelected;
   private Familia familiaSelected;
   private List<Familia> listaFamilias;
   private List<Grupotaxonomico> listaGrupoTaxonomicos;
   
   
   private String nombre;
   private String especie;
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

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
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
    public List<Familia> getListaFamilias() {
        return listaFamilias;
    }

    /**
     * @param listaFamilias the listaEspecies to set
     */
    public void setListaFamilias(List<Familia> listaFamilias) {
        this.listaFamilias = listaFamilias;
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
    public Familia getFamiliaSelected() {
        return familiaSelected;
    }

    /**
     * @param familiaSelected the especieSelected to set
     */
    public void setFamiliaSelected(Familia familiaSelected) {
        this.familiaSelected = familiaSelected;
    }
    
    public void abrirVentanaAgregarAnimal(Integer familiaIdSelected) {
        PrimeFaces pf = PrimeFaces.current();
        familiaSelected = null;
        grupotaxonomicoSelected = null;
        nombre = null;
        especie = null;
        descripcion = null;
        if (familiaIdSelected == 0) {
            listaFamilias = familiaEJB.findAll();
            pf.executeScript("PF('AgregarAnimalConFamilia').show()");

        } else {
            familiaSelected = familiaEJB.find(familiaIdSelected);
            pf.executeScript("PF('AgregarAnimal').show()");
        }
    }
    
    public void registrarAnimal(AnimalController animalController) {
        PrimeFaces pf = PrimeFaces.current();
        nombre = Util.formatText(nombre);
        especie = Util.formatText(especie);
        if (!animalEJB.existeNombre(nombre)) {
            if (!animalEJB.existeEspecie(especie)) {
                Animal animal = new Animal();
                animal.setAnNombre(nombre);
                animal.setFaId(familiaSelected);
                animal.setAnEspNombre(especie);
                animal.setGrupotaxonomicoId(grupotaxonomicoSelected);
                if (descripcion != null && !descripcion.equals("")) {
                    animal.setAnDescripcion(descripcion);
                }
                animalEJB.create(animal);
                nombre = null;
                descripcion = null;
                especie = null;
                familiaSelected = null;
                grupotaxonomicoSelected = null;
                animalController.updateListaAnimales();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Registro Exitoso."));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error:", "La especie ya existe"));
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error:", "El nombre del animal ya existe"));
        }

        pf.executeScript("PF('mensajeRegistroExitoso').show()");
    }
}
