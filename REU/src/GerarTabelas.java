import dto.Usuario;
import persist.PersistenciaDao;
import java.util.Date;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 *  @author Geovane
 */
public class GerarTabelas {

    public static void main(String[] args) throws Exception{

        Configuration conf = new AnnotationConfiguration();
        conf.configure();
        SchemaExport se = new SchemaExport(conf);
        se.create(true, true);
     
        
        Usuario usuario = new Usuario();
        usuario.setLogin("admin");
        usuario.setSenha("12345");
        
      
    }
}