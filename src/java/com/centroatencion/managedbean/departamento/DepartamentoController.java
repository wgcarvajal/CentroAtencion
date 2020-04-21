/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.managedbean.departamento;

import com.centroatencion.entities.Departamento;
import com.centroatencion.facade.DepartamentoFacade;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Wilson Carvajal
 */
@Named("departController")
@SessionScoped
public class DepartamentoController implements Serializable  {
    
    @EJB
    private DepartamentoFacade departamentoEJB;
    
    private String departamento;
    private List<Departamento> listaDepartamentos;
    
    public DepartamentoController()
    {
        
    }
    
    public String getDepartamento()
    {
        return departamento;
    }
    
    public void setDepartamento(String departamento)
    {
        this.departamento=departamento;
    }
    
    public List<Departamento> getListaDepartamentos()
    {
        if(listaDepartamentos==null)
        {
            listaDepartamentos = departamentoEJB.findAll();
        }
        return listaDepartamentos;
    }
    
    public void searchByNombreDepartamento()
    {
        this.listaDepartamentos=departamentoEJB.searchByNombreDepartamento(this.departamento);
    }
    
    public void updateListaDepartamentos()
    {
        if(departamento!=null && !departamento.isEmpty())
        {
            searchByNombreDepartamento();
        }
        else
        {
            listaDepartamentos = departamentoEJB.findAll();
        }
        
    }
    
}
