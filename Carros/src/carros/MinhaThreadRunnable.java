/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carros;

import java.util.Random;

/**
 *
 * @author tone
 */
public class MinhaThreadRunnable implements Runnable {

    private String nome;
    private int valorAdormecida;

    public MinhaThreadRunnable(String nome, int valorAdormecida) {
        this.nome = nome;
        this.valorAdormecida = valorAdormecida;
        run();
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 6; i++) {
                System.out.println(nome + " Contador " + i);
                Random r = new Random();
                int aleatorio = r.nextInt(valorAdormecida);
                Thread.sleep(aleatorio);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(nome+" Finalizou!");
    }

}
