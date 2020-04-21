/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.managedbean.direccionterritorial;

import com.centroatencion.entities.Direcctionterritorial;
import com.centroatencion.facade.DirecctionterritorialFacade;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Wilson Carvajal
 */
@ManagedBean(name="dTerritorialController")
@ViewScoped
public class DireccionTerritorialController implements Serializable{
    
    @EJB
    private DirecctionterritorialFacade direccionTerritorialEJB;
    
    
    private List<Direcctionterritorial> listaDireccionTerritorial;
    private List<Direcctionterritorial> listaDireccionTerritoriaFiltrados;
    
    public DireccionTerritorialController() 
    {
        
    } 

    public List<Direcctionterritorial> getListaDireccionTerritoriaFiltrados() {
        return listaDireccionTerritoriaFiltrados;
    }

    public void setListaDireccionTerritoriaFiltrados(List<Direcctionterritorial> listaDireccionTerritoriaFiltrados) {
        this.listaDireccionTerritoriaFiltrados = listaDireccionTerritoriaFiltrados;
    }
    
    
    
    public List<Direcctionterritorial> getListaDireccionTerritorial()
    {
        if(listaDireccionTerritorial==null)
        {
            listaDireccionTerritorial = direccionTerritorialEJB.findAll();
        }
        return listaDireccionTerritorial;
    }
    
    
    
    public void updateListaDireccionTerritorial()
    {
        listaDireccionTerritorial = direccionTerritorialEJB.findAll();
    }
    
}
