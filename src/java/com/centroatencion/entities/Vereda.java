/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.entities;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Wilson Carvajal
 */
@Entity
@Table(name = "vereda", catalog = "hogardepasobd", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vereda.findAll", query = "SELECT v FROM Vereda v"),
    @NamedQuery(name = "Vereda.findByVerId", query = "SELECT v FROM Vereda v WHERE v.verId = :verId"),
    @NamedQuery(name = "Vereda.findByMunicipio", query = "SELECT v FROM Vereda v WHERE v.municipioId.munId = :municipioId"),
    @NamedQuery(name = "Vereda.findByMunicipioAndNombre", query = "SELECT v FROM Vereda v WHERE v.municipioId.munId = :municipioId AND LOWER(v.verNombre) LIKE :verNombre"),
    @NamedQuery(name = "Vereda.findByVerNombre", query = "SELECT v FROM Vereda v WHERE v.verNombre = :verNombre")})
public class Vereda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "verId")
    private Long verId;
    @Basic(optional = false)
    @Column(name = "verNombre")
    private String verNombre;
    @OneToMany(mappedBy = "veredaId")
    private List<Persona> personaList;
    @JoinColumn(name = "municipioId", referencedColumnName = "munId")
    @ManyToOne(optional = false)
    private Municipio municipioId;

    public Vereda() {
    }

    public Vereda(Long verId) {
        this.verId = verId;
    }

    public Vereda(Long verId, String verNombre) {
        this.verId = verId;
        this.verNombre = verNombre;
    }

    public Long getVerId() {
        return verId;
    }

    public void setVerId(Long verId) {
        this.verId = verId;
    }

    public String getVerNombre() {
        return verNombre;
    }

    public void setVerNombre(String verNombre) {
        this.verNombre = verNombre;
    }

    @XmlTransient
    public List<Persona> getPersonaList() {
        return personaList;
    }

    public void setPersonaList(List<Persona> personaList) {
        this.personaList = personaList;
    }

    public Municipio getMunicipioId() {
        return municipioId;
    }

    public void setMunicipioId(Municipio municipioId) {
        this.municipioId = municipioId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (verId != null ? verId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vereda)) {
            return false;
        }
        Vereda other = (Vereda) object;
        if ((this.verId == null && other.verId != null) || (this.verId != null && !this.verId.equals(other.verId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Vereda[ verId=" + verId + " ]";
    }
    
}
