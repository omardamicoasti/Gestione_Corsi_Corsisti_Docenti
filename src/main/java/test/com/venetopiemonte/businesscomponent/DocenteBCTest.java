package test.com.venetopiemonte.businesscomponent;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.venetopiemonte.businesscomponent.DocenteBC;
import com.venetopiemonte.businesscomponent.model.Docente;
import com.venetopiemonte.exceptions.DAOException;

class DocenteBCTest {

	@Test
	void testGetDocenteById() {
		try {
			DocenteBC dBC = new DocenteBC();
			Docente doc = dBC.getDocenteById(1);
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
			DocenteBC dBC = new DocenteBC();
			Docente[] docenti = dBC.getDocenti();
			assertNotNull(docenti);
			System.out.println(docenti[0]);
		} catch (DAOException | ClassNotFoundException | IOException exc) {
			exc.printStackTrace();
			fail("errore dovuto al getById: " + exc.getMessage());
		}
	}
	
	

}
