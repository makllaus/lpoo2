/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectyoutube;

/**
 *
 * @author tone
 */
public class ProjectYouTube {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Video v[] = new Video[3];

        v[0] = new Video("Aula 1 de POO");
        v[1] = new Video("Aula 2 de POO");
        v[2] = new Video("Aula 3 de POO");

        Gafanhoto g[] = new Gafanhoto[2];

        g[0] = new Gafanhoto("Antonio", 30, "M", "makllaus");
        g[1] = new Gafanhoto("Beatriz", 25, "F", "Bea");

        Visualizacao visu[] = new Visualizacao[6];
        visu[0] = new Visualizacao(g[0], v[0]);
        visu[1] = new Visualizacao(g[0], v[1]);
        visu[2] = new Visualizacao(g[0], v[2]);
        visu[3] = new Visualizacao(g[1], v[0]);
        visu[4] = new Visualizacao(g[1], v[1]);
        visu[5] = new Visualizacao(g[1], v[2]);
        v[0].play();
        v[0].play();
        v[0].play();
        visu[0].avaliar();
        visu[0].avaliar(7);
        visu[0].avaliar(50.0f);
        visu[1].avaliar();
        visu[1].avaliar(5);
        visu[1].avaliar(75.0f);
        visu[2].avaliar();
        visu[2].avaliar(3);
        visu[2].avaliar(19.0f);
        visu[3].avaliar();
        visu[3].avaliar(8);
        visu[3].avaliar(90.1f);
        visu[4].avaliar();
        visu[4].avaliar(9);
        visu[4].avaliar(35.0f);
        visu[5].avaliar();
        visu[5].avaliar(1);
        visu[5].avaliar(100.0f);

        for (int i = 0; i < visu.length; i++) {
            System.out.println(visu[i].toString());
        }

        System.out.println(v[0].toString());
        System.out.println(v[1].toString());
        System.out.println(v[2].toString());

        System.out.println(g[0].toString());
        System.out.println(g[1].toString());
    }

}
