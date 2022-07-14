package test.com.venetopiemonte.architecture.dao;

import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import com.venetopiemonte.architecture.dao.CorsoDAO;
import com.venetopiemonte.businesscomponent.model.Corso;
import com.venetopiemonte.dbaccess.DBAccess;
import com.venetopiemonte.exceptions.DAOException;

@TestMethodOrder(OrderAnnotation.class)
class CorsoDAOTest {
	private static Corso corso;
	private static Connection conn;
	
	
	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
		conn = DBAccess.getConnection();
		corso = new Corso();
		
		corso.setNomeCorso("java");
		GregorianCalendar gcInizio= new GregorianCalendar(10, 2, 2019);
		GregorianCalendar gcFine= new GregorianCalendar(15, 2, 2019);
		
		corso.setInizio(gcInizio.getTime());
		corso.setFine(gcFine.getTime());
		
		corso.setCosto(300);
		corso.setCommenti("corso fantasticamente fantastico");
		corso.setAula("A500");
		corso.setCodDocente(2);
		corso.setCodCorso(44);

	}
	@Test
	@Order(1)
	void testCrete() {
		try {
			CorsoDAO.getFactory().create(conn, corso);
			System.out.println("creato corso");
		} catch (DAOException exc) {
			exc.printStackTrace();
			fail("Eccezione dovuta al create: " + exc.getMessage());
		}
	}
	
	@Test
	@Order(2)
	void testUpdateGetByID() {
		try {
			corso = new Corso();
			corso.setCodCorso(44);
			corso.setNomeCorso("Java advanced");
			GregorianCalendar gcInizio= new GregorianCalendar(10, 2, 2019);
			GregorianCalendar gcFine= new GregorianCalendar(20, 2, 2019);
			corso.setInizio(gcInizio.getTime());
			corso.setFine(gcFine.getTime());
			corso.setCosto(500);
			corso.setCommenti("corso ancora più fantasticamente fantastico");
			corso.setCodDocente(2);
			corso.setAula("A500");


			CorsoDAO.getFactory().update(conn, corso);
			System.out.println("Aggiornato corso");
			Corso cors = CorsoDAO.getFactory().getById(conn, 44);
			System.out.println(cors.toString());

		} catch (DAOException exc) {
			exc.printStackTrace();
			fail("GetByID / update fallito: " + exc.getMessage());
		}
	}
	
	@AfterAll
	public static void tearDownAfterClass() throws Exception {
		try {
			CorsoDAO.getFactory().delete(conn, 44);
			System.out.println("corso eliminato");
			DBAccess.closeConnection();
		} catch (DAOException exc) {
			exc.printStackTrace();
			fail("Metodo di pulizia fallito: " + exc.getMessage());
		}
	}

}
