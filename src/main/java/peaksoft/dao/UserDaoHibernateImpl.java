package peaksoft.dao;

import org.hibernate.*;
import peaksoft.model.User;

import org.hibernate.Session;
import peaksoft.util.Config;

import javax.security.auth.login.Configuration;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    public UserDaoHibernateImpl() {

    }

    @Override
    public User   UpdateUser(long id ,String name, String surname, byte age) {
        try {
            Session session= Config.getSession().openSession();
            session.beginTransaction();
            User user = (User) session.get(User.class,id);
            user.setName(name);
            user.setLastName(surname);
            user.setAge(age);
            session.getTransaction().commit();
            session.close();
            return user;
        }catch (HibernateException e){
            e.getMessage();
            return null;
        }

    }

    @Override
    public void createUsersTable() {
       try{

        Session session = Config.getSession().openSession();
        String sql = "create table if not exists users(\n" +
                "  id SERIAL PRIMARY KEY  ,\n" +
                "  name varchar(50),\n" +
                " lastName varchar(60) ,\n" +
                " age INTEGER\n" +
                ")";
        session.beginTransaction();
        session.createSQLQuery(sql);
        session.getTransaction().commit();
        session.close();
    }catch (HibernateException e){
           System.out.println(e.getMessage());
       }
    }


    @Override
    public void dropUsersTable() {
        try {
            Session session = Config.getSession().openSession();
            session.beginTransaction();
            Query query = session.createSQLQuery("DROP TABLE users;");
            query.executeUpdate();
            session.getTransaction().commit();
            session.close();
        }catch (HibernateException e ){
            System.out.println(e.getMessage());
        }



    }

    @Override
    public void saveUser(User user) {
      try {
          Session session = Config.getSession().openSession();
          session.beginTransaction();
          session.save(user);
          session.getTransaction().commit();
          session.close();
      }catch (HibernateException e){
          System.out.println(e.getMessage());
      }

    }

    @Override
    public void removeUserById(long id) {
        try {
            Session session = Config.getSession().openSession();
            session.beginTransaction();
            User user= (User) session.get(User.class,id);
            session.delete(user);
            session.getTransaction().commit();
            session.close();
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<User> getAllUsers() {
    try {
        Session session= Config.getSession().openSession();
        session.beginTransaction();
        List<User> users=session.createQuery("from User").list();
        session.getTransaction().commit();
        session.close();
 return users;
    }catch (HibernateException e){
        System.out.println(e.getMessage());
    return null;
    }
    }

    @Override
    public void cleanUsersTable() {
        try {
            Session session = Config.getSession().openSession();
            session.beginTransaction();
             session.createQuery("delete from User").executeUpdate();
             session.getTransaction().commit();
            session.close();
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }
    }
}
