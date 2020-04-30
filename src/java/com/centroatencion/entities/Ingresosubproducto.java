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
 * @author aranda
 */
@Entity
@Table(name = "ingresosubproducto", catalog = "hogardepasobd", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ingresosubproducto.findAll", query = "SELECT i FROM Ingresosubproducto i"),
    @NamedQuery(name = "Ingresosubproducto.findByIngsubproId", query = "SELECT i FROM Ingresosubproducto i WHERE i.ingsubproId = :ingsubproId")})
public class Ingresosubproducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ingsubproId")
    private Long ingsubproId;
    @JoinColumn(name = "ingId", referencedColumnName = "ingId")
    @ManyToOne(optional = false)
    private Ingreso ingId;
    @JoinColumn(name = "subprodId", referencedColumnName = "subprodId")
    @ManyToOne(optional = false)
    private Subproducto subprodId;

    public Ingresosubproducto() {
    }

    public Ingresosubproducto(Long ingsubproId) {
        this.ingsubproId = ingsubproId;
    }

    public Long getIngsubproId() {
        return ingsubproId;
    }

    public void setIngsubproId(Long ingsubproId) {
        this.ingsubproId = ingsubproId;
    }

    public Ingreso getIngId() {
        return ingId;
    }

    public void setIngId(Ingreso ingId) {
        this.ingId = ingId;
    }

    public Subproducto getSubprodId() {
        return subprodId;
    }

    public void setSubprodId(Subproducto subprodId) {
        this.subprodId = subprodId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ingsubproId != null ? ingsubproId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ingresosubproducto)) {
            return false;
        }
        Ingresosubproducto other = (Ingresosubproducto) object;
        if ((this.ingsubproId == null && other.ingsubproId != null) || (this.ingsubproId != null && !this.ingsubproId.equals(other.ingsubproId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Ingresosubproducto[ ingsubproId=" + ingsubproId + " ]";
    }
    
}
