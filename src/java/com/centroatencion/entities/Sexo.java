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
@Table(name = "sexo", catalog = "hogardepasobd", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sexo.findAll", query = "SELECT s FROM Sexo s"),
    @NamedQuery(name = "Sexo.findBySexId", query = "SELECT s FROM Sexo s WHERE s.sexId = :sexId"),
    @NamedQuery(name = "Sexo.findBySexTipo", query = "SELECT s FROM Sexo s WHERE s.sexTipo = :sexTipo"),
    @NamedQuery(name = "Sexo.findBySexTipoAbreviatura", query = "SELECT s FROM Sexo s WHERE s.sexTipoAbreviatura = :sexTipoAbreviatura")})
public class Sexo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sexId")
    private Integer sexId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "sexTipo")
    private String sexTipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "sexTipoAbreviatura")
    private String sexTipoAbreviatura;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sexoId")
    private List<Ingreso> ingresoList;

    public Sexo() {
    }

    public Sexo(Integer sexId) {
        this.sexId = sexId;
    }

    public Sexo(Integer sexId, String sexTipo, String sexTipoAbreviatura) {
        this.sexId = sexId;
        this.sexTipo = sexTipo;
        this.sexTipoAbreviatura = sexTipoAbreviatura;
    }

    public Integer getSexId() {
        return sexId;
    }

    public void setSexId(Integer sexId) {
        this.sexId = sexId;
    }

    public String getSexTipo() {
        return sexTipo;
    }

    public void setSexTipo(String sexTipo) {
        this.sexTipo = sexTipo;
    }

    public String getSexTipoAbreviatura() {
        return sexTipoAbreviatura;
    }

    public void setSexTipoAbreviatura(String sexTipoAbreviatura) {
        this.sexTipoAbreviatura = sexTipoAbreviatura;
    }

    @XmlTransient
    public List<Ingreso> getIngresoList() {
        return ingresoList;
    }

    public void setIngresoList(List<Ingreso> ingresoList) {
        this.ingresoList = ingresoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sexId != null ? sexId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sexo)) {
            return false;
        }
        Sexo other = (Sexo) object;
        if ((this.sexId == null && other.sexId != null) || (this.sexId != null && !this.sexId.equals(other.sexId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.centroatencion.entities.Sexo[ sexId=" + sexId + " ]";
    }
    
}
