/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.managedbean.ingreso;

import com.centroatencion.facade.IngresoFacade;
import com.centroatencion.managedbean.util.Util;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Wilson Carvajal
 */
@ManagedBean(name="ingresosController")
@ViewScoped
public class IngresosController implements Serializable
{
    @EJB
    private IngresoFacade ingresoEJB;
    List listaIngresos;
    
    @PostConstruct
    public void init()
    {
        listaIngresos = ingresoEJB.findAllIngresos();
    }

    public List getListaIngresos() {
        return listaIngresos;
    }
    
    public String  formatDate(Date date)
    {
        return Util.formatDate(date);
    }
    
    public void onclick()
    {
        System.out.println("onclick");
    }
    
    public String formatEstado(Integer estado)
    {
        if(estado.equals(1))
        {
            return "Vivo";
        }
        return "Muerto";
    }
}
