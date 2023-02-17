package com.lab03.implement;

import com.lab03.dao.genericDAO;
import com.lab03.mapper.RowMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AbstractDAO<T> implements genericDAO<T> {

    private static String DB_URL = "jdbc:mysql://localhost:3306/qlsv";
    private static String USER_NAME = "root";
    private static String PASSWORD = "";
    public static Connection getConnection() {
        Connection conn = null;
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
//            System.out.println("connect successfully!");
        } catch (Exception ex) {
//            System.out.println("connect failure!");
            ex.printStackTrace();
        }
        return conn;
    }

    @Override
    public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters) {
        List<T> results = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;

        try {
                connection = getConnection();
                statement = connection.prepareStatement(sql);
                setParameter(statement,parameters);
                rs = statement.executeQuery();
                while (rs.next()){
                    results.add(rowMapper.mapRow(rs));
                }
                return results;

        }catch (SQLException e){
            return null;
        }finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (rs != null) {
                    rs.close();
                }

            }catch (SQLException e){
                return null;
            }
        }
    }

    @Override
    public int update(String sql, Object... parameters) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(sql);
            setParameter(statement,parameters);
            statement.executeUpdate();
            connection.commit();
            return 1;
        }
        catch (SQLException e){
            if (connection != null) {
                try {
                    connection.rollback();
                }catch (SQLException e1){
                    e1.printStackTrace();
                }
            }
            return -1;
        }finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (statement != null) {
                    statement.close();
                }
            }catch (SQLException e2){

                e2.printStackTrace();

            }
        }
    }

    @Override
    public Long insert(String sql, Object... parameters) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;

        try {
            connection = getConnection();
            Long id = null;
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(sql,statement.RETURN_GENERATED_KEYS);
            setParameter(statement,parameters);
            statement.executeUpdate();
            rs = statement.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getLong(1);
            }
            connection.commit();
            return   id;
        }
        catch (SQLException e){
            if (connection != null) {
                try {
                    connection.rollback();
                }catch (SQLException e1){
                    e1.printStackTrace();
                }
            }
        }finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (rs != null) {
                    rs.close();
                }
            }catch (SQLException e2){
                e2.printStackTrace();
            }
        }
        return null;
    }

    private void setParameter(PreparedStatement statement, Object... parameters) {
        try {
            for (int i = 0; i < parameters.length; i++) {
                Object parameter = parameters[i];
                int index = i+1;
                if (parameter instanceof Integer){
                    statement.setInt(index,(int) parameter);
                }
                if (parameter instanceof String){
                    statement.setString(index,(String) parameter);
                }
                if (parameter instanceof Float){
                    statement.setFloat(index,(float) parameter);
                }
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
