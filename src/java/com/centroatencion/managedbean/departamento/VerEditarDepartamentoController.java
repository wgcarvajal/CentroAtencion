/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.managedbean.departamento;

import com.centroatencion.entities.Departamento;
import com.centroatencion.facade.DepartamentoFacade;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Wilson Carvajal
 */
@Named("verEditarDepartamentoController")
@SessionScoped
public class VerEditarDepartamentoController implements Serializable{
    @EJB
    private DepartamentoFacade departamentoEJB;
   
    private Departamento departamento;
    private boolean campoNombre;
    private String nombre;
    private DepartamentoController departamentoController;

    //private ValidarEdicionUsuarios validarEdicionUsuario;

    public VerEditarDepartamentoController() {
        
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Departamento getDepartamento()
    {
        return departamento;
    }

    public boolean isCampoNombre() {
        return campoNombre;
    }

    public void setCampoNombre(boolean campoNombre) {
        this.campoNombre = campoNombre;
    }

    public void departamentoSeleccionado(Departamento departamento, DepartamentoController mgb) {
        this.departamentoController = mgb;
        this.departamento = departamento;
        this.campoNombre = true;
        
        PrimeFaces pf = PrimeFaces.current();  
        pf.executeScript("PF('verEditarDepartamento').show()");

    }
    public void mostrarModificarNombre() {
        this.campoNombre = false;
        this.nombre = this.departamento.getDepNombre();
    }

    public void cancelarActualizarNombre() {
        this.campoNombre = true;
        this.nombre = "";
    }

    public void actualizarNombre() {
        this.campoNombre = true;
        this.departamento.setDepNombre(nombre);
        this.departamentoEJB.edit(this.departamento);
        departamentoController.updateListaDepartamentos();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info. Campo Nombre Actualizado.", ""));
    }
}
