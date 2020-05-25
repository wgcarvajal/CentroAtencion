/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.managedbean.ingreso;

import com.centroatencion.entities.Animal;
import com.centroatencion.entities.Departamento;
import com.centroatencion.entities.Desarrollobiologico;
import com.centroatencion.entities.Direcctionterritorial;
import com.centroatencion.entities.Donanteinfractor;
import com.centroatencion.entities.Estado;
import com.centroatencion.entities.Familia;
import com.centroatencion.entities.Genero;
import com.centroatencion.entities.Ingreso;
import com.centroatencion.entities.Ingresosubproducto;
import com.centroatencion.entities.Lugardecomisoentregavoluntaria;
import com.centroatencion.entities.Municipio;
import com.centroatencion.entities.Orden;
import com.centroatencion.entities.Persona;
import com.centroatencion.entities.Responsable;
import com.centroatencion.entities.Responsableingreso;
import com.centroatencion.entities.Subproducto;
import com.centroatencion.entities.Vereda;
import com.centroatencion.facade.AnimalFacade;
import com.centroatencion.facade.DepartamentoFacade;
import com.centroatencion.facade.DesarrollobiologicoFacade;
import com.centroatencion.facade.DirecctionterritorialFacade;
import com.centroatencion.facade.DonanteinfractorFacade;
import com.centroatencion.facade.EstadoFacade;
import com.centroatencion.facade.GeneroFacade;
import com.centroatencion.facade.IngresoFacade;
import com.centroatencion.facade.IngresosubproductoFacade;
import com.centroatencion.facade.LugardecomisoentregavoluntariaFacade;
import com.centroatencion.facade.MunicipioFacade;
import com.centroatencion.facade.PersonaFacade;
import com.centroatencion.facade.ResponsableFacade;
import com.centroatencion.facade.ResponsableingresoFacade;
import com.centroatencion.facade.SubproductoFacade;
import com.centroatencion.facade.VeredaFacade;
import com.centroatencion.managedbean.util.Util;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.http.HttpServletRequest;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author Wilson Carvajal
 */
