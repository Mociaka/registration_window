package com.example.registrationwindow;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

public class DatabaseHendler extends Configs{
    Connection connection;

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        String connectionString  = "jdbc:mysql://" + dbHost + ":" +dbPort + "/" +dbName;
        Class.forName("com.mysql.cj.jdbc.Driver");
//        Class.forName("com.mysql.jdbc.Driver");

        connection = DriverManager.getConnection(connectionString,dbUser, dbPass);
        return  connection;
    }

    public void SignUpUser(Users user)  {
        String insert = "INSERT INTO " + Const.USER_TABLE +
                " (" + Const.USER_FIRST_NAME + ", " + Const.USER_LAST_NAME + ", " +
                Const.USER_NAME + ", " + Const.USER_PASSWORD + ", " +
                Const.USER_LOCATION + ", " + Const.USER_GENDER + ") " +
                " VALUES (?, ?, ?, ?, ?, ?)";
        try {
        PreparedStatement prst = getConnection().prepareStatement(insert);

            prst.setString(1,user.getFirstName());
            prst.setString(2,user.getLastName());
            prst.setString(3,user.getUserName());
            prst.setString(4, createHash(user.getPasswrod()));
            prst.setString(5,user.getLocation());
            prst.setString(6,user.getGender());

            prst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        }

    }

    public ResultSet getUser(Users user){
        ResultSet resultSet =null;
        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " + Const.USER_NAME + "=? AND " + Const.USER_PASSWORD + "=?";
        try {


        PreparedStatement ps = getConnection().prepareStatement(select);
        ps.setString(1,user.getUserName());
        ps.setString(2, createHash(user.getPasswrod()));

        resultSet = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        }
        return  resultSet;


    }
    public String createHash(String input) {

        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        byte[] hash = md.digest(input.getBytes(StandardCharsets.UTF_8));
        BigInteger number = new BigInteger(1, hash);
        StringBuilder hexString = new StringBuilder(number.toString(16));
        while (hexString.length() < 32) {
            hexString.insert(0, '0');
        }


        return hexString.toString().substring(0,32);
    }


}
