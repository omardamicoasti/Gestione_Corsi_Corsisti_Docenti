package com.venetopiemonte.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import com.venetopiemonte.businesscomponent.model.Iscrizione;
import com.venetopiemonte.exceptions.DAOException;

public class IscrizioneDAO implements GenericDAO<Iscrizione>, DAOConstants {
	private CachedRowSet rowSet;

	public IscrizioneDAO() throws DAOException {
		try {
			rowSet = RowSetProvider.newFactory().createCachedRowSet();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}

	}

	public static IscrizioneDAO getFactory() throws DAOException {
		return new IscrizioneDAO();
	}

	@Override
	public void create(Connection conn, Iscrizione entity) throws DAOException {
		try {
			rowSet.setCommand(SELECT_ISCRIZIONE);
			rowSet.execute(conn);
			rowSet.moveToInsertRow();
			rowSet.updateLong(1, entity.getCodCorso());
			rowSet.updateLong(2, entity.getCodCorsista());
			rowSet.insertRow();
			rowSet.moveToCurrentRow();
			rowSet.acceptChanges();

		} catch (SQLException sql) {
			throw new DAOException(sql);
		}

	}

	@Override
	public void delete(Connection conn, long id) throws DAOException {

	}

	public void delete(Connection conn, long idCorsista, long idCorso) throws DAOException {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(DELETE_ISCRIZIONE);
			ps.setLong(1, idCorsista);
			ps.setLong(2, idCorso);
			ps.execute();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	@Override
	public Iscrizione getById(Connection conn, long id) throws DAOException {
		return null;
	}

	
	@Override
	public Iscrizione[] getAll(Connection conn) throws DAOException {
		Iscrizione[] iscrizione = null;
		try {
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery(SELECT_ISCRIZIONE);
			rs.last();
			iscrizione = new Iscrizione[rs.getRow()];
			rs.beforeFirst();
			for (int i = 0; rs.next(); i++) {
				Iscrizione a = new Iscrizione();
				a.setCodCorso(rs.getLong(1));
				a.setCodCorsista(rs.getLong(2));

				iscrizione[i] = a;
			}
			rs.close();

		} catch (SQLException sql) {
			throw new DAOException(sql);

		}
		return iscrizione;

	}

	public long[] getCorsiByIscritto(Connection conn, long id) throws DAOException {
		long[] corsi = null;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SELECT_ISCRIZIONE_BYCODCORSISTA, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			rs.last();
			corsi = new long[rs.getRow()];
			rs.beforeFirst();
			for (int i = 0; rs.next(); i++) {
				corsi[i] = rs.getLong(1);
			}
			rs.close();

		} catch (SQLException sql) {
			throw new DAOException(sql);

		}
		return corsi;
	}

	public long[] getIscrittiByCorso(Connection conn, long id) throws DAOException {
		long[] iscritti = null;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SELECT_ISCRIZIONE_BYCODCORSO, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			rs.last();
			iscritti = new long[rs.getRow()];
			rs.beforeFirst();
			for (int i = 0; rs.next(); i++) {

				iscritti[i] = rs.getLong(2);
			}
			rs.close();

		} catch (SQLException sql) {
			throw new DAOException(sql);

		}
		return iscritti;
	}
	
	public long[] getNonIscrittiByCorso(Connection conn, long id) throws DAOException {
		long[] iscritti = null;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SELECT_CORSISTI_NONISCRITTI, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			rs.last();
			iscritti = new long[rs.getRow()];
			rs.beforeFirst();
			for (int i = 0; rs.next(); i++) {
				iscritti[i] = rs.getLong(1);
			}
			rs.close();

		} catch (SQLException sql) {
			throw new DAOException(sql);

		}
		return iscritti;
	}

	@Override
	public void update(Connection conn, Iscrizione entity) throws DAOException {
	}
}
