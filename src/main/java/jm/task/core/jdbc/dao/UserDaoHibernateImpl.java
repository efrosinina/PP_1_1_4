//package jm.task.core.jdbc.dao;
//
//import jm.task.core.jdbc.model.User;
//import org.hibernate.Session;
//import org.hibernate.Transaction;
//import jm.task.core.jdbc.util.Util;
//import org.hibernate.query.Query;
//
//import java.util.List;
//import java.util.logging.Logger;
//
//public class UserDaoHibernateImpl implements UserDao {
//    private static String createQuery = "create table if not exists users" +
//            "(id INT AUTO_INCREMENT PRIMARY KEY NOT NULL," +
//            " name VARCHAR(64) NOT NULL," +
//            " lastName VARCHAR(64) NOT NULL, age TINYINT)";
//    public UserDaoHibernateImpl() {
//
//    }
//
//    @Override
//    public void createUsersTable() {
//        try (Session session = Util.getSessionFactory().openSession()) {
//            Transaction transaction = session.beginTransaction();
//            Query query = session.createSQLQuery(createQuery).addEntity(User.class);
//            query.executeUpdate();
//            transaction.commit();
//        }
//    }
//
//    @Override
//    public void dropUsersTable() {
//        try (Session session = Util.getSessionFactory().openSession()) {
//            Transaction transaction = session.beginTransaction();
//            Query query = session.createSQLQuery("drop table if exists users").addEntity(User.class);
//            query.executeUpdate();
//            transaction.commit();
//        }
//    }
//
//    @Override
//    public void saveUser(String name, String lastName, byte age) { //Done
//        Transaction transaction = null;
//        try (Session session = Util.getSessionFactory().openSession()) {
//            transaction = session.beginTransaction();
//            session.save(new User(name, lastName, age));
//            transaction.commit();
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void removeUserById(long id) { // Done
//        Transaction transaction = null;
//        try (Session session = Util.getSessionFactory().openSession()) {
//            transaction = session.beginTransaction();
//            User user = session.load(User.class, id);
//            session.delete(user);
//            transaction.commit();
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//        }
//    }
//
//    @Override
//    public List<User> getAllUsers() { //Done
//        List<User> list = null;
//        try (Session session = Util.getSessionFactory().openSession()) {
//            Transaction transaction = session.beginTransaction();
//            return session.createSQLQuery("select * from users").addEntity(User.class).list();
//        }
//    }
//
//    @Override
//    public void cleanUsersTable() {
//        Transaction transaction = null;
//        try (Session session = Util.getSessionFactory().openSession()) {
//            transaction = session.beginTransaction();
//            Query query = session.createSQLQuery("truncate table users").addEntity(User.class);
//            query.executeUpdate();
//            transaction.commit();
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//        }
//    }
//}
