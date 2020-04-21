/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.entities;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author aranda
 */
@Entity
@Table(name = "denunciaaudios", catalog = "hogardepasobd", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Denunciaaudios.findAll", query = "SELECT d FROM Denunciaaudios d"),
    @NamedQuery(name = "Denunciaaudios.findByDauId", query = "SELECT d FROM Denunciaaudios d WHERE d.dauId = :dauId"),
    @NamedQuery(name = "Denunciaaudios.findByDauNombre", query = "SELECT d FROM Denunciaaudios d WHERE d.dauNombre = :dauNombre")})
public class Denunciaaudios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "dauId")
    private Long dauId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dauNombre")
    private int dauNombre;
    @JoinColumn(name = "denId", referencedColumnName = "denId")
    @ManyToOne(optional = false)
    private Denuncia denId;

    public Denunciaaudios() {
    }

    public Denunciaaudios(Long dauId) {
        this.dauId = dauId;
    }

    public Denunciaaudios(Long dauId, int dauNombre) {
        this.dauId = dauId;
        this.dauNombre = dauNombre;
    }

    public Long getDauId() {
        return dauId;
    }

    public void setDauId(Long dauId) {
        this.dauId = dauId;
    }

    public int getDauNombre() {
        return dauNombre;
    }

    public void setDauNombre(int dauNombre) {
        this.dauNombre = dauNombre;
    }

    public Denuncia getDenId() {
        return denId;
    }

    public void setDenId(Denuncia denId) {
        this.denId = denId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dauId != null ? dauId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Denunciaaudios)) {
            return false;
        }
        Denunciaaudios other = (Denunciaaudios) object;
        if ((this.dauId == null && other.dauId != null) || (this.dauId != null && !this.dauId.equals(other.dauId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.centroatencion.entities.Denunciaaudios[ dauId=" + dauId + " ]";
    }
    
}
