package com.venetopiemonte.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.venetopiemonte.businesscomponent.model.Docente;
import com.venetopiemonte.exceptions.DAOException;

public class DocenteDAO implements GenericDAO<Docente>, DAOConstants {

	public static DocenteDAO getFactory() throws DAOException {
		return new DocenteDAO();
	}

	private DocenteDAO() {
	}
	
	@Override
	public void create(Connection conn, Docente entity) throws DAOException {
		
	}

	@Override
	public void update(Connection conn, Docente entity) throws DAOException {
		
	}

	@Override
	public void delete(Connection conn, long id) throws DAOException {
		
	}

	@Override
	public Docente getById(Connection conn, long id) throws DAOException {
		Docente doc = null;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SELECT_DOCENTE_BYCOD);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				doc = new Docente();
				doc.setNome(rs.getString(1));
				doc.setCognome(rs.getString(2));
				doc.setCv(rs.getString(3));
				doc.setCodDocente(rs.getLong(4));
			}
			ps.close();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return doc;
	}

	@Override
	public Docente[] getAll(Connection conn) throws DAOException {
		Docente[] docenti = null;
		try {
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery(SELECT_DOCENTE);
			rs.last();
			docenti = new Docente[rs.getRow()];
			rs.beforeFirst();
			for (int i = 0; rs.next(); i++) {
				Docente doc = new Docente();
				doc.setNome(rs.getString(1));
				doc.setCognome(rs.getString(2));
				doc.setCv(rs.getString(3));
				doc.setCodDocente(rs.getLong(4));		
				docenti[i] = doc;
			}
			rs.close();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return docenti;
	}
	
}
