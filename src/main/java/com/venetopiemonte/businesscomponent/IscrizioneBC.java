package com.venetopiemonte.businesscomponent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;


import com.venetopiemonte.architecture.dao.IscrizioneDAO;
import com.venetopiemonte.businesscomponent.model.Iscrizione;
import com.venetopiemonte.dbaccess.DBAccess;
import com.venetopiemonte.exceptions.DAOException;

public class IscrizioneBC {
	private Connection conn;

	public IscrizioneBC() throws ClassNotFoundException, DAOException, IOException {
		conn=DBAccess.getConnection();
	}
	
	public void create(Iscrizione iscrizione) 
			throws DAOException, ClassNotFoundException, IOException {
		try {
			IscrizioneDAO.getFactory().create(conn, iscrizione);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		} finally {
			DBAccess.closeConnection();
		}
	}
	
	public Iscrizione[] getIscrizioni() throws DAOException {
		Iscrizione[] iscrizioni= null;
		try {
			iscrizioni = IscrizioneDAO.getFactory().getAll(conn);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		} finally {
			DBAccess.closeConnection();
		}
		return iscrizioni;
	}
	
	public long[] getIscrittiByCorso(long id) throws DAOException {
		try {
			return IscrizioneDAO.getFactory().getIscrittiByCorso(conn, id);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		} finally {
			DBAccess.closeConnection();
		}
	}
	
	public long[] getNonIscrittiByCorso(long id) throws DAOException {
		try {
			return IscrizioneDAO.getFactory().getNonIscrittiByCorso(conn, id);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		} finally {
			DBAccess.closeConnection();
		}
	}
	
	public long[] getCorsiByIscritto(long id) throws DAOException {
		try {
			return IscrizioneDAO.getFactory().getCorsiByIscritto(conn, id);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		} finally {
			DBAccess.closeConnection();
		}
	}
	
	public void delete(long idCorsista, long idCorso) throws DAOException {
		try {
			IscrizioneDAO.getFactory().delete(conn, idCorsista, idCorso);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		} finally {
			DBAccess.closeConnection();
		}
	}
	
}
