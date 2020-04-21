/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.managedbean.animal;

import com.centroatencion.entities.Animal;
import com.centroatencion.entities.Especie;
import com.centroatencion.entities.Familia;
import com.centroatencion.entities.Fotoanimal;
import com.centroatencion.entities.Grupotaxonomico;
import com.centroatencion.entities.Orden;
import com.centroatencion.facade.AnimalFacade;
import com.centroatencion.facade.EspecieFacade;
import com.centroatencion.facade.FotoanimalFacade;
import com.centroatencion.facade.GrupotaxonomicoFacade;
import com.centroatencion.utilidades.RedimensionadorImagenes;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.List;
import java.util.regex.Pattern;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.inject.Named;
import org.apache.commons.io.FileUtils;
import org.primefaces.PrimeFaces;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Wilson Carvajal
 */

@Named("verEditarAnimalController")
@SessionScoped
public class VerEditarAnimalController implements Serializable{
    @EJB
    private AnimalFacade animalEJB;
    @EJB
    private FotoanimalFacade fotoAnimalEJB;
    @EJB
    private EspecieFacade especieEJB;
    @EJB
    private GrupotaxonomicoFacade grupoTaxonomicoEJB;
    
    private Orden orden;
    private Familia familia;
    private Especie especie;
    private Grupotaxonomico grupotaxonomico;
    
    private static final String RUTAFOTOSANIMAL= "/Users/aranda/uploads/fotosAnimales/";
   
    private Animal animal;
    private boolean campoNombre;
    private boolean campoDescripcion;
    private boolean campoEspecie;
    private boolean campoGrupoTaxonomico;
    private String nombre;
    private String descripcion;
    private AnimalController animalController;
    private boolean campoFoto;
    private UploadedFile uploadedFileFoto;
    private List<Especie>especies;
    private List<Grupotaxonomico> gruposTaxonomicos;
    

    //private ValidarEdicionUsuarios validarEdicionUsuario;

