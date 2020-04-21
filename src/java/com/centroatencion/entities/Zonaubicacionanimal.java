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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author aranda
 */
@Entity
@Table(name = "zonaubicacionanimal", catalog = "hogardepasobd", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Zonaubicacionanimal.findAll", query = "SELECT z FROM Zonaubicacionanimal z"),
    @NamedQuery(name = "Zonaubicacionanimal.findByZonubianId", query = "SELECT z FROM Zonaubicacionanimal z WHERE z.zonubianId = :zonubianId"),
    @NamedQuery(name = "Zonaubicacionanimal.findByZonubianUbicacion", query = "SELECT z FROM Zonaubicacionanimal z WHERE z.zonubianUbicacion = :zonubianUbicacion"),
    @NamedQuery(name = "Zonaubicacionanimal.findByEntidadId", query = "SELECT z FROM Zonaubicacionanimal z WHERE z.entidadId.entId = :entId"),
    @NamedQuery(name = "Zonaubicacionanimal.findByZonaubianArea", query = "SELECT z FROM Zonaubicacionanimal z WHERE z.zonaubianArea = :zonaubianArea")})
public class Zonaubicacionanimal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "zonubianId")
    private Integer zonubianId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "zonubianNombre")
    private String zonubianNombre;
    @Lob
    @Size(max = 65535)
    @Column(name = "zonubianDescripcion")
    private String zonubianDescripcion;
    @Size(max = 50)
    @Column(name = "zonubianUbicacion")
    private String zonubianUbicacion;
    @Column(name = "zonaubianArea")
    private Integer zonaubianArea;
    @JoinColumn(name = "entidadId", referencedColumnName = "entId")
    @ManyToOne(optional = false)
    private Entidad entidadId;
    @JoinColumn(name = "tipozonaubicacionId", referencedColumnName = "tzuId")
    @ManyToOne(optional = false)
    private Tipozonaubicacion tipozonaubicacionId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "zonaubicacionanimalId")
    private List<Asignazona> asignazonaList;

    public Zonaubicacionanimal() {
    }

    public Zonaubicacionanimal(Integer zonubianId) {
        this.zonubianId = zonubianId;
    }

    public Zonaubicacionanimal(Integer zonubianId, String zonubianNombre) {
        this.zonubianId = zonubianId;
        this.zonubianNombre = zonubianNombre;
    }

    public Integer getZonubianId() {
        return zonubianId;
    }

    public void setZonubianId(Integer zonubianId) {
        this.zonubianId = zonubianId;
    }

    public String getZonubianNombre() {
        return zonubianNombre;
    }

    public void setZonubianNombre(String zonubianNombre) {
        this.zonubianNombre = zonubianNombre;
    }

    public String getZonubianDescripcion() {
        return zonubianDescripcion;
    }

    public void setZonubianDescripcion(String zonubianDescripcion) {
        this.zonubianDescripcion = zonubianDescripcion;
    }

    public String getZonubianUbicacion() {
        return zonubianUbicacion;
    }

    public void setZonubianUbicacion(String zonubianUbicacion) {
        this.zonubianUbicacion = zonubianUbicacion;
    }

    public Integer getZonaubianArea() {
        return zonaubianArea;
    }

    public void setZonaubianArea(Integer zonaubianArea) {
        this.zonaubianArea = zonaubianArea;
    }

    public Entidad getEntidadId() {
        return entidadId;
    }

    public void setEntidadId(Entidad entidadId) {
        this.entidadId = entidadId;
    }

    public Tipozonaubicacion getTipozonaubicacionId() {
        return tipozonaubicacionId;
    }

    public void setTipozonaubicacionId(Tipozonaubicacion tipozonaubicacionId) {
        this.tipozonaubicacionId = tipozonaubicacionId;
    }

    @XmlTransient
    public List<Asignazona> getAsignazonaList() {
        return asignazonaList;
    }

    public void setAsignazonaList(List<Asignazona> asignazonaList) {
        this.asignazonaList = asignazonaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (zonubianId != null ? zonubianId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zonaubicacionanimal)) {
            return false;
        }
        Zonaubicacionanimal other = (Zonaubicacionanimal) object;
        if ((this.zonubianId == null && other.zonubianId != null) || (this.zonubianId != null && !this.zonubianId.equals(other.zonubianId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Zonaubicacionanimal[ zonubianId=" + zonubianId + " ]";
    }
    
    
    
}
