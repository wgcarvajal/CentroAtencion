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
@Table(name = "ingresodocumento", catalog = "hogardepasobd", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ingresodocumento.findAll", query = "SELECT i FROM Ingresodocumento i"),
    @NamedQuery(name = "Ingresodocumento.findByIngId", query = "SELECT i FROM Ingresodocumento i WHERE i.ingId.ingId = :ingId"),
    @NamedQuery(name = "Ingresodocumento.findByIngDocId", query = "SELECT i FROM Ingresodocumento i WHERE i.ingDocId = :ingDocId"),
    @NamedQuery(name = "Ingresodocumento.findByIngDocNombre", query = "SELECT i FROM Ingresodocumento i WHERE i.ingDocNombre = :ingDocNombre")})
public class Ingresodocumento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ingDocId")
    private Long ingDocId;
    @Basic(optional = false)
    @Column(name = "ingDocNombre")
    private String ingDocNombre;
    @JoinColumn(name = "ingId", referencedColumnName = "ingId")
    @ManyToOne(optional = false)
    private Ingreso ingId;

    public Ingresodocumento() {
    }

    public Ingresodocumento(Long ingDocId) {
        this.ingDocId = ingDocId;
    }

    public Ingresodocumento(Long ingDocId, String ingDocNombre) {
        this.ingDocId = ingDocId;
        this.ingDocNombre = ingDocNombre;
    }

    public Long getIngDocId() {
        return ingDocId;
    }

    public void setIngDocId(Long ingDocId) {
        this.ingDocId = ingDocId;
    }

    public String getIngDocNombre() {
        return ingDocNombre;
    }

    public void setIngDocNombre(String ingDocNombre) {
        this.ingDocNombre = ingDocNombre;
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
        hash += (ingDocId != null ? ingDocId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ingresodocumento)) {
            return false;
        }
        Ingresodocumento other = (Ingresodocumento) object;
        if ((this.ingDocId == null && other.ingDocId != null) || (this.ingDocId != null && !this.ingDocId.equals(other.ingDocId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Ingresodocumento[ ingDocId=" + ingDocId + " ]";
    }
    
}
