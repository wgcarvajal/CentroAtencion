/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.managedbean.especie;

import com.centroatencion.entities.Familia;
import com.centroatencion.entities.Especie;
import com.centroatencion.facade.FamiliaFacade;
import com.centroatencion.facade.EspecieFacade;
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
@ManagedBean(name="espController")
@ViewScoped
public class EspecieController implements Serializable{
    

    @EJB
    private FamiliaFacade familiaEJB;
    @EJB
    private EspecieFacade especieEJB;
    private List<Familia> listaFamilias;
    private List<Especie> listaEspecies;
    private Integer familiaIdSelected;
    private boolean enabledTablaEspecies;
    private String nombreEspecie;
    
    public EspecieController() 
    {
        
    } 
    @PostConstruct
    public void init()
    {
        this.initValues();
    }   
    
    public List<Familia>getListaFamilias()
    {
        return listaFamilias;
    }
    
    public List<Especie> getListaEspecies()
    {
        return listaEspecies;
    }
    public boolean getEnabledTablaEspecies()
    {
        return enabledTablaEspecies;
    }
    
    public String getNombreEspecie()
    {
        return nombreEspecie;
    }
    public void setNombreEspecie(String nombreEspecie)
    {
        this.nombreEspecie= nombreEspecie;
    }
    
    public Integer getFamiliaIdSelected()
    {
        return familiaIdSelected;
    }
    
    private void initValues()
    {
        familiaIdSelected = 0;
        enabledTablaEspecies = true;
        listaFamilias = familiaEJB.findAll();
        listaEspecies = especieEJB.findAll();
    }
    
    public void changedFamilia(ValueChangeEvent e)
    {
        enabledTablaEspecies = false;
        this.nombreEspecie = null;
        this.familiaIdSelected = null;
        this.listaEspecies = null;
        int idFamilia = Integer.parseInt(e.getNewValue().toString());
        this.enabledTablaEspecies = true;
        this.familiaIdSelected = idFamilia;
        if(idFamilia!=0)
        {
            this.listaEspecies = especieEJB.findByFamilia(familiaIdSelected);
        }
        else
        {
            this.listaEspecies = especieEJB.findAll();
        }
    }
    
    public void searchByFamiliaAndNombreEspecie()
    {
        this.listaEspecies=especieEJB.findByFamiliaAndNombre(familiaIdSelected, nombreEspecie);
    }
    
    public void updateListaEspecies()
    {
        if(nombreEspecie!=null && !nombreEspecie.isEmpty())
        {
            searchByFamiliaAndNombreEspecie();
        }
        else
        {
            if(familiaIdSelected ==0)
            {
                listaEspecies = especieEJB.findAll();
            }
            else{listaEspecies = especieEJB.findByFamilia(familiaIdSelected);}
        }
        
    }
    
}
