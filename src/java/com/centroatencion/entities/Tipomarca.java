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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author aranda
 */
@Entity
@Table(name = "tipomarca", catalog = "hogardepasobd", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipomarca.findAll", query = "SELECT t FROM Tipomarca t"),
    @NamedQuery(name = "Tipomarca.findByTipomarcId", query = "SELECT t FROM Tipomarca t WHERE t.tipomarcId = :tipomarcId"),
    @NamedQuery(name = "Tipomarca.findByTipomarcaNombre", query = "SELECT t FROM Tipomarca t WHERE t.tipomarcaNombre = :tipomarcaNombre")})
public class Tipomarca implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tipomarcId")
    private Integer tipomarcId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "tipomarcaNombre")
    private String tipomarcaNombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipomarcaid")
    private List<Marca> marcaList;

    public Tipomarca() {
    }

    public Tipomarca(Integer tipomarcId) {
        this.tipomarcId = tipomarcId;
    }

    public Tipomarca(Integer tipomarcId, String tipomarcaNombre) {
        this.tipomarcId = tipomarcId;
        this.tipomarcaNombre = tipomarcaNombre;
    }

    public Integer getTipomarcId() {
        return tipomarcId;
    }

    public void setTipomarcId(Integer tipomarcId) {
        this.tipomarcId = tipomarcId;
    }

    public String getTipomarcaNombre() {
        return tipomarcaNombre;
    }

    public void setTipomarcaNombre(String tipomarcaNombre) {
        this.tipomarcaNombre = tipomarcaNombre;
    }

    @XmlTransient
    public List<Marca> getMarcaList() {
        return marcaList;
    }

    public void setMarcaList(List<Marca> marcaList) {
        this.marcaList = marcaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipomarcId != null ? tipomarcId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipomarca)) {
            return false;
        }
        Tipomarca other = (Tipomarca) object;
        if ((this.tipomarcId == null && other.tipomarcId != null) || (this.tipomarcId != null && !this.tipomarcId.equals(other.tipomarcId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.centroatencion.entities.Tipomarca[ tipomarcId=" + tipomarcId + " ]";
    }
    
}
