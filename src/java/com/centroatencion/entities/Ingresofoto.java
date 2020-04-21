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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author aranda
 */
@Entity
@Table(name = "ingresofoto", catalog = "hogardepasobd", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ingresofoto.findAll", query = "SELECT i FROM Ingresofoto i"),
    @NamedQuery(name = "Ingresofoto.findByIngfotoId", query = "SELECT i FROM Ingresofoto i WHERE i.ingfotoId = :ingfotoId"),
    @NamedQuery(name = "Ingresofoto.findByIngfotoNombre", query = "SELECT i FROM Ingresofoto i WHERE i.ingfotoNombre = :ingfotoNombre")})
public class Ingresofoto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ingfotoId")
    private Long ingfotoId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ingfotoNombre")
    private int ingfotoNombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ingfotoFecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ingfotoFecha;
    @JoinColumn(name = "ingresoId", referencedColumnName = "ingId")
    @ManyToOne(optional = false)
    private Ingreso ingresoId;

    public Ingresofoto() {
    }

    public Ingresofoto(Long ingfotoId) {
        this.ingfotoId = ingfotoId;
    }

    public Ingresofoto(Long ingfotoId, int ingfotoNombre, Date ingfotoFecha) {
        this.ingfotoId = ingfotoId;
        this.ingfotoNombre = ingfotoNombre;
        this.ingfotoFecha = ingfotoFecha;
    }

    public Long getIngfotoId() {
        return ingfotoId;
    }

    public void setIngfotoId(Long ingfotoId) {
        this.ingfotoId = ingfotoId;
    }

    public int getIngfotoNombre() {
        return ingfotoNombre;
    }

    public void setIngfotoNombre(int ingfotoNombre) {
        this.ingfotoNombre = ingfotoNombre;
    }

    public Date getIngfotoFecha() {
        return ingfotoFecha;
    }

    public void setIngfotoFecha(Date ingfotoFecha) {
        this.ingfotoFecha = ingfotoFecha;
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
        hash += (ingfotoId != null ? ingfotoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ingresofoto)) {
            return false;
        }
        Ingresofoto other = (Ingresofoto) object;
        if ((this.ingfotoId == null && other.ingfotoId != null) || (this.ingfotoId != null && !this.ingfotoId.equals(other.ingfotoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Ingresofoto[ ingfotoId=" + ingfotoId + " ]";
    }
    
}
