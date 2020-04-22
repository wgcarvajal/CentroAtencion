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
    private List<Familia> listaFamilias;
    
    
    
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

    public Integer getFamiliaIdSelected() {
        return familiaIdSelected;
    }

    public void setFamiliaIdSelected(Integer familiaIdSelected) {
        this.familiaIdSelected = familiaIdSelected;
    }

    public List<Familia> getListaFamilias() {
        return listaFamilias;
    }

    public void setListaFamilias(List<Familia> listaFamilias) {
        this.listaFamilias = listaFamilias;
    }
    
    public void abrirVentanaAgregarEspecie(Integer familiaIdSelected)
    {
        PrimeFaces pf = PrimeFaces.current();
        this.familiaIdSelected = familiaIdSelected;
        nombre=null;
        descripcion =null;
        if (familiaIdSelected == 0) {
            listaFamilias = familiaEJB.findAll();
            pf.executeScript("PF('AgregarEspecieConFamilia').show()");

        } else {
            pf.executeScript("PF('AgregarEspecie').show()");
        }
    }
    
    public void registrarEspecie(EspecieController especieController) {
        PrimeFaces pf = PrimeFaces.current();
        nombre = Util.formatText(nombre);
        if (!especieEJB.existeNombre(nombre)) {
            Familia familia = familiaEJB.find(familiaIdSelected);
            Especie especie = new Especie();
            especie.setFaId(familia);
            especie.setEspNombre(nombre);
            if (descripcion != null && !descripcion.isEmpty()) {
                especie.setEspDescripcion(descripcion);
            }
            especieEJB.create(especie);
            nombre = "";
            descripcion = "";
            especieController.updateListaEspecies();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Registro Exitoso."));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error:", "La especie ya existe"));
            
        }
        pf.executeScript("PF('mensajeRegistroExitoso').show()");
   }
   
    public void registrarFamiliaConNombre(EspecieController especieController) {
        PrimeFaces pf = PrimeFaces.current();
        nombre = Util.formatText(nombre);
        if (!especieEJB.existeNombre(nombre)) {
            Familia familia = familiaEJB.find(familiaIdSelected);
            Especie especie = new Especie();
            especie.setFaId(familia);
            especie.setEspNombre(nombre);
            if (descripcion != null && !descripcion.isEmpty()) {
                especie.setEspDescripcion(descripcion);
            }
            especieEJB.create(especie);
            nombre = "";
            descripcion = "";
            familiaIdSelected = 0;
            especieController.updateListaEspecies();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Registro Exitoso."));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error:", "La especie ya existe"));
        }
        pf.executeScript("PF('mensajeRegistroExitoso').show()");
    }
    
}
