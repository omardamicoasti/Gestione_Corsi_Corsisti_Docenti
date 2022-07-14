package com.venetopiemonte.businesscomponent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.venetopiemonte.architecture.dao.CorsistaDAO;
import com.venetopiemonte.architecture.dao.CorsoDAO;
import com.venetopiemonte.businesscomponent.idgenerator.CorsistaIdGenerator;
import com.venetopiemonte.businesscomponent.idgenerator.CorsoIdGenerator;
import com.venetopiemonte.businesscomponent.model.Corsista;
import com.venetopiemonte.businesscomponent.model.Corso;
import com.venetopiemonte.businesscomponent.model.Docente;
import com.venetopiemonte.dbaccess.DBAccess;
import com.venetopiemonte.exceptions.DAOException;

public class CorsistaBC {
	Connection conn;
	
	
	public CorsistaBC() throws ClassNotFoundException, DAOException, IOException {
		conn = DBAccess.getConnection();
	}
	
	public Corsista getById(long codCorsista) throws DAOException {
		try {
			return CorsistaDAO.getFactory().getById(conn, codCorsista);	
			
		} catch (SQLException sql) {
			throw new DAOException(sql);
		} finally {
			DBAccess.closeConnection();
		}
	}
	
	public void createOrUpdate(Corsista corsista) throws DAOException, ClassNotFoundException, IOException {
		try {
			if (corsista.getCodCorsista() > 0)
				CorsistaDAO.getFactory().update(conn, corsista);
			else {
				long id = CorsistaIdGenerator.getInstance().getNextId();
				corsista.setCodCorsista(id);
				CorsistaDAO.getFactory().create(conn, corsista);
			}
		} catch (SQLException sql) {
			throw new DAOException(sql);
		} finally {
			DBAccess.closeConnection();
		}
	}
	
	
	public void delete(long id) throws DAOException {
		try {
			CorsistaDAO.getFactory().delete(conn, id);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		} finally {
			DBAccess.closeConnection();
		}
	}
	
	public Corsista[] getCorsisti() throws DAOException {
		try {
			return CorsistaDAO.getFactory().getAll(conn);			
		} catch (SQLException sql) {
			throw new DAOException(sql);
		} finally {
			DBAccess.closeConnection();
		}
	}
	
	public Corsista[] searchCorsista(String query) throws DAOException, ClassNotFoundException, IOException {
		ArrayList<Corsista> lista = new ArrayList<Corsista>();
		String[] criterioDiRicerca = query.toLowerCase().split(" ");

		for (Corsista a : getCorsisti()) {

			for (String s : criterioDiRicerca)
				if (a.getNome().toLowerCase().contains(s) 
						|| a.getCognome().toLowerCase().contains(s))   
					lista.add(a);
		}
		Corsista[] corsista = new Corsista[lista.size()];
		for (int i = 0; i < lista.size(); i++)
			corsista[i] = lista.get(i);

		return corsista;
	}
	
	
}