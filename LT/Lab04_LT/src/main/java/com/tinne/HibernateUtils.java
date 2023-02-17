package com.tinne;

import com.tinne.pojo.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import javax.persistence.Query;
import java.util.List;


public class HibernateUtils {
    private static final SessionFactory FACTORY;//tạo getFactory
    //khối tĩnh này chạy 1 lần
    static {
        Configuration conf=new Configuration();
        //C1. cung cấp thông tin cấu hình file xml
        conf.configure("hibernate.cfg.xml");

        //Khai bao tồn tại Category
        conf.addAnnotatedClass(Student.class);
        //ServiceRegistry lớp trừ tượng ko thay đổi theo thời gian
        ServiceRegistry registry= new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
        FACTORY =conf.buildSessionFactory(registry);

    }
    public static SessionFactory getFactory() {
        return FACTORY;
    }


    public  static void update(Student s){
        Session session=HibernateUtils.getFactory().openSession();
        try{
            Student student = session.get(Student.class,s.getId());
            student.copy(s);
            session.getTransaction().begin();
            session.save(student);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }

    public  static void delete(int id){
        Session session=HibernateUtils.getFactory().openSession();
        Transaction tx = null;
        try{
            Student student = session.get(Student.class,id);
            tx = session.getTransaction();
            tx.begin();
            session.delete(student);
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
    public  static void insert(Student s){
        Session session=HibernateUtils.getFactory().openSession();
        try{
            session.getTransaction().begin();
            session.save(s);
            session.getTransaction().commit();

        } finally {
            session.close();
        }
    }

    public static List<Student> query(String hql) {
        Session session=HibernateUtils.getFactory().openSession();
        Query q=session.createQuery(hql);
        List<Student> students =q.getResultList();
        return students;
    }
}
