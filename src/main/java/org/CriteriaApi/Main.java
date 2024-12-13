package org.CriteriaApi;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.jack.HibernateUtil;
import org.jack.Student;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SessionFactory factory= HibernateUtil.getSessionfactory();
        Session session= factory.openSession();
// criteria api is used to filter data with writing queries.......
        Criteria criteria=session.createCriteria(Student.class);


        // queries.......................................................................
//        criteria.add(Restrictions.gt("id",2));
//        criteria.add(Restrictions.lt("id",5));
//        criteria.add(Restrictions.between("id",2,8));
//        to find name starts with
   //     criteria.add(Restrictions.like("name","j%"));
//        criteria.add(Restrictions.eq("address","noida"));
//        criteria.add(Restrictions.between("id",2,8));

        List<Student> list= criteria.list();
        for(Student s: list){
            System.out.println(s);
        }

        session.close();
        factory.close();

    }

}