/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.tads.musica.model.persistencia;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Dieval
 */
@Entity
@Table(name = "ALBUM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Album.findAll", query = "SELECT a FROM Album a")
    , @NamedQuery(name = "Album.findById", query = "SELECT a FROM Album a WHERE a.id = :id")
    , @NamedQuery(name = "Album.findByTitulo", query = "SELECT a FROM Album a WHERE a.titulo = :titulo")
    , @NamedQuery(name = "Album.findByDatalancamento", query = "SELECT a FROM Album a WHERE a.datalancamento = :datalancamento")
    , @NamedQuery(name = "Album.findByTempototal", query = "SELECT a FROM Album a WHERE a.tempototal = :tempototal")})
public class Album implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "TITULO")
    private String titulo;
    @Basic(optional = false)
    @Column(name = "DATALANCAMENTO")
    @Temporal(TemporalType.DATE)
    private Date datalancamento;
    @Basic(optional = false)
    @Column(name = "TEMPOTOTAL")
    private int tempototal;
    @JoinColumn(name = "GENERO", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Genero genero;
    @JoinColumn(name = "TIPOMIDIA", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private TipoMidia tipomidia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "album", fetch = FetchType.EAGER)
    private List<Faixa> faixaList;

    public Album() {
    }

    public Album(Integer id) {
        this.id = id;
    }

    public Album(Integer id, String titulo, Date datalancamento, int tempototal) {
        this.id = id;
        this.titulo = titulo;
        this.datalancamento = datalancamento;
        this.tempototal = tempototal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getDatalancamento() {
        return datalancamento;
    }

    public void setDatalancamento(Date datalancamento) {
        this.datalancamento = datalancamento;
    }

    public int getTempototal() {
        return tempototal;
    }

    public void setTempototal(int tempototal) {
        this.tempototal = tempototal;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public TipoMidia getTipomidia() {
        return tipomidia;
    }

    public void setTipomidia(TipoMidia tipomidia) {
        this.tipomidia = tipomidia;
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
        if (!(object instanceof Album)) {
            return false;
        }
        Album other = (Album) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ufpr.tads.musica.model.persistencia.Album[ id=" + id + " ]";
    }
    
}
