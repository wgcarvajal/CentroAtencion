/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author aranda
 */
@Entity
@Table(name = "grupo", catalog = "hogardepasobd", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Grupo.findAll", query = "SELECT g FROM Grupo g"),
    @NamedQuery(name = "Grupo.findByGrupoid", query = "SELECT g FROM Grupo g WHERE g.grupoid = :grupoid"),
    @NamedQuery(name = "Grupo.findByGrupodescripcion", query = "SELECT g FROM Grupo g WHERE g.grupodescripcion = :grupodescripcion")})
public class Grupo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "grupoid")
    private String grupoid;
    @Basic(optional = false)
    @Column(name = "grupodescripcion")
    private String grupodescripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grupo")
    private List<Usuariogrupo> usuariogrupoList;

    public Grupo() {
    }

    public Grupo(String grupoid) {
        this.grupoid = grupoid;
    }

    public Grupo(String grupoid, String grupodescripcion) {
        this.grupoid = grupoid;
        this.grupodescripcion = grupodescripcion;
    }

    public String getGrupoid() {
        return grupoid;
    }

    public void setGrupoid(String grupoid) {
        this.grupoid = grupoid;
    }

    public String getGrupodescripcion() {
        return grupodescripcion;
    }

    public void setGrupodescripcion(String grupodescripcion) {
        this.grupodescripcion = grupodescripcion;
    }

    @XmlTransient
    public List<Usuariogrupo> getUsuariogrupoList() {
        return usuariogrupoList;
    }

    public void setUsuariogrupoList(List<Usuariogrupo> usuariogrupoList) {
        this.usuariogrupoList = usuariogrupoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (grupoid != null ? grupoid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grupo)) {
            return false;
        }
        Grupo other = (Grupo) object;
        if ((this.grupoid == null && other.grupoid != null) || (this.grupoid != null && !this.grupoid.equals(other.grupoid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Grupo[ grupoid=" + grupoid + " ]";
    }
    
}
