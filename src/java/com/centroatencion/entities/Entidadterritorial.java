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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "entidadterritorial", catalog = "hogardepasobd", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entidadterritorial.findAll", query = "SELECT e FROM Entidadterritorial e"),
    @NamedQuery(name = "Entidadterritorial.findAllByDireccionterritorial", query = "SELECT e FROM Entidadterritorial e WHERE e.dirterId.dirterId = :dirterId"),
    @NamedQuery(name = "Entidadterritorial.findAllByDireccionterritorialWithoutCurrentEntidadterritorial", query = "SELECT e FROM Entidadterritorial e WHERE e.dirterId.dirterId = :dirterId AND e.entterId != :entterId"),
    @NamedQuery(name = "Entidadterritorial.findByEntterId", query = "SELECT e FROM Entidadterritorial e WHERE e.entterId = :entterId"),
    @NamedQuery(name = "Entidadterritorial.findByEntterNombre", query = "SELECT e FROM Entidadterritorial e WHERE e.entterNombre = :entterNombre")})
public class Entidadterritorial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "entterId")
    private Integer entterId;
    @Basic(optional = false)
    @Column(name = "entterNombre")
    private String entterNombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entterId")
    private List<Ubicar> ubicarList;
    @JoinColumn(name = "dirterId", referencedColumnName = "dirterId")
    @ManyToOne(optional = false)
    private Direcctionterritorial dirterId;

    public Entidadterritorial() {
    }

    public Entidadterritorial(Integer entterId) {
        this.entterId = entterId;
    }

    public Entidadterritorial(Integer entterId, String entterNombre) {
        this.entterId = entterId;
        this.entterNombre = entterNombre;
    }

    public Integer getEntterId() {
        return entterId;
    }

    public void setEntterId(Integer entterId) {
        this.entterId = entterId;
    }

    public String getEntterNombre() {
        return entterNombre;
    }

    public void setEntterNombre(String entterNombre) {
        this.entterNombre = entterNombre;
    }

    @XmlTransient
    public List<Ubicar> getUbicarList() {
        return ubicarList;
    }

    public void setUbicarList(List<Ubicar> ubicarList) {
        this.ubicarList = ubicarList;
    }

    public Direcctionterritorial getDirterId() {
        return dirterId;
    }

    public void setDirterId(Direcctionterritorial dirterId) {
        this.dirterId = dirterId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (entterId != null ? entterId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entidadterritorial)) {
            return false;
        }
        Entidadterritorial other = (Entidadterritorial) object;
        if ((this.entterId == null && other.entterId != null) || (this.entterId != null && !this.entterId.equals(other.entterId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Entidadterritorial[ entterId=" + entterId + " ]";
    }
    
}
