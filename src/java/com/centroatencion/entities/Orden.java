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
import javax.persistence.Lob;
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
@Table(name = "orden", catalog = "hogardepasobd", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orden.findAll", query = "SELECT o FROM Orden o ORDER BY o.orNombre asc"),
    @NamedQuery(name = "Orden.findByOrId", query = "SELECT o FROM Orden o WHERE o.orId = :orId"),
    @NamedQuery(name = "Orden.findByNombreOrden", query = "SELECT o FROM Orden o WHERE LOWER(o.orNombre) LIKE :orNombre"),
    @NamedQuery(name = "Orden.findByOrNombre", query = "SELECT o FROM Orden o WHERE o.orNombre = :orNombre")})
public class Orden implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "orId")
    private Integer orId;
    @Basic(optional = false)
    @Column(name = "orNombre")
    private String orNombre;
    @Lob
    @Column(name = "orDescripcion")
    private String orDescripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orId")
    private List<Familia> familiaList;

    public Orden() {
    }

    public Orden(Integer orId) {
        this.orId = orId;
    }

    public Orden(Integer orId, String orNombre) {
        this.orId = orId;
        this.orNombre = orNombre;
    }

    public Integer getOrId() {
        return orId;
    }

    public void setOrId(Integer orId) {
        this.orId = orId;
    }

    public String getOrNombre() {
        return orNombre;
    }

    public void setOrNombre(String orNombre) {
        this.orNombre = orNombre;
    }

    public String getOrDescripcion() {
        return orDescripcion;
    }

    public void setOrDescripcion(String orDescripcion) {
        this.orDescripcion = orDescripcion;
    }

    @XmlTransient
    public List<Familia> getFamiliaList() {
        return familiaList;
    }

    public void setFamiliaList(List<Familia> familiaList) {
        this.familiaList = familiaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orId != null ? orId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orden)) {
            return false;
        }
        Orden other = (Orden) object;
        if ((this.orId == null && other.orId != null) || (this.orId != null && !this.orId.equals(other.orId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Orden[ orId=" + orId + " ]";
    }
    
}
