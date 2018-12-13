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
public class Teste {
    public static void main(String[] args) {
//        MinhaThread thread = new MinhaThread("Thread #1");
//        MinhaThread threads = new MinhaThread("Thread #2");
//        MinhaThreadRunnable threadRun = new MinhaThreadRunnable("Thread #3",300);
//        MinhaThreadRunnable threadRuns = new MinhaThreadRunnable("Thread #4",600);
//        
//        int[] nums1 = {1,2,3,4,5};
//        int[] nums2 = {6,7,8,9,10};
//        int[] nums3 = {11,12,13,14,15};
//        ThreadSoma ts1 = new ThreadSoma("#1",nums1);
//        ThreadSoma ts2 = new ThreadSoma("#2",nums2);
//        ThreadSoma ts3 = new ThreadSoma("#3",nums3);
//        
//        
//        TicTac tt = new TicTac();
//        ThreadTicTac tic = new ThreadTicTac("Tic", tt);
//        ThreadTicTac tac = new ThreadTicTac("Tac", tt);
//        
//        try {
//            tic.t.join();
//            tac.t.join();
//        } catch (InterruptedException ex) {
//            ex.printStackTrace();
//        }
        MinhaThreads t1 = new MinhaThreads("#1");
        MinhaThreads t2 = new MinhaThreads("#2");
        
        t1.suspend();
        
        try {
            Thread.sleep(300);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        
        t2.suspend();
        
        t1.resume();
        
        try {
            Thread.sleep(300);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        t2.resume();
        t2.stop();
        System.out.println("Programa Finalizado");
    }
}
