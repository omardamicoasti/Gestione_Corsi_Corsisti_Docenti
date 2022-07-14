package test.com.venetopiemonte.architecture.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.venetopiemonte.architecture.dao.IscrizioneDAO;
import com.venetopiemonte.businesscomponent.model.Iscrizione;
import com.venetopiemonte.dbaccess.DBAccess;
import com.venetopiemonte.exceptions.DAOException;

@TestMethodOrder(OrderAnnotation.class)
class IscrizioneDAOTest {

	private static Iscrizione iscrizione1;
	private static Iscrizione iscrizione2;
	private static Iscrizione iscrizione3;
	private static Iscrizione iscrizione4;
	private static Connection conn;

	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
		conn = DBAccess.getConnection();
		iscrizione1 = new Iscrizione();
		iscrizione1.setCodCorsista(1);
		iscrizione1.setCodCorso(3);
		iscrizione2 = new Iscrizione();
		iscrizione2.setCodCorsista(2);
		iscrizione2.setCodCorso(2);
		iscrizione3 = new Iscrizione();
		iscrizione3.setCodCorsista(3);
		iscrizione3.setCodCorso(3);
		iscrizione4 = new Iscrizione();
		iscrizione4.setCodCorsista(1);
		iscrizione4.setCodCorso(2);
	}

	@Test
	@Order(1)
	void testCreate() throws Exception {
		try {
			IscrizioneDAO.getFactory().create(conn, iscrizione1);
			IscrizioneDAO.getFactory().create(conn, iscrizione2);
			IscrizioneDAO.getFactory().create(conn, iscrizione3);
			IscrizioneDAO.getFactory().create(conn, iscrizione4);
			System.out.println("iscrizioni create");

		} catch (DAOException exc) {
			exc.printStackTrace();
			fail("Eccezione dovuta al create: " + exc.getMessage());

		}
	}


	@Test
	@Order(2)
	void testGetAll() {
		try {
			Iscrizione[] iscrizioni = IscrizioneDAO.getFactory().getAll(conn);
			assertNotNull(iscrizioni);
			System.out.println("tutte le iscrizioni");
			for(Iscrizione i:iscrizioni) {
				System.out.println(i.toString());
			}
		} catch (DAOException exc) {
			exc.printStackTrace();
			fail("GetAll fallito: " + exc.getMessage());
		}
	}

	@Test
	@Order(3)
	void testGetIscrittiByCorso() {
		try {
			long[] iscritti = IscrizioneDAO.getFactory().getIscrittiByCorso(conn, 3);
			System.out.println("tutti gli iscritti a storia");
			for(long i: iscritti) {
				System.out.println(i + " ");
			}
			assertNotNull(iscritti);
		} catch (DAOException exc) {
			exc.printStackTrace();
			fail("GetIscrittiByCorso fallito: " + exc.getMessage());

		}
	}
	
	@Test
	@Order(5)
	void testGetCorsiByIscritto() {
		try {
			long[] corsi = IscrizioneDAO.getFactory().getCorsiByIscritto(conn, 1);
			System.out.println("tutti i corsi seguiti da Mario Rossi");
			for(long i:corsi) {
				System.out.println(i +" ");
			}
			assertNotNull(corsi);
		} catch (DAOException exc) {
			exc.printStackTrace();
			fail("GetIscrittiByCorso fallito: " + exc.getMessage());

		}
	}

	@AfterAll
	public static void tearDownAfterClass() throws Exception {
		try {
			IscrizioneDAO.getFactory().delete(conn, 1, 3);
			System.out.println("Iscrizione eliminata");
			IscrizioneDAO.getFactory().delete(conn, 2, 2);
			System.out.println("Iscrizione eliminata");
			IscrizioneDAO.getFactory().delete(conn, 3, 3);
			System.out.println("Iscrizione eliminata");
			IscrizioneDAO.getFactory().delete(conn, 1, 2);
			System.out.println("Iscrizione eliminata");
			DBAccess.closeConnection();

		} catch (DAOException exc) {
			exc.printStackTrace();
			fail("Metodo di pulizia fallito: " + exc.getMessage());

		}
	}
}
