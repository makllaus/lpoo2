/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.tads.musica.model.persistencia;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dieval
 */
@Entity
@Table(name = "FAIXA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Faixa.findAll", query = "SELECT f FROM Faixa f")
    , @NamedQuery(name = "Faixa.findByAlbumid", query = "SELECT f FROM Faixa f WHERE f.faixaPK.albumid = :albumid")
    , @NamedQuery(name = "Faixa.findByFaixaordem", query = "SELECT f FROM Faixa f WHERE f.faixaPK.faixaordem = :faixaordem")
    , @NamedQuery(name = "Faixa.findByDuracao", query = "SELECT f FROM Faixa f WHERE f.duracao = :duracao")})
public class Faixa implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FaixaPK faixaPK;
    @Basic(optional = false)
    @Column(name = "DURACAO")
    private int duracao;
    @JoinColumn(name = "ALBUMID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Album album;
    @JoinColumn(name = "GENERO", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Genero genero;
    @JoinColumn(name = "MUSICAID", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Musica musicaid;

    public Faixa() {
    }

    public Faixa(FaixaPK faixaPK) {
        this.faixaPK = faixaPK;
    }

    public Faixa(FaixaPK faixaPK, int duracao) {
        this.faixaPK = faixaPK;
        this.duracao = duracao;
    }

    public Faixa(int albumid, int faixaordem) {
        this.faixaPK = new FaixaPK(albumid, faixaordem);
    }

    public FaixaPK getFaixaPK() {
        return faixaPK;
    }

    public void setFaixaPK(FaixaPK faixaPK) {
        this.faixaPK = faixaPK;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Musica getMusicaid() {
        return musicaid;
    }

    public void setMusicaid(Musica musicaid) {
        this.musicaid = musicaid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (faixaPK != null ? faixaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Faixa)) {
            return false;
        }
        Faixa other = (Faixa) object;
        if ((this.faixaPK == null && other.faixaPK != null) || (this.faixaPK != null && !this.faixaPK.equals(other.faixaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ufpr.tads.musica.model.persistencia.Faixa[ faixaPK=" + faixaPK + " ]";
    }
    
}
