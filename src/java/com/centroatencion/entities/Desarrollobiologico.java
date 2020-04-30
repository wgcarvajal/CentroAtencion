/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Wilson Carvajal
 */
@Entity
@Table(name = "desarrollobiologico", catalog = "hogardepasobd", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Desarrollobiologico.findAll", query = "SELECT d FROM Desarrollobiologico d"),
    @NamedQuery(name = "Desarrollobiologico.findByDesbioId", query = "SELECT d FROM Desarrollobiologico d WHERE d.desbioId = :desbioId"),
    @NamedQuery(name = "Desarrollobiologico.findByDesbioNombre", query = "SELECT d FROM Desarrollobiologico d WHERE d.desbioNombre = :desbioNombre"),
    @NamedQuery(name = "Desarrollobiologico.findByDesbioAbreviatura", query = "SELECT d FROM Desarrollobiologico d WHERE d.desbioAbreviatura = :desbioAbreviatura")})
public class Desarrollobiologico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "desbioId")
    private Integer desbioId;
    @Basic(optional = false)
    @Column(name = "desbioNombre")
    private String desbioNombre;
    @Basic(optional = false)
    @Column(name = "desbioAbreviatura")
    private String desbioAbreviatura;
    @OneToMany(mappedBy = "desbioId")
    private List<Ingreso> ingresoList;

    public Desarrollobiologico() {
    }

    public Desarrollobiologico(Integer desbioId) {
        this.desbioId = desbioId;
    }

    public Desarrollobiologico(Integer desbioId, String desbioNombre, String desbioAbreviatura) {
        this.desbioId = desbioId;
        this.desbioNombre = desbioNombre;
        this.desbioAbreviatura = desbioAbreviatura;
    }

    public Integer getDesbioId() {
        return desbioId;
    }

    public void setDesbioId(Integer desbioId) {
        this.desbioId = desbioId;
    }

    public String getDesbioNombre() {
        return desbioNombre;
    }

    public void setDesbioNombre(String desbioNombre) {
        this.desbioNombre = desbioNombre;
    }

    public String getDesbioAbreviatura() {
        return desbioAbreviatura;
    }

    public void setDesbioAbreviatura(String desbioAbreviatura) {
        this.desbioAbreviatura = desbioAbreviatura;
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
        hash += (desbioId != null ? desbioId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Desarrollobiologico)) {
            return false;
        }
        Desarrollobiologico other = (Desarrollobiologico) object;
        if ((this.desbioId == null && other.desbioId != null) || (this.desbioId != null && !this.desbioId.equals(other.desbioId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Desarrollobiologico[ desbioId=" + desbioId + " ]";
    }
    
}
