package br.ufpr.tads.musica.model;

import br.ufpr.tads.musica.model.Genero;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-22T17:19:51")
@StaticMetamodel(Musica.class)
public class Musica_ { 

    public static volatile SingularAttribute<Musica, Genero> genero;
    public static volatile SingularAttribute<Musica, Date> dataComposicao;
    public static volatile SingularAttribute<Musica, String> titulo;
    public static volatile SingularAttribute<Musica, Integer> rank;
    public static volatile SingularAttribute<Musica, Integer> id;
    public static volatile SingularAttribute<Musica, String> letra;
    public static volatile SingularAttribute<Musica, String> tag;

}