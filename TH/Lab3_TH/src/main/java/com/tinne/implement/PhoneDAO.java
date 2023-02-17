package com.tinne.implement;

import com.tinne.dao.IPhoneDAO;
import com.tinne.pojo.Phone;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;


import java.util.List;

public class PhoneDAO  extends AbstractDAO<Phone> implements IPhoneDAO{
    public List<Phone> getAll() {
        String hql = "FROM Phone";
        return this.query(hql);
    }

    public PhoneDAO(Class<Phone> clazz) {
        super(clazz);
    }

    public Phone topSell() {
        Session session = AbstractDAO.getFactory().openSession();
        Criteria cr = session.createCriteria(Phone.class);
        cr.setProjection(Projections.max("price"));
        String hql = "From Phone where price = ";
        if (cr.list().isEmpty()){
            return  null;
        }else
            hql += Integer.toString((int)cr.list().get(0));
        List<Phone> list = this.query(hql);
        return list.get(0);
    }

    public List<Phone> sort() {
        Session session = AbstractDAO.getFactory().openSession();
        Criteria cr = session.createCriteria(Phone.class);
        cr.addOrder(Order.asc("country"));
        cr.addOrder(Order.desc("price"));
        List<Phone> list = cr.list();
        return list;
    }

    public boolean above50Milion() {
        Session session = AbstractDAO.getFactory().openSession();
        Criteria cr = session.createCriteria(Phone.class);
        cr.add(Restrictions.gt("price",50000));
        if (cr.list().isEmpty())
            return false;
        return true;
    }

    public Phone meetCriteria() {
        Session session = AbstractDAO.getFactory().openSession();
        Criteria cr = session.createCriteria(Phone.class);
        cr.add(Restrictions.gt("price",1500));
        cr.add(Restrictions.ilike("color","pink"));
        if (cr.list().isEmpty())
            return null;
        return (Phone) cr.list().get(0);
    }
}
