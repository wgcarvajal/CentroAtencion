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
@Table(name = "cargo", catalog = "hogardepasobd", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cargo.findAll", query = "SELECT c FROM Cargo c"),
    @NamedQuery(name = "Cargo.findByCargoId", query = "SELECT c FROM Cargo c WHERE c.cargoId = :cargoId"),
    @NamedQuery(name = "Cargo.findByCargoNombre", query = "SELECT c FROM Cargo c WHERE c.cargoNombre = :cargoNombre"),
    @NamedQuery(name = "Cargo.findByCargoAbrevitura", query = "SELECT c FROM Cargo c WHERE c.cargoAbrevitura = :cargoAbrevitura")})
public class Cargo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cargoId")
    private Integer cargoId;
    @Basic(optional = false)
    @Column(name = "cargoNombre")
    private String cargoNombre;
    @Basic(optional = false)
    @Column(name = "cargoAbrevitura")
    private String cargoAbrevitura;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cargoId")
    private List<Asignacargo> asignacargoList;

    public Cargo() {
    }

    public Cargo(Integer cargoId) {
        this.cargoId = cargoId;
    }

    public Cargo(Integer cargoId, String cargoNombre, String cargoAbrevitura) {
        this.cargoId = cargoId;
        this.cargoNombre = cargoNombre;
        this.cargoAbrevitura = cargoAbrevitura;
    }

    public Integer getCargoId() {
        return cargoId;
    }

    public void setCargoId(Integer cargoId) {
        this.cargoId = cargoId;
    }

    public String getCargoNombre() {
        return cargoNombre;
    }

    public void setCargoNombre(String cargoNombre) {
        this.cargoNombre = cargoNombre;
    }

    public String getCargoAbrevitura() {
        return cargoAbrevitura;
    }

    public void setCargoAbrevitura(String cargoAbrevitura) {
        this.cargoAbrevitura = cargoAbrevitura;
    }

    @XmlTransient
    public List<Asignacargo> getAsignacargoList() {
        return asignacargoList;
    }

    public void setAsignacargoList(List<Asignacargo> asignacargoList) {
        this.asignacargoList = asignacargoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cargoId != null ? cargoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cargo)) {
            return false;
        }
        Cargo other = (Cargo) object;
        if ((this.cargoId == null && other.cargoId != null) || (this.cargoId != null && !this.cargoId.equals(other.cargoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Cargo[ cargoId=" + cargoId + " ]";
    }
    
}
