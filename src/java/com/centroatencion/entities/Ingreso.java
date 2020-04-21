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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

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
    @NamedQuery(name = "Ingreso.findByIngNumeroRadicado", query = "SELECT i FROM Ingreso i WHERE i.ingNumeroRadicado = :ingNumeroRadicado"),
    @NamedQuery(name = "Ingreso.findByIngFecha", query = "SELECT i FROM Ingreso i WHERE i.ingFecha = :ingFecha"),
    @NamedQuery(name = "Ingreso.findByIngFechaFin", query = "SELECT i FROM Ingreso i WHERE i.ingFechaFin = :ingFechaFin"),
    @NamedQuery(name = "Ingreso.findByIngNumeroUCTFF", query = "SELECT i FROM Ingreso i WHERE i.ingNumeroUCTFF = :ingNumeroUCTFF"),
    @NamedQuery(name = "Ingreso.findByIngresomuerto", query = "SELECT i FROM Ingreso i WHERE i.ingresomuerto = :ingresomuerto")})
public class Ingreso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ingId")
    private Long ingId;
    @Size(max = 40)
    @Column(name = "ingNumeroRadicado")
    private String ingNumeroRadicado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ingFecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ingFecha;
    @Column(name = "ingFechaFin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ingFechaFin;
    @Size(max = 50)
    @Column(name = "ingNumeroUCTFF")
    private String ingNumeroUCTFF;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ingresomuerto")
    private int ingresomuerto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ingresoId")
    private List<Marca> marcaList;
    @JoinColumn(name = "infractordonatanteId", referencedColumnName = "perId")
    @ManyToOne
    private Persona infractordonatanteId;
    @JoinColumn(name = "denunciaId", referencedColumnName = "denId")
    @ManyToOne
    private Denuncia denunciaId;
    @JoinColumn(name = "animalId", referencedColumnName = "anId")
    @ManyToOne(optional = false)
    private Animal animalId;
    @JoinColumn(name = "causaingresoId", referencedColumnName = "causaingId")
    @ManyToOne(optional = false)
    private Causaingreso causaingresoId;
    @JoinColumn(name = "sexoId", referencedColumnName = "sexId")
    @ManyToOne(optional = false)
    private Sexo sexoId;
    @JoinColumn(name = "veredaId", referencedColumnName = "verId")
    @ManyToOne
    private Vereda veredaId;
    @JoinColumn(name = "desarrollobiologicoId", referencedColumnName = "desbioId")
    @ManyToOne(optional = false)
    private Desarrollobiologico desarrollobiologicoId;
    @JoinColumn(name = "muerteId", referencedColumnName = "mueId")
    @ManyToOne
    private Muerto muerteId;
    @JoinColumn(name = "entidadId", referencedColumnName = "entId")
    @ManyToOne(optional = false)
    private Entidad entidadId;
    @JoinColumn(name = "funcionarioId", referencedColumnName = "perId")
    @ManyToOne(optional = false)
    private Persona funcionarioId;
    @OneToMany(mappedBy = "ingresoIdOrigen")
    private List<Ingreso> ingresoList;
    @JoinColumn(name = "ingresoIdOrigen", referencedColumnName = "ingId")
    @ManyToOne
    private Ingreso ingresoIdOrigen;
    @JoinColumn(name = "municipioId", referencedColumnName = "munId")
    @ManyToOne
    private Municipio municipioId;
    @JoinColumn(name = "liberacionId", referencedColumnName = "libId")
    @ManyToOne
    private Liberacion liberacionId;
    @JoinColumn(name = "lugardecomisoentregavoluntariaId", referencedColumnName = "ldeId")
    @ManyToOne(optional = false)
    private Lugardecomisoentregavoluntaria lugardecomisoentregavoluntariaId;
    @JoinColumn(name = "marcaId", referencedColumnName = "marcId")
    @ManyToOne
    private Marca marcaId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ingresoId")
    private List<Diagnostico> diagnosticoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ingresoId")
    private List<Ingresofoto> ingresofotoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entradaid")
    private List<Asignazona> asignazonaList;

    public Ingreso() {
    }

    public Ingreso(Long ingId) {
        this.ingId = ingId;
    }

    public Ingreso(Long ingId, Date ingFecha, int ingresomuerto) {
        this.ingId = ingId;
        this.ingFecha = ingFecha;
        this.ingresomuerto = ingresomuerto;
    }

    public Long getIngId() {
        return ingId;
    }

    public void setIngId(Long ingId) {
        this.ingId = ingId;
    }

    public String getIngNumeroRadicado() {
        return ingNumeroRadicado;
    }

    public void setIngNumeroRadicado(String ingNumeroRadicado) {
        this.ingNumeroRadicado = ingNumeroRadicado;
    }

    public Date getIngFecha() {
        return ingFecha;
    }

    public void setIngFecha(Date ingFecha) {
        this.ingFecha = ingFecha;
    }

    public Date getIngFechaFin() {
        return ingFechaFin;
    }

    public void setIngFechaFin(Date ingFechaFin) {
        this.ingFechaFin = ingFechaFin;
    }

    public String getIngNumeroUCTFF() {
        return ingNumeroUCTFF;
    }

    public void setIngNumeroUCTFF(String ingNumeroUCTFF) {
        this.ingNumeroUCTFF = ingNumeroUCTFF;
    }

    public int getIngresomuerto() {
        return ingresomuerto;
    }

    public void setIngresomuerto(int ingresomuerto) {
        this.ingresomuerto = ingresomuerto;
    }

    @XmlTransient
    public List<Marca> getMarcaList() {
        return marcaList;
    }

    public void setMarcaList(List<Marca> marcaList) {
        this.marcaList = marcaList;
    }

    public Persona getInfractordonatanteId() {
        return infractordonatanteId;
    }

    public void setInfractordonatanteId(Persona infractordonatanteId) {
        this.infractordonatanteId = infractordonatanteId;
    }

    public Denuncia getDenunciaId() {
        return denunciaId;
    }

    public void setDenunciaId(Denuncia denunciaId) {
        this.denunciaId = denunciaId;
    }

    public Animal getAnimalId() {
        return animalId;
    }

    public void setAnimalId(Animal animalId) {
        this.animalId = animalId;
    }

    public Causaingreso getCausaingresoId() {
        return causaingresoId;
    }

    public void setCausaingresoId(Causaingreso causaingresoId) {
        this.causaingresoId = causaingresoId;
    }

    public Sexo getSexoId() {
        return sexoId;
    }

    public void setSexoId(Sexo sexoId) {
        this.sexoId = sexoId;
    }

    public Vereda getVeredaId() {
        return veredaId;
    }

    public void setVeredaId(Vereda veredaId) {
        this.veredaId = veredaId;
    }

    public Desarrollobiologico getDesarrollobiologicoId() {
        return desarrollobiologicoId;
    }

    public void setDesarrollobiologicoId(Desarrollobiologico desarrollobiologicoId) {
        this.desarrollobiologicoId = desarrollobiologicoId;
    }

    public Muerto getMuerteId() {
        return muerteId;
    }

    public void setMuerteId(Muerto muerteId) {
        this.muerteId = muerteId;
    }

    public Entidad getEntidadId() {
        return entidadId;
    }

    public void setEntidadId(Entidad entidadId) {
        this.entidadId = entidadId;
    }

    public Persona getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(Persona funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    @XmlTransient
    public List<Ingreso> getIngresoList() {
        return ingresoList;
    }

    public void setIngresoList(List<Ingreso> ingresoList) {
        this.ingresoList = ingresoList;
    }

    public Ingreso getIngresoIdOrigen() {
        return ingresoIdOrigen;
    }

    public void setIngresoIdOrigen(Ingreso ingresoIdOrigen) {
        this.ingresoIdOrigen = ingresoIdOrigen;
    }

    public Municipio getMunicipioId() {
        return municipioId;
    }

    public void setMunicipioId(Municipio municipioId) {
        this.municipioId = municipioId;
    }

    public Liberacion getLiberacionId() {
        return liberacionId;
    }

    public void setLiberacionId(Liberacion liberacionId) {
        this.liberacionId = liberacionId;
    }

    public Lugardecomisoentregavoluntaria getLugardecomisoentregavoluntariaId() {
        return lugardecomisoentregavoluntariaId;
    }

    public void setLugardecomisoentregavoluntariaId(Lugardecomisoentregavoluntaria lugardecomisoentregavoluntariaId) {
        this.lugardecomisoentregavoluntariaId = lugardecomisoentregavoluntariaId;
    }

    public Marca getMarcaId() {
        return marcaId;
    }

    public void setMarcaId(Marca marcaId) {
        this.marcaId = marcaId;
    }

    @XmlTransient
    public List<Diagnostico> getDiagnosticoList() {
        return diagnosticoList;
    }

    public void setDiagnosticoList(List<Diagnostico> diagnosticoList) {
        this.diagnosticoList = diagnosticoList;
    }

    @XmlTransient
    public List<Ingresofoto> getIngresofotoList() {
        return ingresofotoList;
    }

    public void setIngresofotoList(List<Ingresofoto> ingresofotoList) {
        this.ingresofotoList = ingresofotoList;
    }

    @XmlTransient
    public List<Asignazona> getAsignazonaList() {
        return asignazonaList;
    }

    public void setAsignazonaList(List<Asignazona> asignazonaList) {
        this.asignazonaList = asignazonaList;
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
        return "com.centroatencion.entities.Ingreso[ ingId=" + ingId + " ]";
    }
    
}
