/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contabanco;

/**
 *
 * @author tone
 */
public class Lutador {
    private String nome;
    private String nacionalidade;
    private int idade;
    private float altura;
    private float peso;
    private String categoria;
    private int vitorias;
    private int derrotas;
    private int empates;
    
    //metodos personalizados
    public void apresentar(){
        System.out.println("Lutador: "+ getNome());
        System.out.println("Origem: "+ getNacionalidade());
        System.out.print(getIdade() + " anos");
        System.out.print(getAltura() + "m de altura");
        System.out.println("Pesando: "+ getPeso() + "Kg");
        System.out.println("Ganhou: " + getVitorias());
        System.out.println("Perdeu: " + getDerrotas());
        System.out.println("Empatou: " + getEmpates());
    }
            
    public void status(){
        System.out.println(getNome());
        System.out.println("É um peso: " + getCategoria());
        System.out.println(getVitorias() + " Vitórias");
        System.out.println(getDerrotas() + " Derrotas");
        System.out.println(getEmpates() + " Empates");
    }
    
    public void ganharLuta(){
        this.setVitorias(getVitorias() + 1);
        
    }
    
    public void perderLuta(){
        this.setDerrotas(getDerrotas() + 1);
    }
    
    public void empatarLuta(){
        this.setEmpates(getEmpates() + 1);
    }
    
    //metodos especiais

    public Lutador(String nome, String nacionalidade, int idade, float altura, float peso, int vitorias, int derrotas, int empates) {
        this.setNome(nome);
        this.setNacionalidade(nacionalidade);
        this.setIdade(idade);
        this.setAltura(altura);
        this.setPeso(peso);
        this.setVitorias(vitorias);
        this.setDerrotas(derrotas);
        this.setEmpates(empates);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
        this.setCategoria();
    }

    public String getCategoria() {
        return categoria;
    }

    private void setCategoria() {
        if (getPeso() < 52.2 || getPeso() > 120.2 ) {
            this.categoria = "Inválida";
        } else if (getPeso() <= 70.3) {
            this.categoria = "Leve";            
        } else if (getPeso() <= 83.9) {
            this.categoria = "Médio";
        } else if ( getPeso() <= 120.2) {
            this.categoria = "Pesado";
        }
    }

    public int getVitorias() {
        return vitorias;
    }

    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

    public int getEmpates() {
        return empates;
    }

    public void setEmpates(int empates) {
        this.empates = empates;
    }
    
    
}
