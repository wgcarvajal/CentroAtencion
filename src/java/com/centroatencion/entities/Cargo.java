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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author aranda
 */
@Entity
@Table(name = "cargo", catalog = "hogardepasobd", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cargo.findAll", query = "SELECT c FROM Cargo c"),
    @NamedQuery(name = "Cargo.findByCarid", query = "SELECT c FROM Cargo c WHERE c.carid = :carid"),
    @NamedQuery(name = "Cargo.findByCarNombre", query = "SELECT c FROM Cargo c WHERE c.carNombre = :carNombre")})
public class Cargo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "carid")
    private Integer carid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "carNombre")
    private String carNombre;
    @OneToMany(mappedBy = "cargoId")
    private List<Contrato> contratoList;

    public Cargo() {
    }

    public Cargo(Integer carid) {
        this.carid = carid;
    }

    public Cargo(Integer carid, String carNombre) {
        this.carid = carid;
        this.carNombre = carNombre;
    }

    public Integer getCarid() {
        return carid;
    }

    public void setCarid(Integer carid) {
        this.carid = carid;
    }

    public String getCarNombre() {
        return carNombre;
    }

    public void setCarNombre(String carNombre) {
        this.carNombre = carNombre;
    }

    @XmlTransient
    public List<Contrato> getContratoList() {
        return contratoList;
    }

    public void setContratoList(List<Contrato> contratoList) {
        this.contratoList = contratoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (carid != null ? carid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cargo)) {
            return false;
        }
        Cargo other = (Cargo) object;
        if ((this.carid == null && other.carid != null) || (this.carid != null && !this.carid.equals(other.carid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Cargo[ carid=" + carid + " ]";
    }
    
}
