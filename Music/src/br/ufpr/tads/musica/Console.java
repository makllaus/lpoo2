package br.ufpr.tads.musica;

import br.ufpr.tads.musica.model.persistencia.Genero;
import br.ufpr.tads.musica.model.persistencia.Musica;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author user
 */
public class Console {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Genero pop = new Genero(null, "Pop");
        Genero rock = new Genero(null, "Rock");

        Musica um = new Musica();
        um.setTitulo("Que País É Este");
        um.setLetra("Nas favelas, no Senado\n"
                + "Sujeira pra todo lado\n"
                + "Ninguém respeita a Constituição\n"
                + "Mas todos acreditam no futuro da nação");

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            um.setDatacomposicao(sdf.parse("01/01/1978"));
        } catch (ParseException ex) {
            um.setDatacomposicao(new java.util.Date());
        }
        um.setRank(1);
        um.setTag("??");
        um.setGenero(rock);

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("musicaPU");
        EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();
        manager.persist(rock);
        manager.persist(pop);
        manager.persist(um);
        manager.getTransaction().commit();

        System.out.println("ID do genero: " + rock.getId());
        System.out.println("ID da musica: " + um.getId());
        
        manager.close();

    }

}
