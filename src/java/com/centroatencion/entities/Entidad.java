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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Wilson Carvajal
 */
@Entity
@Table(name = "entidad", catalog = "hogardepasobd", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entidad.findAll", query = "SELECT e FROM Entidad e"),
    @NamedQuery(name = "Entidad.findByEntId", query = "SELECT e FROM Entidad e WHERE e.entId = :entId"),
    @NamedQuery(name = "Entidad.findByEntNombre", query = "SELECT e FROM Entidad e WHERE e.entNombre = :entNombre"),
    @NamedQuery(name = "Entidad.findByVeredaDepartamento", query = "SELECT e FROM Entidad e WHERE e.veredaId IS NOT NULL and e.veredaId.municipioId.departamentoId.depId=:depId"),
    @NamedQuery(name = "Entidad.findByMunicipioDepartamento", query = "SELECT e FROM Entidad e WHERE e.municipioId IS NOT NULL and e.municipioId.departamentoId.depId=:depId"),
    @NamedQuery(name = "Entidad.findByEntDireccion", query = "SELECT e FROM Entidad e WHERE e.entDireccion = :entDireccion"),
    @NamedQuery(name = "Entidad.findByEntTelefono", query = "SELECT e FROM Entidad e WHERE e.entTelefono = :entTelefono")})
public class Entidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "entId")
    private Integer entId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "entNombre")
    private String entNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "entDireccion")
    private String entDireccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "entTelefono")
    private String entTelefono;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entId")
    private List<Contrato> contratoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entidadId")
    private List<Ingreso> ingresoList;
    @JoinColumn(name = "direccionterritorialId", referencedColumnName = "dirterId")
    @ManyToOne(optional = false)
    private Direcctionterritorial direccionterritorialId;
    @JoinColumn(name = "municipioId", referencedColumnName = "munId")
    @ManyToOne
    private Municipio municipioId;
    @JoinColumn(name = "veredaId", referencedColumnName = "verId")
    @ManyToOne
    private Vereda veredaId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entidadId")
    private List<Zonaubicacionanimal> zonaubicacionanimalList;

    public Entidad() {
    }

    public Entidad(Integer entId) {
        this.entId = entId;
    }

    public Entidad(Integer entId, String entNombre, String entDireccion, String entTelefono) {
        this.entId = entId;
        this.entNombre = entNombre;
        this.entDireccion = entDireccion;
        this.entTelefono = entTelefono;
    }

    public Integer getEntId() {
        return entId;
    }

    public void setEntId(Integer entId) {
        this.entId = entId;
    }

    public String getEntNombre() {
        return entNombre;
    }

    public void setEntNombre(String entNombre) {
        this.entNombre = entNombre;
    }

    public String getEntDireccion() {
        return entDireccion;
    }

    public void setEntDireccion(String entDireccion) {
        this.entDireccion = entDireccion;
    }

    public String getEntTelefono() {
        return entTelefono;
    }

    public void setEntTelefono(String entTelefono) {
        this.entTelefono = entTelefono;
    }

    @XmlTransient
    public List<Contrato> getContratoList() {
        return contratoList;
    }

    public void setContratoList(List<Contrato> contratoList) {
        this.contratoList = contratoList;
    }

    @XmlTransient
    public List<Ingreso> getIngresoList() {
        return ingresoList;
    }

    public void setIngresoList(List<Ingreso> ingresoList) {
        this.ingresoList = ingresoList;
    }

    public Direcctionterritorial getDireccionterritorialId() {
        return direccionterritorialId;
    }

    public void setDireccionterritorialId(Direcctionterritorial direccionterritorialId) {
        this.direccionterritorialId = direccionterritorialId;
    }

    public Municipio getMunicipioId() {
        return municipioId;
    }

    public void setMunicipioId(Municipio municipioId) {
        this.municipioId = municipioId;
    }

    public Vereda getVeredaId() {
        return veredaId;
    }

    public void setVeredaId(Vereda veredaId) {
        this.veredaId = veredaId;
    }

    @XmlTransient
    public List<Zonaubicacionanimal> getZonaubicacionanimalList() {
        return zonaubicacionanimalList;
    }

    public void setZonaubicacionanimalList(List<Zonaubicacionanimal> zonaubicacionanimalList) {
        this.zonaubicacionanimalList = zonaubicacionanimalList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (entId != null ? entId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entidad)) {
            return false;
        }
        Entidad other = (Entidad) object;
        if ((this.entId == null && other.entId != null) || (this.entId != null && !this.entId.equals(other.entId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Entidad[ entId=" + entId + " ]";
    }
}
