/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.managedbean.ingreso;

import com.centroatencion.entities.Animal;
import com.centroatencion.entities.Cargo;
import com.centroatencion.entities.Departamento;
import com.centroatencion.entities.Desarrollobiologico;
import com.centroatencion.entities.Direcctionterritorial;
import com.centroatencion.entities.Donanteinfractor;
import com.centroatencion.entities.Entidadterritorial;
import com.centroatencion.entities.Estado;
import com.centroatencion.entities.Familia;
import com.centroatencion.entities.Genero;
import com.centroatencion.entities.Grupotaxonomico;
import com.centroatencion.entities.Ingreso;
import com.centroatencion.entities.Ingresodocumento;
import com.centroatencion.entities.Ingresofoto;
import com.centroatencion.entities.Lugardecomisoentregavoluntaria;
import com.centroatencion.entities.Municipio;
import com.centroatencion.entities.Orden;
import com.centroatencion.entities.Persona;
import com.centroatencion.entities.Responsable;
import com.centroatencion.entities.Ubicar;
import com.centroatencion.entities.Subproducto;
import com.centroatencion.entities.Vereda;
import com.centroatencion.facade.AsignacargoFacade;
import com.centroatencion.facade.DepartamentoFacade;
import com.centroatencion.facade.DirecctionterritorialFacade;
import com.centroatencion.facade.EntidadterritorialFacade;
import com.centroatencion.facade.EstadoFacade;
import com.centroatencion.facade.IngresoFacade;
import com.centroatencion.facade.IngresodocumentoFacade;
import com.centroatencion.facade.IngresofotoFacade;
import com.centroatencion.facade.MunicipioFacade;
import com.centroatencion.facade.PersonaFacade;
import com.centroatencion.facade.UbicarFacade;
import com.centroatencion.facade.VeredaFacade;
import com.centroatencion.managedbean.util.Util;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import org.primefaces.PrimeFaces;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.TabChangeEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

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
    @EJB
    private EstadoFacade estadoEJB;
    @EJB
    private AsignacargoFacade asignacargoEJB;
    @EJB
    private IngresofotoFacade ingresofotoEJB;
    @EJB
    private IngresodocumentoFacade ingresodocumentoEJB;
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
    private Estado currentEstado;
    private List<Ingresofoto> ingresofotoList;
    private List<Ingresodocumento> ingresodocumentoList;
    
    private Persona currentFuncionario;
    private Cargo currentFuncionarioCargo;
    private StreamedContent document;
    private int indexUtimoIngreso;
    private int indexIngresoImageSelected;
    
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
                    currentEstado = estadoEJB.findCurrentEstado(id);
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
                    FacesContext fc = FacesContext.getCurrentInstance();
                    HttpServletRequest req = (HttpServletRequest) fc.getExternalContext().getRequest();
                    currentFuncionario = personaEJB.findPersonaByNombreUsuario(req.getUserPrincipal().getName());
                    currentFuncionarioCargo = asignacargoEJB.currentCargo(currentFuncionario.getPerId());
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

    public List<Ingresofoto> getIngresofotoList() {
        if(ingresofotoList == null)
        {
            ingresofotoList = ingresofotoEJB.findByIngId(ingreso.getIngId());
        }
        return ingresofotoList;
    }

    public List<Ingresodocumento> getIngresodocumentoList() {
        if(ingresodocumentoList == null)
        {
            ingresodocumentoList = ingresodocumentoEJB.findByIngId(ingreso.getIngId());
        }
        return ingresodocumentoList;
    }
    
    

    public StreamedContent getDocument() {
        return document;
    }

    public int getIndexIngresoImageSelected() {
        return indexIngresoImageSelected;
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
    
    
    public void cargarImagen(FileUploadEvent event) {
        try {
            String folderPaht = Util.RUTAFOTOSINGRESO + ingreso.getIngId();
            String[] split = event.getFile().getFileName().split(Pattern.quote("."));
            int indice = split.length - 1;
            System.out.println("indice:" + indice);
            String extension = split[indice];

            Ingresofoto ingfoto = new Ingresofoto();
            ingfoto.setIngId(ingreso);
            
            ingresofotoEJB.create(ingfoto);

            String filePath = folderPaht + File.separator + ingfoto.getIngfotoId()+ "." + extension;
            ingfoto.setIngFotoNombre(ingreso.getIngId()+ File.separator + ingfoto.getIngfotoId()+ "." + extension);
            ingresofotoEJB.edit(ingfoto);
            if(copyFile(folderPaht, filePath,event.getFile().getInputStream()))
            {
                ingresofotoList = null;
            }
        } catch (IOException ex) {
            Logger.getLogger(IngresoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void cargarDocumento(FileUploadEvent event) {
        try {
            String folderPath = Util.RUTADOCUMENTOSINGRESO + ingreso.getIngId();

            Ingresodocumento ingDocumento = new Ingresodocumento();
            ingDocumento.setIngId(ingreso);
            String filePath = folderPath + File.separator+ event.getFile().getFileName();
            ingDocumento.setIngDocNombre(event.getFile().getFileName());
            if(copyFile(folderPath, filePath,event.getFile().getInputStream()))
            {
                ingresodocumentoEJB.create(ingDocumento);
                ingresodocumentoList = null;
            }
        } catch (IOException ex) {
            Logger.getLogger(IngresoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean copyFile(String folderPath,String filePath,InputStream in) {
        try {

            
            File file = new File(folderPath);
            if (!file.exists()) {
                file.mkdirs();
            }
            // write the inputStream to a FileOutputStream
            OutputStream out = new FileOutputStream(new File(filePath));

            int read = 0;
            byte[] bytes = new byte[1024];

            while ((read = in.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            in.close();
            out.flush();
            out.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public void prepDocumentoDownload(Ingreso ingreso, String fileName) throws Exception {
        File file = new File(Util.RUTADOCUMENTOSINGRESO+ingreso.getIngId()+File.separator+fileName);
        InputStream input = new FileInputStream(file);
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        document = new DefaultStreamedContent(input, externalContext.getMimeType(file.getName()), file.getName());
        System.out.println("PREP = " + document.getName());
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
            ubicar.setFuncionarioId(currentFuncionario);
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
            transladar.setFuncionarioId(currentFuncionario);
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
    
    public void setIndexUtimoIngreso(int IndexUtimoIngreso){
        
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
    
    public boolean renderedMovDt(long ingId)
    {
        return ubicarEJB.existByIngresoId(ingId);
    }
    
    public boolean showAccion(String accion)
    {
        int est = currentEstado.getEstado();
        if(estado == 1)
        {
            switch(accion)
            {
                case "ubicar":
                case "transladar":
                case "reubicar":
                case "fallecimiento":
                case "valoracion":
                    return true;
                default:
                    return false;
            }
        }
        else
        {
            switch(accion)
            {
                case "ubicar":
                case "transladar":
                case "reubicar":
                case "incinerar":
                    return true;
                case "necropsia":
                    return currentEstado.getEstadoCausa()!=null && currentEstado.getEstadoCausa()==1;
                default:
                    return false;
            }
        }
    }
    
    
    public boolean disabledAccion(String accion)
    {
        switch(accion)
        {
            case "BIO":
                return !currentFuncionarioCargo.getCargoAbrevitura().equals("BIO");
            case "VET":
                return !currentFuncionarioCargo.getCargoAbrevitura().equals("VET");
            case "NUT":
                return !(currentFuncionarioCargo.getCargoAbrevitura().equals("BIO") ||
                        currentFuncionarioCargo.getCargoAbrevitura().equals("VET"));
            case "NEC":
                return !currentFuncionarioCargo.getCargoAbrevitura().equals("VET");
        }
        return true;
    }
    
    public void openfotosIngresoDialog(Ingresofoto ingresofoto)
    {
        indexIngresoImageSelected = ingresofotoList.indexOf(ingresofoto);
        PrimeFaces pf = PrimeFaces.current();
        pf.ajax().update(":formIngresoFoto:panelIngresoFoto");
        pf.executeScript("PF('ingresoFoto').show()");
    }
    
    
    public int getWidthIngresoImagen(String imageName)
    {
        BufferedImage bimg;
        try {
            bimg = ImageIO.read(new File(Util.RUTAFOTOSINGRESO+imageName));
            if(bimg.getWidth()<= 600){
                return bimg.getWidth();
            }
        } catch (IOException ex) {
            Logger.getLogger(IngresoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 600;
    }
    
    public int getHeightIngresoImagen(String imageName)
    {
        BufferedImage bimg;
        try {
            bimg = ImageIO.read(new File(Util.RUTAFOTOSINGRESO+imageName));
            if(bimg.getWidth()<= 600){
                return bimg.getHeight();
            }
            else
            {
                return ((600 * bimg.getHeight())/bimg.getWidth());
            }
        } catch (IOException ex) {
            Logger.getLogger(IngresoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
