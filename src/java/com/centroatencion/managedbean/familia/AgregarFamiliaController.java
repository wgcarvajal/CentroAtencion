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
import com.centroatencion.managedbean.util.Util;
import java.io.Serializable;
import java.util.List;
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
    private List<Orden> listaOrden;
    
    
    
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

    public Integer getOrdenIdSelected() {
        return ordenIdSelected;
    }

    public void setOrdenIdSelected(Integer ordenIdSelected) {
        this.ordenIdSelected = ordenIdSelected;
    }

    public List<Orden> getListaOrden() {
        return listaOrden;
    }

    public void setListaOrden(List<Orden> listaOrden) {
        this.listaOrden = listaOrden;
    }
    
    public void abrirVentanaAgregarFamilia(Integer ordenIdSelected)
    {
       this.ordenIdSelected = ordenIdSelected;
       PrimeFaces pf = PrimeFaces.current();
       nombre = "";
       descripcion = "";
       if(ordenIdSelected==0)
       {
          listaOrden = ordenEJB.findAll();
          pf.executeScript("PF('AgregarFamiliaConOrden').show()");
       }else{
          pf.executeScript("PF('AgregarFamilia').show()");
       }
    }
    
    
   public void registrarFamilia(FamiliaController familiaController)
   {
       PrimeFaces pf = PrimeFaces.current();
       nombre = Util.formatText(nombre);
       if (!familiaiEJB.existeNombre(nombre)) {
           Orden orden = ordenEJB.find(ordenIdSelected);
           Familia familia = new Familia();
           familia.setOrId(orden);
           familia.setFaNombre(nombre);
           if (descripcion != null && !descripcion.isEmpty()) {
               familia.setFaDescripcion(descripcion);
           }
           familiaiEJB.create(familia);
           nombre = "";
           descripcion = "";
           ordenIdSelected = 0;
           familiaController.updateListaFamilia();
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Registro Exitoso."));
       } else {
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Familia ya existe."));
       }          
       pf.executeScript("PF('mensajeRegistroExitoso').show()");
   }
}