@ManagedBean(name="nuevoIngresoController")
@ViewScoped
public class NuevoIngresoController implements Serializable
{
    @EJB
    private DirecctionterritorialFacade dirTerritorialEJB;
    @EJB
    private AnimalFacade animalEJB; 
    @EJB
    private PersonaFacade personaEJB;
    @EJB
    private DonanteinfractorFacade donanteinfractorEJB;
    @EJB
    private DepartamentoFacade departamentoEJB;
    @EJB
    private MunicipioFacade municipioEJB;
    @EJB
    private VeredaFacade veredaEJB;
    @EJB
    private ResponsableFacade responsableEJB;
    @EJB
    private LugardecomisoentregavoluntariaFacade lugardecomisoentregavoluntariaEJB;
    @EJB
    private DesarrollobiologicoFacade desarrollobiologicoEJB;
    @EJB
    private GeneroFacade generoEJB;
    @EJB
    private SubproductoFacade subproductoEJB;
    @EJB
    private ResponsableingresoFacade responsableingresoEJB;
    @EJB
    private IngresosubproductoFacade ingresosubproductoEJB;
    @EJB
    private IngresoFacade ingresoEJB;
    @EJB
    private EstadoFacade estadoEJB;
    private Date date;
    private Direcctionterritorial direcctionterritorial;
    private List<Direcctionterritorial>listDirTerritorial;
    private List<Animal> ListaAnimal;
    private List<Departamento> listaDepartamentos;
    private List<Municipio> listaMunicipios;
    private List<Vereda> listaVeredas;
    private List<Departamento> listaDepartamentosOcurrencia;
    private List<Municipio> listaMunicipiosOcurrencia;
    private List<Vereda> listaVeredasOcurrencia;
    private List<Responsable>listaResponsables;
    private List<Lugardecomisoentregavoluntaria> listaLugardecomisoentregavoluntaria;
    private List<Genero> listaGenero;
    private List<Desarrollobiologico> listaDesarrolloBiologico;
    private List<Subproducto> listaSubproducto;
    private Animal animalSelected;
    private Departamento departamentoSelected;
    private Municipio municipioSelected;
    private Vereda veredaSelected;
    private Departamento departamentoOcurrenciaSelected;
    private Municipio municipioOcurrenciaSelected;
    private Vereda veredaOcurrenciaSelected;
    private Genero generoSelected;
    private Desarrollobiologico desarrollobiologicoSelected;
    private Subproducto [] listaSubproductoSelected;
    private String familiaNombre;
    private String ordenNombre;
    private String causaIngreso;
    private String estadoSalud;
    private String noRadicado;
    private String noAUCTFF;
    private boolean verPersona;
    private boolean verMunicipios;
    private boolean verVeredas;
    private boolean verMunicipiosOcurrencia;
    private boolean verVeredasOcurrencia;
    private boolean ejemplarMuerto;
    private boolean ejemplarVivo;
    private boolean productoCompleto;
    private boolean subProducto;
    private String tipoPersona;
    private String identificacion;
    private String nombres;
    private String apellidos;
    private String direccion;
    private String telefono;
    private String observaciones;
    private Responsable [] responsablesSelected;
    private Lugardecomisoentregavoluntaria lugardecomisoentregavoluntariaSelected;
    private int estado;
    private int producto;
    
    
    @PostConstruct
    public void init()
    {
        listDirTerritorial = dirTerritorialEJB.findAll();
        ListaAnimal = animalEJB.findAll();
        listaDepartamentos = departamentoEJB.findAll();
        listaDepartamentosOcurrencia = departamentoEJB.findAll();
        listaResponsables = responsableEJB.findAll();
        listaLugardecomisoentregavoluntaria = lugardecomisoentregavoluntariaEJB.findAll();
        listaDesarrolloBiologico = desarrollobiologicoEJB.findAll();
        listaGenero = generoEJB.findAll();
        listaSubproducto = subproductoEJB.findAll();
        verPersona= false;
        verMunicipios = false;
        verVeredas = false;
        verMunicipiosOcurrencia = false;
        verVeredasOcurrencia = false;
        ejemplarMuerto = false;
        ejemplarVivo = false;
        productoCompleto = false;
        subProducto = false;
        estado = 0;
        producto = 0;
    }
    
