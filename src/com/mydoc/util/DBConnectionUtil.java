package com.mydoc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mydoc.util.CommonUtil;
import com.mydoc.util.CommonConstants;

public class DBConnectionUtil extends CommonUtil {
	private static Connection connection;
	private DBConnectionUtil() {
	}
	
	public static Connection getDBConnection() throws ClassNotFoundException, SQLException {
		if (connection == null || connection.isClosed()) {

			Class.forName(properties.getProperty(CommonConstants.DRIVER_NAME));
			connection = DriverManager.getConnection(properties.getProperty(CommonConstants.URL),
					properties.getProperty(CommonConstants.USERNAME), properties.getProperty(CommonConstants.PASSWORD));
		}
		return connection;
	}
}
