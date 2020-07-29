package com.springmvc.DBTools;

import java.sql.*;
import java.util.Properties;

/**
 * 数据库连接
 */
public class DBDao {
    Connection connection = null;
    Statement statement = null;
    ResultSet rs = null;

    String driverName = null;
    String url = null;
    String userName = null;
    String password = null;

    /**
     * 获取数据库的链接
     * @return
     * @throws Exception
     */
    public Connection getConnection() throws Exception {
        Class.forName(driverName).newInstance();
        Driver driver = DriverManager.getDriver(url);
        Properties props = new Properties();
        props.put("user", userName);
        props.put("password", password);
        connection = driver.connect(url, props);
        return connection;
    }

    /**
     * 关闭数据库连接
     */
    protected void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭statement
     */
    protected void closeStatement() {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭结果集
     */
    protected void closeResultSet() {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭所有
     */
    protected void closeAll() {
        closeResultSet();
        closeStatement();
        closeConnection();
    }
}
