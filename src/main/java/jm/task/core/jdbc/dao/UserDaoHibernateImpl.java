package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;


import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
   // private Transaction transaction = null;
    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {
        //try (Session session = Util.getSessionFactory().openSession()) {
           // Query query = session.createSQLQuery()
       // }
    }

    @Override
    public void dropUsersTable() {
//        try (Session session = Util.getSessionFactory().openSession()) {
//            String query = "create table if not exists users (id INT AUTO_INCREMENT PRIMARY KEY NOT NULL, name VARCHAR(64) NOT NULL, lastName VARCHAR(64) NOT NULL, age TINYINT)";
//                    session.createSQLQuery()
//        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
//        try (Session session = Util.getSessionFactory().openSession()) {
//            User user = new User();
//            transaction = session.beginTransaction();
//            session.save()
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//            e.printStackTrace();
//        }
    }

    @Override
    public void removeUserById(long id) {
//        try (Session session = Util.getSessionFactory().openSession()) {
//            User user = session.load(User.class, id);
//            session.delete(user);
//            session.flush(); //This makes the pending delete to be done
//        }
    }

    @Override
    public List<User> getAllUsers() {
//        try (Session session = Util.getSessionFactory().openSession()) {
//            return session.createSQLQuery("from users", User.class).list();
//        }
        return null;
    }

    @Override
    public void cleanUsersTable() {
//        try (Session session = Util.getSessionFactory().openSession()) {
//            Query query = session.createSQLQuery()
//        }
    }
}
