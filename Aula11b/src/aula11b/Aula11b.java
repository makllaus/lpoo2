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
public class Aula11b {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
       Visitante v = new Visitante();
       v.setNome("Antonio");
       v.setIdade(30);
       v.setSexo("M");
       System.out.println(v.toString());
       Aluno a = new Aluno();
       
       a.setCurso("TADS");
       a.setIdade(30);
       a.setNome("Antonio");
       a.setSexo("M");
       a.setMatricula(20147351);
        System.out.println(a.toString());
    }
    
}
