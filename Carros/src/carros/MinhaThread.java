/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carros;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tone
 */
public class MinhaThread extends Thread {

    private String nomeThread;

    public MinhaThread(String nome) {
        this.nomeThread = nome;
        start();
    }

    @Override
    public void run() {
        
        try {
            for (int i = 0; i < 6; i++) {
                System.out.println(nomeThread + " Contador " + i);
                Random r = new Random();
                int aleatorio = r.nextInt(100);
                Thread.sleep(aleatorio);
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println(nomeThread+" Finalizou!");
    }

}
