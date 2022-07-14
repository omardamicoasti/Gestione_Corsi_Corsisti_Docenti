package test.com.venetopiemonte.architecture.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;

import com.venetopiemonte.exceptions.DAOException;
import com.venetopiemonte.architecture.dao.CorsistaDAO;
import com.venetopiemonte.dbaccess.DBAccess;
import com.venetopiemonte.businesscomponent.idgenerator.CorsistaIdGenerator;
import com.venetopiemonte.businesscomponent.model.Corsista;

@TestMethodOrder(OrderAnnotation.class)
class CorsistaDAOTest {
	private static Corsista corsista;
	private static Connection conn;

	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
		conn = DBAccess.getConnection();
		corsista = new Corsista();
		corsista.setNome("Omar");
		corsista.setCognome("DAmico");
		corsista.setCodCorsista(38);
		corsista.setPrecedentiFormativi(true);
	}

	@Test
	@Order(1)
	void testCreate() {
		try {
			CorsistaDAO.getFactory().create(conn, corsista);
			System.out.println("Corsista creato.");
		} catch (DAOException exc) {
			exc.printStackTrace();
			fail("Eccezione dovuta al create: " + exc.getMessage());
		}
	}

	@Test
	@Order(2)
	void testUpdate() {
		try {
			corsista = new Corsista();
			corsista.setNome("Omars");
			corsista.setCognome("D'Amicos");
			corsista.setCodCorsista(1);
			corsista.setPrecedentiFormativi(true);
			System.out.println("Aggiornato corsista: " + corsista.toString());
			CorsistaDAO.getFactory().update(conn, corsista);
		} catch (DAOException exc) {
			exc.printStackTrace();
			fail("Update fallito: " + exc.getMessage());
		}
	}
	
	@Test
	@Order(3)
	void GetById() {
		try {
			Corsista ord = CorsistaDAO.getFactory().getById(conn, 1);
			System.out.println(ord.toString());
		} catch (DAOException exc) {
			exc.printStackTrace();
			fail("getById: " + exc.getMessage());
		}

	}
	
	@Test
	@Order(3)
	void testGetAll() {
		try { 
			Corsista[] corsisti = CorsistaDAO.getFactory().getAll(conn);
			assertNotNull(corsisti);
			System.out.println("Elenco dei corsisti: ");
			System.out.println(corsisti[0]);
	} catch (DAOException exc) {
		exc.printStackTrace();
		fail("Get All fallito: " +exc.getMessage());
	}
	}


	@AfterAll
	public static void tearDownAfterClass() throws Exception {
		try {
			CorsistaDAO.getFactory().delete(conn, 38);
			System.out.println("Corsista eliminato");
			conn.commit();
			DBAccess.closeConnection();
		} catch (DAOException exc) {
			exc.printStackTrace();
			fail("Metodo di pulizia fallito: " + exc.getMessage());
		}
	}

}
