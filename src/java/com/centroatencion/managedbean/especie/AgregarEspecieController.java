/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.managedbean.especie;

import com.centroatencion.entities.Familia;
import com.centroatencion.entities.Especie;
import com.centroatencion.facade.FamiliaFacade;
import com.centroatencion.facade.EspecieFacade;
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
@ManagedBean(name="agregarEspecieController")
@ViewScoped
public class AgregarEspecieController implements Serializable{
    
    @EJB
    private FamiliaFacade familiaEJB;
    @EJB
    private EspecieFacade especieEJB;
    private String nombre;
    private String descripcion;
    private Integer familiaIdSelected;
    
    
    
    public AgregarEspecieController() 
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
    
    public void abrirVentanaAgregarEspecie(Integer familiaIdSelected)
    {
       this.familiaIdSelected = familiaIdSelected;
       PrimeFaces pf = PrimeFaces.current();
       pf.executeScript("PF('AgregarEspecie').show()");
    }
    
   public void registrarEspecie(EspecieController especieController)
   {
        Familia familia = familiaEJB.find(familiaIdSelected);
        Especie especie = new Especie();
        especie.setFaId(familia);
        especie.setEspNombre(nombre);
        especie.setEspDescripcion(descripcion);
        especieEJB.create(especie);
        nombre="";
        descripcion="";
        especieController.updateListaEspecies();
        PrimeFaces pf = PrimeFaces.current();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Registro Exitoso."));
        pf.executeScript("PF('mensajeRegistroExitoso').show()");
   }
    
}
