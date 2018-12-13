/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carros;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tone
 */
public class TicTac {

    boolean tic;

    synchronized void tic(boolean exe) {
        if (!exe) {
            tic = true;
            notify();
        }
        System.out.println("Tic ");

        tic = true;

        notify();
        try {
            while (tic) {

                wait();
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    synchronized void tac(boolean exe) {
        if (!exe) {
            tic = false;
            notify();
        }
        System.out.println("Tac ");

        tic = false;

        notify();
        try {
            while (!tic) {

                wait();
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
