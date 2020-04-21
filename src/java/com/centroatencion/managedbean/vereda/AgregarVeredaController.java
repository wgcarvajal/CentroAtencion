/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.managedbean.vereda;

import com.centroatencion.entities.Municipio;
import com.centroatencion.entities.Vereda;
import com.centroatencion.facade.MunicipioFacade;
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
@ManagedBean(name="agregarVeredaController")
@ViewScoped
public class AgregarVeredaController implements Serializable{
    
    @EJB
    private MunicipioFacade municipioEJB;
    @EJB
    private VeredaFacade veredaEJB;
    private String nombre;
    private long municipioIdSelected;
    
    
    
    public AgregarVeredaController() 
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
    
    public void abrirVentanaAgregarVereda(Long municipioIdSelected)
    {
       this.municipioIdSelected = municipioIdSelected;
       PrimeFaces pf = PrimeFaces.current();
       pf.executeScript("PF('AgregarVereda').show()");
    }
    
   public void registrarVereda(VeredaController veredaController)
   {
        Municipio municipio = municipioEJB.find(municipioIdSelected);
        Vereda vereda = new Vereda();
        vereda.setMunicipioId(municipio);
        vereda.setVerNombre(nombre);
        veredaEJB.create(vereda);
        nombre="";
        veredaController.updateListaVeredas();
        PrimeFaces pf = PrimeFaces.current();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Registro Exitoso."));
        pf.executeScript("PF('mensajeRegistroExitoso').show()");
   }
    
}
