package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import org.hibernate.Session;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

public class UserDaoHibernateImpl implements UserDao {
    private static String createQuery = "create table if not exists user" +
            "(id INT AUTO_INCREMENT PRIMARY KEY NOT NULL," +
            " name VARCHAR(64) NOT NULL," +
            " lastName VARCHAR(64) NOT NULL, age TINYINT)";
    public UserDaoHibernateImpl() {

    }

    @Override
    @Transactional
    public void createUsersTable() {
        try (Session session = Util.getSessionFactory().openSession()) {
            session.beginTransaction();
            Query query = session.createSQLQuery(createQuery).addEntity(User.class);
            query.executeUpdate();
        }
    }

    @Override
    @Transactional
    public void dropUsersTable() {
        try (Session session = Util.getSessionFactory().openSession()) {
            session.beginTransaction();
            Query query = session.createSQLQuery("drop table if exists user").addEntity(User.class);
            query.executeUpdate();
        }
    }

    @Override
    @Transactional
    public void saveUser(String name, String lastName, byte age) {
        try (Session session = Util.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(new User(name, lastName, age));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    @Transactional
    public void removeUserById(long id) {
        try (Session session = Util.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(session.find(User.class, id));
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        try (Session session = Util.getSessionFactory().openSession()) {
            session.beginTransaction();
            return session.createSQLQuery("select * from user").addEntity(User.class).list();
        }
    }

    @Override
    @Transactional
    public void cleanUsersTable() {
        try (Session session = Util.getSessionFactory().openSession()) {
            session.beginTransaction();
            Query query = session.createSQLQuery("truncate table user").addEntity(User.class);
            query.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}