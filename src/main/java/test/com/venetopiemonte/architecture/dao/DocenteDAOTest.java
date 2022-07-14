package test.com.venetopiemonte.architecture.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.sql.Connection;

import org.junit.jupiter.api.Test;

import com.venetopiemonte.architecture.dao.DocenteDAO;
import com.venetopiemonte.businesscomponent.model.Docente;
import com.venetopiemonte.dbaccess.DBAccess;
import com.venetopiemonte.exceptions.DAOException;

class DocenteDAOTest {

	@Test
	void testGetById() {
		try {
			Connection conn = DBAccess.getConnection();
			Docente doc = DocenteDAO.getFactory().getById(conn, 1);
			assertNotNull(doc);
			System.out.println(doc);
		} catch (DAOException | ClassNotFoundException | IOException exc) {
			exc.printStackTrace();
			fail("errore dovuto al getById: " + exc.getMessage());
		}
		
	}

	@Test
	void testGetAll() {
		try {
			Connection conn = DBAccess.getConnection();
			Docente[] docenti = DocenteDAO.getFactory().getAll(conn);
			assertNotNull(docenti);
			System.out.println(docenti[0]);
		} catch (DAOException | ClassNotFoundException | IOException exc) {
			exc.printStackTrace();
			fail("errore dovuto al getAll: " + exc.getMessage());
		}
	}

}
