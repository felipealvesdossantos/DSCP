
package persist;

import dtoAtividades.Area;
import dtoAtividades.Atividade;
import dtoDocentes.Docente;
import dtoAtividades.Formula;
import dtoDocentes.Classe;
import dtoDocentes.Nivel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateFactory {

    private static SessionFactory factory;

    static{
        AnnotationConfiguration cfg = new AnnotationConfiguration();
        cfg.configure();
        
        cfg.addAnnotatedClass(Area.class);
        cfg.addAnnotatedClass(Atividade.class);
        cfg.addAnnotatedClass(Formula.class);
        cfg.addAnnotatedClass(Docente.class);
        cfg.addAnnotatedClass(Classe.class);
        cfg.addAnnotatedClass(Nivel.class);
        
        factory = cfg.buildSessionFactory();
    }

    public static Session getSession(){
        return factory.openSession();
    }
}
