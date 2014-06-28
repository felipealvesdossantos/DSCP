/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persist.dao;

import java.util.List;

/**
 *
 * @author Geovane
 */
public interface GenericoDao {
    
    public void insert(Object object) throws Exception;
    public void update(Object object) throws Exception;
    public void delete(Object object) throws Exception;
    public List list() throws Exception;
    
}