    public VerEditarAnimalController() {
        
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Animal getAnimal()
    {
        return animal;
    }

    public boolean isCampoNombre() {
        return campoNombre;
    }
    public boolean isCampoDescripcion() {
        return campoDescripcion;
    }
    public void setCampoDescripcion(boolean campoDescripcion) {
        this.campoDescripcion = campoDescripcion;
    }

    public void setCampoNombre(boolean campoNombre) {
        this.campoNombre = campoNombre;
    }
    
    public void setCampoFoto(boolean campoFoto) {
        this.campoFoto = campoFoto;
    }

    public boolean isCampoGrupoTaxonomico() {
        return campoGrupoTaxonomico;
    }

    public void setCampoGrupoTaxonomico(boolean campoGrupoTaxonomico) {
        this.campoGrupoTaxonomico = campoGrupoTaxonomico;
    }
    
    public boolean getCampoFoto() {
        return campoFoto;
    }

    public UploadedFile getUploadedFileFoto() {
        return uploadedFileFoto;
    }

    public void setUploadedFileFoto(UploadedFile uploadedFileFoto) {
        this.uploadedFileFoto = uploadedFileFoto;
    }

    public boolean isCampoEspecie() {
        return campoEspecie;
    }

    public void setCampoEspecie(boolean campoEspecie) {
        this.campoEspecie = campoEspecie;
    }
    
    public Orden getOrden() {
        return orden;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }

    public Familia getFamilia() {
        return familia;
    }

    public void setFamilia(Familia familia) {
        this.familia = familia;
    }

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    public Grupotaxonomico getGrupotaxonomico() {
        return grupotaxonomico;
    }

    public void setGrupotaxonomico(Grupotaxonomico grupotaxonomico) {
        this.grupotaxonomico = grupotaxonomico;
    }

    public List<Especie> getEspecies() {
        return especies;
    }

    public void setEspecies(List<Especie> especies) {
        this.especies = especies;
    }

    public List<Grupotaxonomico> getGruposTaxonomicos() {
        return gruposTaxonomicos;
    }

    public void setGruposTaxonomicos(List<Grupotaxonomico> gruposTaxonomicos) {
        this.gruposTaxonomicos = gruposTaxonomicos;
    }
    
    public StreamedContent getImagenFlujo() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            return new DefaultStreamedContent();
        } else {
            String id = context.getExternalContext().getRequestParameterMap().get("anId");
            List<Fotoanimal> listaFotosAnimal = fotoAnimalEJB.findByIdAnimal(Long.valueOf(id));
            if (listaFotosAnimal==null || listaFotosAnimal.isEmpty())
                return null;
            else
            {
                try
                {
                    File file = new File(RUTAFOTOSANIMAL+listaFotosAnimal.get(0).getFotanNombre());
                    ByteArrayInputStream bin = new ByteArrayInputStream(FileUtils.readFileToByteArray(file));
                    return new DefaultStreamedContent(bin);
                }
                catch(Exception e)
                {
                    e.printStackTrace(System.out);
                    
                }
                return null;
            } 
        }
    }
    
    public void animalSeleccionado(Animal animal, AnimalController mgb) {
        this.animalController = mgb;
        this.animal = animal;
        this.campoNombre = true;
        this.campoDescripcion = true;
        this.campoFoto = true;
        this.campoEspecie = true;
        this.campoGrupoTaxonomico = true;
        grupotaxonomico = grupoTaxonomicoEJB.find(animal.getGrupotaxonomicoId().getGruptaxId());
        List query = especieEJB.findByIdInnerJoinFamiliaAndOrden(animal.getEspId().getEspId());
        especie = (Especie)((Object [])query.get(0))[0];
        familia = (Familia)((Object [])query.get(0))[1];;
        orden  = (Orden)((Object [])query.get(0))[2];
        PrimeFaces pf = PrimeFaces.current();  
        pf.executeScript("PF('verEditarAnimal').show()");

    }
    public void mostrarModificarNombre() {
        this.campoNombre = false;
        this.nombre = this.animal.getAnNombre();
    }

    public void cancelarActualizarNombre() {
        this.campoNombre = true;
        this.nombre = "";
    }

    public void actualizarNombre() {
        this.campoNombre = true;
        //this.animal.setGruptaxNombre(nombre);
        this.animalEJB.edit(this.animal);
        animalController.updateListaAnimales();
        FacesContext.getCurrentInstance().addMessage("desc", new FacesMessage(FacesMessage.SEVERITY_INFO, "Info. Campo Nombre Actualizado.", ""));
    }
    
    public void mostrarModificarDescripcion() {
        this.campoDescripcion = false;
        this.descripcion = this.animal.getAnDescripcion();
    }

    public void cancelarActualizarDescripcion() {
        this.campoDescripcion = true;
        this.descripcion = "";
    }

    public void actualizarDescripcion() {
        this.campoDescripcion = true;
        this.animal.setAnDescripcion(descripcion);
        this.animalEJB.edit(this.animal);
        animalController.updateListaAnimales();
        FacesContext.getCurrentInstance().addMessage("desc", new FacesMessage(FacesMessage.SEVERITY_INFO, "Info. Campo Descripcion Actualizado.", ""));
    }
    
    public void mostrarModificarEspecie() {
        this.campoEspecie = false;
        this.especies = especieEJB.findAll();
    }

    public void cancelarActualizarEspecie() {
        this.campoEspecie = true;
        List query = especieEJB.findByIdInnerJoinFamiliaAndOrden(animal.getEspId().getEspId());
        especie = (Especie)((Object [])query.get(0))[0];
        familia = (Familia)((Object [])query.get(0))[1];;
        orden  = (Orden)((Object [])query.get(0))[2];
    }

    public void actualizarEspecie() {
        this.campoEspecie = true;
        this.animal.setEspId(especie);
        this.animalEJB.edit(this.animal);
        animalController.updateListaAnimales();
        List query = especieEJB.findByIdInnerJoinFamiliaAndOrden(animal.getEspId().getEspId());
        especie = (Especie)((Object [])query.get(0))[0];
        familia = (Familia)((Object [])query.get(0))[1];;
        orden  = (Orden)((Object [])query.get(0))[2];
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info. Campo especie Actualizado.", ""));
    }
    
    public void mostrarModificarGrupoTaxonomico() {
        this.campoGrupoTaxonomico = false;
        this.gruposTaxonomicos = grupoTaxonomicoEJB.findAll();
    }

    public void cancelarActualizarGrupoTaxonomico() {
        this.campoGrupoTaxonomico = true;
        grupotaxonomico = grupoTaxonomicoEJB.find(animal.getGrupotaxonomicoId().getGruptaxId());
    }

    public void actualizarGrupoTaxonomico() {
        this.campoGrupoTaxonomico = true;
        this.animal.setGrupotaxonomicoId(grupotaxonomico);
        this.animalEJB.edit(this.animal);
        animalController.updateListaAnimales();
        grupotaxonomico = grupoTaxonomicoEJB.find(animal.getGrupotaxonomicoId().getGruptaxId());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info. Campo grupo taxonomico actualizado.", ""));
    }
    
    public void mostrarSubirFoto() {
        this.campoFoto = false;
    }
    
    public void cancelarSubirFoto() {
        this.campoFoto = true;
        this.descripcion = "";
    }
    
    public void cargarFoto(FileUploadEvent event) {
        
        this.uploadedFileFoto = event.getFile();
        

    }
    
    public void actualizarFoto() throws InterruptedException {
        RequestContext requestContext = RequestContext.getCurrentInstance();
        if (this.uploadedFileFoto != null) {
            this.campoFoto = true;
                
            try {
                InputStream fi = uploadedFileFoto.getInputstream();
                byte[] buffer = RedimensionadorImagenes.redimensionar(fi,800);
                
                ByteArrayInputStream bin = new ByteArrayInputStream(buffer);
                
                String name = uploadedFileFoto.getFileName();
                String []split = name.split(Pattern.quote("."));
                String extension=split[split.length-1];
                String fileName=animal.getAnId()+"."+extension;
                
                File file = new File(RUTAFOTOSANIMAL+fileName);
                file.createNewFile();
                FileOutputStream fbo= new FileOutputStream(file);
                byte[] bff = new byte[1024];
                int length;
                while((length=bin.read(bff))>0)
                {
                    fbo.write(bff, 0, length);
                }
                fbo.close();
                fi.close();
                bin.close();
                
                List<Fotoanimal>listaFotosAnimal = fotoAnimalEJB.findByIdAnimal(animal.getAnId());
                if(listaFotosAnimal==null || listaFotosAnimal.isEmpty())
                {
                    Fotoanimal fotoanimal= new Fotoanimal();
                    fotoanimal.setAnimalId(animal);
                    fotoanimal.setFotanNombre(fileName);
                    fotoAnimalEJB.create(fotoanimal);
                }
                
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Foto Actualizada exitosamente. Fresione F5 para refrescarla", "Foto Actualizada."));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Thread.sleep(2000);
            this.uploadedFileFoto = null;

        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "No se ha cargado una foto.", "No se ha cargado una foto"));
        }
    }
}
