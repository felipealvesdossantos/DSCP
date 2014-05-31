package REU.persist;

import REU.dto.Area;
import REU.dto.Atividades;
import REU.dto.Docente;
import REU.dto.Formula;
import REU.dto.Pontos;
import REU.dto.Subarea;
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
        cfg.addAnnotatedClass(Pontos.class);
        cfg.addAnnotatedClass(Formula.class);
        cfg.addAnnotatedClass(Docente.class);
        
        factory = cfg.buildSessionFactory();
    }

    public static Session getSession(){
        return factory.openSession();
    }
}
