package com.tinne.implement;

import com.tinne.dao.genericDAO;
import com.tinne.pojo.Manufacture;
import com.tinne.pojo.Phone;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import javax.persistence.Query;
import java.util.List;

public abstract class AbstractDAO<T> implements genericDAO<T> {


    private Class<T> clazz;
    protected AbstractDAO(Class<T> clazz) {
        this.clazz = clazz;
    }

    public abstract List<T> getAll();
    private static final SessionFactory FACTORY;//tạo getFactory
    //khối tĩnh này chạy 1 lần
    static {
        Configuration conf=new Configuration();
        //C1. cung cấp thông tin cấu hình file xml
        conf.configure("hibernate.cfg.xml");

        //Khai bao tồn tại Category
        conf.addAnnotatedClass(Phone.class);
        conf.addAnnotatedClass(Manufacture.class);
        //ServiceRegistry lớp trừ tượng ko thay đổi theo thời gian
        ServiceRegistry registry= new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
        FACTORY =conf.buildSessionFactory(registry);
    }
    public static SessionFactory getFactory() {
        return FACTORY;
    }

    public boolean add(T t) {
        Session session = AbstractDAO.getFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(t);
            tx.commit();
            return true;
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    public List<T> query(String hql) {
        Session session=AbstractDAO.getFactory().openSession();
        Query q=session.createQuery(hql);
        List<T> resultList =q.getResultList();
        return resultList;
    }

    public boolean remove(String id) {
        Session session=AbstractDAO.getFactory().openSession();
        Transaction tx = null;
        try{
            T obj = session.get(clazz,id);
            tx = session.getTransaction();
            tx.begin();
            session.delete(obj);
            tx.commit();
            return  true;
        }catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    public boolean update(T t) {
        Session session=AbstractDAO.getFactory().openSession();
        Transaction tx = null;
        try{
            tx = session.getTransaction();
            tx.begin();
            session.update(t);
            tx.commit();
            return  true;
        }catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    public T get(String id) {
        Session session=AbstractDAO.getFactory().openSession();
        try{
            T obj = session.get(clazz,id);
            return  obj;
        }catch (HibernateException e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }



    public boolean remove(T t) {
        Session session=AbstractDAO.getFactory().openSession();
        Transaction tx = null;
        try{
            tx = session.getTransaction();
            tx.begin();
            session.delete(t);
            tx.commit();
            return  true;
        }catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }
}
