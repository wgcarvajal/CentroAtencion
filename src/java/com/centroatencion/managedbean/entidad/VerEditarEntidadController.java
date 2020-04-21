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
import com.centroatencion.entities.Zonaubicacionanimal;
import com.centroatencion.facade.DepartamentoFacade;
import com.centroatencion.facade.DirecctionterritorialFacade;
import com.centroatencion.facade.EntidadFacade;
import com.centroatencion.facade.MunicipioFacade;
import com.centroatencion.facade.VeredaFacade;
import com.centroatencion.facade.ZonaubicacionanimalFacade;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

/**
 *
 * @author Wilson Carvajal
 */
@ManagedBean(name="verEditarEntidadController")
@ViewScoped
public class VerEditarEntidadController implements Serializable{
   
    @EJB
    private ZonaubicacionanimalFacade zonaubicacionanimalEJB; 
    @EJB
    private EntidadFacade entidadEJB;
    @EJB
    private DepartamentoFacade departamentoEJB;
    @EJB
    private MunicipioFacade municipioEJB;
    @EJB
    private VeredaFacade veredaEJB;
    @EJB
    private DirecctionterritorialFacade direccionTerritorialEJB;
    
    private Entidad entidad;
    private boolean campoNombre;
    private boolean campoDireccion;
    private boolean campoTelefono;
    private boolean campoDeparMunVer;
    private boolean campoDireccionTerritorial;
    private String nombre;
    private String direccion;
    private String telefono;
    private Departamento departamento;
    private EntidadController entidadController;
    private List<Departamento> listaDepartamentos;
    private List<Municipio> listaMunicipios;
    private List<Vereda> listaVeredas;
    private List<Direcctionterritorial> listaDireccionTerritorial;
    private Long idDepartamento;
    private Long idMunicipio;
    private Long idVereda;
    private Integer idDireccionTerritorial;
    
    private List<Zonaubicacionanimal> listaZonaUbicacionAnimal;

    //private ValidarEdicionUsuarios validarEdicionUsuario;

    public VerEditarEntidadController() {
        
    }

    public List<Zonaubicacionanimal> getListaZonaUbicacionAnimal() {
        return listaZonaUbicacionAnimal;
    }

