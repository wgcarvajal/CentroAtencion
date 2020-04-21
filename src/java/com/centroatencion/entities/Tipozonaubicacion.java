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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "tipozonaubicacion", catalog = "hogardepasobd", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipozonaubicacion.findAll", query = "SELECT t FROM Tipozonaubicacion t"),
    @NamedQuery(name = "Tipozonaubicacion.findByTzuId", query = "SELECT t FROM Tipozonaubicacion t WHERE t.tzuId = :tzuId"),
    @NamedQuery(name = "Tipozonaubicacion.findByTzuNombre", query = "SELECT t FROM Tipozonaubicacion t WHERE t.tzuNombre = :tzuNombre")})
public class Tipozonaubicacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tzuId")
    private Integer tzuId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tzuNombre")
    private String tzuNombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipozonaubicacionId")
    private List<Zonaubicacionanimal> zonaubicacionanimalList;

    public Tipozonaubicacion() {
    }

    public Tipozonaubicacion(Integer tzuId) {
        this.tzuId = tzuId;
    }

    public Tipozonaubicacion(Integer tzuId, String tzuNombre) {
        this.tzuId = tzuId;
        this.tzuNombre = tzuNombre;
    }

    public Integer getTzuId() {
        return tzuId;
    }

    public void setTzuId(Integer tzuId) {
        this.tzuId = tzuId;
    }

    public String getTzuNombre() {
        return tzuNombre;
    }

    public void setTzuNombre(String tzuNombre) {
        this.tzuNombre = tzuNombre;
    }

    @XmlTransient
    public List<Zonaubicacionanimal> getZonaubicacionanimalList() {
        return zonaubicacionanimalList;
    }

    public void setZonaubicacionanimalList(List<Zonaubicacionanimal> zonaubicacionanimalList) {
        this.zonaubicacionanimalList = zonaubicacionanimalList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tzuId != null ? tzuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipozonaubicacion)) {
            return false;
        }
        Tipozonaubicacion other = (Tipozonaubicacion) object;
        if ((this.tzuId == null && other.tzuId != null) || (this.tzuId != null && !this.tzuId.equals(other.tzuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.centroatencion.entities.Tipozonaubicacion[ tzuId=" + tzuId + " ]";
    }
    
}
