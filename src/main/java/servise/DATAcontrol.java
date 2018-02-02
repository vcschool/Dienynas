package servise;

import user.User;

import java.sql.*;



public class DATAcontrol {

    private static final String DRIVER = "org.h2.Driver";
    private static final String URL = "jdbc:h2:~/dienynas";
    private static final String USER_NAME = "admin";
    private static final String PASSWORD = "admin";


    public static void insertUser(User user) {

        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (
                Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
                PreparedStatement statement = connection.prepareStatement("INSERT INTO users(FIRSTNAME, LASTNAME, ROLE, PASSWORD, COURSE )" +
                        "VALUES(" + "'"+ user.getFirstName() + "','" + user.getLastName() + "','" +
                        user.getRole() + "','" + user.getPassword() + "','" + user.getCourse() + "')")
        ) {
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void getUser(String firstName){

        try (
                Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE firstName = '" + firstName + "';")
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

    }

    public static void creatDB(){
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (
                Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
                PreparedStatement statement = connection.prepareStatement(
                        "CREATE TABLE IF NOT EXISTS users " +
                                "(" +
                                "    FIRSTNAME  VARCHAR(50)," +
                                "    LASTNAME VARCHAR(50)," +
                                "    ROLE VARCHAR(50)," +
                                "    PASSWORD VARCHAR(50)," +
                                "    COURSE VARCHAR(50)," +
                                "    ID int NOT NULL AUTO_INCREMENT" +
                                ");"
                )
        ) {
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    }


//    public static Course courseControl(){
//
//
//        try {
//            Class.forName(DRIVER);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//
//        try {
//            try (
//                    Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
//                    PreparedStatement statement = connection.prepareStatement(
//                            "INSERT INTO courses (COURSE,STARTDATE) VALUES(?,?)")
//            ) {
//                statement.setString(1,Course.getTitle());
//                statement.setDate(2, java.sql.Date.valueOf(String.valueOf(Course.getStartDate())));
//                statement.execute();
//
//            }
//        } catch (SQLException e1) {
//            e1.printStackTrace();
//        }
//
//        return null;
//    }

//    public static Course showCourse(String title) {
//
//        try {
//            Class.forName(DRIVER);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//
//        try {
//            try (
//                    Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
//                    PreparedStatement statement = connection.prepareStatement(
//                            "SELECT * FROM courses WHERE title=? ")
//            ) {
//                statement.setString(1, title);
//                ResultSet resultSet = statement.executeQuery();
//
//                if (resultSet.next()) {
//                    return new Course(resultSet.getString("title"),
//                            resultSet.getDate(String.valueOf("startdare")),
//                            resultSet.getInt("personalnumber"));
//                }
//            }
//        } catch (SQLException e1) {
//            e1.printStackTrace();
//        }
//
//        return null;
//    }







