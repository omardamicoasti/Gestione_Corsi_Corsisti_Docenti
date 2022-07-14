package com.venetopiemonte.utilities;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.venetopiemonte.architecture.dao.DAOConstants;
import com.venetopiemonte.dbaccess.DBAccess;
import com.venetopiemonte.exceptions.DAOException;

public class LoginAdmin implements DAOConstants{
	private Connection conn;
	
	public LoginAdmin() throws ClassNotFoundException, DAOException, IOException {
		conn = DBAccess.getConnection();
	}
	
	public String controlloAdmin(long codAdmin) throws DAOException {
		PreparedStatement ps; 
		try {
			ps = conn.prepareStatement(SELECT_ADMINPASS);
			ps.setLong(1, codAdmin);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getString(1);
			}
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return null;
	}
	
	
	
}
