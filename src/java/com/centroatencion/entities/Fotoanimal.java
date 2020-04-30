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
@Table(name = "fotoanimal", catalog = "hogardepasobd", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fotoanimal.findAll", query = "SELECT f FROM Fotoanimal f"),
    @NamedQuery(name = "Fotoanimal.findByFotanId", query = "SELECT f FROM Fotoanimal f WHERE f.fotanId = :fotanId"),
    @NamedQuery(name = "Fotoanimal.findByAnimalId", query = "SELECT f FROM Fotoanimal f WHERE f.animalId.anId = :anId"),
    @NamedQuery(name = "Fotoanimal.findByFotanNombre", query = "SELECT f FROM Fotoanimal f WHERE f.fotanNombre = :fotanNombre")})
public class Fotoanimal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "fotanId")
    private Long fotanId;
    @Basic(optional = false)
    @Column(name = "fotanNombre")
    private String fotanNombre;
    @JoinColumn(name = "animalId", referencedColumnName = "anId")
    @ManyToOne(optional = false)
    private Animal animalId;

    public Fotoanimal() {
    }

    public Fotoanimal(Long fotanId) {
        this.fotanId = fotanId;
    }

    public Fotoanimal(Long fotanId, String fotanNombre) {
        this.fotanId = fotanId;
        this.fotanNombre = fotanNombre;
    }

    public Long getFotanId() {
        return fotanId;
    }

    public void setFotanId(Long fotanId) {
        this.fotanId = fotanId;
    }

    public String getFotanNombre() {
        return fotanNombre;
    }

    public void setFotanNombre(String fotanNombre) {
        this.fotanNombre = fotanNombre;
    }

    public Animal getAnimalId() {
        return animalId;
    }

    public void setAnimalId(Animal animalId) {
        this.animalId = animalId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fotanId != null ? fotanId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fotoanimal)) {
            return false;
        }
        Fotoanimal other = (Fotoanimal) object;
        if ((this.fotanId == null && other.fotanId != null) || (this.fotanId != null && !this.fotanId.equals(other.fotanId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Fotoanimal[ fotanId=" + fotanId + " ]";
    }
    
}
