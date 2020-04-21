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
import javax.persistence.Lob;
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
@Table(name = "denuncia", catalog = "hogardepasobd", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Denuncia.findAll", query = "SELECT d FROM Denuncia d"),
    @NamedQuery(name = "Denuncia.findByDenId", query = "SELECT d FROM Denuncia d WHERE d.denId = :denId"),
    @NamedQuery(name = "Denuncia.findByDenPersonaNombre", query = "SELECT d FROM Denuncia d WHERE d.denPersonaNombre = :denPersonaNombre"),
    @NamedQuery(name = "Denuncia.findByDenUbicacion", query = "SELECT d FROM Denuncia d WHERE d.denUbicacion = :denUbicacion"),
    @NamedQuery(name = "Denuncia.findByDenTelefono", query = "SELECT d FROM Denuncia d WHERE d.denTelefono = :denTelefono")})
public class Denuncia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "denId")
    private Long denId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "denPersonaNombre")
    private String denPersonaNombre;
    @Lob
    @Size(max = 65535)
    @Column(name = "denDescripcion")
    private String denDescripcion;
    @Lob
    @Size(max = 65535)
    @Column(name = "denLugar")
    private String denLugar;
    @Column(name = "denUbicacion")
    private Integer denUbicacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "denTelefono")
    private String denTelefono;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "denId")
    private List<Denunciaaudios> denunciaaudiosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "denId")
    private List<Denunciafotos> denunciafotosList;
    @OneToMany(mappedBy = "denunciaId")
    private List<Ingreso> ingresoList;

    public Denuncia() {
    }

    public Denuncia(Long denId) {
        this.denId = denId;
    }

    public Denuncia(Long denId, String denPersonaNombre, String denTelefono) {
        this.denId = denId;
        this.denPersonaNombre = denPersonaNombre;
        this.denTelefono = denTelefono;
    }

    public Long getDenId() {
        return denId;
    }

    public void setDenId(Long denId) {
        this.denId = denId;
    }

    public String getDenPersonaNombre() {
        return denPersonaNombre;
    }

    public void setDenPersonaNombre(String denPersonaNombre) {
        this.denPersonaNombre = denPersonaNombre;
    }

    public String getDenDescripcion() {
        return denDescripcion;
    }

    public void setDenDescripcion(String denDescripcion) {
        this.denDescripcion = denDescripcion;
    }

    public String getDenLugar() {
        return denLugar;
    }

    public void setDenLugar(String denLugar) {
        this.denLugar = denLugar;
    }

    public Integer getDenUbicacion() {
        return denUbicacion;
    }

    public void setDenUbicacion(Integer denUbicacion) {
        this.denUbicacion = denUbicacion;
    }

    public String getDenTelefono() {
        return denTelefono;
    }

    public void setDenTelefono(String denTelefono) {
        this.denTelefono = denTelefono;
    }

    @XmlTransient
    public List<Denunciaaudios> getDenunciaaudiosList() {
        return denunciaaudiosList;
    }

    public void setDenunciaaudiosList(List<Denunciaaudios> denunciaaudiosList) {
        this.denunciaaudiosList = denunciaaudiosList;
    }

    @XmlTransient
    public List<Denunciafotos> getDenunciafotosList() {
        return denunciafotosList;
    }

    public void setDenunciafotosList(List<Denunciafotos> denunciafotosList) {
        this.denunciafotosList = denunciafotosList;
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
        hash += (denId != null ? denId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Denuncia)) {
            return false;
        }
        Denuncia other = (Denuncia) object;
        if ((this.denId == null && other.denId != null) || (this.denId != null && !this.denId.equals(other.denId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.centroatencion.entities.Denuncia[ denId=" + denId + " ]";
    }
    
}
