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
@Table(name = "ingresofoto", catalog = "hogardepasobd", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ingresofoto.findAll", query = "SELECT i FROM Ingresofoto i"),
    @NamedQuery(name = "Ingresofoto.findByIngId", query = "SELECT i FROM Ingresofoto i WHERE i.ingId.ingId = :ingId"),
    @NamedQuery(name = "Ingresofoto.findByIngfotoId", query = "SELECT i FROM Ingresofoto i WHERE i.ingfotoId = :ingfotoId"),
    @NamedQuery(name = "Ingresofoto.findByIngFotoNombre", query = "SELECT i FROM Ingresofoto i WHERE i.ingFotoNombre = :ingFotoNombre")})
public class Ingresofoto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ingfotoId")
    private Long ingfotoId;
    @Column(name = "ingFotoNombre")
    private String ingFotoNombre;
    @JoinColumn(name = "ingId", referencedColumnName = "ingId")
    @ManyToOne(optional = false)
    private Ingreso ingId;

    public Ingresofoto() {
    }

    public Ingresofoto(Long ingfotoId) {
        this.ingfotoId = ingfotoId;
    }

    public Long getIngfotoId() {
        return ingfotoId;
    }

    public void setIngfotoId(Long ingfotoId) {
        this.ingfotoId = ingfotoId;
    }

    public String getIngFotoNombre() {
        return ingFotoNombre;
    }

    public void setIngFotoNombre(String ingFotoNombre) {
        this.ingFotoNombre = ingFotoNombre;
    }

    public Ingreso getIngId() {
        return ingId;
    }

    public void setIngId(Ingreso ingId) {
        this.ingId = ingId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ingfotoId != null ? ingfotoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ingresofoto)) {
            return false;
        }
        Ingresofoto other = (Ingresofoto) object;
        if ((this.ingfotoId == null && other.ingfotoId != null) || (this.ingfotoId != null && !this.ingfotoId.equals(other.ingfotoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Ingresofoto[ ingfotoId=" + ingfotoId + " ]";
    }
    
}
