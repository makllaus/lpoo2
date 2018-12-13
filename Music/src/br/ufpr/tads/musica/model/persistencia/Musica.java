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
 * @author Dieval
 */
@Entity
@Table(name = "MUSICA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Musica.findAll", query = "SELECT m FROM Musica m")
    , @NamedQuery(name = "Musica.findById", query = "SELECT m FROM Musica m WHERE m.id = :id")
    , @NamedQuery(name = "Musica.findByTitulo", query = "SELECT m FROM Musica m WHERE m.titulo = :titulo")
    , @NamedQuery(name = "Musica.findByDatacomposicao", query = "SELECT m FROM Musica m WHERE m.datacomposicao = :datacomposicao")
    , @NamedQuery(name = "Musica.findByTag", query = "SELECT m FROM Musica m WHERE m.tag = :tag")
    , @NamedQuery(name = "Musica.findByRank", query = "SELECT m FROM Musica m WHERE m.rank = :rank")})
public class Musica implements Serializable {

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
    @Lob
    @Column(name = "LETRA")
    private String letra;
    @Basic(optional = false)
    @Column(name = "DATACOMPOSICAO")
    @Temporal(TemporalType.DATE)
    private Date datacomposicao;
    @Basic(optional = false)
    @Column(name = "TAG")
    private String tag;
    @Basic(optional = false)
    @Column(name = "RANK")
    private int rank;
    @JoinColumn(name = "GENERO", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Genero genero;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "musicaid", fetch = FetchType.EAGER)
    private List<Faixa> faixaList;

    public Musica() {
    }

    public Musica(Integer id) {
        this.id = id;
    }

    public Musica(Integer id, String titulo, String letra, Date datacomposicao, String tag, int rank) {
        this.id = id;
        this.titulo = titulo;
        this.letra = letra;
        this.datacomposicao = datacomposicao;
        this.tag = tag;
        this.rank = rank;
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

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public Date getDatacomposicao() {
        return datacomposicao;
    }

    public void setDatacomposicao(Date datacomposicao) {
        this.datacomposicao = datacomposicao;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
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
        if (!(object instanceof Musica)) {
            return false;
        }
        Musica other = (Musica) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ufpr.tads.musica.model.persistencia.Musica[ id=" + id + " ]";
    }
    
}
