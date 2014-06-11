package persist;

import dto.Area;
import dto.Atividades;
import dto.Docente;
import dto.Formula;
import dto.Subarea;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateFactory {

    private static SessionFactory factory;

    static{
        AnnotationConfiguration cfg = new AnnotationConfiguration();
        cfg.configure();
        
        cfg.addAnnotatedClass(Area.class);
        cfg.addAnnotatedClass(Subarea.class);
        cfg.addAnnotatedClass(Atividades.class);
        cfg.addAnnotatedClass(Formula.class);
        cfg.addAnnotatedClass(Docente.class);
        
        factory = cfg.buildSessionFactory();
    }

    public static Session getSession(){
        return factory.openSession();
    }
}
