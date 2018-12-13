package br.ufpr.tads.agenda.db.vo;

import java.io.Serializable;

/**
 *
 * @author Dieval Guizelini
 */
public class AgendaVO implements Serializable {
    private int id=-1;
    private String nome;
    private String telefone;
    
    public AgendaVO() {
    }
    
    public AgendaVO(int id) {
        this.id = id;
    }
    
    public AgendaVO(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    
    public AgendaVO(int id, String nome, String telefone) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
    }

    /**
     * @return the id
     */
    public int getID() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setID(int id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
