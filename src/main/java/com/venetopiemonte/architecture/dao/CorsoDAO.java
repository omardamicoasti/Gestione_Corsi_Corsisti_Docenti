package com.venetopiemonte.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;


import com.venetopiemonte.businesscomponent.model.Corso;
import com.venetopiemonte.exceptions.DAOException;

public class CorsoDAO implements GenericDAO<Corso>, DAOConstants{
	private CachedRowSet rowSet;
	
	
	private CorsoDAO() throws DAOException{
		try {
			rowSet = RowSetProvider.newFactory().createCachedRowSet();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	public static CorsoDAO getFactory() throws DAOException {
		return new CorsoDAO();
	}


	@Override
	public void create(Connection conn, Corso entity) throws DAOException {
		try {
			rowSet.setCommand(SELECT_CORSO);
			rowSet.execute(conn);
			rowSet.moveToInsertRow();
			rowSet.updateString(1, entity.getNomeCorso());
			rowSet.updateDate(2, new java.sql.Date(entity.getInizio().getTime()));
			rowSet.updateDate(3, new java.sql.Date(entity.getFine().getTime()));
			rowSet.updateDouble(4, entity.getCosto());
			rowSet.updateString(5, entity.getCommenti());
			rowSet.updateString(6, entity.getAula());
			rowSet.updateLong(7, entity.getCodDocente());
			rowSet.updateLong(8, entity.getCodCorso());
			rowSet.insertRow();
			rowSet.moveToCurrentRow();
			rowSet.acceptChanges();
			rowSet.close();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		
	}

	@Override
	public void update(Connection conn, Corso entity) throws DAOException {
		PreparedStatement ps;
		try{
			
			ps = conn.prepareStatement(UPDATE_CORSO);
			ps.setString(1, entity.getNomeCorso());
			ps.setDate(2, new java.sql.Date(entity.getInizio().getTime()));
			ps.setDate(3, new java.sql.Date(entity.getFine().getTime()));
			ps.setDouble(4, entity.getCosto());
			ps.setString(5, entity.getCommenti());
			ps.setString(6, entity.getAula());
			ps.setLong(7, entity.getCodDocente());
			ps.setLong(8, entity.getCodCorso());
			ps.execute();
			conn.commit();
			ps.close();
			
		}catch (SQLException sql) {
			throw new DAOException(sql);
		}
		
	}

	@Override
	public void delete(Connection conn, long id) throws DAOException {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(DELETE_CORSO);
			ps.setLong(1, id);
			ps.execute();
			conn.commit();
			ps.close();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		
	}

	@Override
	public Corso getById(Connection conn, long id) throws DAOException {
		Corso corso = null;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SELECT_CORSO_BYCOD);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				corso = new Corso();
				
				corso.setNomeCorso(rs.getString(1));
				corso.setInizio(new java.util.Date(rs.getDate(2).getTime()));
				corso.setFine(new java.util.Date(rs.getDate(3).getTime()));
				corso.setCosto(rs.getDouble(4));
				corso.setCommenti(rs.getString(5));
				corso.setAula(rs.getString(6));
				corso.setCodDocente(rs.getLong(7));
				corso.setCodCorso(rs.getLong(8));
				
			}
			
			ps.close();
		}catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return corso;
	}

	@Override
	public Corso[] getAll(Connection conn) throws DAOException {
		Corso[] corsi= null;
		try {
			Statement stmt = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE, 
					ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery(SELECT_CORSO);
			rs.last();
			corsi = new Corso[rs.getRow()];
			rs.beforeFirst();
			for (int i = 0; rs.next(); i++) {
				Corso a = new Corso();
				a.setNomeCorso(rs.getString(1));
				a.setInizio(new java.util.Date(rs.getDate(2).getTime()));
				a.setFine(new java.util.Date(rs.getDate(3).getTime()));
				a.setCosto(rs.getDouble(4));
				a.setCommenti(rs.getString(5));
				a.setAula(rs.getString(6));
				a.setCodDocente(rs.getLong(7));
				a.setCodCorso(rs.getLong(8));
				corsi[i] = a;
			}
			rs.close();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		
		return corsi;
	}
}
