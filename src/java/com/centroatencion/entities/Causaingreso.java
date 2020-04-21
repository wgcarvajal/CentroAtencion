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
@Table(name = "causaingreso", catalog = "hogardepasobd", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Causaingreso.findAll", query = "SELECT c FROM Causaingreso c"),
    @NamedQuery(name = "Causaingreso.findByCausaingId", query = "SELECT c FROM Causaingreso c WHERE c.causaingId = :causaingId"),
    @NamedQuery(name = "Causaingreso.findByCausaingNombre", query = "SELECT c FROM Causaingreso c WHERE c.causaingNombre = :causaingNombre"),
    @NamedQuery(name = "Causaingreso.findByCausaingAbreviatura", query = "SELECT c FROM Causaingreso c WHERE c.causaingAbreviatura = :causaingAbreviatura")})
public class Causaingreso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "causaingId")
    private Integer causaingId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "causaingNombre")
    private String causaingNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "causaingAbreviatura")
    private String causaingAbreviatura;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "causaingresoId")
    private List<Ingreso> ingresoList;

    public Causaingreso() {
    }

    public Causaingreso(Integer causaingId) {
        this.causaingId = causaingId;
    }

    public Causaingreso(Integer causaingId, String causaingNombre, String causaingAbreviatura) {
        this.causaingId = causaingId;
        this.causaingNombre = causaingNombre;
        this.causaingAbreviatura = causaingAbreviatura;
    }

    public Integer getCausaingId() {
        return causaingId;
    }

    public void setCausaingId(Integer causaingId) {
        this.causaingId = causaingId;
    }

    public String getCausaingNombre() {
        return causaingNombre;
    }

    public void setCausaingNombre(String causaingNombre) {
        this.causaingNombre = causaingNombre;
    }

    public String getCausaingAbreviatura() {
        return causaingAbreviatura;
    }

    public void setCausaingAbreviatura(String causaingAbreviatura) {
        this.causaingAbreviatura = causaingAbreviatura;
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
        hash += (causaingId != null ? causaingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Causaingreso)) {
            return false;
        }
        Causaingreso other = (Causaingreso) object;
        if ((this.causaingId == null && other.causaingId != null) || (this.causaingId != null && !this.causaingId.equals(other.causaingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.centroatencion.entities.Causaingreso[ causaingId=" + causaingId + " ]";
    }
    
}
