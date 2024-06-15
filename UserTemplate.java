package com.voidmain.dao;

import java.io.*;
import java.sql.*;
import java.util.*;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class UserTemplate {

  

    public static int addObject(Object obj) throws ClassNotFoundException {
        int result = 0;
        String sql = "INSERT INTO Users (column1, column2) VALUES (?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Set parameters
            // pstmt.setString(1, obj.getField1());
            // pstmt.setString(2, obj.getField2());

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Object getObject(Class<?> c, Serializable serializable) {
        Object obj = null;
        String sql = "SELECT * FROM Users WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, (Integer) serializable);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                // Create object from ResultSet
                // obj = new User(rs.getInt("id"), rs.getString("column1"), rs.getString("column2"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return obj;
    }

    public static List<Object> getObjectListByQuery(String query) {
        List<Object> list = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                // Create object from ResultSet and add to list
                // list.add(new User(rs.getInt("id"), rs.getString("column1"), rs.getString("column2")));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static int updateObject(Object obj) {
        int result = 0;
        String sql = "UPDATE Users SET column1 = ?, column2 = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Set parameters
            // pstmt.setString(1, obj.getField1());
            // pstmt.setString(2, obj.getField2());
            // pstmt.setInt(3, obj.getId());

            result = pstmt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static int deleteObject(Class<?> c, Serializable serializable) {
        int result = 0;
        String sql = "DELETE FROM Users WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, (Integer) serializable);

            result = pstmt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }
}
