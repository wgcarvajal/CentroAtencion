/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.managedbean.especie;

import com.centroatencion.entities.Orden;
import com.centroatencion.entities.Familia;
import com.centroatencion.entities.Especie;
import com.centroatencion.facade.OrdenFacade;
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
    private OrdenFacade ordenEJB;
    @EJB
    private FamiliaFacade familiaEJB;
    @EJB
    private EspecieFacade especieEJB;
    
    private List<Orden> listaOrdens;
    private List<Familia> listaMuncipios;
    private List<Especie> listaEspecies;
    private Integer ordenIdSelected;
    private Integer familiaIdSelected;
    private boolean enabledSelectFamilias;
    private boolean enabledTablaEspecies;
    private String nombreEspecie;
    
    public EspecieController() 
    {
        
    } 
    @PostConstruct
    public void init()
    {
        this.loadListaOrdens();
        this.initValues();
    }   
    
    public List<Familia>getListaFamilias()
    {
        return listaMuncipios;
    }
    public List<Orden> getListaOrdens()
    {
        return listaOrdens;
    }
    public List<Especie> getListaEspecies()
    {
        return listaEspecies;
    }
    public boolean getEnabledTablaEspecies()
    {
        return enabledTablaEspecies;
    }
    public boolean getEnabledSelectFamilias()
    {
        return enabledSelectFamilias;
    }
    public String getNombreEspecie()
    {
        return nombreEspecie;
    }
    public void setNombreEspecie(String nombreEspecie)
    {
        this.nombreEspecie= nombreEspecie;
    }
    public Integer getOrdenIdSelected()
    {
        return  ordenIdSelected;
    }
    public Integer getFamiliaIdSelected()
    {
        return familiaIdSelected;
    }
    
    private void loadListaOrdens()
    {
        listaOrdens = ordenEJB.findAll();
    }
    
    private void initValues()
    {
        enabledTablaEspecies = false;
        enabledSelectFamilias = false;
    }
    
    public void changedOrden(ValueChangeEvent e)
    {
        enabledSelectFamilias = false;
        enabledTablaEspecies = false;
        this.nombreEspecie = null;
        this.ordenIdSelected = null;
        this.familiaIdSelected = null;
        this.listaMuncipios = null;
        this.listaEspecies = null;
        
        int idOrden = Integer.parseInt(e.getNewValue().toString());
        if(idOrden!=0)
        {
            this.enabledSelectFamilias = true;
            this.ordenIdSelected = idOrden;
            this.listaMuncipios = familiaEJB.findByOrden(ordenIdSelected);
        } 
    }
    
    public void changedFamilia(ValueChangeEvent e)
    {
        enabledTablaEspecies = false;
        this.nombreEspecie = null;
        this.familiaIdSelected = null;
        this.listaEspecies = null;
        int idFamilia = Integer.parseInt(e.getNewValue().toString());
        if(idFamilia!=0)
        {
            this.enabledTablaEspecies = true;
            this.familiaIdSelected = idFamilia;
            this.listaEspecies = especieEJB.findByFamilia(familiaIdSelected);
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
            listaEspecies = especieEJB.findByFamilia(familiaIdSelected);;
        }
        
    }
    
}
