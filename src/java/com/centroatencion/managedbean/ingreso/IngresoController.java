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
import com.centroatencion.entities.Entidadterritorial;
import com.centroatencion.entities.Familia;
import com.centroatencion.entities.Genero;
import com.centroatencion.entities.Grupotaxonomico;
import com.centroatencion.entities.Ingreso;
import com.centroatencion.entities.Lugardecomisoentregavoluntaria;
import com.centroatencion.entities.Municipio;
import com.centroatencion.entities.Orden;
import com.centroatencion.entities.Persona;
import com.centroatencion.entities.Responsable;
import com.centroatencion.entities.Ubicar;
import com.centroatencion.entities.Subproducto;
import com.centroatencion.entities.Vereda;
import com.centroatencion.facade.DepartamentoFacade;
import com.centroatencion.facade.DirecctionterritorialFacade;
import com.centroatencion.facade.EntidadterritorialFacade;
import com.centroatencion.facade.IngresoFacade;
import com.centroatencion.facade.MunicipioFacade;
import com.centroatencion.facade.PersonaFacade;
import com.centroatencion.facade.UbicarFacade;
import com.centroatencion.facade.VeredaFacade;
import com.centroatencion.managedbean.util.Util;
import java.io.IOException;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.primefaces.PrimeFaces;
import org.primefaces.event.TabChangeEvent;

/**
 *
 * @author Wilson Carvajal
 */
@ManagedBean(name="ingresoController")
@ViewScoped
public class IngresoController implements Serializable{
    
    @EJB
    private IngresoFacade ingresoEJB;
    @EJB
    private VeredaFacade veredaEJB;
    @EJB
    private MunicipioFacade municipioEJB;
    @EJB
    private DepartamentoFacade departamentoEJB;
    @EJB
    private UbicarFacade ubicarEJB;
    @EJB
    private EntidadterritorialFacade entidadterritorialEJB;
    @EJB
    private DirecctionterritorialFacade direcctionterritorialEJB;
    @EJB
    private PersonaFacade personaEJB;
    private Object[] ingresoObject;
    private Persona funcionario;
    private Donanteinfractor donanteInfractor;
    private Animal animal;
    private Familia familia;
    private Orden orden;
    private Ingreso ingreso;
    private Genero genero;
    private Vereda veredaOcurrencia;
    private Municipio municipioOcurrencia;
    private Departamento departamentoOCurrencia;
    private Lugardecomisoentregavoluntaria lugardecomisoentregavoluntaria;
    private Vereda veredaExtraccion;
    private Municipio municipioExtraccion;
    private Departamento departamentoExtraccion;
    private Desarrollobiologico desarrollobiologico;
    private Grupotaxonomico grupotaxonomico;
    private Direcctionterritorial direccionterritorial;
    private Integer estado;
    private List<Responsable> listaResponsable;
    private List<Subproducto> listSubproducto;
    private List<Ingreso> ingresos;
    private Ingreso currentIngreso;
    private List<Entidadterritorial> entidadterritorialList;
    private Entidadterritorial entidadterritorialSelectedToUbicar;
    private Date dateUbicar;
    private List<Direcctionterritorial> direcctionterritorialList;
    private Direcctionterritorial direccionterritorialSelectedToTransladar;
    private Date dateTransladar;
    private List<Ubicar> ubicarList;
    
