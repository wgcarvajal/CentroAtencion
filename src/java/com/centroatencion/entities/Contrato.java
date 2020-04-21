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

@Entity
@Table(name = "contrato", catalog = "hogardepasobd", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contrato.findAll", query = "SELECT c FROM Contrato c"),
    @NamedQuery(name = "Contrato.findByContId", query = "SELECT c FROM Contrato c WHERE c.contId = :contId"),
    @NamedQuery(name = "Contrato.findByContFechaInicial", query = "SELECT c FROM Contrato c WHERE c.contFechaInicial = :contFechaInicial"),
    @NamedQuery(name = "Contrato.findByContFechaFinal", query = "SELECT c FROM Contrato c WHERE c.contFechaFinal = :contFechaFinal")})
public class Contrato implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "contId")
    private Long contId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "contFechaInicial")
    @Temporal(TemporalType.TIMESTAMP)
    private Date contFechaInicial;
    @Column(name = "contFechaFinal")
    @Temporal(TemporalType.TIMESTAMP)
    private Date contFechaFinal;
    @JoinColumn(name = "cargoId", referencedColumnName = "carid")
    @ManyToOne
    private Cargo cargoId;
    @JoinColumn(name = "entId", referencedColumnName = "entId")
    @ManyToOne(optional = false)
    private Entidad entId;
    @JoinColumn(name = "perId", referencedColumnName = "perId")
    @ManyToOne(optional = false)
    private Persona perId;

    public Contrato() {
    }

    public Contrato(Long contId) {
        this.contId = contId;
    }

    public Contrato(Long contId, Date contFechaInicial) {
        this.contId = contId;
        this.contFechaInicial = contFechaInicial;
    }

    public Long getContId() {
        return contId;
    }

    public void setContId(Long contId) {
        this.contId = contId;
    }

    public Date getContFechaInicial() {
        return contFechaInicial;
    }

    public void setContFechaInicial(Date contFechaInicial) {
        this.contFechaInicial = contFechaInicial;
    }

    public Date getContFechaFinal() {
        return contFechaFinal;
    }

    public void setContFechaFinal(Date contFechaFinal) {
        this.contFechaFinal = contFechaFinal;
    }

    public Cargo getCargoId() {
        return cargoId;
    }

    public void setCargoId(Cargo cargoId) {
        this.cargoId = cargoId;
    }

    public Entidad getEntId() {
        return entId;
    }

    public void setEntId(Entidad entId) {
        this.entId = entId;
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
        hash += (contId != null ? contId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contrato)) {
            return false;
        }
        Contrato other = (Contrato) object;
        if ((this.contId == null && other.contId != null) || (this.contId != null && !this.contId.equals(other.contId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Contrato[ contId=" + contId + " ]";
    }
    
}