    public Date maxVisibleDate()
    {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public List<Subproducto> getListaSubproducto() {
        return listaSubproducto;
    }

    public Subproducto[] getListaSubproductoSelected() {
        return listaSubproductoSelected;
    }

    public void setListaSubproductoSelected(Subproducto[] listaSubproductoSelected) {
        this.listaSubproductoSelected = listaSubproductoSelected;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Direcctionterritorial getDirecctionterritorial() {
        return direcctionterritorial;
    }

    public void setDirecctionterritorial(Direcctionterritorial direcctionterritorial) {
        this.direcctionterritorial = direcctionterritorial;
    }

    public List<Direcctionterritorial> getListDirTerritorial() {
        return listDirTerritorial;
    }

    public void setListDirTerritorial(List<Direcctionterritorial> listDirTerritorial) {
        this.listDirTerritorial = listDirTerritorial;
    }

    public List<Animal> getListaAnimal() {
        return ListaAnimal;
    }

    public Animal getAnimalSelected() {
        return animalSelected;
    }

    public Departamento getDepartamentoSelected() {
        return departamentoSelected;
    }

    public void setDepartamentoSelected(Departamento departamentoSelected) {
        this.departamentoSelected = departamentoSelected;
    }

    public Municipio getMunicipioSelected() {
        return municipioSelected;
    }

    public void setMunicipioSelected(Municipio municipioSelected) {
        this.municipioSelected = municipioSelected;
    }
    
    public void setAnimalSelected(Animal animalSelected) {
        this.animalSelected = animalSelected;
    }

    public String getCausaIngreso() {
        return causaIngreso;
    }

    public void setCausaIngreso(String causaIngreso) {
        this.causaIngreso = causaIngreso;
    }

    public boolean isVerPersona() {
        return verPersona;
    }

    public boolean isEjemplarVivo() {
        return ejemplarVivo;
    }

    public boolean isProductoCompleto() {
        return productoCompleto;
    }

    public boolean isSubProducto() {
        return subProducto;
    }

    public void setVerPersona(boolean verPersona) {
        this.verPersona = verPersona;
    }

    public String getTipoPersona() {
        return tipoPersona;
    }

    public String getEstadoSalud() {
        return estadoSalud;
    }

    public void setEstadoSalud(String estadoSalud) {
        this.estadoSalud = estadoSalud;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getProducto() {
        return producto;
    }

    public void setProducto(int producto) {
        this.producto = producto;
    }
    
    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Municipio> getListaMunicipios() {
        return listaMunicipios;
    }

    public List<Vereda> getListaVeredas() {
        return listaVeredas;
    }

    public List<Responsable> getListaResponsables() {
        return listaResponsables;
    }

    public boolean isVerVeredas() {
        return verVeredas;
    }

    public boolean isVerMunicipios() {
        return verMunicipios;
    }

    public boolean isEjemplarMuerto() {
        return ejemplarMuerto;
    }
    
    public Vereda getVeredaSelected() {
        return veredaSelected;
    }

    public void setVeredaSelected(Vereda veredaSelected) {
        this.veredaSelected = veredaSelected;
    }

    public List<Departamento> getListaDepartamentosOcurrencia() {
        return listaDepartamentosOcurrencia;
    }

    public List<Municipio> getListaMunicipiosOcurrencia() {
        return listaMunicipiosOcurrencia;
    }

    public List<Vereda> getListaVeredasOcurrencia() {
        return listaVeredasOcurrencia;
    }

    public boolean isVerMunicipiosOcurrencia() {
        return verMunicipiosOcurrencia;
    }

    public boolean isVerVeredasOcurrencia() {
        return verVeredasOcurrencia;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
    public Departamento getDepartamentoOcurrenciaSelected() {
        return departamentoOcurrenciaSelected;
    }

    public void setDepartamentoOcurrenciaSelected(Departamento departamentoOcurrenciaSelected) {
        this.departamentoOcurrenciaSelected = departamentoOcurrenciaSelected;
    }

    public Municipio getMunicipioOcurrenciaSelected() {
        return municipioOcurrenciaSelected;
    }

    public void setMunicipioOcurrenciaSelected(Municipio municipioOcurrenciaSelected) {
        this.municipioOcurrenciaSelected = municipioOcurrenciaSelected;
    }

    public Vereda getVeredaOcurrenciaSelected() {
        return veredaOcurrenciaSelected;
    }

    public void setVeredaOcurrenciaSelected(Vereda veredaOcurrenciaSelected) {
        this.veredaOcurrenciaSelected = veredaOcurrenciaSelected;
    }

    public List<Lugardecomisoentregavoluntaria> getListaLugardecomisoentregavoluntaria() {
        return listaLugardecomisoentregavoluntaria;
    }

    public Lugardecomisoentregavoluntaria getLugardecomisoentregavoluntariaSelected() {
        return lugardecomisoentregavoluntariaSelected;
    }

    public void setLugardecomisoentregavoluntariaSelected(Lugardecomisoentregavoluntaria lugardecomisoentregavoluntariaSelected) {
        this.lugardecomisoentregavoluntariaSelected = lugardecomisoentregavoluntariaSelected;
    }

    public Genero getGeneroSelected() {
        return generoSelected;
    }

    public void setGeneroSelected(Genero generoSelected) {
        this.generoSelected = generoSelected;
    }

    public Desarrollobiologico getDesarrollobiologicoSelected() {
        return desarrollobiologicoSelected;
    }

    public void setDesarrollobiologicoSelected(Desarrollobiologico desarrollobiologicoSelected) {
        this.desarrollobiologicoSelected = desarrollobiologicoSelected;
    }

    public List<Genero> getListaGenero() {
        return listaGenero;
    }

    public List<Desarrollobiologico> getListaDesarrolloBiologico() {
        return listaDesarrolloBiologico;
    }

    public String getNoRadicado() {
        return noRadicado;
    }

    public void setNoRadicado(String noRadicado) {
        this.noRadicado = noRadicado;
    }

    public String getNoAUCTFF() {
        return noAUCTFF;
    }

    public void setNoAUCTFF(String noAUCTFF) {
        this.noAUCTFF = noAUCTFF;
    }
    
    public void reloadAnimalList()
    {
        ListaAnimal = animalEJB.findAll();
    }
    
    public void reloadDepartamentoList()
    {
        listaDepartamentos = departamentoEJB.findAll();
    }
    
    public void reloadMunicipioList()
    {
        listaMunicipios = municipioEJB.findByDepartamento(departamentoSelected.getDepId());
    }
    
    public void reloadVeredaList()
    {
        listaVeredas = veredaEJB.findByMunicipio(municipioSelected.getMunId());
    }
    
    public void reloadDepartamentoOcurrenciaList()
    {
        listaDepartamentosOcurrencia = departamentoEJB.findAll();
    }
    
    public void reloadMunicipioOcurrenciaList()
    {
        listaMunicipiosOcurrencia = municipioEJB.findByDepartamento(departamentoOcurrenciaSelected.getDepId());
    }
    
    public void reloadVeredaOcurrenciaList()
    {
        listaVeredasOcurrencia = veredaEJB.findByMunicipio(municipioOcurrenciaSelected.getMunId());
    }
    
    public String familiaNombre()
    {
        return familiaNombre;
    }
    
    public String ordenNombre()
    {
        return ordenNombre;
    }

    public List<Departamento> getListaDepartamentos() {
        return listaDepartamentos;
    }

    public Responsable[] getResponsablesSelected() {
        return responsablesSelected;
    }

    public void setResponsablesSelected(Responsable[] responsablesSelected) {
        this.responsablesSelected = responsablesSelected;
    }
    
    public void changedAnimal(ValueChangeEvent e)
    {
        if(e.getNewValue() != null){
            animalSelected = (Animal)e.getNewValue();
            List<Object[]> listaObjeto = animalEJB.findFamiliaJoinOrden(animalSelected.getAnId());
            Object[] objects = listaObjeto.get(0);
            Familia f = (Familia)objects[0];
            Orden o = (Orden)objects[1];
            familiaNombre = f.getFaNombre();
            ordenNombre = o.getOrNombre();
        }
        else
        {
            familiaNombre = null;
            ordenNombre = null;
        }
    }
    
    public void changedCausaIngreso(ValueChangeEvent e)
    {
        causaIngreso = (String)e.getNewValue();
        FacesContext context = FacesContext.getCurrentInstance();
        if(causaIngreso.equalsIgnoreCase("DC"))
        {
            tipoPersona = ResourceBundle.getBundle("/Bundle").getString("Infractor");
        }
        else
        {
            tipoPersona = ResourceBundle.getBundle("/Bundle").getString("Donante");
        }
        verPersona= true;
    }
    
    public void changedDepartamento(ValueChangeEvent e)
    {
        if(e.getNewValue()!=null)
        {
            departamentoSelected = (Departamento)e.getNewValue();
            listaMunicipios = municipioEJB.findByDepartamento(departamentoSelected.getDepId());
            verMunicipios = true;
            municipioSelected = null;
            veredaSelected = null;
            listaVeredas = null;
            verVeredas = false;
        }
        else{
            departamentoSelected= null;
            listaMunicipios = null;
            verMunicipios = false;
            municipioSelected = null;
            listaVeredas = null;
            veredaSelected = null;
            verVeredas = false;
        }
    }
    
    public void changedMunicipio(ValueChangeEvent e)
    {
        if(e.getNewValue()!=null)
        {
            municipioSelected = (Municipio)e.getNewValue();
            listaVeredas = veredaEJB.findByMunicipio(municipioSelected.getMunId());
            veredaSelected =null;
            verVeredas = true;
        }
        else{
            municipioSelected = null;
            listaVeredas = null;
            veredaSelected =null;
            verVeredas = false;
        }
    }
    
    public void changedDepartamentoOcurrencia(ValueChangeEvent e)
    {
        if(e.getNewValue()!=null)
        {
            departamentoOcurrenciaSelected = (Departamento)e.getNewValue();
            listaMunicipiosOcurrencia = municipioEJB.findByDepartamento(departamentoOcurrenciaSelected.getDepId());
            verMunicipiosOcurrencia = true;
            municipioOcurrenciaSelected = null;
            listaVeredasOcurrencia = null;
            verVeredasOcurrencia = false;
            veredaOcurrenciaSelected =null;
        }
        else{
            departamentoOcurrenciaSelected= null;
            listaMunicipiosOcurrencia = null;
            verMunicipiosOcurrencia = false;
            municipioOcurrenciaSelected = null;
            listaVeredasOcurrencia = null;
            veredaOcurrenciaSelected =null;
            verVeredasOcurrencia = false;
        }
    }
    
    public void changedMunicipioOcurrencia(ValueChangeEvent e)
    {
        if(e.getNewValue()!=null)
        {
            municipioOcurrenciaSelected = (Municipio)e.getNewValue();
            listaVeredasOcurrencia = veredaEJB.findByMunicipio(municipioOcurrenciaSelected.getMunId());
            verVeredasOcurrencia = true;
            veredaOcurrenciaSelected =null;
        }
        else{
            municipioOcurrenciaSelected = null;
            listaVeredasOcurrencia = null;
            veredaOcurrenciaSelected =null;
            verVeredasOcurrencia = false;
        }
    }
    
    public void changedGenero(ValueChangeEvent e)
    {
        if(e.getNewValue()!=null)
        {
            generoSelected = (Genero)e.getNewValue();
        }else
        {
            generoSelected=null;
        }
    }
    
    public void changedDesarrolloBiologico(ValueChangeEvent e)
    {
        if(e.getNewValue()!=null)
        {
            desarrollobiologicoSelected = (Desarrollobiologico)e.getNewValue();
        }else
        {
            desarrollobiologicoSelected=null;
        }
    }
    
    public void changedEstado(ValueChangeEvent e)
    {
        if(e.getNewValue()!= null)
        {
            int est = (int)e.getNewValue();
            ejemplarVivo = false;
            ejemplarMuerto = false;
            productoCompleto = false;
            subProducto = false;
            producto = 0;
            observaciones = null;
            estadoSalud = null;
            listaSubproductoSelected = null;
            
            if(est == 2)
            {
                ejemplarMuerto = true;
            }
            else
            {
                ejemplarVivo = true;
            }
        }
        
    }
    
    public void changedProducto(ValueChangeEvent e)
    {
        if(e.getNewValue()!= null)
        {
            subProducto = false;
            productoCompleto = false;
            observaciones = null;
            listaSubproductoSelected = null;
            int prod = (int)e.getNewValue();
            if(prod == 2)
            {
                subProducto = true;
            }
            else
            {
                productoCompleto = true;
            }
        }
        
    }
    
    public void buscarPersona()
    {
        Donanteinfractor donanteinfractor = donanteinfractorEJB.findByDoninIdentifiacion(identificacion);
        if(donanteinfractor!=null)
        {
            nombres = donanteinfractor.getDoninNombres();
            apellidos = donanteinfractor.getDoninApellidos();
            direccion = donanteinfractor.getDoninDireccion();
            telefono = donanteinfractor.getDoninTelefono();
        }
    }
    
    public String onFlowProcess(FlowEvent event) {
        
        if(event.getNewStep().equalsIgnoreCase("causa"))
        {
            if(animalSelected!=null)
            {
                return event.getNewStep();
            }
            else{
                FacesContext.getCurrentInstance().
                addMessage("form:seleccionEspecie", 
                        new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                "Campo requerido","Campo requerido"));
                return event.getOldStep();
            }
        }else if(event.getNewStep().equalsIgnoreCase("sitioOcurrencia"))
        {
            if(causaIngreso!=null && !causaIngreso.isEmpty())
            {
                return event.getNewStep();
            }
            else{
                FacesContext.getCurrentInstance().
                addMessage("form:SeleccioneCausa", 
                        new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                "Campo requerido","Campo requerido"));
                return event.getOldStep();
            }
        }
        else
        {
            return event.getNewStep();
        }
    }
    
    public void registrar()
    {
        if(estado!=0)
        {
            if(estado == 2)
            {
                if(producto!=0)
                {
                    guardarIngreso();
                    
                }
                else{
                    FacesContext.getCurrentInstance().
                    addMessage("form:SeleccioneProducto", 
                        new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                "Campo requerido","Campo requerido"));
                }
            }
            else if(estado == 1)
            {
                guardarIngreso();
            }
        }
        else
        {
            FacesContext.getCurrentInstance().
                addMessage("form:SeleccioneEstado", 
                        new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                "Campo requerido","Campo requerido"));
        }
    }
    
