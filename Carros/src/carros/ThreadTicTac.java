/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carros;

/**
 *
 * @author tone
 */
public class ThreadTicTac implements Runnable {

    TicTac tt;
    Thread t;

    public ThreadTicTac(String nome, TicTac tt) {
        this.tt = tt;
        t = new Thread(this, nome);
        t.start();
    }

    @Override
    public void run() {
        if (t.getName().equalsIgnoreCase("Tic")) {
            for (int i = 0; i < 5; i++) {
                tt.tic(true);
            }
            tt.tic(false);
        } else {
            for (int i = 0; i < 5; i++) {
                tt.tac(true);
            }
            tt.tac(false);
        }
    }

}
