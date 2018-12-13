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
public class Video implements AcoesVideo{
    private String titulo;
    private int avaliacoes;
    private int views;
    private int curtidas;
    private boolean reproduzindo;

    public Video(String titulo) {
        this.titulo = titulo;
        this.avaliacoes = 1;
        this.curtidas = 0;
        this.views = 0;
        this.reproduzindo = false;
    }
    

    @Override
    public void play() {
        setReproduzindo(true);
        
    }

    @Override
    public void pause() {
        setReproduzindo(false);
    }

    @Override
    public void like() {
        setCurtidas(getCurtidas() + 1);

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(int avaliacoes) {
        int nova;
        nova = (getAvaliacoes() + avaliacoes) / getViews(); 
        this.avaliacoes = avaliacoes;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getCurtidas() {
        return curtidas;
    }

    public void setCurtidas(int curtidas) {
        this.curtidas = curtidas;
    }

    public boolean isReproduzindo() {
        return reproduzindo;
    }

    public void setReproduzindo(boolean reproduzindo) {
        this.reproduzindo = reproduzindo;
    }

    @Override
    public String toString() {
        return "Video{" 
                + "titulo=" + titulo 
                + ", avaliacoes=" + avaliacoes 
                + ", views=" + views 
                + ", curtidas=" + curtidas 
                + ", reproduzindo=" + reproduzindo + '}';
    }
    
}
