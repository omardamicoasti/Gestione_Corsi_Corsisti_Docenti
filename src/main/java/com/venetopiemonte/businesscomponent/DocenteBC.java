package com.venetopiemonte.businesscomponent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.venetopiemonte.architecture.dao.DocenteDAO;
import com.venetopiemonte.businesscomponent.model.Docente;
import com.venetopiemonte.dbaccess.DBAccess;
import com.venetopiemonte.exceptions.DAOException;

public class DocenteBC {
	Connection conn;
	
	
	public DocenteBC() throws ClassNotFoundException, DAOException, IOException {
		conn = DBAccess.getConnection();
	}
	
	public Docente getDocenteById(long codDocente) throws DAOException {
		try {
			return DocenteDAO.getFactory().getById(conn, codDocente);			
		} catch (SQLException sql) {
			throw new DAOException(sql);
		} finally {
			DBAccess.closeConnection();
		}
	}
	
	public Docente[] getDocenti() throws DAOException {
		try {
			return DocenteDAO.getFactory().getAll(conn);			
		} catch (SQLException sql) {
			throw new DAOException(sql);
		} finally {
			DBAccess.closeConnection();
		}
	}
}
