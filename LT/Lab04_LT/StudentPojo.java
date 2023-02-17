package com.tinne.pojo;

import com.tinne.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.List;

public class StudentPojo {


    public void addStudent(Student s){
        HibernateUtils.update(s);
    }

    public List<Student> sellectAll() {
            String hql = "FROM Student";
            return HibernateUtils.query(hql);
    }

    public Student selectById(String id) {
        String hql = "FROM Student where id = "+ id;
        List<Student> students = HibernateUtils.query(hql);
        if (students.isEmpty()){
            return  null;
        }else
            return students.get(0);
    }

    public int insert(Student student) {
        try {
            HibernateUtils.insert(student);
            return 1;
        }catch (Exception e){
            return -1;
        }
    }

    public int upate(Student student) {
        try {
            HibernateUtils.update(student);
            return 1;
        }catch (Exception e){
            return -1;
        }
    }

    public int delete(int id) {
        try {
            HibernateUtils.delete(id);
            return 1;
        }catch (Exception e){
            return -1;
        }
    }
}
