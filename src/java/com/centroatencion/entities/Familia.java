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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "familia", catalog = "hogardepasobd", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Familia.findAll", query = "SELECT f FROM Familia f order by f.faNombre asc"),
    @NamedQuery(name = "Familia.findByFaId", query = "SELECT f FROM Familia f WHERE f.faId = :faId"),
    @NamedQuery(name = "Familia.findByOrden", query = "SELECT f FROM Familia f WHERE f.orId.orId = :orId"),
    @NamedQuery(name = "Familia.findByOrdenAndNombre", query = "SELECT f FROM Familia f WHERE f.orId.orId = :orId AND LOWER(f.faNombre) LIKE :faNombre order by f.faNombre asc"),
    @NamedQuery(name = "Familia.findByFaNombreOrderByFaNombre", query = "SELECT f FROM Familia f WHERE LOWER(f.faNombre) LIKE :faNombre order by f.faNombre asc"),
    @NamedQuery(name = "Familia.findByIdInnerJoinOrden", query = "SELECT f,o FROM Familia f INNER JOIN Orden o WHERE f.faId = :faId And f.orId.orId = o.orId"),
    @NamedQuery(name = "Familia.findByFaNombre", query = "SELECT f FROM Familia f WHERE f.faNombre = :faNombre")})
public class Familia implements Serializable {

   private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "faId")
    private Integer faId;
    @Basic(optional = false)
    @Column(name = "faNombre")
    private String faNombre;
    @Lob
    @Column(name = "faDescripcion")
    private String faDescripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "faId")
    private List<Animal> animalList;
    @JoinColumn(name = "orId", referencedColumnName = "orId")
    @ManyToOne(optional = false)
    private Orden orId;

    public Familia() {
    }

    public Familia(Integer faId) {
        this.faId = faId;
    }

    public Familia(Integer faId, String faNombre) {
        this.faId = faId;
        this.faNombre = faNombre;
    }

    public Integer getFaId() {
        return faId;
    }

    public void setFaId(Integer faId) {
        this.faId = faId;
    }

    public String getFaNombre() {
        return faNombre;
    }

    public void setFaNombre(String faNombre) {
        this.faNombre = faNombre;
    }

    public String getFaDescripcion() {
        return faDescripcion;
    }

    public void setFaDescripcion(String faDescripcion) {
        this.faDescripcion = faDescripcion;
    }

    @XmlTransient
    public List<Animal> getAnimalList() {
        return animalList;
    }

    public void setAnimalList(List<Animal> animalList) {
        this.animalList = animalList;
    }

    public Orden getOrId() {
        return orId;
    }

    public void setOrId(Orden orId) {
        this.orId = orId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (faId != null ? faId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Familia)) {
            return false;
        }
        Familia other = (Familia) object;
        if ((this.faId == null && other.faId != null) || (this.faId != null && !this.faId.equals(other.faId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Familia[ faId=" + faId + " ]";
    }
    
}
