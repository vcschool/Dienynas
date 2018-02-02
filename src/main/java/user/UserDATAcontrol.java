package user;

import java.sql.*;


public class UserDATAcontrol {

    private static final String DRIVER = "org.h2.Driver";
    private static final String URL = "jdbc:h2:~/dienynas";
    private static final String USER_NAME = "admin";
    private static final String PASSWORD = "admin";

    public static User connectUser(String firstName) {

        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        try {
            try (
                    Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
                    PreparedStatement statement = connection.prepareStatement(
                            "SELECT * FROM users WHERE firstName = ? ")
            ) {
                statement.setString(1, firstName);
                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    return new User(resultSet.getString("firstName"),
                            resultSet.getString("lastName"),
                            resultSet.getString("password"),
                            resultSet.getString("course"),
                            resultSet.getString("role"));
                }
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        return null;
    }

    public static String findCourse() {

        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        try (
                Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
                PreparedStatement statement = connection.prepareStatement(
                        "SELECT course FROM users")
        ) {
            ResultSet resultSet = statement.executeQuery();

            ResultSetMetaData rsmd = resultSet.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while (resultSet.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) System.out.print(",  ");
                    String columnValue = resultSet.getString(i);
                    System.out.print(columnValue + " " + rsmd.getColumnName(i));
                }


        }



    } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


    public static String findStudents(String course) {

        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        try (
                Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
                PreparedStatement statement = connection.prepareStatement(
                        "SELECT FIRSTNAME ,LASTNAME  FROM USERS WHERE COURSE =?")
        ) {
            statement.setString(1, course);
            ResultSet resultSet = statement.executeQuery();

            ResultSetMetaData rsmd = resultSet.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while (resultSet.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) System.out.print(",  ");
                    String columnValue = resultSet.getString(i);
                    System.out.print(columnValue + " " + rsmd.getColumnName(i));
                }


            }



        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }

    public static User changePassword(String password, String firstName, String lastName) {

        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }



            try (
                    Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
                    PreparedStatement statement = connection.prepareStatement(
                            "UPDATE USERS SET PASSWORD = ? WHERE FIRSTNAME = ? AND LASTNAME =? ")
            ) {
                statement.setString(1, password);
                statement.setString(2, firstName);
                statement.setString(3, lastName);
                statement.execute();


            } catch (SQLException e) {
                e.printStackTrace();
            }

        return null;
    }



}