/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author aranda
 */
@Entity
@Table(name = "usuariogrupo", catalog = "hogardepasobd", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuariogrupo.findAll", query = "SELECT u FROM Usuariogrupo u"),
    @NamedQuery(name = "Usuariogrupo.findByGrupoId", query = "SELECT u FROM Usuariogrupo u WHERE u.usuariogrupoPK.grupoId = :grupoId"),
    @NamedQuery(name = "Usuariogrupo.findByUsuarioId", query = "SELECT u FROM Usuariogrupo u WHERE u.usuariogrupoPK.usuarioId = :usuarioId"),
    @NamedQuery(name = "Usuariogrupo.findByNombreusuario", query = "SELECT u FROM Usuariogrupo u WHERE u.nombreusuario = :nombreusuario")})
public class Usuariogrupo implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UsuariogrupoPK usuariogrupoPK;
    @Basic(optional = false)
    @Column(name = "nombreusuario")
    private String nombreusuario;
    @JoinColumn(name = "grupoId", referencedColumnName = "grupoid", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Grupo grupo;
    @JoinColumn(name = "usuarioId", referencedColumnName = "usuId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;

    public Usuariogrupo() {
    }

    public Usuariogrupo(UsuariogrupoPK usuariogrupoPK) {
        this.usuariogrupoPK = usuariogrupoPK;
    }

    public Usuariogrupo(UsuariogrupoPK usuariogrupoPK, String nombreusuario) {
        this.usuariogrupoPK = usuariogrupoPK;
        this.nombreusuario = nombreusuario;
    }

    public Usuariogrupo(String grupoId, long usuarioId) {
        this.usuariogrupoPK = new UsuariogrupoPK(grupoId, usuarioId);
    }

    public UsuariogrupoPK getUsuariogrupoPK() {
        return usuariogrupoPK;
    }

    public void setUsuariogrupoPK(UsuariogrupoPK usuariogrupoPK) {
        this.usuariogrupoPK = usuariogrupoPK;
    }

    public String getNombreusuario() {
        return nombreusuario;
    }

    public void setNombreusuario(String nombreusuario) {
        this.nombreusuario = nombreusuario;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuariogrupoPK != null ? usuariogrupoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuariogrupo)) {
            return false;
        }
        Usuariogrupo other = (Usuariogrupo) object;
        if ((this.usuariogrupoPK == null && other.usuariogrupoPK != null) || (this.usuariogrupoPK != null && !this.usuariogrupoPK.equals(other.usuariogrupoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Usuariogrupo[ usuariogrupoPK=" + usuariogrupoPK + " ]";
    }
    
}
