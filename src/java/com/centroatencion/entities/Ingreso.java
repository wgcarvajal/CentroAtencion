/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Wilson Carvajal
 */
@Entity
@Table(name = "ingreso", catalog = "hogardepasobd", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ingreso.findAll", query = "SELECT i FROM Ingreso i"),
    @NamedQuery(name = "Ingreso.findByIngId", query = "SELECT i FROM Ingreso i WHERE i.ingId = :ingId"),
    @NamedQuery(name = "Ingreso.findByIngNumeroRadicado", query = "SELECT i FROM Ingreso i WHERE i.ingRadicado = :ingRadicado"),
    @NamedQuery(name = "Ingreso.findByIngFecha", query = "SELECT i FROM Ingreso i WHERE i.ingFecha = :ingFecha"),
    @NamedQuery(name = "Ingreso.findMaxConsecutivo",query = "SELECT MAX(i.ingConsecutivo) FROM Ingreso i"),
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
    @Column(name = "ingConsecutivo")
    private long ingConsecutivo;
    @Column(name = "ingEstado")
    private Integer ingEstado;
    @Column(name = "ingCausa")
    private String ingCausa;
    @Lob
    @Column(name = "ingObservaciones")
    private String ingObservaciones;
    @Column(name = "ingEstadoSalud")
    private String ingEstadoSalud;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ingId")
    private List<Ingresosubproducto> ingresosubproductoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ingId")
    private List<Responsableingreso> responsableingresoList;
    @JoinColumn(name = "dirterId", referencedColumnName = "dirterId")
    @ManyToOne(optional = false)
    private Direcctionterritorial dirterId;
    @JoinColumn(name = "animalId", referencedColumnName = "anId")
    @ManyToOne(optional = false)
    private Animal animalId;
    @JoinColumn(name = "depExtraccionId", referencedColumnName = "depId")
    @ManyToOne
    private Departamento depExtraccionId;
    @JoinColumn(name = "depOcurrenciaId", referencedColumnName = "depId")
    @ManyToOne
    private Departamento depOcurrenciaId;
    @JoinColumn(name = "desbioId", referencedColumnName = "desbioId")
    @ManyToOne
    private Desarrollobiologico desbioId;
    @JoinColumn(name = "donanteinfractorId", referencedColumnName = "doninId")
    @ManyToOne
    private Donanteinfractor donanteinfractorId;
    @JoinColumn(name = "funcionarioId", referencedColumnName = "perId")
    @ManyToOne(optional = false)
    private Persona funcionarioId;
    @JoinColumn(name = "genId", referencedColumnName = "genId")
    @ManyToOne
    private Genero genId;
    @JoinColumn(name = "lugardecomisoentregavoluntariaId", referencedColumnName = "lugDecEntVoId")
    @ManyToOne
    private Lugardecomisoentregavoluntaria lugardecomisoentregavoluntariaId;
    @JoinColumn(name = "munExtraccionId", referencedColumnName = "munId")
    @ManyToOne
    private Municipio munExtraccionId;
    @JoinColumn(name = "verOcurrenciaId", referencedColumnName = "verId")
    @ManyToOne
    private Vereda verOcurrenciaId;
    @JoinColumn(name = "verExtraccionId", referencedColumnName = "verId")
    @ManyToOne
    private Vereda verExtraccionId;
    @JoinColumn(name = "munOcurrenciaId", referencedColumnName = "munId")
    @ManyToOne
    private Municipio munOcurrenciaId;

    public Ingreso() {
    }

    public Ingreso(Long ingId) {
        this.ingId = ingId;
    }

    public Ingreso(Long ingId, Date ingFecha) {
        this.ingId = ingId;
        this.ingFecha = ingFecha;
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

    public Integer getIngEstado() {
        return ingEstado;
    }

    public void setIngEstado(Integer ingEstado) {
        this.ingEstado = ingEstado;
    }

    public String getIngCausa() {
        return ingCausa;
    }

    public void setIngCausa(String ingCausa) {
        this.ingCausa = ingCausa;
    }

    public String getIngObservaciones() {
        return ingObservaciones;
    }

    public void setIngObservaciones(String ingObservaciones) {
        this.ingObservaciones = ingObservaciones;
    }

    public String getIngEstadoSalud() {
        return ingEstadoSalud;
    }

    public void setIngEstadoSalud(String ingEstadoSalud) {
        this.ingEstadoSalud = ingEstadoSalud;
    }

    @XmlTransient
    public List<Ingresosubproducto> getIngresosubproductoList() {
        return ingresosubproductoList;
    }

    public void setIngresosubproductoList(List<Ingresosubproducto> ingresosubproductoList) {
        this.ingresosubproductoList = ingresosubproductoList;
    }

    @XmlTransient
    public List<Responsableingreso> getResponsableingresoList() {
        return responsableingresoList;
    }

    public void setResponsableingresoList(List<Responsableingreso> responsableingresoList) {
        this.responsableingresoList = responsableingresoList;
    }

    public Direcctionterritorial getDirterId() {
        return dirterId;
    }

    public void setDirterId(Direcctionterritorial dirterId) {
        this.dirterId = dirterId;
    }

    public Animal getAnimalId() {
        return animalId;
    }

    public void setAnimalId(Animal animalId) {
        this.animalId = animalId;
    }

    public Departamento getDepExtraccionId() {
        return depExtraccionId;
    }

    public void setDepExtraccionId(Departamento depExtraccionId) {
        this.depExtraccionId = depExtraccionId;
    }

    public Departamento getDepOcurrenciaId() {
        return depOcurrenciaId;
    }

    public void setDepOcurrenciaId(Departamento depOcurrenciaId) {
        this.depOcurrenciaId = depOcurrenciaId;
    }

    public Desarrollobiologico getDesbioId() {
        return desbioId;
    }

    public void setDesbioId(Desarrollobiologico desbioId) {
        this.desbioId = desbioId;
    }

    public Donanteinfractor getDonanteinfractorId() {
        return donanteinfractorId;
    }

    public void setDonanteinfractorId(Donanteinfractor donanteinfractorId) {
        this.donanteinfractorId = donanteinfractorId;
    }

    public Persona getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(Persona funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    public Genero getGenId() {
        return genId;
    }

    public void setGenId(Genero genId) {
        this.genId = genId;
    }

    public Lugardecomisoentregavoluntaria getLugardecomisoentregavoluntariaId() {
        return lugardecomisoentregavoluntariaId;
    }

    public void setLugardecomisoentregavoluntariaId(Lugardecomisoentregavoluntaria lugardecomisoentregavoluntariaId) {
        this.lugardecomisoentregavoluntariaId = lugardecomisoentregavoluntariaId;
    }

    public Municipio getMunExtraccionId() {
        return munExtraccionId;
    }

    public void setMunExtraccionId(Municipio munExtraccionId) {
        this.munExtraccionId = munExtraccionId;
    }

    public Vereda getVerOcurrenciaId() {
        return verOcurrenciaId;
    }

    public void setVerOcurrenciaId(Vereda verOcurrenciaId) {
        this.verOcurrenciaId = verOcurrenciaId;
    }

    public Vereda getVerExtraccionId() {
        return verExtraccionId;
    }

    public void setVerExtraccionId(Vereda verExtraccionId) {
        this.verExtraccionId = verExtraccionId;
    }

    public Municipio getMunOcurrenciaId() {
        return munOcurrenciaId;
    }

    public void setMunOcurrenciaId(Municipio munOcurrenciaId) {
        this.munOcurrenciaId = munOcurrenciaId;
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
