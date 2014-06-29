/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package persist.dao;

 import dtoAtividades.Formula;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import persist.PersistenciaDao;

/**
 *
 * @author GAOliveira
 */
public class FormulaDao implements GenericoDao{
      
    PersistenciaDao persistencia = new PersistenciaDao();
    
    @Override
    public void recebeDto(Object object) throws Exception{
            persistencia.salvar(object);
    }
    
    public List listarTodos() throws Exception{
        PersistenciaDao pdao = new PersistenciaDao();
        
        return pdao.listar(Formula.class);
    }
    
     public static void excluir(Formula formula) throws Exception{
        PersistenciaDao persistenciaDao = new PersistenciaDao();
        persistenciaDao.excluir(formula);

    }
}


