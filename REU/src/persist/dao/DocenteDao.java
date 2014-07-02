/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package persist.dao;

import dtoDocentes.Docente;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import persist.PersistenciaDao;

/**
 *
 * @author GAOliveira
 */
public class DocenteDao {
    
PersistenciaDao persistencia = new PersistenciaDao();
    
    public void recebeDto(Object object) throws Exception{
            persistencia.salvar(object);
    }
    
    public List listarTodos() throws Exception{
        PersistenciaDao pdao = new PersistenciaDao();
        
        return pdao.listar(Docente.class);
    }
    
     public static void excluir(Docente docente) throws Exception{
        PersistenciaDao persistenciaDao = new PersistenciaDao();
        persistenciaDao.excluir(docente);

    }
}


    

