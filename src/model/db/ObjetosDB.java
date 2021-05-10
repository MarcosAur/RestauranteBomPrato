package model.db;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author marcos
 */
public class ObjetosDB {

    private static Connection conec;

    private static Properties loadProperties() {
        try (FileInputStream is = new FileInputStream("db.properties")) {

            Properties props = new Properties();
            props.load(is);
            return props;

        } catch (IOException ex) {
            throw new DbException(ex.getMessage());
        }
    }

    public static Connection getConnection() {

        Properties props = loadProperties();
        String dburl = props.getProperty("dburl");
        try {
            conec = DriverManager.getConnection(dburl, props);
            return conec;
        } catch (SQLException ex) {
            throw new DbException(ex.getMessage());
        }
    }

    public static void closeConnection() {
        if (conec != null) {
            try {
                conec.close();
            } catch (SQLException ex) {
                throw new DbException(ex.getMessage());
            }
        }
    }

    public static void closeStatement(Statement st) {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException ex) {
                throw new DbException(ex.getMessage());
            }
        }
    }

    public static void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                throw new DbException(ex.getMessage());
            }
        }
    }
}
