/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.managedbean.grupotaxonomico;

import com.centroatencion.entities.Grupotaxonomico;
import com.centroatencion.facade.GrupotaxonomicoFacade;
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
@Named("verEditarGrupoTaxonomicoController")
@SessionScoped
public class VerEditarGrupoTaxonomicoController implements Serializable{
    @EJB
    private GrupotaxonomicoFacade grupoTaxonomicoEJB;
   
    private Grupotaxonomico grupoTaxonomico;
    private boolean campoNombre;
    private boolean campoAbreviatura;
    private String nombre;
    private String abreviatura;
    private GrupoTaxonomicoController grupoTaxonomicoController;

    //private ValidarEdicionUsuarios validarEdicionUsuario;

    public VerEditarGrupoTaxonomicoController() {
        
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public Grupotaxonomico getGrupoTaxonomico()
    {
        return grupoTaxonomico;
    }

    public boolean isCampoNombre() {
        return campoNombre;
    }
    public boolean isCampoAbreviatura() {
        return campoAbreviatura;
    }
    public void setCampoAbreviatura(boolean campoAbreviatura) {
        this.campoAbreviatura = campoAbreviatura;
    }

    public void setCampoNombre(boolean campoNombre) {
        this.campoNombre = campoNombre;
    }

    public void grupoTaxonomicoSeleccionado(Grupotaxonomico grupoTaxonomico, GrupoTaxonomicoController mgb) {
        this.grupoTaxonomicoController = mgb;
        this.grupoTaxonomico = grupoTaxonomico;
        this.campoNombre = true;
        this.campoAbreviatura = true;
        PrimeFaces pf = PrimeFaces.current();  
        pf.executeScript("PF('verEditarGrupoTaxonomico').show()");

    }
    public void mostrarModificarNombre() {
        this.campoNombre = false;
        this.nombre = this.grupoTaxonomico.getGruptaxNombre();
    }

    public void cancelarActualizarNombre() {
        this.campoNombre = true;
        this.nombre = "";
    }

    public void actualizarNombre() {
        this.campoNombre = true;
        this.grupoTaxonomico.setGruptaxNombre(nombre);
        this.grupoTaxonomicoEJB.edit(this.grupoTaxonomico);
        grupoTaxonomicoController.updateListaGrupoTaxonomicoes();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info. Campo Nombre Actualizado.", ""));
    }
    
    public void mostrarModificarAbreviatura() {
        this.campoAbreviatura = false;
        this.abreviatura = this.grupoTaxonomico.getGrupotaxAbreviatura();
    }

    public void cancelarActualizarAbreviatura() {
        this.campoAbreviatura = true;
        this.abreviatura = "";
    }

    public void actualizarAbreviatura() {
        this.campoAbreviatura = true;
        this.grupoTaxonomico.setGrupotaxAbreviatura(abreviatura);
        this.grupoTaxonomicoEJB.edit(this.grupoTaxonomico);
        grupoTaxonomicoController.updateListaGrupoTaxonomicoes();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info. Campo Descripcion Actualizado.", ""));
    }
}
