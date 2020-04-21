/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.managedbean.vereda;

import com.centroatencion.entities.Departamento;
import com.centroatencion.entities.Municipio;
import com.centroatencion.entities.Vereda;
import com.centroatencion.facade.DepartamentoFacade;
import com.centroatencion.facade.MunicipioFacade;
import com.centroatencion.facade.VeredaFacade;
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
@ManagedBean(name="verController")
@ViewScoped
public class VeredaController implements Serializable{
    
    @EJB
    private DepartamentoFacade departamentoEJB;
    @EJB
    private MunicipioFacade municipioEJB;
    @EJB
    private VeredaFacade veredaEJB;
    
    private List<Departamento> listaDepartamentos;
    private List<Municipio> listaMuncipios;
    private List<Vereda> listaVeredas;
    private Long departamentoIdSelected;
    private Long municipioIdSelected;
    private boolean enabledSelectMunicipios;
    private boolean enabledTablaVeredas;
    private String nombreVereda;
    
    public VeredaController() 
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
    public List<Vereda> getListaVeredas()
    {
        return listaVeredas;
    }
    public boolean getEnabledTablaVeredas()
    {
        return enabledTablaVeredas;
    }
    public boolean getEnabledSelectMunicipios()
    {
        return enabledSelectMunicipios;
    }
    public String getNombreVereda()
    {
        return nombreVereda;
    }
    public void setNombreVereda(String nombreVereda)
    {
        this.nombreVereda= nombreVereda;
    }
    public Long getDepartamentoIdSelected()
    {
        return  departamentoIdSelected;
    }
    public Long getMunicipioIdSelected()
    {
        return municipioIdSelected;
    }
    
    private void loadListaDepartamentos()
    {
        listaDepartamentos = departamentoEJB.findAll();
    }
    
    private void initValues()
    {
        enabledTablaVeredas = false;
        enabledSelectMunicipios = false;
    }
    
    public void changedDepartamento(ValueChangeEvent e)
    {
        enabledSelectMunicipios = false;
        enabledTablaVeredas = false;
        this.nombreVereda = null;
        this.departamentoIdSelected = null;
        this.municipioIdSelected = null;
        this.listaMuncipios = null;
        this.listaVeredas = null;
        
        Long idDepartamento = Long.parseLong(e.getNewValue().toString());
        if(!idDepartamento.equals(0L))
        {
            this.enabledSelectMunicipios = true;
            this.departamentoIdSelected = idDepartamento;
            this.listaMuncipios = municipioEJB.findByDepartamento(departamentoIdSelected);
        } 
    }
    
    public void changedMunicipio(ValueChangeEvent e)
    {
        enabledTablaVeredas = false;
        this.nombreVereda = null;
        this.municipioIdSelected = null;
        this.listaVeredas = null;
        Long idMunicipio = Long.parseLong(e.getNewValue().toString());
        if(!idMunicipio.equals(0L))
        {
            this.enabledTablaVeredas = true;
            this.municipioIdSelected = idMunicipio;
            this.listaVeredas = veredaEJB.findByMunicipio(municipioIdSelected);
        } 
    }
    
    public void searchByMunicipioAndNombreVereda()
    {
        this.listaVeredas=veredaEJB.findByMunicipioAndNombre(municipioIdSelected, nombreVereda);
    }
    
    public void updateListaVeredas()
    {
        if(nombreVereda!=null && !nombreVereda.isEmpty())
        {
            searchByMunicipioAndNombreVereda();
        }
        else
        {
            listaVeredas = veredaEJB.findByMunicipio(municipioIdSelected);;
        }
        
    }
    
}
