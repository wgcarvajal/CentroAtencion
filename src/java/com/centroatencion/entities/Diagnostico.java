/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author aranda
 */
@Entity
@Table(name = "diagnostico", catalog = "hogardepasobd", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Diagnostico.findAll", query = "SELECT d FROM Diagnostico d"),
    @NamedQuery(name = "Diagnostico.findByDiagId", query = "SELECT d FROM Diagnostico d WHERE d.diagId = :diagId"),
    @NamedQuery(name = "Diagnostico.findByDiagFecha", query = "SELECT d FROM Diagnostico d WHERE d.diagFecha = :diagFecha")})
public class Diagnostico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "diagId")
    private Long diagId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "diagFecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date diagFecha;
    @Lob
    @Size(max = 65535)
    @Column(name = "diagPresuntivo")
    private String diagPresuntivo;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "diagObervacion")
    private String diagObervacion;
    @JoinColumn(name = "ingresoId", referencedColumnName = "ingId")
    @ManyToOne(optional = false)
    private Ingreso ingresoId;

    public Diagnostico() {
    }

    public Diagnostico(Long diagId) {
        this.diagId = diagId;
    }

    public Diagnostico(Long diagId, Date diagFecha, String diagObervacion) {
        this.diagId = diagId;
        this.diagFecha = diagFecha;
        this.diagObervacion = diagObervacion;
    }

    public Long getDiagId() {
        return diagId;
    }

    public void setDiagId(Long diagId) {
        this.diagId = diagId;
    }

    public Date getDiagFecha() {
        return diagFecha;
    }

    public void setDiagFecha(Date diagFecha) {
        this.diagFecha = diagFecha;
    }

    public String getDiagPresuntivo() {
        return diagPresuntivo;
    }

    public void setDiagPresuntivo(String diagPresuntivo) {
        this.diagPresuntivo = diagPresuntivo;
    }

    public String getDiagObervacion() {
        return diagObervacion;
    }

    public void setDiagObervacion(String diagObervacion) {
        this.diagObervacion = diagObervacion;
    }

    public Ingreso getIngresoId() {
        return ingresoId;
    }

    public void setIngresoId(Ingreso ingresoId) {
        this.ingresoId = ingresoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (diagId != null ? diagId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Diagnostico)) {
            return false;
        }
        Diagnostico other = (Diagnostico) object;
        if ((this.diagId == null && other.diagId != null) || (this.diagId != null && !this.diagId.equals(other.diagId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.centroatencion.entities.Diagnostico[ diagId=" + diagId + " ]";
    }
    
}
