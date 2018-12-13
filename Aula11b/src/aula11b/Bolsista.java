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
public class Bolsista extends Aluno{
    private float bolsa;
    
    public void renoverBolsa(){
        System.out.println("Renovando bolsa!");
    }
    
    @Override
    public void pagarMensalidade(){
        System.out.println("Pagamento facilitado para bolsista!");
    }

    public float getBolsa() {
        return bolsa;
    }

    public void setBolsa(float bolsa) {
        this.bolsa = bolsa;
    }
}
