/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectyoutube;

/**
 *
 * @author tone
 */
public class Visualizacao {

    private Gafanhoto espectador;
    private Video filme;

    public Visualizacao(Gafanhoto espectador, Video filme) {
        this.espectador = espectador;
        this.filme = filme;
        espectador.setTotAssistido(espectador.getTotAssistido() + 1);
        filme.setViews(filme.getViews() + 1);
    }

    public void avaliar() {
        filme.setAvaliacoes(5);

    }

    public void avaliar(int nota) {
        filme.setAvaliacoes(nota);
    }

    public void avaliar(float porc) {
        int tot = 0;
        if (porc <= 20) {
            tot = 3;
        } else if (porc <= 50) {
            tot = 5;
        } else if (porc <= 90) {
            tot = 8;
        } else {
            tot = 10;
        }
        filme.setAvaliacoes(tot);

    }

    public Gafanhoto getEspectador() {
        return espectador;
    }

    public void setEspectador(Gafanhoto espectador) {
        this.espectador = espectador;
    }

    public Video getFilme() {
        return filme;
    }

    public void setFilme(Video filme) {
        this.filme = filme;
    }

    @Override
    public String toString() {
        return "Visualizacao{" + "espectador=" + espectador + ", filme=" + filme + '}';
    }

}
