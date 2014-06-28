/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persist.dao;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 *
 * @author felipe
 */
public class GerarTabelas {

    public void geracao() {
        Configuration conf = new AnnotationConfiguration();
        conf.configure();

        SchemaExport se = new SchemaExport(conf);
        se.create(true, true);
    }
}
