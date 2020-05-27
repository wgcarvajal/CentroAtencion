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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author aranda
 */
@Entity
@Table(name = "estado", catalog = "hogardepasobd", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estado.findAll", query = "SELECT e FROM Estado e"),
    @NamedQuery(name = "Estado.findCurrentEstado", query = "SELECT e FROM Estado e WHERE e.ingId.ingId = :ingId ORDER BY e.estadoFecha DESC"),
    @NamedQuery(name = "Estado.findByEstadoId", query = "SELECT e FROM Estado e WHERE e.estadoId = :estadoId"),
    @NamedQuery(name = "Estado.findByEstado", query = "SELECT e FROM Estado e WHERE e.estado = :estado"),
    @NamedQuery(name = "Estado.findByEstadoFecha", query = "SELECT e FROM Estado e WHERE e.estadoFecha = :estadoFecha")})
public class Estado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "estadoId")
    private Long estadoId;
    @Basic(optional = false)
    @Column(name = "estado")
    private int estado;
    @Basic(optional = false)
    @Column(name = "estadoFecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date estadoFecha;
    @Column(name = "estadoCausa")
    private Integer estadoCausa;
    @Column(name = "estadoSubproducto")
    private Boolean estadoSubproducto;
    @Lob
    @Column(name = "estadoCausaDescripcion")
    private String estadoCausaDescripcion;
    @JoinColumn(name = "ingId", referencedColumnName = "ingId")
    @ManyToOne(optional = false)
    private Ingreso ingId;
    @JoinColumn(name = "ingCurrentId", referencedColumnName = "ingId")
    @ManyToOne(optional = false)
    private Ingreso ingCurrentId;

    public Estado() {
    }

    public Estado(Long estadoId) {
        this.estadoId = estadoId;
    }

    public Estado(Long estadoId, int estado, Date estadoFecha) {
        this.estadoId = estadoId;
        this.estado = estado;
        this.estadoFecha = estadoFecha;
    }

    public Long getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Long estadoId) {
        this.estadoId = estadoId;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Date getEstadoFecha() {
        return estadoFecha;
    }

    public void setEstadoFecha(Date estadoFecha) {
        this.estadoFecha = estadoFecha;
    }

    public Integer getEstadoCausa() {
        return estadoCausa;
    }

    public void setEstadoCausa(Integer estadoCausa) {
        this.estadoCausa = estadoCausa;
    }

    public Boolean getEstadoSubproducto() {
        return estadoSubproducto;
    }

    public void setEstadoSubproducto(Boolean estadoSubproducto) {
        this.estadoSubproducto = estadoSubproducto;
    }

    public String getEstadoCausaDescripcion() {
        return estadoCausaDescripcion;
    }

    public void setEstadoCausaDescripcion(String estadoCausaDescripcion) {
        this.estadoCausaDescripcion = estadoCausaDescripcion;
    }

    public Ingreso getIngId() {
        return ingId;
    }

    public void setIngId(Ingreso ingId) {
        this.ingId = ingId;
    }

    public Ingreso getIngCurrentId() {
        return ingCurrentId;
    }

    public void setIngCurrentId(Ingreso ingCurrentId) {
        this.ingCurrentId = ingCurrentId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estadoId != null ? estadoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estado)) {
            return false;
        }
        Estado other = (Estado) object;
        if ((this.estadoId == null && other.estadoId != null) || (this.estadoId != null && !this.estadoId.equals(other.estadoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Estado[ estadoId=" + estadoId + " ]";
    }
    
}
