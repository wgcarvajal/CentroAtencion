/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.managedbean.familia;

import com.centroatencion.entities.Orden;
import com.centroatencion.entities.Familia;
import com.centroatencion.facade.OrdenFacade;
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
@ManagedBean(name="famController")
@ViewScoped
public class FamiliaController implements Serializable{
    
    @EJB
    private OrdenFacade ordenEJB;
    @EJB
    private FamiliaFacade familiaEJB;
    
    private List<Orden> listaOrdens;
    private List<Familia> listaFamilias;
    private Integer ordenIdSelected;
    private boolean enabledTablaOrdens;
    private String nombreFamilia;
    
    public FamiliaController() 
    {
        
    }    
    @PostConstruct
    private void init()
    {
        this.loadListaOrdens();
        this.initValues();
    }   
    
    public List<Familia>getListaFamilias()
    {
        return listaFamilias;
    }
    public List<Orden> getListaOrdens()
    {
        return listaOrdens;
    }
    public boolean getEnabledTablaOrdens()
    {
        return enabledTablaOrdens;
    }
    public String getNombreFamilia()
    {
        return nombreFamilia;
    }
    public void setNombreFamilia(String nombreFamilia)
    {
        this.nombreFamilia= nombreFamilia;
    }
    public Integer getOrdenIdSelected()
    {
        return  ordenIdSelected;
    }
    
    private void loadListaOrdens()
    {
        listaOrdens = ordenEJB.findAll();
    }
    
    private void initValues()
    {
        enabledTablaOrdens = true;
        ordenIdSelected =0;
        listaFamilias = familiaEJB.findAll();
    }
    
    public void changedOrden(ValueChangeEvent e)
    {
        enabledTablaOrdens = false;
        this.nombreFamilia = null;
        this.ordenIdSelected = null;
        this.listaFamilias = null;
        this.nombreFamilia = null;
        
        int idOrden = Integer.parseInt(e.getNewValue().toString());
        this.enabledTablaOrdens = true;
        if(idOrden!=0)
        {
            this.ordenIdSelected = idOrden;
            this.listaFamilias = familiaEJB.findByOrden(ordenIdSelected);
        }
        else{
            this.ordenIdSelected = 0;
            this.listaFamilias = familiaEJB.findAll();
        }
    }
    
    public void searchByOrdenAndNombreFamilia()
    {
        this.listaFamilias=familiaEJB.findByOrdenAndNombre(ordenIdSelected, nombreFamilia);
    }
    
    public void updateListaFamilia()
    {
        if(nombreFamilia!=null && !nombreFamilia.isEmpty())
        {
            searchByOrdenAndNombreFamilia();
        }
        else
        {
            if(ordenIdSelected ==0)
            {
                listaFamilias = familiaEJB.findAll();
            }
            else{listaFamilias = familiaEJB.findByOrden(ordenIdSelected);}
        }
        
    }
}
