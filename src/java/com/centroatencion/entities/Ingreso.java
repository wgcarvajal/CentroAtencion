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
 * @author aranda
 */
@Entity
@Table(name = "ingreso", catalog = "hogardepasobd", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ingreso.findAll", query = "SELECT i FROM Ingreso i"),
    @NamedQuery(name = "Ingreso.findByIngId", query = "SELECT i FROM Ingreso i WHERE i.ingId = :ingId"),
    @NamedQuery(name = "Ingreso.findByIngNumeroRadicado", query = "SELECT i FROM Ingreso i WHERE i.ingRadicado = :ingRadicado"),
    @NamedQuery(name = "Ingreso.findByIngFecha", query = "SELECT i FROM Ingreso i WHERE i.ingFecha = :ingFecha"),
    @NamedQuery(name = "Ingreso.findByIngNumeroUCTFF", query = "SELECT i FROM Ingreso i WHERE i.ingAUCTFF = :ingAUCTFF")})
public class Ingreso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ingId")
    private Long ingId;
    @Basic(optional = false)
    @Column(name = "ingFecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ingFecha;
    @Column(name = "ingRadicado")
    private String ingRadicado;
    @Column(name = "ingAUCTFF")
    private String ingAUCTFF;
    @Basic(optional = false)
    @Column(name = "ingConsecutivo")
    private long ingConsecutivo;
    @Basic(optional = false)
    @Column(name = "ingEstado")
    private int ingEstado;
    @JoinColumn(name = "animalId", referencedColumnName = "anId")
    @ManyToOne(optional = false)
    private Animal animalId;
    @JoinColumn(name = "dirterId", referencedColumnName = "dirterId")
    @ManyToOne(optional = false)
    private Direcctionterritorial dirterId;
    @JoinColumn(name = "funcionarioId", referencedColumnName = "perId")
    @ManyToOne(optional = false)
    private Persona funcionarioId;

    public Ingreso() {
    }

    public Ingreso(Long ingId) {
        this.ingId = ingId;
    }

    public Ingreso(Long ingId, Date ingFecha, long ingConsecutivo, int ingEstado) {
        this.ingId = ingId;
        this.ingFecha = ingFecha;
        this.ingConsecutivo = ingConsecutivo;
        this.ingEstado = ingEstado;
    }

    public Long getIngId() {
        return ingId;
    }

    public void setIngId(Long ingId) {
        this.ingId = ingId;
    }

    public Date getIngFecha() {
        return ingFecha;
    }

    public void setIngFecha(Date ingFecha) {
        this.ingFecha = ingFecha;
    }

    public String getIngRadicado() {
        return ingRadicado;
    }

    public void setIngRadicado(String ingRadicado) {
        this.ingRadicado = ingRadicado;
    }

    public String getIngAUCTFF() {
        return ingAUCTFF;
    }

    public void setIngAUCTFF(String ingAUCTFF) {
        this.ingAUCTFF = ingAUCTFF;
    }

    public long getIngConsecutivo() {
        return ingConsecutivo;
    }

    public void setIngConsecutivo(long ingConsecutivo) {
        this.ingConsecutivo = ingConsecutivo;
    }

    public int getIngEstado() {
        return ingEstado;
    }

    public void setIngEstado(int ingEstado) {
        this.ingEstado = ingEstado;
    }

    public Animal getAnimalId() {
        return animalId;
    }

    public void setAnimalId(Animal animalId) {
        this.animalId = animalId;
    }

    public Direcctionterritorial getDirterId() {
        return dirterId;
    }

    public void setDirterId(Direcctionterritorial dirterId) {
        this.dirterId = dirterId;
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
        hash += (ingId != null ? ingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ingreso)) {
            return false;
        }
        Ingreso other = (Ingreso) object;
        if ((this.ingId == null && other.ingId != null) || (this.ingId != null && !this.ingId.equals(other.ingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Ingreso[ ingId=" + ingId + " ]";
    }
    
}
