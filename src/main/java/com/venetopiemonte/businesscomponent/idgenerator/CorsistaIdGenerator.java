package com.venetopiemonte.businesscomponent.idgenerator;

import java.sql.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.venetopiemonte.architecture.dao.DAOConstants;
import com.venetopiemonte.dbaccess.DBAccess;
import com.venetopiemonte.exceptions.DAOException;

public class CorsistaIdGenerator implements IdGeneratorInterface, DAOConstants {
	private static CorsistaIdGenerator idGen;
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	private CorsistaIdGenerator() throws ClassNotFoundException, DAOException, IOException {
		conn = DBAccess.getConnection();
	}
	
	public static CorsistaIdGenerator getInstance() throws ClassNotFoundException, DAOException, IOException {
		if (idGen == null) {
			idGen = new CorsistaIdGenerator();
		}
		return idGen;
	}
	
	@Override
	public long getNextId() throws ClassNotFoundException, DAOException, IOException {
		long id = 0;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SELECT_CORSISTASEQ);
			rs.next();
			id = rs.getLong(1);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return id;
	}
	
}
