package com.majorbit.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static DBConnection instance = null;
    public DBConnection() {

    }
        public static DBConnection getInstance() {
            if(instance ==null) {
                instance = new DBConnection();
            }
            return instance;
        }

        private Connection connection;

        public void init() {

            try {
                Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
    			String url="jdbc:mysql://fonderium.it:3306/provola4kdb?autoReconnect=true&useSSL=false"; //dbms+server+porta+nome database
                String username = "provola4k";
                String password = "provola4k";
                connection = DriverManager.getConnection(url,username, password);
                connection.setAutoCommit(false);
            } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {

                e.printStackTrace();
            } catch (SQLException e) {

                e.printStackTrace();
            }
        }

        public Connection getConnection() {

            try {
                if(connection == null || connection.isClosed()) {
                    init();
                }
            } catch (SQLException e) {

                e.printStackTrace();
            }

            return connection;


        }
}