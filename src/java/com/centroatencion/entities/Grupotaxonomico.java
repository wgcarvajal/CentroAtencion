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
 * @author Wilson Carvajal
 */
@Entity
@Table(name = "grupotaxonomico", catalog = "hogardepasobd", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Grupotaxonomico.findAll", query = "SELECT g FROM Grupotaxonomico g"),
    @NamedQuery(name = "Grupotaxonomico.findByGruptaxId", query = "SELECT g FROM Grupotaxonomico g WHERE g.gruptaxId = :gruptaxId"),
    @NamedQuery(name = "Grupotaxonomico.findByGruptaxNombre", query = "SELECT g FROM Grupotaxonomico g WHERE g.gruptaxNombre = :gruptaxNombre"),
    @NamedQuery(name = "Grupotaxonomico.searchByNombreGrupoTaxonomico", query = "SELECT g FROM Grupotaxonomico g WHERE LOWER(g.gruptaxNombre) LIKE :gruptaxNombre"),
    @NamedQuery(name = "Grupotaxonomico.findByGrupotaxAbreviatura", query = "SELECT g FROM Grupotaxonomico g WHERE g.grupotaxAbreviatura = :grupotaxAbreviatura")})
public class Grupotaxonomico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "gruptaxId")
    private Integer gruptaxId;
    @Basic(optional = false)
    @Column(name = "gruptaxNombre")
    private String gruptaxNombre;
    @Basic(optional = false)
    @Column(name = "grupotaxAbreviatura")
    private String grupotaxAbreviatura;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grupotaxonomicoId")
    private List<Animal> animalList;

    public Grupotaxonomico() {
    }

    public Grupotaxonomico(Integer gruptaxId) {
        this.gruptaxId = gruptaxId;
    }

    public Grupotaxonomico(Integer gruptaxId, String gruptaxNombre, String grupotaxAbreviatura) {
        this.gruptaxId = gruptaxId;
        this.gruptaxNombre = gruptaxNombre;
        this.grupotaxAbreviatura = grupotaxAbreviatura;
    }

    public Integer getGruptaxId() {
        return gruptaxId;
    }

    public void setGruptaxId(Integer gruptaxId) {
        this.gruptaxId = gruptaxId;
    }

    public String getGruptaxNombre() {
        return gruptaxNombre;
    }

    public void setGruptaxNombre(String gruptaxNombre) {
        this.gruptaxNombre = gruptaxNombre;
    }

    public String getGrupotaxAbreviatura() {
        return grupotaxAbreviatura;
    }

    public void setGrupotaxAbreviatura(String grupotaxAbreviatura) {
        this.grupotaxAbreviatura = grupotaxAbreviatura;
    }

    @XmlTransient
    public List<Animal> getAnimalList() {
        return animalList;
    }

    public void setAnimalList(List<Animal> animalList) {
        this.animalList = animalList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gruptaxId != null ? gruptaxId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grupotaxonomico)) {
            return false;
        }
        Grupotaxonomico other = (Grupotaxonomico) object;
        if ((this.gruptaxId == null && other.gruptaxId != null) || (this.gruptaxId != null && !this.gruptaxId.equals(other.gruptaxId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Grupotaxonomico[ gruptaxId=" + gruptaxId + " ]";
    }
    
}
