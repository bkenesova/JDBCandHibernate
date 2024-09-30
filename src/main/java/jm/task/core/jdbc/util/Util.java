package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String URL = "jdbc:postgresql://localhost:5272/postgres";
    private static final String USER = "root";
    private static final String PASSWORD = "123";

    private static SessionFactory sessionFactory;

    public static Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        return conn;
    }


    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration()
                        .setProperty("hibernate.connection.url", URL)
                        .setProperty("hibernate.connection.username", USER)
                        .setProperty("hibernate.connection.password", PASSWORD)
                        .setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect")
                        .setProperty("hibernate.hbm2ddl.auto", "update")
                        .addAnnotatedClass(User.class);

                sessionFactory = configuration.buildSessionFactory();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}