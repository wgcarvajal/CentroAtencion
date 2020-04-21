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
@Table(name = "ubicacionmarca", catalog = "hogardepasobd", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ubicacionmarca.findAll", query = "SELECT u FROM Ubicacionmarca u"),
    @NamedQuery(name = "Ubicacionmarca.findByUbicacionmarcId", query = "SELECT u FROM Ubicacionmarca u WHERE u.ubicacionmarcId = :ubicacionmarcId"),
    @NamedQuery(name = "Ubicacionmarca.findByUbicacionmarcNombre", query = "SELECT u FROM Ubicacionmarca u WHERE u.ubicacionmarcNombre = :ubicacionmarcNombre"),
    @NamedQuery(name = "Ubicacionmarca.findByUbicacionmarcAbreviatura", query = "SELECT u FROM Ubicacionmarca u WHERE u.ubicacionmarcAbreviatura = :ubicacionmarcAbreviatura")})
public class Ubicacionmarca implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ubicacionmarcId")
    private Integer ubicacionmarcId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "ubicacionmarcNombre")
    private String ubicacionmarcNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "ubicacionmarcAbreviatura")
    private String ubicacionmarcAbreviatura;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ubicacionmarcaId")
    private List<Marca> marcaList;

    public Ubicacionmarca() {
    }

    public Ubicacionmarca(Integer ubicacionmarcId) {
        this.ubicacionmarcId = ubicacionmarcId;
    }

    public Ubicacionmarca(Integer ubicacionmarcId, String ubicacionmarcNombre, String ubicacionmarcAbreviatura) {
        this.ubicacionmarcId = ubicacionmarcId;
        this.ubicacionmarcNombre = ubicacionmarcNombre;
        this.ubicacionmarcAbreviatura = ubicacionmarcAbreviatura;
    }

    public Integer getUbicacionmarcId() {
        return ubicacionmarcId;
    }

    public void setUbicacionmarcId(Integer ubicacionmarcId) {
        this.ubicacionmarcId = ubicacionmarcId;
    }

    public String getUbicacionmarcNombre() {
        return ubicacionmarcNombre;
    }

    public void setUbicacionmarcNombre(String ubicacionmarcNombre) {
        this.ubicacionmarcNombre = ubicacionmarcNombre;
    }

    public String getUbicacionmarcAbreviatura() {
        return ubicacionmarcAbreviatura;
    }

    public void setUbicacionmarcAbreviatura(String ubicacionmarcAbreviatura) {
        this.ubicacionmarcAbreviatura = ubicacionmarcAbreviatura;
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
        hash += (ubicacionmarcId != null ? ubicacionmarcId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ubicacionmarca)) {
            return false;
        }
        Ubicacionmarca other = (Ubicacionmarca) object;
        if ((this.ubicacionmarcId == null && other.ubicacionmarcId != null) || (this.ubicacionmarcId != null && !this.ubicacionmarcId.equals(other.ubicacionmarcId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.centroatencion.entities.Ubicacionmarca[ ubicacionmarcId=" + ubicacionmarcId + " ]";
    }
    
}
