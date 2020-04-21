/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author aranda
 */
@Embeddable
public class UsuariogrupoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "grupoId")
    private String grupoId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuarioId")
    private long usuarioId;

    public UsuariogrupoPK() {
    }

    public UsuariogrupoPK(String grupoId, long usuarioId) {
        this.grupoId = grupoId;
        this.usuarioId = usuarioId;
    }

    public String getGrupoId() {
        return grupoId;
    }

    public void setGrupoId(String grupoId) {
        this.grupoId = grupoId;
    }

    public long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(long usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (grupoId != null ? grupoId.hashCode() : 0);
        hash += (int) usuarioId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuariogrupoPK)) {
            return false;
        }
        UsuariogrupoPK other = (UsuariogrupoPK) object;
        if ((this.grupoId == null && other.grupoId != null) || (this.grupoId != null && !this.grupoId.equals(other.grupoId))) {
            return false;
        }
        if (this.usuarioId != other.usuarioId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.centroatencion.entities.UsuariogrupoPK[ grupoId=" + grupoId + ", usuarioId=" + usuarioId + " ]";
    }
    
}
