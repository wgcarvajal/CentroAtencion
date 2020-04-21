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
@Table(name = "departamento", catalog = "hogardepasobd", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Departamento.findAll", query = "SELECT d FROM Departamento d"),
    @NamedQuery(name = "Departamento.findByDepId", query = "SELECT d FROM Departamento d WHERE d.depId = :depId"),
    @NamedQuery(name = "Departamento.findByNombreDepartamento", query = "SELECT d FROM Departamento d WHERE LOWER(d.depNombre) LIKE :depNombre"),
    @NamedQuery(name = "Departamento.findByDepNombre", query = "SELECT d FROM Departamento d WHERE d.depNombre = :depNombre")})
public class Departamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "depId")
    private Long depId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "depNombre")
    private String depNombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departamentoId")
    private List<Municipio> municipioList;

    public Departamento() {
    }

    public Departamento(Long depId) {
        this.depId = depId;
    }

    public Departamento(Long depId, String depNombre) {
        this.depId = depId;
        this.depNombre = depNombre;
    }

    public Long getDepId() {
        return depId;
    }

    public void setDepId(Long depId) {
        this.depId = depId;
    }

    public String getDepNombre() {
        return depNombre;
    }

    public void setDepNombre(String depNombre) {
        this.depNombre = depNombre;
    }

    @XmlTransient
    public List<Municipio> getMunicipioList() {
        return municipioList;
    }

    public void setMunicipioList(List<Municipio> municipioList) {
        this.municipioList = municipioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (depId != null ? depId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departamento)) {
            return false;
        }
        Departamento other = (Departamento) object;
        if ((this.depId == null && other.depId != null) || (this.depId != null && !this.depId.equals(other.depId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.centroatencion.entities.Departamento[ depId=" + depId + " ]";
    }
    
}
