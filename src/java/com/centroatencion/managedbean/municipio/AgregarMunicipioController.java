/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.managedbean.municipio;

import com.centroatencion.entities.Departamento;
import com.centroatencion.entities.Municipio;
import com.centroatencion.facade.DepartamentoFacade;
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
@ManagedBean(name="agregarMunicipioController")
@ViewScoped
public class AgregarMunicipioController implements Serializable
{
    @EJB
    private MunicipioFacade municipioiEJB;
    @EJB
    private DepartamentoFacade departamentoEJB;
    private String nombre;
    private long departamentoIdSelected;
    
    
    
    public AgregarMunicipioController() 
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
    
    public void abrirVentanaAgregarMunicipio(Long departamentoIdSelected)
    {
       this.departamentoIdSelected = departamentoIdSelected;
       PrimeFaces pf = PrimeFaces.current();
       pf.executeScript("PF('AgregarMunicipio').show()");
    }
    
   public void registrarMunicipio(MunicipioController municipioController)
   {
        Departamento departamento = departamentoEJB.find(departamentoIdSelected);
        Municipio municipio = new Municipio();
        municipio.setDepartamentoId(departamento);
        municipio.setMunNombre(nombre);
        municipioiEJB.create(municipio);
        nombre="";
        municipioController.updateListaMunicipio();
        PrimeFaces pf = PrimeFaces.current();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Registro Exitoso."));
        pf.executeScript("PF('mensajeRegistroExitoso').show()");
   }
    
}
