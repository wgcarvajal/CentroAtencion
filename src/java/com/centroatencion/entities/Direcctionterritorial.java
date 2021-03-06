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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Wilson Carvajal
 */
@Entity
@Table(name = "direcctionterritorial", catalog = "hogardepasobd", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Direcctionterritorial.findAll", query = "SELECT d FROM Direcctionterritorial d"),
    @NamedQuery(name = "Direcctionterritorial.findAllWithoutCurrentDireccionterritorial", query = "SELECT d FROM Direcctionterritorial d WHERE d.dirterId != :dirterId"),
    @NamedQuery(name = "Direcctionterritorial.findByDirterId", query = "SELECT d FROM Direcctionterritorial d WHERE d.dirterId = :dirterId"),
    @NamedQuery(name = "Direcctionterritorial.findByDirterNombre", query = "SELECT d FROM Direcctionterritorial d WHERE d.dirterNombre = :dirterNombre"),
    @NamedQuery(name = "Direcctionterritorial.findByDirterAbreviatura", query = "SELECT d FROM Direcctionterritorial d WHERE d.dirterAbreviatura = :dirterAbreviatura")})
public class Direcctionterritorial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "dirterId")
    private Integer dirterId;
    @Basic(optional = false)
    @Column(name = "dirterNombre")
    private String dirterNombre;
    @Basic(optional = false)
    @Column(name = "dirterAbreviatura")
    private String dirterAbreviatura;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dirterId")
    private List<Ingreso> ingresoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dirterId")
    private List<Entidadterritorial> entidadterritorialList;

    public Direcctionterritorial() {
    }

    public Direcctionterritorial(Integer dirterId) {
        this.dirterId = dirterId;
    }

    public Direcctionterritorial(Integer dirterId, String dirterNombre, String dirterAbreviatura) {
        this.dirterId = dirterId;
        this.dirterNombre = dirterNombre;
        this.dirterAbreviatura = dirterAbreviatura;
    }

    public Integer getDirterId() {
        return dirterId;
    }

    public void setDirterId(Integer dirterId) {
        this.dirterId = dirterId;
    }

    public String getDirterNombre() {
        return dirterNombre;
    }

    public void setDirterNombre(String dirterNombre) {
        this.dirterNombre = dirterNombre;
    }

    public String getDirterAbreviatura() {
        return dirterAbreviatura;
    }

    public void setDirterAbreviatura(String dirterAbreviatura) {
        this.dirterAbreviatura = dirterAbreviatura;
    }

    @XmlTransient
    public List<Ingreso> getIngresoList() {
        return ingresoList;
    }

    public void setIngresoList(List<Ingreso> ingresoList) {
        this.ingresoList = ingresoList;
    }

    @XmlTransient
    public List<Entidadterritorial> getEntidadterritorialList() {
        return entidadterritorialList;
    }

    public void setEntidadterritorialList(List<Entidadterritorial> entidadterritorialList) {
        this.entidadterritorialList = entidadterritorialList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dirterId != null ? dirterId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Direcctionterritorial)) {
            return false;
        }
        Direcctionterritorial other = (Direcctionterritorial) object;
        if ((this.dirterId == null && other.dirterId != null) || (this.dirterId != null && !this.dirterId.equals(other.dirterId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Direcctionterritorial[ dirterId=" + dirterId + " ]";
    }
    
}
