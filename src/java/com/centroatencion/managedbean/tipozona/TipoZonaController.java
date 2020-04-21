/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.managedbean.tipozona;

import com.centroatencion.entities.Tipozonaubicacion;
import com.centroatencion.facade.TipozonaubicacionFacade;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Wilson Carvajal
 */
@ManagedBean(name="tipZonaController")
@ViewScoped
public class TipoZonaController implements Serializable{
    
    @EJB
    private TipozonaubicacionFacade tipozonaubicacionEJB;
    
    private List<Tipozonaubicacion> listaTipoZonaUbicacionbicacion;
    
    public TipoZonaController() 
    {
        
    } 
    
    public List<Tipozonaubicacion>getListaTipoZonaUbicacion()
    {
        if(listaTipoZonaUbicacionbicacion==null)
        {
            listaTipoZonaUbicacionbicacion = tipozonaubicacionEJB.findAll();
        }
        return listaTipoZonaUbicacionbicacion;
    }
    
    public void setListaTipoZonaUbicacion(List<Tipozonaubicacion> listaTipoZonaUbicacionbicacion)
    {
        this.listaTipoZonaUbicacionbicacion= listaTipoZonaUbicacionbicacion;
    }
    
    public void updateListaTipoZonaUbicacion()
    {
        this.listaTipoZonaUbicacionbicacion = tipozonaubicacionEJB.findAll();
    }
}
