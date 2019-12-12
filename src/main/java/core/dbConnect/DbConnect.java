package core.dbConnect;

import core.General.envGlobals;
import core.configuration.configProperties;

import java.sql.*;

public class DbConnect {
    static configProperties configProps = new configProperties();

    public static String url = "";
    public static String username = "";
    public static String password = "";

    static Connection connection = null;
    static Statement statement = null;

    public static void qa_ConnectDb() throws ClassNotFoundException, SQLException {
        url = configProps.QA_dbUrl;
        username = configProps.QA_dbUserName;
        password = configProps.QA_dbPassword;

        Class.forName("com.mysql.jdbc.Driver"); // MYSQL
        connection = DriverManager.getConnection(url, username, password); //DB connection
    }

    public static void dev_ConnectDb() throws ClassNotFoundException, SQLException {
        url = configProps.DEV_dbUrl;
        username = configProps.DEV_dbUserName;
        password = configProps.DEV_dbPassword;

        Class.forName("com.mysql.jdbc.Driver"); // MYSQL
        connection = DriverManager.getConnection(url, username, password); //DB connection
    }

    public static void uat_ConnectDb() throws ClassNotFoundException, SQLException {
        url = configProps.UAT_dbUrl;
        username = configProps.UAT_dbUserName;
        password = configProps.UAT_dbPassword;

        Class.forName("com.mysql.jdbc.Driver"); // MYSQL
        connection = DriverManager.getConnection(url, username, password); //DB connection
    }

    public static void qa_dbConnection() {
        try {
            qa_ConnectDb();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Connection Failed!");
            e.printStackTrace();
        }    }

    public static void dev_dbConnection() {
        try {
            dev_ConnectDb();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Connection Failed!");
            e.printStackTrace();
        }    }

    public static void uat_dbConnection() {
        try {
            uat_ConnectDb();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Connection Failed!");
            e.printStackTrace();
        }    }

    public static void allDBConn() throws SQLException, ClassNotFoundException {
        qa_ConnectDb();
        dev_ConnectDb();
        uat_ConnectDb();
    }

    public static void getQAID() throws SQLException {
        String query = "";
        ResultSet rs = null;
        String data = "";

        query = "select * from employees where email = 'test@gmail.com'";

        statement = connection.createStatement();
        rs = statement.executeQuery(query);
        rs.setFetchSize(100);
        while (rs.next()) {
            data = rs.getString("Id");
//            envGlobals.myID = Integer.parseInt(data);
            break;
        }
        rs.close();
    }



}
