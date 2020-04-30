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
 * @author aranda
 */
@Entity
@Table(name = "subproducto", catalog = "hogardepasobd", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subproducto.findAll", query = "SELECT s FROM Subproducto s"),
    @NamedQuery(name = "Subproducto.findBySubprodId", query = "SELECT s FROM Subproducto s WHERE s.subprodId = :subprodId"),
    @NamedQuery(name = "Subproducto.findBySubprodNombre", query = "SELECT s FROM Subproducto s WHERE s.subprodNombre = :subprodNombre")})
public class Subproducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "subprodId")
    private Integer subprodId;
    @Basic(optional = false)
    @Column(name = "subprodNombre")
    private String subprodNombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subprodId")
    private List<Ingresosubproducto> ingresosubproductoList;

    public Subproducto() {
    }

    public Subproducto(Integer subprodId) {
        this.subprodId = subprodId;
    }

    public Subproducto(Integer subprodId, String subprodNombre) {
        this.subprodId = subprodId;
        this.subprodNombre = subprodNombre;
    }

    public Integer getSubprodId() {
        return subprodId;
    }

    public void setSubprodId(Integer subprodId) {
        this.subprodId = subprodId;
    }

    public String getSubprodNombre() {
        return subprodNombre;
    }

    public void setSubprodNombre(String subprodNombre) {
        this.subprodNombre = subprodNombre;
    }

    @XmlTransient
    public List<Ingresosubproducto> getIngresosubproductoList() {
        return ingresosubproductoList;
    }

    public void setIngresosubproductoList(List<Ingresosubproducto> ingresosubproductoList) {
        this.ingresosubproductoList = ingresosubproductoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (subprodId != null ? subprodId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subproducto)) {
            return false;
        }
        Subproducto other = (Subproducto) object;
        if ((this.subprodId == null && other.subprodId != null) || (this.subprodId != null && !this.subprodId.equals(other.subprodId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Subproducto[ subprodId=" + subprodId + " ]";
    }
    
}
