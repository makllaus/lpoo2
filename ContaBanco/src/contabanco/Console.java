/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contabanco;

import java.lang.reflect.Array;

/**
 *
 * @author tone
 */
public class Console {
    
    public static void main(String[] args) {
        Lutador lutadores[] = new Lutador[6];
        lutadores[0] = new Lutador("Antonio Miranda", "Brasil", 30, 1.75f, 95.4f, 11, 1, 1);
        lutadores[1] = new Lutador("Michelli Borges", "Brasil", 33, 1.63f, 61.2f, 15, 3, 5);
        lutadores[2] = new Lutador("Beatriz Caroline", "Oxóssi", 25, 1.55f, 53.9f, 4, 1, 1);
        lutadores[3] = new Lutador("Jessica Jones", "USA", 32, 1.75f, 70.4f, 1, 5, 2);
        lutadores[4] = new Lutador("Deonice Cardim", "Portugal", 54, 1.60f, 60.5f, 54, 0, 0);
        lutadores[5] = new Lutador("Lagerta", "Kattekath", 35, 1.72f, 69.4f, 100, 0, 0);
        
        Luta UEC01 = new Luta();
        
        UEC01.marcarLuta(lutadores[1], lutadores[0]);
        UEC01.lutar();
    }
    
}
