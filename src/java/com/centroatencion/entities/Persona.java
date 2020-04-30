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
 * @author Wilson Carvajal
 */
@Entity
@Table(name = "persona", catalog = "hogardepasobd", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p"),
    @NamedQuery(name = "Persona.findByPerId", query = "SELECT p FROM Persona p WHERE p.perId = :perId"),
    @NamedQuery(name = "Persona.findByPerIdentificacion", query = "SELECT p FROM Persona p WHERE p.perIdentificacion = :perIdentificacion"),
    @NamedQuery(name = "Persona.findByPerNombres", query = "SELECT p FROM Persona p WHERE p.perNombres = :perNombres"),
    @NamedQuery(name = "Persona.findByPerApellidos", query = "SELECT p FROM Persona p WHERE p.perApellidos = :perApellidos"),
    @NamedQuery(name = "Persona.findByPerdireccion", query = "SELECT p FROM Persona p WHERE p.perdireccion = :perdireccion"),
    @NamedQuery(name = "Persona.findByPertelefono", query = "SELECT p FROM Persona p WHERE p.pertelefono = :pertelefono"),
    @NamedQuery(name = "Persona.findByUsuNombreUsuario", query = "SELECT p FROM Persona p WHERE p.usuarioId.usuNombreUsuario = :usuNombreUsuario"),
    @NamedQuery(name = "Persona.findByPerEmail", query = "SELECT p FROM Persona p WHERE p.perEmail = :perEmail")})
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "perId")
    private Long perId;
    @Basic(optional = false)
    @Column(name = "perIdentificacion")
    private String perIdentificacion;
    @Basic(optional = false)
    @Column(name = "perNombres")
    private String perNombres;
    @Basic(optional = false)
    @Column(name = "perApellidos")
    private String perApellidos;
    @Column(name = "perdireccion")
    private String perdireccion;
    @Column(name = "pertelefono")
    private String pertelefono;
    @Column(name = "perEmail")
    private String perEmail;
    @JoinColumn(name = "municipioId", referencedColumnName = "munId")
    @ManyToOne
    private Municipio municipioId;
    @JoinColumn(name = "tipoidentificacionId", referencedColumnName = "tipidentId")
    @ManyToOne
    private Tipoidentificacion tipoidentificacionId;
    @JoinColumn(name = "usuarioId", referencedColumnName = "usuId")
    @ManyToOne(optional = false)
    private Usuario usuarioId;
    @JoinColumn(name = "veredaId", referencedColumnName = "verId")
    @ManyToOne
    private Vereda veredaId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "funcionarioId")
    private List<Ingreso> ingresoList;

    public Persona() {
    }

    public Persona(Long perId) {
        this.perId = perId;
    }

    public Persona(Long perId, String perIdentificacion, String perNombres, String perApellidos) {
        this.perId = perId;
        this.perIdentificacion = perIdentificacion;
        this.perNombres = perNombres;
        this.perApellidos = perApellidos;
    }

    public Long getPerId() {
        return perId;
    }

    public void setPerId(Long perId) {
        this.perId = perId;
    }

    public String getPerIdentificacion() {
        return perIdentificacion;
    }

    public void setPerIdentificacion(String perIdentificacion) {
        this.perIdentificacion = perIdentificacion;
    }

    public String getPerNombres() {
        return perNombres;
    }

    public void setPerNombres(String perNombres) {
        this.perNombres = perNombres;
    }

    public String getPerApellidos() {
        return perApellidos;
    }

    public void setPerApellidos(String perApellidos) {
        this.perApellidos = perApellidos;
    }

    public String getPerdireccion() {
        return perdireccion;
    }

    public void setPerdireccion(String perdireccion) {
        this.perdireccion = perdireccion;
    }

    public String getPertelefono() {
        return pertelefono;
    }

    public void setPertelefono(String pertelefono) {
        this.pertelefono = pertelefono;
    }

    public String getPerEmail() {
        return perEmail;
    }

    public void setPerEmail(String perEmail) {
        this.perEmail = perEmail;
    }

    public Municipio getMunicipioId() {
        return municipioId;
    }

    public void setMunicipioId(Municipio municipioId) {
        this.municipioId = municipioId;
    }

    public Tipoidentificacion getTipoidentificacionId() {
        return tipoidentificacionId;
    }

    public void setTipoidentificacionId(Tipoidentificacion tipoidentificacionId) {
        this.tipoidentificacionId = tipoidentificacionId;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Vereda getVeredaId() {
        return veredaId;
    }

    public void setVeredaId(Vereda veredaId) {
        this.veredaId = veredaId;
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
        hash += (perId != null ? perId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.perId == null && other.perId != null) || (this.perId != null && !this.perId.equals(other.perId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Persona[ perId=" + perId + " ]";
    }
    
}
