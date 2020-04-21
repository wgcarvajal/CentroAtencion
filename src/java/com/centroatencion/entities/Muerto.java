/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.entities;

import java.io.Serializable;
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
@Table(name = "muerto", catalog = "hogardepasobd", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Muerto.findAll", query = "SELECT m FROM Muerto m"),
    @NamedQuery(name = "Muerto.findByMueId", query = "SELECT m FROM Muerto m WHERE m.mueId = :mueId"),
    @NamedQuery(name = "Muerto.findByMueFecha", query = "SELECT m FROM Muerto m WHERE m.mueFecha = :mueFecha"),
    @NamedQuery(name = "Muerto.findByMueEutanasia", query = "SELECT m FROM Muerto m WHERE m.mueEutanasia = :mueEutanasia")})
public class Muerto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mueId")
    private Long mueId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mueFecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date mueFecha;
    @Lob
    @Size(max = 65535)
    @Column(name = "mueResultadoNecropsia")
    private String mueResultadoNecropsia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mueEutanasia")
    private int mueEutanasia;
    @OneToMany(mappedBy = "muerteId")
    private List<Ingreso> ingresoList;

    public Muerto() {
    }

    public Muerto(Long mueId) {
        this.mueId = mueId;
    }

    public Muerto(Long mueId, Date mueFecha, int mueEutanasia) {
        this.mueId = mueId;
        this.mueFecha = mueFecha;
        this.mueEutanasia = mueEutanasia;
    }

    public Long getMueId() {
        return mueId;
    }

    public void setMueId(Long mueId) {
        this.mueId = mueId;
    }

    public Date getMueFecha() {
        return mueFecha;
    }

    public void setMueFecha(Date mueFecha) {
        this.mueFecha = mueFecha;
    }

    public String getMueResultadoNecropsia() {
        return mueResultadoNecropsia;
    }

    public void setMueResultadoNecropsia(String mueResultadoNecropsia) {
        this.mueResultadoNecropsia = mueResultadoNecropsia;
    }

    public int getMueEutanasia() {
        return mueEutanasia;
    }

    public void setMueEutanasia(int mueEutanasia) {
        this.mueEutanasia = mueEutanasia;
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
        hash += (mueId != null ? mueId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Muerto)) {
            return false;
        }
        Muerto other = (Muerto) object;
        if ((this.mueId == null && other.mueId != null) || (this.mueId != null && !this.mueId.equals(other.mueId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.centroatencion.entities.Muerto[ mueId=" + mueId + " ]";
    }
    
}