    @PostConstruct
    public void init()
    {
        FacesContext context = FacesContext.getCurrentInstance();
        Map<String, String> paramMap = context.getExternalContext().getRequestParameterMap();
        String ingId = paramMap.get("ingreso");
        
        if (ingId != null && !ingId.equals("")) {
            try {
                Long id = Long.parseLong(ingId);
                ingresoObject = ingresoEJB.findIngresoByIngId(id);
                if(ingresoObject==null)
                {
                    goToIngresos();
                }
                else{
                    ingreso = (Ingreso)ingresoObject[0];
                    ingresos = ingresoEJB.findTransladosByIngId(id);
                    if(ingresos!=null && !ingresos.isEmpty())
                    {
                        currentIngreso = ingresos.get(ingresos.size()-1);
                    }
                    else
                    {
                        currentIngreso = ingreso;
                    }
                    animal = (Animal)ingresoObject[1];
                    familia = (Familia)ingresoObject[2];
                    orden = (Orden)ingresoObject[3];
                    grupotaxonomico = (Grupotaxonomico)ingresoObject[4];
                    funcionario = (Persona)ingresoObject[5];
                    direccionterritorial = (Direcctionterritorial)ingresoObject[6];
                    genero = ingreso.getGenId();
                    desarrollobiologico = ingreso.getDesbioId();
                    donanteInfractor = ingreso.getDonanteinfractorId();
                    estado = (Integer)ingresoObject[7];
                    listSubproducto = ingresoEJB.findSubproductos(ingreso.getIngId());
                    if(ingreso.getVerOcurrenciaId()!=null)
                    {
                        veredaOcurrencia = ingreso.getVerOcurrenciaId();
                        Object [] municipiodepartamento = veredaEJB.findMuncipioDepartamentoById(veredaOcurrencia.getVerId());
                        municipioOcurrencia = (Municipio)municipiodepartamento[0];
                        departamentoOCurrencia = (Departamento)municipiodepartamento[1];
                    }
                    else if(ingreso.getMunOcurrenciaId()!=null)
                    {
                        municipioOcurrencia = ingreso.getMunOcurrenciaId();
                        departamentoOCurrencia = municipioEJB.findDepartamentoById(municipioOcurrencia.getMunId());
                    }
                    else if(ingreso.getDepOcurrenciaId()!=null)
                    {
                        departamentoOCurrencia = ingreso.getDepOcurrenciaId();
                    }
                    
                    if(ingreso.getLugardecomisoentregavoluntariaId()!=null)
                    {
                        lugardecomisoentregavoluntaria = ingreso.getLugardecomisoentregavoluntariaId();
                    }
                    
                    if(ingreso.getVerExtraccionId()!=null)
                    {
                        veredaExtraccion = ingreso.getVerExtraccionId();
                        Object [] municipiodepartamento = veredaEJB.findMuncipioDepartamentoById(veredaExtraccion.getVerId());
                        municipioExtraccion = (Municipio)municipiodepartamento[0];
                        departamentoExtraccion = (Departamento)municipiodepartamento[1];
                    }
                    else if(ingreso.getMunExtraccionId()!=null)
                    {
                        municipioExtraccion = ingreso.getMunExtraccionId();
                        departamentoExtraccion = municipioEJB.findDepartamentoById(municipioExtraccion.getMunId());
                    }
                    else if(ingreso.getDepExtraccionId()!=null)
                    {
                        departamentoExtraccion = ingreso.getDepExtraccionId();
                    }
                }
                
            } catch (NumberFormatException e) {
                goToIngresos();
            }
        } else {
            goToIngresos();
        }
    }
    
