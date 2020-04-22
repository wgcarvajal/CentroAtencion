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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "especie", catalog = "hogardepasobd", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Especie.findAll", query = "SELECT e FROM Especie e order by e.espNombre"),
    @NamedQuery(name = "Especie.findByEspId", query = "SELECT e FROM Especie e WHERE e.espId = :espId"),
    @NamedQuery(name = "Especie.findByFamilia", query = "SELECT e FROM Especie e WHERE e.faId.faId = :faId"),
    @NamedQuery(name = "Especie.findByIdInnerJoinFamiliaAndOrden", query = "SELECT e,f,o FROM Especie e INNER JOIN Familia f INNER JOIN Orden o WHERE e.espId = :espId And e.faId.faId = f.faId And f.orId.orId = o.orId"),
    @NamedQuery(name = "Especie.findByFamiliaAndNombre", query = "SELECT e FROM Especie e WHERE e.faId.faId = :faId AND LOWER(e.espNombre) LIKE :espNombre order by e.espNombre"),
    @NamedQuery(name = "Especie.findByLikeEspNombre", query = "SELECT e FROM Especie e WHERE LOWER(e.espNombre) LIKE :espNombre order by e.espNombre"),
    @NamedQuery(name = "Especie.findByEspNombre", query = "SELECT e FROM Especie e WHERE e.espNombre = :espNombre")})
public class Especie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "espId")
    private Integer espId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "espNombre")
    private String espNombre;
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "espDescripcion")
    private String espDescripcion;
    @JoinColumn(name = "faId", referencedColumnName = "faId")
    @ManyToOne(optional = false)
    private Familia faId;
    @OneToMany(mappedBy = "espId")
    private List<Animal> animalList;

    public Especie() {
    }

    public Especie(Integer espId) {
        this.espId = espId;
    }

    public Especie(Integer espId, String espNombre) {
        this.espId = espId;
        this.espNombre = espNombre;
    }

    public Integer getEspId() {
        return espId;
    }

    public void setEspId(Integer espId) {
        this.espId = espId;
    }

    public String getEspNombre() {
        return espNombre;
    }

    public void setEspNombre(String espNombre) {
        this.espNombre = espNombre;
    }

    public String getEspDescripcion() {
        return espDescripcion;
    }

    public void setEspDescripcion(String espDescripcion) {
        this.espDescripcion = espDescripcion;
    }

    public Familia getFaId() {
        return faId;
    }

    public void setFaId(Familia faId) {
        this.faId = faId;
    }

    @XmlTransient
    public List<Animal> getAnimalList() {
        return animalList;
    }

    public void setAnimalList(List<Animal> animalList) {
        this.animalList = animalList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (espId != null ? espId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Especie)) {
            return false;
        }
        Especie other = (Especie) object;
        if ((this.espId == null && other.espId != null) || (this.espId != null && !this.espId.equals(other.espId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.centroatencion.entities.Especie[ espId=" + espId + " ]";
    }
    
}
