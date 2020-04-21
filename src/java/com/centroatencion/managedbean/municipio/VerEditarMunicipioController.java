/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.managedbean.municipio;

import com.centroatencion.entities.Municipio;
import com.centroatencion.facade.MunicipioFacade;
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
@ManagedBean(name="verEditarMunicipioController")
@ViewScoped
public class VerEditarMunicipioController implements Serializable{
    
    @EJB
    private MunicipioFacade municipioEJB;
   
    private Municipio municipio;
    private boolean campoNombre;
    private String nombre;
    private MunicipioController municipioController;

    //private ValidarEdicionUsuarios validarEdicionUsuario;

    public VerEditarMunicipioController() {
        
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Municipio getMunicipio()
    {
        return municipio;
    }

    public boolean isCampoNombre() {
        return campoNombre;
    }

    public void setCampoNombre(boolean campoNombre) {
        this.campoNombre = campoNombre;
    }

    public void municipioSeleccionado(Municipio municipio, MunicipioController mgb) {
        this.municipioController = mgb;
        this.municipio = municipio;
        this.campoNombre = true;
        PrimeFaces pf = PrimeFaces.current();  
        pf.executeScript("PF('verEditarMunicipio').show()");

    }
    public void mostrarModificarNombre() {
        this.campoNombre = false;
        this.nombre = this.municipio.getMunNombre();
    }

    public void cancelarActualizarNombre() {
        this.campoNombre = true;
        this.nombre = "";
    }

    public void actualizarNombre() {
        this.campoNombre = true;
        this.municipio.setMunNombre(nombre);
        this.municipioEJB.edit(this.municipio);
        municipioController.updateListaMunicipio();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info. Campo Nombre Actualizado.", ""));
    }
    
}
