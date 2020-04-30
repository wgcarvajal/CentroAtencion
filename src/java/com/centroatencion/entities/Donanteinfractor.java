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
@Table(name = "donanteinfractor", catalog = "hogardepasobd", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Donanteinfractor.findAll", query = "SELECT d FROM Donanteinfractor d"),
    @NamedQuery(name = "Donanteinfractor.findByDoninId", query = "SELECT d FROM Donanteinfractor d WHERE d.doninId = :doninId"),
    @NamedQuery(name = "Donanteinfractor.findByDoninIdentifiacion", query = "SELECT d FROM Donanteinfractor d WHERE d.doninIdentifiacion = :doninIdentifiacion"),
    @NamedQuery(name = "Donanteinfractor.findByDoninNombres", query = "SELECT d FROM Donanteinfractor d WHERE d.doninNombres = :doninNombres"),
    @NamedQuery(name = "Donanteinfractor.findByDoninApellidos", query = "SELECT d FROM Donanteinfractor d WHERE d.doninApellidos = :doninApellidos"),
    @NamedQuery(name = "Donanteinfractor.findByDoninDireccion", query = "SELECT d FROM Donanteinfractor d WHERE d.doninDireccion = :doninDireccion"),
    @NamedQuery(name = "Donanteinfractor.findByDoninTelefono", query = "SELECT d FROM Donanteinfractor d WHERE d.doninTelefono = :doninTelefono")})
public class Donanteinfractor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "doninId")
    private Long doninId;
    @Column(name = "doninIdentifiacion")
    private String doninIdentifiacion;
    @Column(name = "doninNombres")
    private String doninNombres;
    @Column(name = "doninApellidos")
    private String doninApellidos;
    @Column(name = "doninDireccion")
    private String doninDireccion;
    @Column(name = "doninTelefono")
    private String doninTelefono;
    @OneToMany(mappedBy = "donanteinfractorId")
    private List<Ingreso> ingresoList;

    public Donanteinfractor() {
    }

    public Donanteinfractor(Long doninId) {
        this.doninId = doninId;
    }

    public Long getDoninId() {
        return doninId;
    }

    public void setDoninId(Long doninId) {
        this.doninId = doninId;
    }

    public String getDoninIdentifiacion() {
        return doninIdentifiacion;
    }

    public void setDoninIdentifiacion(String doninIdentifiacion) {
        this.doninIdentifiacion = doninIdentifiacion;
    }

    public String getDoninNombres() {
        return doninNombres;
    }

    public void setDoninNombres(String doninNombres) {
        this.doninNombres = doninNombres;
    }

    public String getDoninApellidos() {
        return doninApellidos;
    }

    public void setDoninApellidos(String doninApellidos) {
        this.doninApellidos = doninApellidos;
    }

    public String getDoninDireccion() {
        return doninDireccion;
    }

    public void setDoninDireccion(String doninDireccion) {
        this.doninDireccion = doninDireccion;
    }

    public String getDoninTelefono() {
        return doninTelefono;
    }

    public void setDoninTelefono(String doninTelefono) {
        this.doninTelefono = doninTelefono;
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
        hash += (doninId != null ? doninId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Donanteinfractor)) {
            return false;
        }
        Donanteinfractor other = (Donanteinfractor) object;
        if ((this.doninId == null && other.doninId != null) || (this.doninId != null && !this.doninId.equals(other.doninId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Donanteinfractor[ doninId=" + doninId + " ]";
    }
    
}
