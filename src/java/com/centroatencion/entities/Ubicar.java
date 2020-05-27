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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Wilson Carvajal
 */
@Entity
@Table(name = "ubicar", catalog = "hogardepasobd", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ubicar.findAll", query = "SELECT r FROM Ubicar r"),
    @NamedQuery(name = "Ubicar.searchByIngresoId", query = "SELECT r FROM Ubicar r WHERE r.ingId.ingId = :ingId ORDER BY r.ubFecha ASC"),
    @NamedQuery(name = "Ubicar.searchByIngresoIdDesc", query = "SELECT r FROM Ubicar r WHERE r.ingId.ingId = :ingId ORDER BY r.ubFecha DESC"),
    @NamedQuery(name = "Ubicar.existByIngresoId", query = "SELECT r FROM Ubicar r WHERE r.ingId.ingId = :ingId"),
    @NamedQuery(name = "Ubicar.findByReubId", query = "SELECT r FROM Ubicar r WHERE r.ubId = :ubId"),
    @NamedQuery(name = "Ubicar.findByReubFecha", query = "SELECT r FROM Ubicar r WHERE r.ubFecha = :ubFecha")})
public class Ubicar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ubId")
    private Long ubId;
    @Basic(optional = false)
    @Column(name = "ubFecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ubFecha;
    @JoinColumn(name = "entterId", referencedColumnName = "entterId")
    @ManyToOne(optional = false)
    private Entidadterritorial entterId;
    @JoinColumn(name = "ingId", referencedColumnName = "ingId")
    @ManyToOne(optional = false)
    private Ingreso ingId;
    @JoinColumn(name = "funcionarioId", referencedColumnName = "perId")
    @ManyToOne(optional = false)
    private Persona funcionarioId;

    public Ubicar() {
    }

    public Ubicar(Long ubId) {
        this.ubId = ubId;
    }

    public Ubicar(Long ubId, Date ubFecha) {
        this.ubId = ubId;
        this.ubFecha = ubFecha;
    }

    public Long getUbId() {
        return ubId;
    }

    public void setUbId(Long ubId) {
        this.ubId = ubId;
    }

    public Date getUbFecha() {
        return ubFecha;
    }

    public void setUbFecha(Date ubFecha) {
        this.ubFecha = ubFecha;
    }

    public Entidadterritorial getEntterId() {
        return entterId;
    }

    public void setEntterId(Entidadterritorial entterId) {
        this.entterId = entterId;
    }

    public Ingreso getIngId() {
        return ingId;
    }

    public void setIngId(Ingreso ingId) {
        this.ingId = ingId;
    }

    public Persona getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(Persona funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ubId != null ? ubId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ubicar)) {
            return false;
        }
        Ubicar other = (Ubicar) object;
        if ((this.ubId == null && other.ubId != null) || (this.ubId != null && !this.ubId.equals(other.ubId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Ubicar[ ubId=" + ubId + " ]";
    }
    
}
