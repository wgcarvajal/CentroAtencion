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
@Table(name = "lugardecomisoentregavoluntaria", catalog = "hogardepasobd", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lugardecomisoentregavoluntaria.findAll", query = "SELECT l FROM Lugardecomisoentregavoluntaria l"),
    @NamedQuery(name = "Lugardecomisoentregavoluntaria.findByLdeId", query = "SELECT l FROM Lugardecomisoentregavoluntaria l WHERE l.ldeId = :ldeId"),
    @NamedQuery(name = "Lugardecomisoentregavoluntaria.findByLdeNombre", query = "SELECT l FROM Lugardecomisoentregavoluntaria l WHERE l.ldeNombre = :ldeNombre"),
    @NamedQuery(name = "Lugardecomisoentregavoluntaria.findByLdeAbreviatura", query = "SELECT l FROM Lugardecomisoentregavoluntaria l WHERE l.ldeAbreviatura = :ldeAbreviatura")})
public class Lugardecomisoentregavoluntaria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ldeId")
    private Integer ldeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ldeNombre")
    private String ldeNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "ldeAbreviatura")
    private String ldeAbreviatura;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lugardecomisoentregavoluntariaId")
    private List<Ingreso> ingresoList;

    public Lugardecomisoentregavoluntaria() {
    }

    public Lugardecomisoentregavoluntaria(Integer ldeId) {
        this.ldeId = ldeId;
    }

    public Lugardecomisoentregavoluntaria(Integer ldeId, String ldeNombre, String ldeAbreviatura) {
        this.ldeId = ldeId;
        this.ldeNombre = ldeNombre;
        this.ldeAbreviatura = ldeAbreviatura;
    }

    public Integer getLdeId() {
        return ldeId;
    }

    public void setLdeId(Integer ldeId) {
        this.ldeId = ldeId;
    }

    public String getLdeNombre() {
        return ldeNombre;
    }

    public void setLdeNombre(String ldeNombre) {
        this.ldeNombre = ldeNombre;
    }

    public String getLdeAbreviatura() {
        return ldeAbreviatura;
    }

    public void setLdeAbreviatura(String ldeAbreviatura) {
        this.ldeAbreviatura = ldeAbreviatura;
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
        hash += (ldeId != null ? ldeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lugardecomisoentregavoluntaria)) {
            return false;
        }
        Lugardecomisoentregavoluntaria other = (Lugardecomisoentregavoluntaria) object;
        if ((this.ldeId == null && other.ldeId != null) || (this.ldeId != null && !this.ldeId.equals(other.ldeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.centroatencion.entities.Lugardecomisoentregavoluntaria[ ldeId=" + ldeId + " ]";
    }
    
}
