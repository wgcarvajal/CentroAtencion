/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.managedbean.entidad;

import com.centroatencion.entities.Departamento;
import com.centroatencion.entities.Direcctionterritorial;
import com.centroatencion.entities.Entidad;
import com.centroatencion.entities.Municipio;
import com.centroatencion.entities.Vereda;
import com.centroatencion.facade.DepartamentoFacade;
import com.centroatencion.facade.DirecctionterritorialFacade;
import com.centroatencion.facade.EntidadFacade;
import com.centroatencion.facade.MunicipioFacade;
import com.centroatencion.facade.VeredaFacade;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Wilson Carvajal
 */
@ManagedBean(name="agregarEntidadController")
@ViewScoped
public class AgregarEntidadController implements Serializable
{
    @EJB
    private EntidadFacade entidadiEJB;
    @EJB
    private DirecctionterritorialFacade direccionTerritorialEJB;
    @EJB
    private MunicipioFacade municipioEJB;
    @EJB
    private DepartamentoFacade departamentoEJB;
    @EJB
    private VeredaFacade veredaEJB;
    
    private String nombre;
    private String direccion;
    private String telefono;
    private Long departamentoIdSelected;
    private List<Municipio> listaMunicipios;
    private List<Direcctionterritorial> listaDireccionTerritorial;
    private Integer direccionTerritorialIdSelected;
    private Long municipioSelected;
    private boolean enabledListaMunicipios;
    private List<Vereda> listaVeredas;
    private Long veredaSelected;
    private boolean enabledListaVeredas;
    
    
    public AgregarEntidadController() 
    {
        enabledListaMunicipios = false;
        enabledListaVeredas = false;
        municipioSelected = null;
        veredaSelected = null;
    }
    
    public String getNombre() 
    {
        return nombre;
    }

    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }
    public String getDireccion() 
    {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    

    public List<Municipio> getListaMunicipios() {
        listaMunicipios = municipioEJB.findByDepartamento(departamentoIdSelected);
        return listaMunicipios;
    }

    public void setListaMunicipios(List<Municipio> listaMunicipios) {
        this.listaMunicipios = listaMunicipios;
    }

    public Long getMunicipioSelected() {
        return municipioSelected;
    }

    public void setMunicipioSelected(Long municipioSelected) {
        this.municipioSelected = municipioSelected;
    }
    
    public List<Vereda> getListaVeredas() {
        return listaVeredas;
    }

    public void setListaVeredas(List<Vereda> listaVeredas) {
        this.listaVeredas = listaVeredas;
    }

    public Long getVeredaSelected() {
        return veredaSelected;
    }

    public void setVeredaSelected(Long veredaSelected) {
        this.veredaSelected = veredaSelected;
    }

    public boolean isEnabledListaVeredas() {
        return enabledListaVeredas;
    }

    public void setEnabledListaVeredas(boolean enabledListaVeredas) {
        this.enabledListaVeredas = enabledListaVeredas;
    }

    public List<Direcctionterritorial> getListaDireccionTerritorial() {
        listaDireccionTerritorial = direccionTerritorialEJB.findAll();
        return listaDireccionTerritorial;
    }

    public void setListaDireccionTerritorial(List<Direcctionterritorial> listaDireccionTerritorial) {
        this.listaDireccionTerritorial = listaDireccionTerritorial;
    }

    public Integer getDireccionTerritorialIdSelected() {
        return direccionTerritorialIdSelected;
    }

    public void setDireccionTerritorialIdSelected(Integer direccionTerritorialIdSelected) {
        this.direccionTerritorialIdSelected = direccionTerritorialIdSelected;
    }
    
    

    public void setDireccion(String direccion) 
    {
        this.direccion = direccion;
    }

    public boolean isEnabledListaMunicipios() {
        return enabledListaMunicipios;
    }

    public void setEnabledListaMunicipios(boolean enabledListaMunicipios) {
        this.enabledListaMunicipios = enabledListaMunicipios;
    }
    
    
    public void abrirVentanaAgregarEntidad(Long departamentoId)
    {
       this.departamentoIdSelected = departamentoId;
       enabledListaVeredas = false;
       veredaSelected = null;
       municipioSelected = null;
       direccionTerritorialIdSelected = null;
       PrimeFaces pf = PrimeFaces.current();
       pf.executeScript("PF('AgregarEntidad').show()");
    }
    
   public void registrarEntidad(EntidadController entidadController)
   {
       if(municipioSelected==null || municipioSelected.equals(0L))
       {
            FacesContext.getCurrentInstance().addMessage("form:municipio", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Campo obligatorio", "Campo obligatorio"));
       }
       else
       {
        Direcctionterritorial direccionTerritorial = direccionTerritorialEJB.find(direccionTerritorialIdSelected);
        Entidad entidad = new Entidad();
        entidad.setDireccionterritorialId(direccionTerritorial);
        entidad.setEntNombre(nombre);
        entidad.setEntDireccion(direccion);
        entidad.setEntTelefono(telefono);
        if(veredaSelected!=null && !veredaSelected.equals(0L))
        {
            Vereda vereda = veredaEJB.find(veredaSelected);
            entidad.setVeredaId(vereda);
        }
        else if(municipioSelected!=null)
        {
            Municipio municipio = municipioEJB.find(municipioSelected);
            entidad.setMunicipioId(municipio);
        }
        entidadiEJB.create(entidad);
        nombre="";
        entidadController.updateListaEntidad();
        PrimeFaces pf = PrimeFaces.current();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Registro Exitoso."));
        pf.executeScript("PF('mensajeRegistroExitoso').show()");
       }
   }
   
   
   public void changedMunicipio(ValueChangeEvent e)
   {
       enabledListaVeredas = false;
       municipioSelected = null;
       veredaSelected = null;
       Long idMunicipio = Long.parseLong(e.getNewValue().toString());
        if(!idMunicipio.equals(0L))
        {
            enabledListaVeredas = true;
            municipioSelected = idMunicipio;
            this.listaVeredas = veredaEJB.findByMunicipio(municipioSelected);
        }
       
   }
    
}
