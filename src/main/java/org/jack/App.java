package org.jack;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.function.DoubleToIntFunction;

public class App
{
    public static void main( String[] args )
    {
        SessionFactory factory= HibernateUtil.getSessionfactory();
        System.out.println(factory);

        // to add data
        Student st= new Student(2,"john","noida");

        Session session=factory.openSession();
        Transaction tx= session.beginTransaction();

        session.save(st);
        tx.commit();
        session.close();
        factory.close();

    }
}
