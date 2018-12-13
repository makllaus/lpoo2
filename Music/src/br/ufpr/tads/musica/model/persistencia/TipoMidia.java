/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.tads.musica.model.persistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
 * @author Dieval
 */
@Entity
@Table(name = "TIPOMIDIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoMidia.findAll", query = "SELECT t FROM TipoMidia t")
    , @NamedQuery(name = "TipoMidia.findById", query = "SELECT t FROM TipoMidia t WHERE t.id = :id")
    , @NamedQuery(name = "TipoMidia.findByMidia", query = "SELECT t FROM TipoMidia t WHERE t.midia = :midia")})
public class TipoMidia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "MIDIA")
    private String midia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipomidia", fetch = FetchType.EAGER)
    private List<Album> albumList;

    public TipoMidia() {
    }

    public TipoMidia(Integer id) {
        this.id = id;
    }

    public TipoMidia(Integer id, String midia) {
        this.id = id;
        this.midia = midia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMidia() {
        return midia;
    }

    public void setMidia(String midia) {
        this.midia = midia;
    }

    @XmlTransient
    public List<Album> getAlbumList() {
        return albumList;
    }

    public void setAlbumList(List<Album> albumList) {
        this.albumList = albumList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoMidia)) {
            return false;
        }
        TipoMidia other = (TipoMidia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ufpr.tads.musica.model.persistencia.TipoMidia[ id=" + id + " ]";
    }
    
}
