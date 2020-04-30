/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Wilson Carvajal
 */
@Entity
@Table(name = "responsableingreso", catalog = "hogardepasobd", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Responsableingreso.findAll", query = "SELECT r FROM Responsableingreso r"),
    @NamedQuery(name = "Responsableingreso.findByRespingId", query = "SELECT r FROM Responsableingreso r WHERE r.respingId = :respingId")})
public class Responsableingreso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "respingId")
    private Long respingId;
    @JoinColumn(name = "ingId", referencedColumnName = "ingId")
    @ManyToOne(optional = false)
    private Ingreso ingId;
    @JoinColumn(name = "respId", referencedColumnName = "respId")
    @ManyToOne(optional = false)
    private Responsable respId;

    public Responsableingreso() {
    }

    public Responsableingreso(Long respingId) {
        this.respingId = respingId;
    }

    public Long getRespingId() {
        return respingId;
    }

    public void setRespingId(Long respingId) {
        this.respingId = respingId;
    }

    public Ingreso getIngId() {
        return ingId;
    }

    public void setIngId(Ingreso ingId) {
        this.ingId = ingId;
    }

    public Responsable getRespId() {
        return respId;
    }

    public void setRespId(Responsable respId) {
        this.respId = respId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (respingId != null ? respingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Responsableingreso)) {
            return false;
        }
        Responsableingreso other = (Responsableingreso) object;
        if ((this.respingId == null && other.respingId != null) || (this.respingId != null && !this.respingId.equals(other.respingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Responsableingreso[ respingId=" + respingId + " ]";
    }
    
}
