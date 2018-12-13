/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contabanco;

import static java.lang.Math.round;
import java.util.Random;

/**
 *
 * @author tone
 */
public class Luta {

    private Lutador desafiado;
    private Lutador desafiante;
    private int rounds;
    private boolean aprovada;

    public void marcarLuta(Lutador player1, Lutador player2) {
        if (player1.getCategoria().equals(player2.getCategoria()) && player1 != player2) {
            this.setAprovada(true);
            this.setDesafiado(player1);
            this.setDesafiante(player2);

        } else {
            this.setAprovada(false);
            this.setDesafiado(null);
            this.setDesafiante(null);
        }
    }

    public void lutar() {
        if (this.isAprovada()) {
            System.out.println("### DESAFIADO ###");
            desafiado.apresentar();
            System.out.println("### DESAFIANTE ###");
            desafiante.apresentar();
            
            Random random = new Random();
            int vencedor = random.nextInt(3);
            switch (vencedor){
                case 0: // EMPATE
                    System.out.println("LUTA EMPATOU");
                    desafiado.empatarLuta();
                    desafiante.empatarLuta();
                    break;
                case 1: // DESAFIADO GANHOU
                    System.out.println(desafiado.getNome() + "Ganhou a Luta");
                    desafiado.ganharLuta();
                    desafiante.perderLuta();
                    break;
                case 2: // DESAFIANTE GANHOU
                    System.out.println(desafiante.getNome() + "Ganhou a Luta");
                    desafiante.ganharLuta();
                    desafiado.perderLuta();
                    break;
                    
            }
        } else {
            System.out.println("Luta não pode acontecer!");
        }

    }

    public Lutador getDesafiado() {
        return desafiado;
    }

    public void setDesafiado(Lutador desafiado) {
        this.desafiado = desafiado;
    }

    public Lutador getDesafiante() {
        return desafiante;
    }

    public void setDesafiante(Lutador desafiante) {
        this.desafiante = desafiante;
    }

    public int getRounds() {
        return rounds;
    }

    public void setRounds(int rounds) {
        this.rounds = rounds;
    }

    public boolean isAprovada() {
        return aprovada;
    }

    public void setAprovada(boolean aprovada) {
        this.aprovada = aprovada;
    }

}
