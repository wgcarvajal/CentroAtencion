/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.managedbean.orden;

import com.centroatencion.entities.Orden;
import com.centroatencion.facade.OrdenFacade;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Wilson Carvajal
 */
@Named("orController")
@SessionScoped
public class OrdenController implements Serializable  {
    
    @EJB
    private OrdenFacade ordenEJB;
    
    private String orden;
    private List<Orden> listaOrdenes;
    
    public OrdenController()
    {
        
    }
    
    public String getOrden()
    {
        return orden;
    }
    
    public void setOrden(String orden)
    {
        this.orden=orden;
    }
    
    public List<Orden> getListaOrdenes()
    {
        if(listaOrdenes==null)
        {
            listaOrdenes = ordenEJB.findAll();
        }
        return listaOrdenes;
    }
    
    public void searchByNombreOrden()
    {
        this.listaOrdenes=ordenEJB.searchByNombreOrden(this.orden);
    }
    
    public void updateListaOrdenes()
    {
        if(orden!=null && !orden.isEmpty())
        {
            searchByNombreOrden();
        }
        else
        {
            listaOrdenes = ordenEJB.findAll();
        }
        
    }
    
}
