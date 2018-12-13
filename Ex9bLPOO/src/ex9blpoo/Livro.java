/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex9blpoo;

/**
 *
 * @author tone
 */
public class Livro implements Publicacao {
    private String titulo;
    private String autor;
    private int totPages;
    private int pageAtual;
    private boolean aberto;
    private Pessoa leitor;
    
    public String detalhes(){
       return "Livro{"+"Titulo="+getTitulo()+",\n autor="
                            + getAutor() + ",\n totPages=" + getTotPages() 
                            + ",\n pageAtual=" + getPageAtual()+ ",\n aberto="
                            + isAberto() +",\n Leitor="+ getLeitor().getNome()+"}";
        
    }

    @Override
    public void abrir() {
        this.setAberto(true);
    }

    @Override
    public void fechar() {
        this.setAberto(false);
    }

    @Override
    public void folhear(int page) {
        this.setPageAtual(page);
        
    }

    @Override
    public void nextPage() {
        this.setPageAtual(getPageAtual()+ 1);
    }

    @Override
    public void previousPage() {
        this.setPageAtual(getPageAtual()- 1);
    }

    public Livro(String titulo, String autor, int totPages, Pessoa leitor) {
        this.titulo = titulo;
        this.autor = autor;
        this.totPages = totPages;
        this.pageAtual = 0;
        this.aberto = false;
        this.leitor = leitor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getTotPages() {
        return totPages;
    }

    public void setTotPages(int totPages) {
        this.totPages = totPages;
    }

    public int getPageAtual() {
        return pageAtual;
    }

    public void setPageAtual(int pageAtual) {
        this.pageAtual = pageAtual;
    }

    public boolean isAberto() {
        return aberto;
    }

    public void setAberto(boolean aberto) {
        this.aberto = aberto;
    }

    public Pessoa getLeitor() {
        return leitor;
    }

    public void setLeitor(Pessoa leitor) {
        this.leitor = leitor;
    }
    
    
}