    public void goToIngresos()
    {
        try{
            FacesContext.getCurrentInstance().getExternalContext().redirect("/CentroAtencion/user/ingreso/ingresos.xhtml");
        }catch(IOException e)
        {
            Logger.getLogger(IngresoController.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    public Persona getFuncionario() {
        return funcionario;
    }

    public Animal getAnimal() {
        return animal;
    }

    public Ingreso getIngreso() {
        return ingreso;
    }

    public Direcctionterritorial getDireccionterritorial() {
        return direccionterritorial;
    }

    public Familia getFamilia() {
        return familia;
    }

    public Orden getOrden() {
        return orden;
    }

    public Genero getGenero() {
        return genero;
    }

    public Desarrollobiologico getDesarrollobiologico() {
        return desarrollobiologico;
    }

    public Grupotaxonomico getGrupotaxonomico() {
        return grupotaxonomico;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public List<Responsable> getListaResponsable() {
        return listaResponsable;
    }

    public List<Subproducto> getListSubproducto() {
        return listSubproducto;
    }

    public Donanteinfractor getDonanteInfractor() {
        return donanteInfractor;
    }

    public Vereda getVeredaOcurrencia() {
        return veredaOcurrencia;
    }

    public Municipio getMunicipioOcurrencia() {
        return municipioOcurrencia;
    }

    public Departamento getDepartamentoOCurrencia() {
        return departamentoOCurrencia;
    }

    public Lugardecomisoentregavoluntaria getLugardecomisoentregavoluntaria() {
        return lugardecomisoentregavoluntaria;
    }

    public Vereda getVeredaExtraccion() {
        return veredaExtraccion;
    }

    public Municipio getMunicipioExtraccion() {
        return municipioExtraccion;
    }

    public Departamento getDepartamentoExtraccion() {
        return departamentoExtraccion;
    }
    
    public String formatFecha(Date date)
    {
        return Util.formatDate(date);
    }
    
    public String returnEnt()
    {
        return "33";
    }
    
    public String returnAnio(Date date)
    {
        return Util.getAnio(date);
    }

    public List<Entidadterritorial> getEntidadterritorialList() {
        return entidadterritorialList;
    }

    public void setEntidadterritorialList(List<Entidadterritorial> entidadterritorialList) {
        this.entidadterritorialList = entidadterritorialList;
    }

    public Entidadterritorial getEntidadterritorialSelectedToUbicar() {
        return entidadterritorialSelectedToUbicar;
    }

    public void setEntidadterritorialSelectedToUbicar(Entidadterritorial entidadterritorialSelectedToUbicar) {
        this.entidadterritorialSelectedToUbicar = entidadterritorialSelectedToUbicar;
    }

    public Date getDateUbicar() {
        return dateUbicar;
    }

    public void setDateUbicar(Date dateUbicar) {
        this.dateUbicar = dateUbicar;
    }

    public Direcctionterritorial getDireccionterritorialSelectedToTransladar() {
        return direccionterritorialSelectedToTransladar;
    }

    public void setDireccionterritorialSelectedToTransladar(Direcctionterritorial direccionterritorialSelectedToTransladar) {
        this.direccionterritorialSelectedToTransladar = direccionterritorialSelectedToTransladar;
    }

    public Date getDateTransladar() {
        return dateTransladar;
    }

    public void setDateTransladar(Date dateTransladar) {
        this.dateTransladar = dateTransladar;
    }

    public List<Direcctionterritorial> getDirecctionterritorialList() {
        return direcctionterritorialList;
    }

    public void setDirecctionterritorialList(List<Direcctionterritorial> direcctionterritorialList) {
        this.direcctionterritorialList = direcctionterritorialList;
    }

    public List<Ingreso> getIngresos() {
        return ingresos;
    }

    public List<Ubicar> getUbicarList() {
        return ubicarList;
    }
    
    public String returnEstado(Integer estado)
    {
        if(estado.equals(1))
        {
            return "Vivo";
        }
        return "Muerto";
    }
    
    public String returnResponsables()
    {
        if(listaResponsable!=null && !listaResponsable.isEmpty())
        {
            String responsables = "";
            for(int i = 0;i<listaResponsable.size();i++)
            {
                if(i!=0)
                {
                    responsables = responsables+", ";
                }
                responsables = responsables + listaResponsable.get(i).getRespNombre();
            }
            return responsables;
        }
        return "";
    }
    
    public boolean returnEsSubproducto()
    {
        if(listSubproducto!=null && !listSubproducto.isEmpty())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public String returnSubproducto()
    {
        if(listSubproducto!=null && !listSubproducto.isEmpty())
        {
            String subproducto = "";
            for(int i = 0;i<listSubproducto.size();i++)
            {
                if(i!=0)
                {
                    subproducto = subproducto+", ";
                }
                subproducto = subproducto + listSubproducto.get(i).getSubprodNombre();
            }
            return subproducto;
        }
        return "";
    }
    
    public String returnEstadoSalud(String estadoSalud)
    {
        if(estadoSalud.equals("B"))
        {
            return "Bueno";
        }
        else if(estadoSalud.equals("R"))
        {
            return "Regular";
        }
        return "Malo";
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
    
    public void openUbicarDialog()
    {
        PrimeFaces pf = PrimeFaces.current();
        dateUbicar = null;
        entidadterritorialSelectedToUbicar = null;
        Direcctionterritorial dt = currentIngreso.getDirterId();
        List<Ubicar> ubicarList = ubicarEJB.searchByIngresoId(currentIngreso.getIngId());
        if(ubicarList!=null && !ubicarList.isEmpty())
        {
            Entidadterritorial entidadterritorial = ubicarList.get(ubicarList.size()-1).getEntterId();
            entidadterritorialList = entidadterritorialEJB.findAllByDireccionterritorialWithoutCurrentEntidadterritorial(dt.getDirterId(), entidadterritorial.getEntterId());
        }
        else{
            entidadterritorialList = entidadterritorialEJB.findAllByDireccionterritorial(dt.getDirterId());
        }
        pf.ajax().update(":formUbicar");
        pf.executeScript("PF('ubicar').show()");
    }
    
    public void aceptarUbicar()
    {
        PrimeFaces pf = PrimeFaces.current();
        if(entidadterritorialSelectedToUbicar==null)
        {
            FacesContext.getCurrentInstance().
                addMessage("formUbicar:selectEntidadTerritorial", 
                        new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                "Campo requerido","Campo requerido"));
            
        }
        
        if(dateUbicar==null)
        {
            FacesContext.getCurrentInstance().
                addMessage("formUbicar:dateUbicar", 
                        new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                "Campo requerido","Campo requerido"));
            
        }
        
        if(entidadterritorialSelectedToUbicar!=null && dateUbicar!=null)
        {
            Ubicar ubicar = new Ubicar();
            ubicar.setIngId(currentIngreso);
            ubicar.setEntterId(entidadterritorialSelectedToUbicar);
            ubicar.setUbFecha(dateUbicar);
            FacesContext fc = FacesContext.getCurrentInstance();
            HttpServletRequest req = (HttpServletRequest) fc.getExternalContext().getRequest();
            Persona p = personaEJB.findPersonaByNombreUsuario(req.getUserPrincipal().getName());
            ubicar.setFuncionarioId(p);
            ubicarEJB.create(ubicar);
            entidadterritorialSelectedToUbicar = null;
            dateUbicar = null;
            FacesContext.getCurrentInstance().
                addMessage(null, 
                        new FacesMessage(FacesMessage.SEVERITY_INFO,
                                "Operación exitosa","Operación exitosa"));
        }
        pf.ajax().update("formUbicar:panelUbicar");
    }
    
    public void openTransladarDialog()
    {
        PrimeFaces pf = PrimeFaces.current();
        dateTransladar = null;
        direccionterritorialSelectedToTransladar = null;
        Direcctionterritorial dt = currentIngreso.getDirterId();
        direcctionterritorialList = direcctionterritorialEJB.findAllWithoutCurrentDireccionterritorial(dt.getDirterId());
        pf.ajax().update(":formTransladar");
        pf.executeScript("PF('transladar').show()");
    }
    
    public void aceptarTransladar()
    {
        PrimeFaces pf = PrimeFaces.current();
        if(direccionterritorialSelectedToTransladar==null)
        {
            FacesContext.getCurrentInstance().
                addMessage("formTransladar:selectDireccionTerritorial", 
                        new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                "Campo requerido","Campo requerido"));
            
        }
        
        if(dateTransladar==null)
        {
            FacesContext.getCurrentInstance().
                addMessage("formTransladar:dateTransladar", 
                        new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                "Campo requerido","Campo requerido"));
            
        }
        
        if(direccionterritorialSelectedToTransladar!=null && dateTransladar!=null)
        {
            Ingreso transladar = new Ingreso();
            transladar.setIngTranslado(ingreso);
            transladar.setIngFecha(dateTransladar);
            transladar.setDirterId(direccionterritorialSelectedToTransladar);
            FacesContext fc = FacesContext.getCurrentInstance();
            HttpServletRequest req = (HttpServletRequest) fc.getExternalContext().getRequest();
            Persona p = personaEJB.findPersonaByNombreUsuario(req.getUserPrincipal().getName());
            transladar.setFuncionarioId(p);
            ingresoEJB.create(transladar);
            ingresos = ingresoEJB.findTransladosByIngId(ingreso.getIngId());
            if(ingresos!=null && !ingresos.isEmpty())
            {
                currentIngreso = ingresos.get(ingresos.size()-1);
            }
            else
            {
                currentIngreso = ingreso;
            }
            direccionterritorialSelectedToTransladar = null;
            dateTransladar = null;
            FacesContext.getCurrentInstance().
                addMessage(null, 
                        new FacesMessage(FacesMessage.SEVERITY_INFO,
                                "Operación exitosa","Operación exitosa"));
        }
        pf.ajax().update("formTransladar:panelTranladar");
    }
    
    public int getIndexUtimoIngreso()
    {
        if(ingresos!=null && !ingresos.isEmpty())
        {
            return ingresos.size();
        }
        return 0;
    }
    
    public void onTabChangeIngreso(TabChangeEvent tabEvent)
    {
        String titleTip = tabEvent.getTab().getTitletip();
        if(titleTip!=null && titleTip.equalsIgnoreCase("MovDt"))
        {
            ubicarList=null;
            ubicarList = ubicarEJB.searchByIngresoIdDesc(ingreso.getIngId());
        }
        
    }
    
    public void onTabChangeTranslado(TabChangeEvent tabEvent)
    {
        String titleTip = tabEvent.getTab().getTitletip();
        String [] split = titleTip.split("_");
        Long id = Long.parseLong(split[1]);
        if(split[0].equals("MovDT"))
        {
            ubicarList=null;
            ubicarList = ubicarEJB.searchByIngresoIdDesc(id);
        }
        
    }
    
    public boolean renderedMovDt()
    {
        return ubicarList!=null && !ubicarList.isEmpty();
    }
    
}
