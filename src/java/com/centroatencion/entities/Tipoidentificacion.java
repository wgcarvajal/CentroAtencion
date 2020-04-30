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
@Table(name = "tipoidentificacion", catalog = "hogardepasobd", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipoidentificacion.findAll", query = "SELECT t FROM Tipoidentificacion t"),
    @NamedQuery(name = "Tipoidentificacion.findByTipidentId", query = "SELECT t FROM Tipoidentificacion t WHERE t.tipidentId = :tipidentId"),
    @NamedQuery(name = "Tipoidentificacion.findByTipidentNombre", query = "SELECT t FROM Tipoidentificacion t WHERE t.tipidentNombre = :tipidentNombre"),
    @NamedQuery(name = "Tipoidentificacion.findByTipidentAbreviatura", query = "SELECT t FROM Tipoidentificacion t WHERE t.tipidentAbreviatura = :tipidentAbreviatura")})
public class Tipoidentificacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tipidentId")
    private Integer tipidentId;
    @Basic(optional = false)
    @Column(name = "tipidentNombre")
    private String tipidentNombre;
    @Basic(optional = false)
    @Column(name = "tipidentAbreviatura")
    private String tipidentAbreviatura;
    @OneToMany(mappedBy = "tipoidentificacionId")
    private List<Persona> personaList;

    public Tipoidentificacion() {
    }

    public Tipoidentificacion(Integer tipidentId) {
        this.tipidentId = tipidentId;
    }

    public Tipoidentificacion(Integer tipidentId, String tipidentNombre, String tipidentAbreviatura) {
        this.tipidentId = tipidentId;
        this.tipidentNombre = tipidentNombre;
        this.tipidentAbreviatura = tipidentAbreviatura;
    }

    public Integer getTipidentId() {
        return tipidentId;
    }

    public void setTipidentId(Integer tipidentId) {
        this.tipidentId = tipidentId;
    }

    public String getTipidentNombre() {
        return tipidentNombre;
    }

    public void setTipidentNombre(String tipidentNombre) {
        this.tipidentNombre = tipidentNombre;
    }

    public String getTipidentAbreviatura() {
        return tipidentAbreviatura;
    }

    public void setTipidentAbreviatura(String tipidentAbreviatura) {
        this.tipidentAbreviatura = tipidentAbreviatura;
    }

    @XmlTransient
    public List<Persona> getPersonaList() {
        return personaList;
    }

    public void setPersonaList(List<Persona> personaList) {
        this.personaList = personaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipidentId != null ? tipidentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipoidentificacion)) {
            return false;
        }
        Tipoidentificacion other = (Tipoidentificacion) object;
        if ((this.tipidentId == null && other.tipidentId != null) || (this.tipidentId != null && !this.tipidentId.equals(other.tipidentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Tipoidentificacion[ tipidentId=" + tipidentId + " ]";
    }
    
}
