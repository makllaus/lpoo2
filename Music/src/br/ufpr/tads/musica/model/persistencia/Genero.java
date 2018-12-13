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
@Table(name = "GENERO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Genero.findAll", query = "SELECT g FROM Genero g")
    , @NamedQuery(name = "Genero.findById", query = "SELECT g FROM Genero g WHERE g.id = :id")
    , @NamedQuery(name = "Genero.findByNome", query = "SELECT g FROM Genero g WHERE g.nome = :nome")})
public class Genero implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    
    @Basic(optional = false)
    @Column(name = "NOME")
    private String nome;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "genero", fetch = FetchType.EAGER)
    private List<Musica> musicaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "genero", fetch = FetchType.EAGER)
    private List<Album> albumList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "genero", fetch = FetchType.LAZY)
    private List<Faixa> faixaList;

    public Genero() {
    }

    public Genero(Integer id) {
        this.id = id;
    }

    public Genero(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public List<Musica> getMusicaList() {
        return musicaList;
    }

    public void setMusicaList(List<Musica> musicaList) {
        this.musicaList = musicaList;
    }

    @XmlTransient
    public List<Album> getAlbumList() {
        return albumList;
    }

    public void setAlbumList(List<Album> albumList) {
        this.albumList = albumList;
    }

    @XmlTransient
    public List<Faixa> getFaixaList() {
        return faixaList;
    }

    public void setFaixaList(List<Faixa> faixaList) {
        this.faixaList = faixaList;
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
        if (!(object instanceof Genero)) {
            return false;
        }
        Genero other = (Genero) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("%s (%d)",this.nome!=null?this.nome:"",
                this.id!=null?this.id : 0);
                //"br.ufpr.tads.musica.model.persistencia.Genero[ id=" + id + " ]";
    }
    
}
