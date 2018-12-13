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
public class Ex9bLPOO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Pessoa[] p = new Pessoa[3];
        Livro[] l = new Livro[3];
        
        p[0] = new Pessoa("Antonio", 30, "M");
        p[1] = new Pessoa("Miranda", 31, "F");
        p[2] = new Pessoa("Neto", 12, "M");
        
        l[0] = new Livro("Livro 1","Autor 1",1501,p[0]);
        l[1] = new Livro("Livro 2","Autor 2",150,p[1]);
        l[2] = new Livro("Livro 3","Autor 3",754,p[2]);
        
        for (int i = 0; i < l.length; i++) {
            System.out.println(l[i].detalhes());            
        }
    }
    
}
