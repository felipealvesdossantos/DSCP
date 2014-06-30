/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcoes;

import dtoAtividades.Formula;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import persist.HibernateFactory;
import org.hibernate.Query;
import org.hibernate.exception.ConstraintViolationException;

/**
 *
 * @author felipe
 */
public class Geral implements Serializable {

    public static String listar(Class classe, String query, int id) throws Exception, SQLException, ConstraintViolationException {

        Session session = HibernateFactory.getSession();
        Transaction transaction = session.beginTransaction();
        List<Formula> lista;
        String descFormula;
        
        Criteria selectAll = session.createCriteria(classe);
        transaction.commit();

        Query obj = session.createQuery(query);
        lista = obj.list();
        descFormula = lista.get(0).getDescricao();

        session.close();

        return descFormula;
    }
}