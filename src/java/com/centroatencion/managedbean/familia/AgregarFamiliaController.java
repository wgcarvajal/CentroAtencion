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
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Wilson Carvajal
 */
@ManagedBean(name="agregarFamiliaController")
@ViewScoped
public class AgregarFamiliaController implements Serializable
{
    @EJB
    private FamiliaFacade familiaiEJB;
    @EJB
    private OrdenFacade ordenEJB;
    private String nombre;
    private String descripcion;
    private Integer ordenIdSelected;
    
    
    
    public AgregarFamiliaController() 
    {
        
    }
    
    public String getNombre() 
    {
        return nombre;
    }

    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }
    public String getDescripcion() 
    {
        return descripcion;
    }

    public void setDescripcion(String descripcion) 
    {
        this.descripcion = descripcion;
    }
    
    public void abrirVentanaAgregarFamilia(Integer ordenIdSelected)
    {
       this.ordenIdSelected = ordenIdSelected;
       PrimeFaces pf = PrimeFaces.current();
       pf.executeScript("PF('AgregarFamilia').show()");
    }
    
   public void registrarFamilia(FamiliaController familiaController)
   {
        Orden orden = ordenEJB.find(ordenIdSelected);
        Familia familia = new Familia();
        familia.setOrId(orden);
        familia.setFaNombre(nombre);
        if(descripcion!=null && !descripcion.isEmpty())
        {
            familia.setFaDescripcion(descripcion);
        }
        familiaiEJB.create(familia);
        nombre="";
        familiaController.updateListaFamilia();
        PrimeFaces pf = PrimeFaces.current();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Registro Exitoso."));
        pf.executeScript("PF('mensajeRegistroExitoso').show()");
   }
    
}
