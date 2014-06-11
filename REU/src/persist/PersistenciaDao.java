package persist;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Expression;

public class PersistenciaDao implements Serializable{
    
    public void salvar(Object object) throws Exception, SQLException, ConstraintViolationException{

       Session session = HibernateFactory.getSession();
       Transaction transaction = session.beginTransaction();
       try{

       session.saveOrUpdate(object);
       session.flush();
       transaction.commit();
       }catch(Exception e){
    	transaction.rollback();
    	throw new Exception("Houve erros: "+e.getMessage());
       }finally{
         session.close();
       }
    }
    
    public void alterar(Object object) throws Exception, SQLException, ConstraintViolationException{

       Session session = HibernateFactory.getSession();
       Transaction transaction = session.beginTransaction();
       try{

       session.update(object);
       session.flush();
       transaction.commit();
       }catch(Exception e){
    	transaction.rollback();
    	throw new Exception("Houve erros: "+e.getMessage());
       }finally{
         session.close();
       }
    }
    
    public void excluir(Object object) throws Exception, SQLException, ConstraintViolationException{

        Session session = HibernateFactory.getSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.delete(object);
            session.flush();
            transaction.commit();
        }catch(Exception e){
            transaction.rollback();
            throw new Exception("Houve erros: "+e.getMessage());
        }finally{
             session.close();
        }
    }
    
    public List listarFiltro(Class classeEntidade, Map parametros, String orderBy){

        Session session = HibernateFactory.getSession();
        Criteria consulta = session.createCriteria(classeEntidade);

        if(orderBy!=null && !orderBy.equals("")){
            String[] ordenadores = orderBy.split(",");
            for(String order : ordenadores){
                consulta.addOrder(Order.asc(order));
            }
        }

        String key = "";
        for (Iterator it = parametros.keySet().iterator(); it.hasNext();) {
            key = (String) it.next();
            consulta.add(Expression.like(key, parametros.get(key)));
        }
        
        List resultado = consulta.list();
        session.close();
        return resultado;
    }
    
    public List listarFiltroHql(Class classeEntidade, Map parametros, String orderBy, String order, StringBuilder hql){

        Session session = HibernateFactory.getSession();

        StringBuilder hqlQuery = new StringBuilder("from " + classeEntidade.getName() + " bean where 1=1 ");
        hqlQuery.append(hql);
        
        if(orderBy != null && !orderBy.equals("")){
            hqlQuery.append(" order by " + orderBy  + " " + order);
        }

        Query query = session.createQuery(hqlQuery.toString());

        if(parametros != null){
            Iterator iter = parametros.keySet().iterator();
            while (iter.hasNext()) {
                String name = (String) iter.next();
                Object value = parametros.get(name);
                query.setParameter(name,value);
            }
        }

        List lista = query.list();
        session.close();
        return lista;
    }
    
    public List listar(Class clazz) throws Exception, SQLException, ConstraintViolationException {

        Session session = HibernateFactory.getSession();
        Transaction transaction = session.beginTransaction();

        List objts;
        objts = null;
        Criteria selectAll = session.createCriteria(clazz);
        transaction.commit();
        objts = selectAll.list();
        session.close();
        return objts;
    }
    
    public static Object load(Class<Object> beanClass,Serializable id){
        try{
            Object result = null;
            Session session = HibernateFactory.getSession();

            result = (Object) session.load(beanClass, id);

            session.flush();
            session.refresh(result);
            session.close();
            
            return result;
        }catch(Throwable e){
             e.printStackTrace();
        }
        
        return null;
    }
}
