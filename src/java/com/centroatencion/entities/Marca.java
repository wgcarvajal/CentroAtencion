/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.entities;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author aranda
 */
@Entity
@Table(name = "marca", catalog = "hogardepasobd", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Marca.findAll", query = "SELECT m FROM Marca m"),
    @NamedQuery(name = "Marca.findByMarcId", query = "SELECT m FROM Marca m WHERE m.marcId = :marcId")})
public class Marca implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "marcId")
    private Long marcId;
    @JoinColumn(name = "ingresoId", referencedColumnName = "ingId")
    @ManyToOne(optional = false)
    private Ingreso ingresoId;
    @JoinColumn(name = "tipomarcaid", referencedColumnName = "tipomarcId")
    @ManyToOne(optional = false)
    private Tipomarca tipomarcaid;
    @JoinColumn(name = "ubicacionmarcaId", referencedColumnName = "ubicacionmarcId")
    @ManyToOne(optional = false)
    private Ubicacionmarca ubicacionmarcaId;
    @OneToMany(mappedBy = "marcaId")
    private List<Ingreso> ingresoList;

    public Marca() {
    }

    public Marca(Long marcId) {
        this.marcId = marcId;
    }

    public Long getMarcId() {
        return marcId;
    }

    public void setMarcId(Long marcId) {
        this.marcId = marcId;
    }

    public Ingreso getIngresoId() {
        return ingresoId;
    }

    public void setIngresoId(Ingreso ingresoId) {
        this.ingresoId = ingresoId;
    }

    public Tipomarca getTipomarcaid() {
        return tipomarcaid;
    }

    public void setTipomarcaid(Tipomarca tipomarcaid) {
        this.tipomarcaid = tipomarcaid;
    }

    public Ubicacionmarca getUbicacionmarcaId() {
        return ubicacionmarcaId;
    }

    public void setUbicacionmarcaId(Ubicacionmarca ubicacionmarcaId) {
        this.ubicacionmarcaId = ubicacionmarcaId;
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
        hash += (marcId != null ? marcId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Marca)) {
            return false;
        }
        Marca other = (Marca) object;
        if ((this.marcId == null && other.marcId != null) || (this.marcId != null && !this.marcId.equals(other.marcId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.centroatencion.entities.Marca[ marcId=" + marcId + " ]";
    }
    
}
