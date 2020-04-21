/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.managedbean.municipio;

import com.centroatencion.entities.Departamento;
import com.centroatencion.entities.Municipio;
import com.centroatencion.facade.DepartamentoFacade;
import com.centroatencion.facade.MunicipioFacade;
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
@ManagedBean(name="munController")
@ViewScoped
public class MunicipioController implements Serializable{
    
    @EJB
    private DepartamentoFacade departamentoEJB;
    @EJB
    private MunicipioFacade municipioEJB;
    
    private List<Departamento> listaDepartamentos;
    private List<Municipio> listaMuncipios;
    private Long departamentoIdSelected;
    private boolean enabledTablaDepartamentos;
    private String nombreMunicipio;
    
    public MunicipioController() 
    {
        
    }    
    @PostConstruct
    private void init()
    {
        this.loadListaDepartamentos();
        this.initValues();
    }   
    
    public List<Municipio>getListaMunicipios()
    {
        return listaMuncipios;
    }
    public List<Departamento> getListaDepartamentos()
    {
        return listaDepartamentos;
    }
    public boolean getEnabledTablaDepartamentos()
    {
        return enabledTablaDepartamentos;
    }
    public String getNombreMunicipio()
    {
        return nombreMunicipio;
    }
    public void setNombreMunicipio(String nombreMunicipio)
    {
        this.nombreMunicipio= nombreMunicipio;
    }
    public Long getDepartamentoIdSelected()
    {
        return  departamentoIdSelected;
    }
    
    private void loadListaDepartamentos()
    {
        listaDepartamentos = departamentoEJB.findAll();
    }
    
    private void initValues()
    {
        enabledTablaDepartamentos = false;
    }
    
    public void changedDepartamento(ValueChangeEvent e)
    {
        enabledTablaDepartamentos = false;
        this.nombreMunicipio = null;
        this.departamentoIdSelected = null;
        this.listaMuncipios = null;
        this.nombreMunicipio = null;
        
        Long idDepartamento = Long.parseLong(e.getNewValue().toString());
        if(!idDepartamento.equals(0L))
        {
            this.enabledTablaDepartamentos = true;
            this.departamentoIdSelected = idDepartamento;
            this.listaMuncipios = municipioEJB.findByDepartamento(departamentoIdSelected);
        } 
    }
    
    public void searchByDepartamentoAndNombreMunicipio()
    {
        this.listaMuncipios=municipioEJB.findByDepartamentoAndNombre(departamentoIdSelected, nombreMunicipio);
    }
    
    public void updateListaMunicipio()
    {
        if(nombreMunicipio!=null && !nombreMunicipio.isEmpty())
        {
            searchByDepartamentoAndNombreMunicipio();
        }
        else
        {
            listaMuncipios = municipioEJB.findByDepartamento(departamentoIdSelected);;
        }
        
    }
}
