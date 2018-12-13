/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.tads.musica.model.persistencia;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Dieval
 */
@Embeddable
public class FaixaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "ALBUMID")
    private int albumid;
    @Basic(optional = false)
    @Column(name = "FAIXAORDEM")
    private int faixaordem;

    public FaixaPK() {
    }

    public FaixaPK(int albumid, int faixaordem) {
        this.albumid = albumid;
        this.faixaordem = faixaordem;
    }

    public int getAlbumid() {
        return albumid;
    }

    public void setAlbumid(int albumid) {
        this.albumid = albumid;
    }

    public int getFaixaordem() {
        return faixaordem;
    }

    public void setFaixaordem(int faixaordem) {
        this.faixaordem = faixaordem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) albumid;
        hash += (int) faixaordem;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FaixaPK)) {
            return false;
        }
        FaixaPK other = (FaixaPK) object;
        if (this.albumid != other.albumid) {
            return false;
        }
        if (this.faixaordem != other.faixaordem) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ufpr.tads.musica.model.persistencia.FaixaPK[ albumid=" + albumid + ", faixaordem=" + faixaordem + " ]";
    }
    
}
