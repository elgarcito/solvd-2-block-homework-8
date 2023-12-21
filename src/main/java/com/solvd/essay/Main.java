package com.solvd.essay;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static {
        System.setProperty("log4j.configurationFile", "log4j2.xml");

    }
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/solvd_essay","root","Edgar1269!");
        conn.setAutoCommit(false);
        try {
            PreparedStatement ps =conn.prepareStatement("insert into essay_module (module_description) value (?) ", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,"Greater module");
            ps.executeUpdate();


        } catch (Exception e) {
            conn.rollback();
        }
        finally {
            conn.setAutoCommit(true);
        }


    }
}