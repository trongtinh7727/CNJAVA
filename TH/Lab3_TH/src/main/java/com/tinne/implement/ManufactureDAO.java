package com.tinne.implement;

import com.tinne.dao.IManufacture;
import com.tinne.pojo.Manufacture;
import com.tinne.pojo.Phone;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class ManufactureDAO extends AbstractDAO<Manufacture> implements IManufacture {
    public ManufactureDAO(Class<Manufacture> clazz) {

        super(clazz);
    }

    @Override
    public boolean chkMoreT100() {
        Session session = AbstractDAO.getFactory().openSession();
        Criteria cr = session.createCriteria(Manufacture.class);
        cr.add(Restrictions.gt("employee",100));
        if (cr.list().isEmpty())
            return false;
        return true;
    }

    @Override
    public int countEmployee() {
        Session session = AbstractDAO.getFactory().openSession();
        Criteria cr = session.createCriteria(Phone.class);
        cr.setProjection(Projections.sum("employee"));
        if (cr.list().isEmpty()){
            return  -1;
        }
        return (int) cr.list().get(0);
    }

    @Override
    public Manufacture chkCriteria  () {
        Session session = AbstractDAO.getFactory().openSession();
        Criteria cr = session.createCriteria(Phone.class);
        cr.add(Restrictions.ilike("location","%US%"));
        if (cr.list().isEmpty())
           return null;
        return (Manufacture) cr.list().get(0);
    }

    @Override
    public List<Manufacture> getAll() {
        String hql = "FROM Manufacture";
        return this.query(hql);
    }
}
