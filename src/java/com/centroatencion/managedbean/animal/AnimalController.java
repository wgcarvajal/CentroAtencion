/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.managedbean.animal;

import com.centroatencion.entities.Animal;
import com.centroatencion.entities.Familia;
import com.centroatencion.facade.AnimalFacade;
import com.centroatencion.facade.FamiliaFacade;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ValueChangeEvent;

/**
 *
 * @author Wilson Carvajal
 */
@ManagedBean(name="anController")
@ViewScoped
public class AnimalController implements Serializable  {
    
    @EJB
    private AnimalFacade animalEJB;
    @EJB
    private FamiliaFacade familiaEJB;
    private String busqueda;
    private List<Animal> listaAnimales;
    private String buscarPor;
    private String labelBusqueda;
    private List<Animal> listaAnimalesFiltrados;
    private List<Familia> listaFamilias;
    private Integer familiaIdSelected;
    
    public AnimalController()
    {
        buscarPor = "e";
        labelBusqueda = "Especie";
    }
    
    @PostConstruct
    public void init()
    {
        this.initValues();
    }
    
    private void initValues(){
        familiaIdSelected = 0;
        listaFamilias = familiaEJB.findAll();
        listaAnimales = animalEJB.findAll();
    }
    
    public String getBusqueda()
    {
        return busqueda;
    }
    
    public void setBusqueda(String busqueda)
    {
        this.busqueda=busqueda;
    }
    
    public List<Animal> getListaAnimales()
    {
        return listaAnimales;
    }
    
    public void setListaAnimales(List<Animal>listaAnimales)
    {
        this.listaAnimales= listaAnimales;
    }
    
    public Integer getFamiliaIdSelected()
    {
        return familiaIdSelected;
    }
    
    public String getBuscarPor()
    {
        return buscarPor;
    }
    
    public void setBuscarPor(String buscarPor)
    {
        this.buscarPor= buscarPor;
    }
    
    public String getLabelBusqueda()
    {
        return labelBusqueda;
    }

    public List<Familia> getListaFamilias() {
        return listaFamilias;
    }

    public void setListaFamilias(List<Familia> listaFamilias) {
        this.listaFamilias = listaFamilias;
    }
    
    /**
     * @return the listaAnimalesFiltrados
     */
    public List<Animal> getListaAnimalesFiltrados() {
        return listaAnimalesFiltrados;
    }

    /**
     * @param listaAnimalesFiltrados the listaAnimalesFiltrados to set
     */
    public void setListaAnimalesFiltrados(List<Animal> listaAnimalesFiltrados) {
        this.listaAnimalesFiltrados = listaAnimalesFiltrados;
    }
    
    public void searchByNombreAnimal()
    {
        if(buscarPor.equals("e"))
        {
            this.listaAnimales=animalEJB.searchByFamilia(this.busqueda);
        }
        else if(buscarPor.equals("g"))
        {
            this.listaAnimales=animalEJB.searchByGrupoTaxonomico(this.busqueda);
        }
    }
    
    public void updateListaAnimales()
    {
        if(busqueda!=null && !busqueda.isEmpty())
        {
            searchByNombreAnimal();
        }
        else
        {
            if(familiaIdSelected ==0){
                listaAnimales = animalEJB.findAll();
            }
            else{
                listaAnimales = animalEJB.findByFamilia(familiaIdSelected);
            }
        }
        
    }
    
    public void changedBusqueda(ValueChangeEvent e)
    {
        String busquedavalue = e.getNewValue().toString();
        buscarPor = busquedavalue;
        if(buscarPor.equals("e"))
        {
            labelBusqueda = "Especie";
        }
        else if(buscarPor.equals("g"))
        {
            labelBusqueda = "Grupo taxonómico";
        }
        busqueda =null;
        updateListaAnimales();
        
    }
    
    public void changedFamilia(ValueChangeEvent e)
    {
        this.familiaIdSelected = null;
        this.listaAnimales = null;
        int idFamilia = Integer.parseInt(e.getNewValue().toString());
        this.familiaIdSelected = idFamilia;
        if(idFamilia!=0)
        {
            this.listaAnimales = animalEJB.findByFamilia(familiaIdSelected);
        }
        else
        {
            this.listaAnimales = animalEJB.findAll();
        }
    }
}
