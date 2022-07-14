package com.venetopiemonte.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import com.venetopiemonte.businesscomponent.model.Corsista;
import com.venetopiemonte.exceptions.DAOException;

public class CorsistaDAO implements DAOConstants {

	private CachedRowSet rowSet;

	private CorsistaDAO() throws DAOException {
		try {
			rowSet = RowSetProvider.newFactory().createCachedRowSet();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	public static CorsistaDAO getFactory() throws DAOException {
		return new CorsistaDAO();
	}

	public void create(Connection conn, Corsista entity) throws DAOException {

		try {
			rowSet.setCommand(SELECT_CORSISTA);
			rowSet.execute(conn);
			rowSet.moveToInsertRow();
			rowSet.updateString(1, entity.getNome());
			rowSet.updateString(2, entity.getCognome());
			rowSet.updateLong(3, entity.getCodCorsista());
			boolean precForm = entity.getPrecedentiFormativi();
			if (precForm == true)
				rowSet.updateString(4, "T");
			else
				rowSet.updateString(4, "F");
			rowSet.insertRow();
			rowSet.moveToCurrentRow();
			rowSet.acceptChanges();
			rowSet.close();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}

	}

	public void update(Connection conn, Corsista entity) throws DAOException {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(UPDATE_CORSISTA);
			ps.setString(1, entity.getNome());
			ps.setString(2, entity.getCognome());
			Boolean precForm = entity.getPrecedentiFormativi();
			if (precForm == true)
				ps.setString(3, "T");
			else
				ps.setString(3, "F");
			ps.setLong(4, entity.getCodCorsista());
			ps.execute();
			conn.commit();
			ps.close();

		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	public void delete(Connection conn, long codCorsista) throws DAOException {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(DELETE_CORSISTA);
			ps.setLong(1, codCorsista);
			ps.execute();
			conn.commit();
			ps.close();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	
	public Corsista getById(Connection conn, long codCorsista) throws DAOException {
		Corsista corsista = null;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SELECT_CORSISTA_BYCOD);
			ps.setLong(1, codCorsista);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				corsista = new Corsista();
				corsista.setNome(rs.getString(1));
				corsista.setCognome(rs.getString(2));
				corsista.setCodCorsista(rs.getLong(3));
				corsista.setPrecedentiFormativi(rs.getBoolean(4));
			}
			
			ps.close();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return corsista;
	}


	public Corsista[] getAll(Connection conn) throws DAOException {
		Corsista[] corsisti = null;
		try {
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery(SELECT_CORSISTA);
			rs.last();
			corsisti = new Corsista[rs.getRow()];
			rs.beforeFirst();
			for (int i = 0; rs.next(); i++) {
				Corsista corsista = new Corsista();
				corsista.setNome(rs.getString(1));
				corsista.setCognome(rs.getString(2));
				corsista.setCodCorsista(rs.getLong(3));
				corsista.setPrecedentiFormativi(rs.getBoolean(4));
				corsisti[i] = corsista;
			}
			
			rs.close();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return corsisti;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}