    public void guardarIngreso() {
        Ingreso ingreso = new Ingreso();
        ingreso.setIngFecha(date);
        ingreso.setDirterId(direcctionterritorial);
        if (noRadicado != null && !noRadicado.isEmpty()) {
            ingreso.setIngRadicado(noRadicado);
        }
        if (noAUCTFF != null && !noAUCTFF.isEmpty()) {
            ingreso.setIngAUCTFF(noAUCTFF);
        }
        ingreso.setAnimalId(animalSelected);
        ingreso.setIngCausa(causaIngreso);
        boolean actualizarDonante = false;
        Donanteinfractor donanteinfractor = null;
        if (identificacion != null && !identificacion.isEmpty()) {
            donanteinfractor = donanteinfractorEJB.findByDoninIdentifiacion(identificacion);
            if (donanteinfractor != null) {
                if (nombres != null && !nombres.isEmpty()) {
                    nombres = Util.formatText(nombres);
                    if (!nombres.equals(donanteinfractor.getDoninNombres())) {
                        actualizarDonante = true;
                        donanteinfractor.setDoninNombres(nombres);
                    }
                }

                if (apellidos != null && !apellidos.isEmpty()) {
                    apellidos = Util.formatText(apellidos);
                    if (!apellidos.equals(donanteinfractor.getDoninApellidos())) {
                        actualizarDonante = true;
                        donanteinfractor.setDoninApellidos(apellidos);
                    }
                }

                if (telefono != null && !telefono.isEmpty()) {
                    if (!telefono.equals(donanteinfractor.getDoninTelefono())) {
                        actualizarDonante = true;
                        donanteinfractor.setDoninTelefono(telefono);
                    }
                }

                if (direccion != null && !direccion.isEmpty()) {
                    direccion = Util.formatText(direccion);
                    if (!direccion.equals(donanteinfractor.getDoninDireccion())) {
                        actualizarDonante = true;
                        donanteinfractor.setDoninDireccion(direccion);
                    }
                }

                if (actualizarDonante) {
                    donanteinfractorEJB.edit(donanteinfractor);
                }

            } else {
                donanteinfractor = new Donanteinfractor();
                donanteinfractor.setDoninIdentifiacion(identificacion);
                if (nombres != null && !nombres.isEmpty()) {
                    nombres = Util.formatText(nombres);
                    donanteinfractor.setDoninNombres(nombres);
                }
                if (apellidos != null && !apellidos.isEmpty()) {
                    apellidos = Util.formatText(apellidos);
                    donanteinfractor.setDoninApellidos(apellidos);
                }

                if (telefono != null && !telefono.isEmpty()) {
                    donanteinfractor.setDoninTelefono(telefono);
                }

                if (direccion != null && !direccion.isEmpty()) {
                    direccion = Util.formatText(direccion);
                    donanteinfractor.setDoninDireccion(direccion);
                }
                donanteinfractorEJB.create(donanteinfractor);
            }
        } else if (nombres != null && !nombres.isEmpty()) {
            nombres = Util.formatText(nombres);
            donanteinfractor = new Donanteinfractor();
            donanteinfractor.setDoninNombres(nombres);
            if (apellidos != null && !apellidos.isEmpty()) {
                apellidos = Util.formatText(apellidos);
                donanteinfractor.setDoninApellidos(apellidos);
            }

            if (telefono != null && !telefono.isEmpty()) {
                donanteinfractor.setDoninTelefono(telefono);
            }

            if (direccion != null && !direccion.isEmpty()) {
                direccion = Util.formatText(direccion);
                donanteinfractor.setDoninDireccion(direccion);
            }
            donanteinfractorEJB.create(donanteinfractor);
        }
        if (donanteinfractor != null) {
            ingreso.setDonanteinfractorId(donanteinfractor);
        }

        if (veredaOcurrenciaSelected != null) {
            ingreso.setVerOcurrenciaId(veredaOcurrenciaSelected);
        } else if (municipioOcurrenciaSelected != null) {
            ingreso.setMunOcurrenciaId(municipioOcurrenciaSelected);
        } else if (departamentoOcurrenciaSelected != null) {
            ingreso.setDepOcurrenciaId(departamentoOcurrenciaSelected);
        }

        if (lugardecomisoentregavoluntariaSelected != null) {
            ingreso.setLugardecomisoentregavoluntariaId(lugardecomisoentregavoluntariaSelected);
        }

        if (veredaSelected != null) {
            ingreso.setVerExtraccionId(veredaSelected);
        } else if (municipioSelected != null) {
            ingreso.setMunExtraccionId(municipioSelected);
        } else if (departamentoSelected != null) {
            ingreso.setDepExtraccionId(departamentoSelected);
        }

        if (generoSelected != null) {
            ingreso.setGenId(generoSelected);
        }

        if (desarrollobiologicoSelected != null) {
            ingreso.setDesbioId(desarrollobiologicoSelected);
        }

        if (observaciones != null && !observaciones.isEmpty()) {
            ingreso.setIngObservaciones(observaciones);
        }

        if (estado == 1) {
            if (estadoSalud != null && !estadoSalud.isEmpty()) {
                ingreso.setIngEstadoSalud(estadoSalud);
            }
        }

        FacesContext fc = FacesContext.getCurrentInstance();
        HttpServletRequest req = (HttpServletRequest) fc.getExternalContext().getRequest();
        Persona p = personaEJB.findPersonaByNombreUsuario(req.getUserPrincipal().getName());
        ingreso.setFuncionarioId(p);

        long consecutivo = ingresoEJB.findMaxConsecutivo();
        consecutivo = consecutivo + 1;
        ingreso.setIngConsecutivo(consecutivo);
        ingresoEJB.create(ingreso);

        if (responsablesSelected != null && responsablesSelected.length > 0) {
            for (Responsable r : responsablesSelected) {
                Responsableingreso responsableingreso = new Responsableingreso();
                responsableingreso.setRespId(r);
                responsableingreso.setIngId(ingreso);
                responsableingresoEJB.create(responsableingreso);
            }
        }

        if (listaSubproductoSelected != null && listaSubproductoSelected.length > 0) {
            for (Subproducto insub : listaSubproductoSelected) {
                Ingresosubproducto ingresosubproducto = new Ingresosubproducto();
                ingresosubproducto.setSubprodId(insub);
                ingresosubproducto.setIngId(ingreso);
                ingresosubproductoEJB.create(ingresosubproducto);
            }
        }
        Estado e = new Estado();
        e.setIngId(ingreso);
        e.setEstado(estado);
        e.setEstadoFecha(date);
        estadoEJB.create(e);
    }
}
