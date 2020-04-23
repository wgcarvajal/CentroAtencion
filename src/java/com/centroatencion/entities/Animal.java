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
 * @author aranda
 */
@Entity
@Table(name = "animal", catalog = "hogardepasobd", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Animal.findAll", query = "SELECT a FROM Animal a order by a.anEspNombre asc"),
    @NamedQuery(name = "Animal.findByAnId", query = "SELECT a FROM Animal a WHERE a.anId = :anId"),
    @NamedQuery(name = "Animal.searchByNombreAnimal", query = "SELECT a FROM Animal a WHERE LOWER(a.anNombre) LIKE :anNombre"),
    @NamedQuery(name = "Animal.searchByFamilia", query = "SELECT a FROM Animal a WHERE LOWER(a.faId.faNombre) LIKE :faNombre"),
    @NamedQuery(name = "Animal.findByFamilia", query = "SELECT a FROM Animal a WHERE a.faId.faId = :faId order by a.anEspNombre asc"),
    @NamedQuery(name = "Animal.searchByGrupoTaxonomico", query = "SELECT a FROM Animal a WHERE LOWER(a.grupotaxonomicoId.gruptaxNombre) LIKE :gruptaxNombre"),
    @NamedQuery(name = "Animal.findByAnNombre", query = "SELECT a FROM Animal a WHERE a.anNombre = :anNombre"),
    @NamedQuery(name = "Animal.findByAnEspNombre", query = "SELECT a FROM Animal a WHERE a.anEspNombre = :anEspNombre")})
public class Animal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "anId")
    private Long anId;
    @Basic(optional = false)
    @Column(name = "anNombre")
    private String anNombre;
    @Basic(optional = false)
    @Column(name = "anEspNombre")
    private String anEspNombre;
    @Lob
    @Column(name = "anDescripcion")
    private String anDescripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "animalId")
    private List<Fotoanimal> fotoanimalList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "animalId")
    private List<Ingreso> ingresoList;
    @JoinColumn(name = "faId", referencedColumnName = "faId")
    @ManyToOne(optional = false)
    private Familia faId;
    @JoinColumn(name = "grupotaxonomicoId", referencedColumnName = "gruptaxId")
    @ManyToOne(optional = false)
    private Grupotaxonomico grupotaxonomicoId;

    public Animal() {
    }

    public Animal(Long anId) {
        this.anId = anId;
    }

    public Animal(Long anId, String anNombre, String anEspNombre) {
        this.anId = anId;
        this.anNombre = anNombre;
        this.anEspNombre = anEspNombre;
    }

    public Long getAnId() {
        return anId;
    }

    public void setAnId(Long anId) {
        this.anId = anId;
    }

    public String getAnNombre() {
        return anNombre;
    }

    public void setAnNombre(String anNombre) {
        this.anNombre = anNombre;
    }

    public String getAnEspNombre() {
        return anEspNombre;
    }

    public void setAnEspNombre(String anEspNombre) {
        this.anEspNombre = anEspNombre;
    }

    public String getAnDescripcion() {
        return anDescripcion;
    }

    public void setAnDescripcion(String anDescripcion) {
        this.anDescripcion = anDescripcion;
    }

    @XmlTransient
    public List<Fotoanimal> getFotoanimalList() {
        return fotoanimalList;
    }

    public void setFotoanimalList(List<Fotoanimal> fotoanimalList) {
        this.fotoanimalList = fotoanimalList;
    }

    @XmlTransient
    public List<Ingreso> getIngresoList() {
        return ingresoList;
    }

    public void setIngresoList(List<Ingreso> ingresoList) {
        this.ingresoList = ingresoList;
    }

    public Familia getFaId() {
        return faId;
    }

    public void setFaId(Familia faId) {
        this.faId = faId;
    }

    public Grupotaxonomico getGrupotaxonomicoId() {
        return grupotaxonomicoId;
    }

    public void setGrupotaxonomicoId(Grupotaxonomico grupotaxonomicoId) {
        this.grupotaxonomicoId = grupotaxonomicoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (anId != null ? anId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Animal)) {
            return false;
        }
        Animal other = (Animal) object;
        if ((this.anId == null && other.anId != null) || (this.anId != null && !this.anId.equals(other.anId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Animal[ anId=" + anId + " ]";
    }
}
