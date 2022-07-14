package test.com.venetopiemonte.businesscomponent;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.venetopiemonte.businesscomponent.IscrizioneBC;
import com.venetopiemonte.businesscomponent.model.Iscrizione;
import com.venetopiemonte.dbaccess.DBAccess;
import com.venetopiemonte.exceptions.DAOException;

@TestMethodOrder(OrderAnnotation.class)
class IscrizioneBCTest {
	private static IscrizioneBC iscrizioneBC;

	
	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
		iscrizioneBC = new IscrizioneBC();
	}
	
	@Test
	@Order(1)
	void testCreate() throws Exception {
		try {
			Iscrizione iscrizione1 = new Iscrizione();
			Iscrizione iscrizione2 = new Iscrizione();
			Iscrizione iscrizione3 = new Iscrizione();
			Iscrizione iscrizione4 = new Iscrizione();
			
			iscrizione1.setCodCorsista(1);
			iscrizione1.setCodCorso(3);
			
			iscrizione2.setCodCorsista(2);
			iscrizione2.setCodCorso(2);
			
			iscrizione3.setCodCorsista(3);
			iscrizione3.setCodCorso(3);
			
			iscrizione4.setCodCorsista(1);
			iscrizione4.setCodCorso(2);
			
			iscrizioneBC.create(iscrizione1);
			iscrizioneBC.create(iscrizione2);
			iscrizioneBC.create(iscrizione3);
			iscrizioneBC.create(iscrizione4);
			
			System.out.println("iscrizioni create");
			

		} catch (DAOException exc) {
			exc.printStackTrace();
			fail("Eccezione dovuta al create: " + exc.getMessage());

		}
	}
	
	@Test
	@Order(2)
	void testGetIscrizioni() throws Exception {
		try {
			Iscrizione[] iscrizioni= iscrizioneBC.getIscrizioni();
			assertNotNull(iscrizioni);
			System.out.println("tutte le iscrizioni");
			System.out.println(iscrizioni.length);
			
			for(Iscrizione i: iscrizioni) {
				System.out.println(i.toString());
			}
			
		} catch (DAOException exc) {
			exc.printStackTrace();
			fail("Eccezione dovuta al create: " + exc.getMessage());

		}
	}
	
	@Test
	@Order(3)
	void testGetIscrittiByCorso() {
		try {
			long[] iscritti = iscrizioneBC.getIscrittiByCorso(3);
			System.out.println("tutti gli iscritti a storia");
			for(long i: iscritti) {
				System.out.println(i);
			}
			assertNotNull(iscritti);
		} catch (DAOException exc) {
			exc.printStackTrace();
			fail("GetIscrittiByCorso fallito: " + exc.getMessage());

		}
	}
	
	@Test
	@Order(4)
	void testGetCorsiByIscritto() {
		try {
			long[] corsi = iscrizioneBC.getCorsiByIscritto(1);
			System.out.println("tutti i corsi seguiti da Mario Rossi");
			for(long i: corsi) {
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
			iscrizioneBC.delete(2, 2);
			iscrizioneBC.delete(1, 3);
			iscrizioneBC.delete(3, 3);
			iscrizioneBC.delete(1, 2);
			
			DBAccess.closeConnection();

		} catch (DAOException exc) {
			exc.printStackTrace();
			fail("Metodo di pulizia fallito: " + exc.getMessage());

		}
	}
}
