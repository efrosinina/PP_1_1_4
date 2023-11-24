package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Util {
    static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/users";
    static final String DB_USER = "root";
    static final String DB_PASSWORD = "LizaWizard77@";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            System.out.println("Connection is success");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Connection is failed");
        }
        return connection;
    }
}

//    private static SessionFactory sessionFactory;
//    public static SessionFactory getSessionFactory() {
//        if (sessionFactory == null) {
//            try {
//                Configuration configuration = new Configuration();
//                Properties settings = new Properties();
//                settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
//                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/userse");
//                settings.put(Environment.USER, "root");
//                settings.put(Environment.PASS, "LizaWizard77@");
//                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
//                settings.put(Environment.SHOW_SQL, "true");
//                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
//                settings.put(Environment.HBM2DDL_AUTO, "create-drop");
//                configuration.setProperties(settings);
//                configuration.addAnnotatedClass(User.class);
//
//                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
//                        .applySettings(configuration.getProperties()).build();
//                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return sessionFactory;
//    }