    public void setListaZonaUbicacionAnimal(List<Zonaubicacionanimal> listaZonaUbicacionAnimal) {
        this.listaZonaUbicacionAnimal = listaZonaUbicacionAnimal;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Entidad getEntidad()
    {
        return entidad;
    }

    public boolean isCampoNombre() {
        return campoNombre;
    }

    public boolean isCampoDeparMunVer() {
        return campoDeparMunVer;
    }

    public void setCampoDeparMunVer(boolean campoDeparMunVer) {
        this.campoDeparMunVer = campoDeparMunVer;
    }
    
    public void setCampoNombre(boolean campoNombre) {
        this.campoNombre = campoNombre;
    }

    public boolean isCampoTelefono() {
        return campoTelefono;
    }

    public void setCampoTelefono(boolean campoTelefono) {
        this.campoTelefono = campoTelefono;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Departamento> getListaDepartamentos() {
        return listaDepartamentos;
    }

    public void setListaDepartamentos(List<Departamento> listaDepartamentos) {
        this.listaDepartamentos = listaDepartamentos;
    }

    public Long getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Long idDepartamento) {
        this.idDepartamento = idDepartamento;
    }
    
    public boolean isCampoDireccion() {
        return campoDireccion;
    }

    public void setCampoDireccion(boolean campoDireccion) {
        this.campoDireccion = campoDireccion;
    }

    public List<Municipio> getListaMunicipios() {
        return listaMunicipios;
    }

    public void setListaMunicipios(List<Municipio> listaMunicipios) {
        this.listaMunicipios = listaMunicipios;
    }

    public Long getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(Long idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public List<Vereda> getListaVeredas() {
        return listaVeredas;
    }

    public void setListaVeredas(List<Vereda> listaVeredas) {
        this.listaVeredas = listaVeredas;
    }

    public Long getIdVereda() {
        return idVereda;
    }

    public void setIdVereda(Long idVereda) {
        this.idVereda = idVereda;
    }

    public boolean isCampoDireccionTerritorial() {
        return campoDireccionTerritorial;
    }

    public void setCampoDireccionTerritorial(boolean campoDireccionTerritorial) {
        this.campoDireccionTerritorial = campoDireccionTerritorial;
    }

    public List<Direcctionterritorial> getListaDireccionTerritorial() {
        return listaDireccionTerritorial;
    }

    public void setListaDireccionTerritorial(List<Direcctionterritorial> listaDireccionTerritorial) {
        this.listaDireccionTerritorial = listaDireccionTerritorial;
    }

    public Integer getIdDireccionTerritorial() {
        return idDireccionTerritorial;
    }

    public void setIdDireccionTerritorial(Integer idDireccionTerritorial) {
        this.idDireccionTerritorial = idDireccionTerritorial;
    }

    
    
    public void entidadSeleccionado(Entidad entidad, EntidadController mgb) {
        this.entidadController = mgb;
        this.entidad = entidad;
        this.campoNombre = true;
        this.campoDireccion = true;
        this.campoTelefono = true;
        this.campoDeparMunVer = true;
        this.campoDireccionTerritorial = true;
        this.listaZonaUbicacionAnimal = zonaubicacionanimalEJB.findByEntidadId(entidad.getEntId());

    }
    public void mostrarModificarDireccionTerritorial() {
        this.campoDireccionTerritorial = false;
        this.listaDireccionTerritorial = direccionTerritorialEJB.findAll();
        idDireccionTerritorial = entidad.getDireccionterritorialId().getDirterId();
        
    }

    public void cancelarActualizarDireccionTerritorial() {
        this.campoDireccionTerritorial = true;
    }

    public void actualizarDireccionTerritorial() {
        if(idDireccionTerritorial.equals(0))
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Seleccione una Dirección territorial", "Seleccione una Dirección territorial"));
        }
        else
        {
            this.campoDireccionTerritorial = true;
            Direcctionterritorial direcctionterritorial = direccionTerritorialEJB.find(idDireccionTerritorial);
            entidad.setDireccionterritorialId(direcctionterritorial);
            entidadEJB.edit(entidad);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info. Campo direcciton territorial Actualizado.", ""));
        }
    }
    
    public void mostrarModificarNombre() {
        this.campoNombre = false;
        this.nombre = this.entidad.getEntNombre();
    }

    public void cancelarActualizarNombre() {
        this.campoNombre = true;
        this.nombre = "";
    }

    public void actualizarNombre() {
        this.campoNombre = true;
        this.entidad.setEntNombre(nombre);
        this.entidadEJB.edit(this.entidad);
        entidadController.updateListaEntidad();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info. Campo Nombre Actualizado.", ""));
    }
    
    public void mostrarModificarDireccion() {
        this.campoDireccion = false;
        this.direccion = this.entidad.getEntDireccion();
    }

    public void cancelarActualizarDireccion() {
        this.campoDireccion = true;
        this.direccion = "";
    }

    public void actualizarDireccion() {
        this.campoDireccion = true;
        this.entidad.setEntDireccion(direccion);
        this.entidadEJB.edit(this.entidad);
        entidadController.updateListaEntidad();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info. Campo dirección Actualizado.", ""));
    }
    
    public void mostrarModificarTelefono() {
        this.campoTelefono = false;
        this.telefono = this.entidad.getEntTelefono();
    }

    public void cancelarActualizarTelefono() {
        this.campoTelefono = true;
        this.telefono = "";
    }

    public void actualizarTelefono() {
        this.campoTelefono = true;
        this.entidad.setEntTelefono(telefono);
        this.entidadEJB.edit(this.entidad);
        entidadController.updateListaEntidad();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info. Campo teléfono Actualizado.", ""));
    }
    
    public void mostrarModificarDepartamentoMunicipioVereda() {
        this.campoDeparMunVer = false;
        listaDepartamentos = departamentoEJB.findAll();
        if (entidad != null) {
            if (entidad.getMunicipioId() != null) {
                idDepartamento = entidad.getMunicipioId().getDepartamentoId().getDepId();
                idMunicipio = entidad.getMunicipioId().getMunId();
            } else if (entidad.getVeredaId() != null) {
                idDepartamento = entidad.getVeredaId().getMunicipioId().getDepartamentoId().getDepId();
                idMunicipio = entidad.getVeredaId().getMunicipioId().getMunId();
                idVereda = entidad.getVeredaId().getVerId();
            }
            else
            {
                idDepartamento = 0L;
                idMunicipio = 0L;
                idVereda = 0L;
            }
        }
        else
        {
            idDepartamento = 0L;
            idMunicipio = 0L;
            idVereda = 0L;
        }
        
        if(!idDepartamento.equals(0L))
        {
            listaMunicipios = municipioEJB.findByDepartamento(idDepartamento);
            if(!idMunicipio.equals(0L))
            {
                listaVeredas = veredaEJB.findByMunicipio(idMunicipio);
            }
        }
        
        
    }

    public void cancelarActualizarDepartamentoMunicipioVereda() {
        this.campoDeparMunVer = true;
        //this.telefono = "";
    }

    public void actualizarDepartamentoMunicipioVereda() {
        
       if(idDepartamento==null || idDepartamento.equals(0L))
       {
          FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Seleccione un departamento", "Seleccione un departamento"));
       }
       else if(idMunicipio == null || idMunicipio.equals(0L))
       {
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Seleccione un municipio", "Seleccione un municipio"));
       }
       else
       {
            
            if(idVereda!=null && !idVereda.equals(0L))
            {
                Vereda vereda = veredaEJB.find(idVereda);
                entidad.setVeredaId(vereda);
                entidad.setMunicipioId(null);
            }
            else
            {
                Municipio municipio = municipioEJB.find(idMunicipio);
                entidad.setMunicipioId(municipio);
                entidad.setVeredaId(null);
            }
            entidadEJB.edit(entidad);
            this.campoDeparMunVer = true;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info. Actualizado.", ""));
       }
    }
    
    public String getFormatDepartamento()
    {
        if (entidad != null) {
            if (entidad.getMunicipioId() != null) {
                return entidad.getMunicipioId().getDepartamentoId().getDepNombre();
            } else if (entidad.getVeredaId() != null) {
                return entidad.getVeredaId().getMunicipioId().getDepartamentoId().getDepNombre();
            }
        }
        return"";
    }
    
    public String getFormatMunicipio()
    {
        if (entidad != null) {
            if (entidad.getMunicipioId() != null) {
                return entidad.getMunicipioId().getMunNombre();
            }else if (entidad.getVeredaId() != null) {
                return entidad.getVeredaId().getMunicipioId().getMunNombre();
            }
        }
        return"";
    }
    
    public String getFormatVereda()
    {
        if (entidad != null) {
            if (entidad.getVeredaId() != null) {
                return entidad.getVeredaId().getVerNombre();
            }
        }
        return"";
    }
    
    public void changedDepartamento(ValueChangeEvent e)
    {
        listaMunicipios = null;
        listaVeredas = null;
        idDepartamento = 0L;
        idMunicipio = 0L;
        idVereda = 0L;
        Long id = Long.parseLong(e.getNewValue().toString());
        if(!id.equals(0L))
        {
            listaMunicipios = municipioEJB.findByDepartamento(id);
            this.idDepartamento = id;
        } 
    }
    
    public void changedMunicipio(ValueChangeEvent e)
    {
        listaVeredas = null;
        idMunicipio = 0L;
        idVereda = 0L;
        Long id = Long.parseLong(e.getNewValue().toString());
        if(!id.equals(0L))
        {
            listaVeredas = veredaEJB.findByMunicipio(id);
            this.idMunicipio = id;
        } 
    }
    
    public void updateListaZona()
    {
        listaZonaUbicacionAnimal = zonaubicacionanimalEJB.findByEntidadId(entidad.getEntId());
    }
}
