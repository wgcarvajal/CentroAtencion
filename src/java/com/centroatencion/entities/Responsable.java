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
@Table(name = "responsable", catalog = "hogardepasobd", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Responsable.findAll", query = "SELECT r FROM Responsable r ORDER BY r.respNombre asc"),
    @NamedQuery(name = "Responsable.findByRespId", query = "SELECT r FROM Responsable r WHERE r.respId = :respId"),
    @NamedQuery(name = "Responsable.findByRespNombre", query = "SELECT r FROM Responsable r WHERE r.respNombre = :respNombre"),
    @NamedQuery(name = "Responsable.findByRespAbreviatura", query = "SELECT r FROM Responsable r WHERE r.respAbreviatura = :respAbreviatura")})
public class Responsable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "respId")
    private Integer respId;
    @Basic(optional = false)
    @Column(name = "respNombre")
    private String respNombre;
    @Basic(optional = false)
    @Column(name = "respAbreviatura")
    private String respAbreviatura;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "respId")
    private List<Responsableingreso> responsableingresoList;

    public Responsable() {
    }

    public Responsable(Integer respId) {
        this.respId = respId;
    }

    public Responsable(Integer respId, String respNombre, String respAbreviatura) {
        this.respId = respId;
        this.respNombre = respNombre;
        this.respAbreviatura = respAbreviatura;
    }

    public Integer getRespId() {
        return respId;
    }

    public void setRespId(Integer respId) {
        this.respId = respId;
    }

    public String getRespNombre() {
        return respNombre;
    }

    public void setRespNombre(String respNombre) {
        this.respNombre = respNombre;
    }

    public String getRespAbreviatura() {
        return respAbreviatura;
    }

    public void setRespAbreviatura(String respAbreviatura) {
        this.respAbreviatura = respAbreviatura;
    }

    @XmlTransient
    public List<Responsableingreso> getResponsableingresoList() {
        return responsableingresoList;
    }

    public void setResponsableingresoList(List<Responsableingreso> responsableingresoList) {
        this.responsableingresoList = responsableingresoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (respId != null ? respId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Responsable)) {
            return false;
        }
        Responsable other = (Responsable) object;
        if ((this.respId == null && other.respId != null) || (this.respId != null && !this.respId.equals(other.respId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Responsable[ respId=" + respId + " ]";
    }
    
}
