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
@Table(name = "municipio", catalog = "hogardepasobd", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Municipio.findAll", query = "SELECT m FROM Municipio m"),
    @NamedQuery(name = "Municipio.findByMunId", query = "SELECT m FROM Municipio m WHERE m.munId = :munId"),
    @NamedQuery(name = "Municipio.findByDepartamento", query = "SELECT m FROM Municipio m WHERE m.departamentoId.depId = :departamentoId ORDER BY m.munNombre asc"),
    @NamedQuery(name = "Municipio.findByDepartamentoAndNombre", query = "SELECT m FROM Municipio m WHERE m.departamentoId.depId = :departamentoId AND LOWER(m.munNombre) LIKE :munNombre"),
    @NamedQuery(name = "Municipio.findDepartamentoById",query = "SELECT d FROM Municipio m INNER JOIN m.departamentoId d WHERE m.munId = :munId "),
    @NamedQuery(name = "Municipio.findByMunNombre", query = "SELECT m FROM Municipio m WHERE m.munNombre = :munNombre")})
public class Municipio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "munId")
    private Long munId;
    @Basic(optional = false)
    @Column(name = "munNombre")
    private String munNombre;
    @OneToMany(mappedBy = "municipioId")
    private List<Persona> personaList;
    @JoinColumn(name = "departamentoId", referencedColumnName = "depId")
    @ManyToOne(optional = false)
    private Departamento departamentoId;
    @OneToMany(mappedBy = "munExtraccionId")
    private List<Ingreso> ingresoList;
    @OneToMany(mappedBy = "munOcurrenciaId")
    private List<Ingreso> ingresoList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "municipioId")
    private List<Vereda> veredaList;

    public Municipio() {
    }

    public Municipio(Long munId) {
        this.munId = munId;
    }

    public Municipio(Long munId, String munNombre) {
        this.munId = munId;
        this.munNombre = munNombre;
    }

    public Long getMunId() {
        return munId;
    }

    public void setMunId(Long munId) {
        this.munId = munId;
    }

    public String getMunNombre() {
        return munNombre;
    }

    public void setMunNombre(String munNombre) {
        this.munNombre = munNombre;
    }

    @XmlTransient
    public List<Persona> getPersonaList() {
        return personaList;
    }

    public void setPersonaList(List<Persona> personaList) {
        this.personaList = personaList;
    }

    public Departamento getDepartamentoId() {
        return departamentoId;
    }

    public void setDepartamentoId(Departamento departamentoId) {
        this.departamentoId = departamentoId;
    }

    @XmlTransient
    public List<Ingreso> getIngresoList() {
        return ingresoList;
    }

    public void setIngresoList(List<Ingreso> ingresoList) {
        this.ingresoList = ingresoList;
    }

    @XmlTransient
    public List<Ingreso> getIngresoList1() {
        return ingresoList1;
    }

    public void setIngresoList1(List<Ingreso> ingresoList1) {
        this.ingresoList1 = ingresoList1;
    }

    @XmlTransient
    public List<Vereda> getVeredaList() {
        return veredaList;
    }

    public void setVeredaList(List<Vereda> veredaList) {
        this.veredaList = veredaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (munId != null ? munId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Municipio)) {
            return false;
        }
        Municipio other = (Municipio) object;
        if ((this.munId == null && other.munId != null) || (this.munId != null && !this.munId.equals(other.munId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Municipio[ munId=" + munId + " ]";
    }
    
}
