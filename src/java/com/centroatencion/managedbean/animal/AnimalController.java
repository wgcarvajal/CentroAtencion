/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.managedbean.animal;

import com.centroatencion.entities.Animal;
import com.centroatencion.facade.AnimalFacade;
import java.io.Serializable;
import java.util.List;
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
    
    private String busqueda;
    private List<Animal> listaAnimales;
    private String buscarPor;
    private String labelBusqueda;
    private List<Animal> listaAnimalesFiltrados;
    
    public AnimalController()
    {
        buscarPor = "e";
        labelBusqueda = "Especie";
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
        if(listaAnimales==null)
        {
            listaAnimales = animalEJB.findAll();
        }
        return listaAnimales;
    }
    
    public void setListaAnimales(List<Animal>listaAnimales)
    {
        this.listaAnimales= listaAnimales;
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
            this.listaAnimales=animalEJB.searchByEspecie(this.busqueda);
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
            listaAnimales = animalEJB.findAll();
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
}
