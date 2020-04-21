/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author aranda
 */
@Entity
@Table(name = "desarrollobiologico", catalog = "hogardepasobd", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Desarrollobiologico.findAll", query = "SELECT d FROM Desarrollobiologico d"),
    @NamedQuery(name = "Desarrollobiologico.findByDesbioId", query = "SELECT d FROM Desarrollobiologico d WHERE d.desbioId = :desbioId"),
    @NamedQuery(name = "Desarrollobiologico.findByDesbioEstado", query = "SELECT d FROM Desarrollobiologico d WHERE d.desbioEstado = :desbioEstado"),
    @NamedQuery(name = "Desarrollobiologico.findByDesbioEstadoAbreviatura", query = "SELECT d FROM Desarrollobiologico d WHERE d.desbioEstadoAbreviatura = :desbioEstadoAbreviatura")})
public class Desarrollobiologico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "desbioId")
    private Integer desbioId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "desbioEstado")
    private String desbioEstado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "desbioEstadoAbreviatura")
    private String desbioEstadoAbreviatura;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "desarrollobiologicoId")
    private List<Ingreso> ingresoList;

    public Desarrollobiologico() {
    }

    public Desarrollobiologico(Integer desbioId) {
        this.desbioId = desbioId;
    }

    public Desarrollobiologico(Integer desbioId, String desbioEstado, String desbioEstadoAbreviatura) {
        this.desbioId = desbioId;
        this.desbioEstado = desbioEstado;
        this.desbioEstadoAbreviatura = desbioEstadoAbreviatura;
    }

    public Integer getDesbioId() {
        return desbioId;
    }

    public void setDesbioId(Integer desbioId) {
        this.desbioId = desbioId;
    }

    public String getDesbioEstado() {
        return desbioEstado;
    }

    public void setDesbioEstado(String desbioEstado) {
        this.desbioEstado = desbioEstado;
    }

    public String getDesbioEstadoAbreviatura() {
        return desbioEstadoAbreviatura;
    }

    public void setDesbioEstadoAbreviatura(String desbioEstadoAbreviatura) {
        this.desbioEstadoAbreviatura = desbioEstadoAbreviatura;
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
        hash += (desbioId != null ? desbioId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Desarrollobiologico)) {
            return false;
        }
        Desarrollobiologico other = (Desarrollobiologico) object;
        if ((this.desbioId == null && other.desbioId != null) || (this.desbioId != null && !this.desbioId.equals(other.desbioId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.centroatencion.entities.Desarrollobiologico[ desbioId=" + desbioId + " ]";
    }
    
}
