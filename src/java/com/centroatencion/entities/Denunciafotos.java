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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author aranda
 */
@Entity
@Table(name = "denunciafotos", catalog = "hogardepasobd", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Denunciafotos.findAll", query = "SELECT d FROM Denunciafotos d"),
    @NamedQuery(name = "Denunciafotos.findByDfotId", query = "SELECT d FROM Denunciafotos d WHERE d.dfotId = :dfotId"),
    @NamedQuery(name = "Denunciafotos.findByDfotNombre", query = "SELECT d FROM Denunciafotos d WHERE d.dfotNombre = :dfotNombre")})
public class Denunciafotos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "dfotId")
    private Long dfotId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "dfotNombre")
    private String dfotNombre;
    @JoinColumn(name = "denId", referencedColumnName = "denId")
    @ManyToOne(optional = false)
    private Denuncia denId;

    public Denunciafotos() {
    }

    public Denunciafotos(Long dfotId) {
        this.dfotId = dfotId;
    }

    public Denunciafotos(Long dfotId, String dfotNombre) {
        this.dfotId = dfotId;
        this.dfotNombre = dfotNombre;
    }

    public Long getDfotId() {
        return dfotId;
    }

    public void setDfotId(Long dfotId) {
        this.dfotId = dfotId;
    }

    public String getDfotNombre() {
        return dfotNombre;
    }

    public void setDfotNombre(String dfotNombre) {
        this.dfotNombre = dfotNombre;
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
        hash += (dfotId != null ? dfotId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Denunciafotos)) {
            return false;
        }
        Denunciafotos other = (Denunciafotos) object;
        if ((this.dfotId == null && other.dfotId != null) || (this.dfotId != null && !this.dfotId.equals(other.dfotId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.centroatencion.entities.Denunciafotos[ dfotId=" + dfotId + " ]";
    }
    
}
