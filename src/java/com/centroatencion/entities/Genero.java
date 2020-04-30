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
@Table(name = "genero", catalog = "hogardepasobd", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Genero.findAll", query = "SELECT g FROM Genero g ORDER BY g.genNombre asc"),
    @NamedQuery(name = "Genero.findByGenId", query = "SELECT g FROM Genero g WHERE g.genId = :genId"),
    @NamedQuery(name = "Genero.findByGenNombre", query = "SELECT g FROM Genero g WHERE g.genNombre = :genNombre"),
    @NamedQuery(name = "Genero.findByGenAbreviatura", query = "SELECT g FROM Genero g WHERE g.genAbreviatura = :genAbreviatura")})
public class Genero implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "genId")
    private Integer genId;
    @Basic(optional = false)
    @Column(name = "genNombre")
    private String genNombre;
    @Basic(optional = false)
    @Column(name = "genAbreviatura")
    private String genAbreviatura;
    @OneToMany(mappedBy = "genId")
    private List<Ingreso> ingresoList;

    public Genero() {
    }

    public Genero(Integer genId) {
        this.genId = genId;
    }

    public Genero(Integer genId, String genNombre, String genAbreviatura) {
        this.genId = genId;
        this.genNombre = genNombre;
        this.genAbreviatura = genAbreviatura;
    }

    public Integer getGenId() {
        return genId;
    }

    public void setGenId(Integer genId) {
        this.genId = genId;
    }

    public String getGenNombre() {
        return genNombre;
    }

    public void setGenNombre(String genNombre) {
        this.genNombre = genNombre;
    }

    public String getGenAbreviatura() {
        return genAbreviatura;
    }

    public void setGenAbreviatura(String genAbreviatura) {
        this.genAbreviatura = genAbreviatura;
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
        hash += (genId != null ? genId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Genero)) {
            return false;
        }
        Genero other = (Genero) object;
        if ((this.genId == null && other.genId != null) || (this.genId != null && !this.genId.equals(other.genId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Genero[ genId=" + genId + " ]";
    }
    
}
