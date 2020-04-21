/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.managedbean.vereda;

import com.centroatencion.entities.Vereda;
import com.centroatencion.facade.VeredaFacade;
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
@ManagedBean(name="verEditarVeredaController")
@ViewScoped
public class VerEditarVeredaController implements Serializable{
    
    @EJB
    private VeredaFacade veredaEJB;
   
    private Vereda vereda;
    private boolean campoNombre;
    private String nombre;
    private VeredaController veredaController;

    //private ValidarEdicionUsuarios validarEdicionUsuario;

    public VerEditarVeredaController() {
        
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Vereda getVereda()
    {
        return vereda;
    }

    public boolean isCampoNombre() {
        return campoNombre;
    }

    public void setCampoNombre(boolean campoNombre) {
        this.campoNombre = campoNombre;
    }

    public void veredaSeleccionado(Vereda vereda, VeredaController mgb) {
        this.veredaController = mgb;
        this.vereda = vereda;
        this.campoNombre = true;
        PrimeFaces pf = PrimeFaces.current();  
        pf.executeScript("PF('verEditarVereda').show()");

    }
    public void mostrarModificarNombre() {
        this.campoNombre = false;
        this.nombre = this.vereda.getVerNombre();
    }

    public void cancelarActualizarNombre() {
        this.campoNombre = true;
        this.nombre = "";
    }

    public void actualizarNombre() {
        this.campoNombre = true;
        this.vereda.setVerNombre(nombre);
        this.veredaEJB.edit(this.vereda);
        veredaController.updateListaVeredas();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info. Campo Nombre Actualizado.", ""));
    }
    
}
