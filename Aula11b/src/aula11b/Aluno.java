/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula11b;

/**
 *
 * @author tone
 */
public class Aluno extends Pessoa {
    private int matricula;
    private String curso;
    
    public void pagarMensalidade(){
        System.out.println("Pagando Mensalidade");
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Aluno{" + "matricula=" + matricula + ", curso=" + curso + '}';
    }
    
}
