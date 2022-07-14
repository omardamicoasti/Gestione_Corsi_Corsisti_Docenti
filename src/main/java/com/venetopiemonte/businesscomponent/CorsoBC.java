package com.venetopiemonte.businesscomponent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.venetopiemonte.architecture.dao.CorsoDAO;
import com.venetopiemonte.businesscomponent.idgenerator.CorsoIdGenerator;
import com.venetopiemonte.businesscomponent.model.Corso;
import com.venetopiemonte.businesscomponent.model.Docente;
import com.venetopiemonte.dbaccess.DBAccess;
import com.venetopiemonte.exceptions.DAOException;

public class CorsoBC {
	private Connection conn;

	public CorsoBC() throws ClassNotFoundException, DAOException, IOException {
		conn = DBAccess.getConnection();
	}

	public void createOrUpdate(Corso corso) throws DAOException, ClassNotFoundException, IOException {
		try {
			if (corso.getCodCorso() > 0)
				CorsoDAO.getFactory().update(conn, corso);
			else {
				long id = CorsoIdGenerator.getInstance().getNextId();
				corso.setCodCorso(id);
				CorsoDAO.getFactory().create(conn, corso);
			}
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}  finally {
			DBAccess.closeConnection();
		}
	}

	public Corso[] getCorsi() throws DAOException {
		Corso[] corsi = null;
		try {
			corsi = CorsoDAO.getFactory().getAll(conn);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}  finally {
			DBAccess.closeConnection();
		}
		return corsi;
	}

	public Corso getById(long id) throws DAOException {
		try {
			return CorsoDAO.getFactory().getById(conn, id);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		} finally {
			DBAccess.closeConnection();
		}
	}

	public void delete(long id) throws DAOException {
		try {
			CorsoDAO.getFactory().delete(conn, id);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		} finally {
			DBAccess.closeConnection();
		}
	}

	public Corso[] searchCorsi(String query) throws DAOException, ClassNotFoundException, IOException {
		ArrayList<Corso> lista = new ArrayList<Corso>();
		String[] criterioDiRicerca = query.toLowerCase().split(" ");

		for (Corso a : getCorsi()) {
			long codDocente = a.getCodDocente();

			Docente docente = new DocenteBC().getDocenteById(codDocente);

			for (String s : criterioDiRicerca)
				if (a.getNomeCorso().toLowerCase().contains(s) 
						|| a.getAula().toLowerCase().contains(s) 
						|| docente.getNome().toLowerCase().contains(s)
						|| docente.getCognome().toLowerCase().contains(s))   
					lista.add(a);
		}
		
		Corso[] corsi = new Corso[lista.size()];
		for (int i = 0; i < lista.size(); i++)
			corsi[i] = lista.get(i);

		return corsi;
	}
}
