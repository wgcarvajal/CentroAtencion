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
@Table(name = "asignacargo", catalog = "hogardepasobd", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asignacargo.findAll", query = "SELECT a FROM Asignacargo a"),
    @NamedQuery(name = "Asignacargo.currentCargo", query = "SELECT a.cargoId FROM Asignacargo a WHERE a.perId.perId = :perId AND a.asigCargoFechaFinal IS NULL"),
    @NamedQuery(name = "Asignacargo.findByAsigCargoId", query = "SELECT a FROM Asignacargo a WHERE a.asigCargoId = :asigCargoId"),
    @NamedQuery(name = "Asignacargo.findByAsigCargoFechaInicial", query = "SELECT a FROM Asignacargo a WHERE a.asigCargoFechaInicial = :asigCargoFechaInicial"),
    @NamedQuery(name = "Asignacargo.findByAsigCargoFechaFinal", query = "SELECT a FROM Asignacargo a WHERE a.asigCargoFechaFinal = :asigCargoFechaFinal")})
public class Asignacargo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "asigCargoId")
    private Long asigCargoId;
    @Basic(optional = false)
    @Column(name = "asigCargoFechaInicial")
    @Temporal(TemporalType.TIMESTAMP)
    private Date asigCargoFechaInicial;
    @Column(name = "asigCargoFechaFinal")
    @Temporal(TemporalType.TIMESTAMP)
    private Date asigCargoFechaFinal;
    @JoinColumn(name = "cargoId", referencedColumnName = "cargoId")
    @ManyToOne(optional = false)
    private Cargo cargoId;
    @JoinColumn(name = "perId", referencedColumnName = "perId")
    @ManyToOne(optional = false)
    private Persona perId;

    public Asignacargo() {
    }

    public Asignacargo(Long asigCargoId) {
        this.asigCargoId = asigCargoId;
    }

    public Asignacargo(Long asigCargoId, Date asigCargoFechaInicial) {
        this.asigCargoId = asigCargoId;
        this.asigCargoFechaInicial = asigCargoFechaInicial;
    }

    public Long getAsigCargoId() {
        return asigCargoId;
    }

    public void setAsigCargoId(Long asigCargoId) {
        this.asigCargoId = asigCargoId;
    }

    public Date getAsigCargoFechaInicial() {
        return asigCargoFechaInicial;
    }

    public void setAsigCargoFechaInicial(Date asigCargoFechaInicial) {
        this.asigCargoFechaInicial = asigCargoFechaInicial;
    }

    public Date getAsigCargoFechaFinal() {
        return asigCargoFechaFinal;
    }

    public void setAsigCargoFechaFinal(Date asigCargoFechaFinal) {
        this.asigCargoFechaFinal = asigCargoFechaFinal;
    }

    public Cargo getCargoId() {
        return cargoId;
    }

    public void setCargoId(Cargo cargoId) {
        this.cargoId = cargoId;
    }

    public Persona getPerId() {
        return perId;
    }

    public void setPerId(Persona perId) {
        this.perId = perId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (asigCargoId != null ? asigCargoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asignacargo)) {
            return false;
        }
        Asignacargo other = (Asignacargo) object;
        if ((this.asigCargoId == null && other.asigCargoId != null) || (this.asigCargoId != null && !this.asigCargoId.equals(other.asigCargoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Asignacargo[ asigCargoId=" + asigCargoId + " ]";
    }
    
}
