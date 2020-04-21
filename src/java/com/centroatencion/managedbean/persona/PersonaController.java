/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.managedbean.persona;

import com.centroatencion.entities.Persona;
import com.centroatencion.entities.Usuario;
import com.centroatencion.entities.Usuariogrupo;
import com.centroatencion.facade.PersonaFacade;
import com.centroatencion.facade.UsuarioFacade;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Wilson Carvajal
 */
@ManagedBean(name="perController")
@ViewScoped
public class PersonaController implements Serializable 
{
    @EJB
    private PersonaFacade personaEJB;
    @EJB
    private UsuarioFacade usuarioEJB;
    private List<Persona> listaPersonas;
    private List<Persona> listaPersonasFiltradas;
    
    public PersonaController()
    {
        
    }

    public List<Persona> getListaPersonas() {
        if(listaPersonas == null || listaPersonas.isEmpty())
        {
            FacesContext fc = FacesContext.getCurrentInstance();
            HttpServletRequest req = (HttpServletRequest) fc.getExternalContext().getRequest();        
            if (req.getUserPrincipal() != null)
            {
                String nombreusuario = req.getUserPrincipal().getName();
                Object[] object= (Object[])usuarioEJB.findByUsuNombreUsuario(nombreusuario);
                Usuariogrupo usuariogrupo = (Usuariogrupo)object[1];
                if(usuariogrupo.getGrupo().getGrupoid().equals("admin"))
                {
                    
                }
                
                listaPersonas = personaEJB.findAll();
            }
        }
        return listaPersonas;
    }

    public void setListaPersonas(List<Persona> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }

    public List<Persona> getListaPersonasFiltradas() {
        return listaPersonasFiltradas;
    }

    public void setListaPersonasFiltradas(List<Persona> listaPersonasFiltradas) {
        this.listaPersonasFiltradas = listaPersonasFiltradas;
    }
    
    
    
}
