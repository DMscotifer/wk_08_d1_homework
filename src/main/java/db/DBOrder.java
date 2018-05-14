package db;

import models.Order;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DBOrder {

    private static Session session;
    private static Transaction transaction;

    public static void save(Order order){
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(order);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static List<Order> getOrder(){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Order> results = null;
        try {
            String hql = "from Order";
            results = session.createQuery(hql).list();
        } catch (HibernateException e) {
        } finally {
            session.close();
        }
        return results;
    }

    public static void delete(Order order) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.delete(order);
            transaction.commit();
        } catch (HibernateException e){
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static Order find(int id){
        session = HibernateUtil.getSessionFactory().openSession();
        Order result = null;
        try{
            String hql = "from Order where id = :id";
            Query query = session.createQuery(hql);
            query.setInteger("id", id);
            result = (Order)query.uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }

    public static void update(Order order){
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.update(order);
            transaction.commit();
        } catch (HibernateException e){
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

}
