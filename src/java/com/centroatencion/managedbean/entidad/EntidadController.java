/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.managedbean.entidad;

import com.centroatencion.entities.Departamento;
import com.centroatencion.entities.Entidad;
import com.centroatencion.entities.Vereda;
import com.centroatencion.facade.DepartamentoFacade;
import com.centroatencion.facade.EntidadFacade;
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
@ManagedBean(name="entController")
@ViewScoped
public class EntidadController implements Serializable{
    
    @EJB
    private DepartamentoFacade departamentoEJB;
    @EJB
    private EntidadFacade entidadEJB;
    @EJB
    private VeredaFacade veredaEJB; 
    
    private List<Departamento> listaDepartamento;
    private List<Entidad> listaEntidades;
    private Long departamentoIdSelected;
    private boolean enabledTablaEntidades;
    private String nombreEntidad;
    
    public EntidadController() 
    {
        
    }    
    @PostConstruct
    private void init()
    {
        this.loadListaDepartamento();
        this.initValues();
    }   
    
    public List<Entidad>getListaEntidades()
    {
        return listaEntidades;
    }
    public List<Departamento> getListaDepartamento()
    {
        return listaDepartamento;
    }
    public boolean getEnabledTablaEntidades()
    {
        return enabledTablaEntidades;
    }
    public String getNombreEntidad()
    {
        return nombreEntidad;
    }
    public void setNombreEntidad(String nombreEntidad)
    {
        this.nombreEntidad= nombreEntidad;
    }
    public Long getDepartamentoIdSelected()
    {
        return  departamentoIdSelected;
    }
    
    private void loadListaDepartamento()
    {
        listaDepartamento = departamentoEJB.findAll();
    }
    
    private void initValues()
    {
        enabledTablaEntidades = false;
    }
    
    public void changedDepartamento(ValueChangeEvent e)
    {
        enabledTablaEntidades = false;
        this.nombreEntidad = null;
        this.departamentoIdSelected = null;
        this.listaEntidades = null;
        this.nombreEntidad = null;
        
        Long idDepartamento = Long.parseLong(e.getNewValue().toString());
        if(!idDepartamento.equals(0L))
        {
            this.enabledTablaEntidades = true;
            this.departamentoIdSelected = idDepartamento;
           this.listaEntidades = entidadEJB.findByDepartamento(departamentoIdSelected);
        } 
    }
    
    
    
    public void updateListaEntidad()
    {
        listaEntidades = entidadEJB.findByDepartamento(departamentoIdSelected);;
    }
    
    public String formatMunicipio(Entidad entidad)
    {
        if(entidad.getMunicipioId()!=null)
        {
            return entidad.getMunicipioId().getMunNombre();
        }
        else if(entidad.getVeredaId()!=null)
        {
            Vereda vereda = veredaEJB.find(entidad.getVeredaId().getVerId());
            return vereda.getMunicipioId().getMunNombre();
        }
        return "";
    }
    
    public String formatVereda(Entidad entidad)
    {
        if(entidad.getVeredaId()!=null)
        {
            return entidad.getVeredaId().getVerNombre();
        }
        return "";
    }
}
