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
@Table(name = "lugardecomisoentregavoluntaria", catalog = "hogardepasobd", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lugardecomisoentregavoluntaria.findAll", query = "SELECT l FROM Lugardecomisoentregavoluntaria l ORDER BY l.lugDecEntVoNombre asc"),
    @NamedQuery(name = "Lugardecomisoentregavoluntaria.findByLugDecEntVoId", query = "SELECT l FROM Lugardecomisoentregavoluntaria l WHERE l.lugDecEntVoId = :lugDecEntVoId"),
    @NamedQuery(name = "Lugardecomisoentregavoluntaria.findByLugDecEntVoNombre", query = "SELECT l FROM Lugardecomisoentregavoluntaria l WHERE l.lugDecEntVoNombre = :lugDecEntVoNombre"),
    @NamedQuery(name = "Lugardecomisoentregavoluntaria.findByLugDecEntVoAbreviatura", query = "SELECT l FROM Lugardecomisoentregavoluntaria l WHERE l.lugDecEntVoAbreviatura = :lugDecEntVoAbreviatura")})
public class Lugardecomisoentregavoluntaria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "lugDecEntVoId")
    private Integer lugDecEntVoId;
    @Basic(optional = false)
    @Column(name = "lugDecEntVoNombre")
    private String lugDecEntVoNombre;
    @Basic(optional = false)
    @Column(name = "lugDecEntVoAbreviatura")
    private String lugDecEntVoAbreviatura;
    @OneToMany(mappedBy = "lugardecomisoentregavoluntariaId")
    private List<Ingreso> ingresoList;

    public Lugardecomisoentregavoluntaria() {
    }

    public Lugardecomisoentregavoluntaria(Integer lugDecEntVoId) {
        this.lugDecEntVoId = lugDecEntVoId;
    }

    public Lugardecomisoentregavoluntaria(Integer lugDecEntVoId, String lugDecEntVoNombre, String lugDecEntVoAbreviatura) {
        this.lugDecEntVoId = lugDecEntVoId;
        this.lugDecEntVoNombre = lugDecEntVoNombre;
        this.lugDecEntVoAbreviatura = lugDecEntVoAbreviatura;
    }

    public Integer getLugDecEntVoId() {
        return lugDecEntVoId;
    }

    public void setLugDecEntVoId(Integer lugDecEntVoId) {
        this.lugDecEntVoId = lugDecEntVoId;
    }

    public String getLugDecEntVoNombre() {
        return lugDecEntVoNombre;
    }

    public void setLugDecEntVoNombre(String lugDecEntVoNombre) {
        this.lugDecEntVoNombre = lugDecEntVoNombre;
    }

    public String getLugDecEntVoAbreviatura() {
        return lugDecEntVoAbreviatura;
    }

    public void setLugDecEntVoAbreviatura(String lugDecEntVoAbreviatura) {
        this.lugDecEntVoAbreviatura = lugDecEntVoAbreviatura;
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
        hash += (lugDecEntVoId != null ? lugDecEntVoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lugardecomisoentregavoluntaria)) {
            return false;
        }
        Lugardecomisoentregavoluntaria other = (Lugardecomisoentregavoluntaria) object;
        if ((this.lugDecEntVoId == null && other.lugDecEntVoId != null) || (this.lugDecEntVoId != null && !this.lugDecEntVoId.equals(other.lugDecEntVoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Lugardecomisoentregavoluntaria[ lugDecEntVoId=" + lugDecEntVoId + " ]";
    }
    
}
