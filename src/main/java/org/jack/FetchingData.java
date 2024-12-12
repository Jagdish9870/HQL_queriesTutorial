package org.jack;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import java.util.List;
import java.util.Scanner;

public class FetchingData {
    public static void main(String[] args) {

        System.out.println("choose option given below");
        System.out.println("choose 1 to see all data");
        System.out.println("choose 2 to see data with multiple fields");
        System.out.println("choose 3 to see data by id ");
          System.out.println("choose 4 to update data ");
        System.out.println("choose 5 to delete data by id ");
        System.out.println("choose 6  to exit");

        Scanner sc= new Scanner(System.in);
        int choice = sc.nextInt();
        switch(choice){


            case 1:
                SessionFactory factory= HibernateUtil.getSessionfactory();
                Session session= factory.openSession();
                Transaction tx= session.beginTransaction();
                Query q= session.createQuery("from Student");
            List<Student> list= q.list();
            for(Student s:list){
                System.out.println(s);
            }

                tx.commit();
                session.close();
                factory.close();
                break;
            case 2:
                SessionFactory factory2= HibernateUtil.getSessionfactory();
                Session session2= factory2.openSession();
                Transaction tx2= session2.beginTransaction();
                Query q2= session2.createQuery("from Student as s where s.id=:id and s.address=:ad");
                q2.setParameter("id",1);
                q2.setParameter("ad","noida");
                System.out.println(q2.uniqueResult());


                tx2.commit();
                session2.close();
                factory2.close();
                break;
            case 3:
                SessionFactory factory3= HibernateUtil.getSessionfactory();
                Session session3= factory3.openSession();
                Transaction tx3= session3.beginTransaction();
                Query q3= session3.createQuery("from Student as s where s.id= '1' ");


                System.out.println(q3.uniqueResult());

                tx3.commit();
                session3.close();
                factory3.close();
                break;
            case 4:
                SessionFactory factory4= HibernateUtil.getSessionfactory();
                Session session4= factory4.openSession();
                Transaction tx4= session4.beginTransaction();
                Query q4= session4.createQuery("update Student set address='kurukshetra' where id='1' ");

                System.out.println(q4.executeUpdate()+" updated successfully");

                tx4.commit();
                session4.close();
                factory4.close();
                break;
            case 5:
                SessionFactory factory5= HibernateUtil.getSessionfactory();
                Session session5= factory5.openSession();
                Transaction tx5= session5.beginTransaction();
                Query q5= session5.createQuery("delete from Student where id='2' ");


                System.out.println(q5.executeUpdate()+ " deleted successfully");

                tx5.commit();

                session5.close();
                factory5.close();
                break;
            default:
                break;
        }
    }
}
