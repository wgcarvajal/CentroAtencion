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
@Table(name = "asignazona", catalog = "hogardepasobd", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asignazona.findAll", query = "SELECT a FROM Asignazona a"),
    @NamedQuery(name = "Asignazona.findByAzonaId", query = "SELECT a FROM Asignazona a WHERE a.azonaId = :azonaId"),
    @NamedQuery(name = "Asignazona.findByAzonafechanicial", query = "SELECT a FROM Asignazona a WHERE a.azonafechanicial = :azonafechanicial"),
    @NamedQuery(name = "Asignazona.findByAzonafechafinal", query = "SELECT a FROM Asignazona a WHERE a.azonafechafinal = :azonafechafinal")})
public class Asignazona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "azonaId")
    private Long azonaId;
    @Lob
    @Size(max = 65535)
    @Column(name = "azonaObservaciones")
    private String azonaObservaciones;
    @Basic(optional = false)
    @NotNull
    @Column(name = "azonafechanicial")
    @Temporal(TemporalType.TIMESTAMP)
    private Date azonafechanicial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "azonafechafinal")
    @Temporal(TemporalType.TIMESTAMP)
    private Date azonafechafinal;
    @JoinColumn(name = "entradaid", referencedColumnName = "ingId")
    @ManyToOne(optional = false)
    private Ingreso entradaid;
    @JoinColumn(name = "zonaubicacionanimalId", referencedColumnName = "zonubianId")
    @ManyToOne(optional = false)
    private Zonaubicacionanimal zonaubicacionanimalId;

    public Asignazona() {
    }

    public Asignazona(Long azonaId) {
        this.azonaId = azonaId;
    }

    public Asignazona(Long azonaId, Date azonafechanicial, Date azonafechafinal) {
        this.azonaId = azonaId;
        this.azonafechanicial = azonafechanicial;
        this.azonafechafinal = azonafechafinal;
    }

    public Long getAzonaId() {
        return azonaId;
    }

    public void setAzonaId(Long azonaId) {
        this.azonaId = azonaId;
    }

    public String getAzonaObservaciones() {
        return azonaObservaciones;
    }

    public void setAzonaObservaciones(String azonaObservaciones) {
        this.azonaObservaciones = azonaObservaciones;
    }

    public Date getAzonafechanicial() {
        return azonafechanicial;
    }

    public void setAzonafechanicial(Date azonafechanicial) {
        this.azonafechanicial = azonafechanicial;
    }

    public Date getAzonafechafinal() {
        return azonafechafinal;
    }

    public void setAzonafechafinal(Date azonafechafinal) {
        this.azonafechafinal = azonafechafinal;
    }

    public Ingreso getEntradaid() {
        return entradaid;
    }

    public void setEntradaid(Ingreso entradaid) {
        this.entradaid = entradaid;
    }

    public Zonaubicacionanimal getZonaubicacionanimalId() {
        return zonaubicacionanimalId;
    }

    public void setZonaubicacionanimalId(Zonaubicacionanimal zonaubicacionanimalId) {
        this.zonaubicacionanimalId = zonaubicacionanimalId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (azonaId != null ? azonaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asignazona)) {
            return false;
        }
        Asignazona other = (Asignazona) object;
        if ((this.azonaId == null && other.azonaId != null) || (this.azonaId != null && !this.azonaId.equals(other.azonaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.centroatencion.entities.Asignazona[ azonaId=" + azonaId + " ]";
    }
    
}
