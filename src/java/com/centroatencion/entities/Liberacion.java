/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author aranda
 */
@Entity
@Table(name = "liberacion", catalog = "hogardepasobd", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Liberacion.findAll", query = "SELECT l FROM Liberacion l"),
    @NamedQuery(name = "Liberacion.findByLibId", query = "SELECT l FROM Liberacion l WHERE l.libId = :libId"),
    @NamedQuery(name = "Liberacion.findByVeredaId", query = "SELECT l FROM Liberacion l WHERE l.veredaId = :veredaId"),
    @NamedQuery(name = "Liberacion.findByMunicipioId", query = "SELECT l FROM Liberacion l WHERE l.municipioId = :municipioId"),
    @NamedQuery(name = "Liberacion.findByLibFecha", query = "SELECT l FROM Liberacion l WHERE l.libFecha = :libFecha"),
    @NamedQuery(name = "Liberacion.findByLibUbicacion", query = "SELECT l FROM Liberacion l WHERE l.libUbicacion = :libUbicacion")})
public class Liberacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "libId")
    private Long libId;
    @Column(name = "veredaId")
    private BigInteger veredaId;
    @Column(name = "municipioId")
    private BigInteger municipioId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "libFecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date libFecha;
    @Size(max = 100)
    @Column(name = "libUbicacion")
    private String libUbicacion;
    @Lob
    @Size(max = 65535)
    @Column(name = "libObservacion")
    private String libObservacion;
    @OneToMany(mappedBy = "liberacionId")
    private List<Ingreso> ingresoList;

    public Liberacion() {
    }

    public Liberacion(Long libId) {
        this.libId = libId;
    }

    public Liberacion(Long libId, Date libFecha) {
        this.libId = libId;
        this.libFecha = libFecha;
    }

    public Long getLibId() {
        return libId;
    }

    public void setLibId(Long libId) {
        this.libId = libId;
    }

    public BigInteger getVeredaId() {
        return veredaId;
    }

    public void setVeredaId(BigInteger veredaId) {
        this.veredaId = veredaId;
    }

    public BigInteger getMunicipioId() {
        return municipioId;
    }

    public void setMunicipioId(BigInteger municipioId) {
        this.municipioId = municipioId;
    }

    public Date getLibFecha() {
        return libFecha;
    }

    public void setLibFecha(Date libFecha) {
        this.libFecha = libFecha;
    }

    public String getLibUbicacion() {
        return libUbicacion;
    }

    public void setLibUbicacion(String libUbicacion) {
        this.libUbicacion = libUbicacion;
    }

    public String getLibObservacion() {
        return libObservacion;
    }

    public void setLibObservacion(String libObservacion) {
        this.libObservacion = libObservacion;
    }

    @XmlTransient
    public List<Ingreso> getIngresoList() {
        return ingresoList;
    }

    public void setIngresoList(List<Ingreso> ingresoList) {
        this.ingresoList = ingresoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (libId != null ? libId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Liberacion)) {
            return false;
        }
        Liberacion other = (Liberacion) object;
        if ((this.libId == null && other.libId != null) || (this.libId != null && !this.libId.equals(other.libId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.centroatencion.entities.Liberacion[ libId=" + libId + " ]";
    }
    
}
