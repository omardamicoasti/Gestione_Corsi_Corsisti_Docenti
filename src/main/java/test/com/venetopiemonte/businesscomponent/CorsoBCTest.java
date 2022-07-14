package test.com.venetopiemonte.businesscomponent;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.venetopiemonte.businesscomponent.CorsoBC;
import com.venetopiemonte.businesscomponent.model.Corso;
import com.venetopiemonte.dbaccess.DBAccess;
import com.venetopiemonte.exceptions.DAOException;

@TestMethodOrder(OrderAnnotation.class)
class CorsoBCTest {
	private static CorsoBC corsoBc;

	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
		corsoBc = new CorsoBC();
	}

	@Test
	@Order(1)
	void testCreate() throws Exception {
		try {
			Corso corso = new Corso();
			corso.setNomeCorso("giardinaggio");
			GregorianCalendar inizio = new GregorianCalendar(2022, 9, 15);
			GregorianCalendar fine = new GregorianCalendar(2022, 9, 20);
			corso.setInizio(inizio.getTime());
			corso.setFine(fine.getTime());
			corso.setCosto(98.50);
			corso.setCommenti("ciao");
			corso.setAula("aula bella");
			corso.setCodDocente(1);
			corsoBc.createOrUpdate(corso);

			System.out.println("corso creato");

		} catch (DAOException exc) {
			exc.printStackTrace();
			fail("Eccezione dovuta al create: " + exc.getMessage());

		}
	}

	@Test
	@Order(2)
	void testUpdateGetByID() {
		try {
			Corso corso = new Corso();			
			corso.setNomeCorso("giardinaggio ultrasonico");
			GregorianCalendar inizio = new GregorianCalendar(2022, 9, 15);
			GregorianCalendar fine = new GregorianCalendar(2022, 9, 25);
			corso.setInizio(inizio.getTime());
			corso.setFine(fine.getTime());
			corso.setCosto(1000);
			corso.setCommenti("ciao");
			corso.setAula("aula bella");
			corso.setCodDocente(1);
			corso.setCodCorso(6);
			try {
				corsoBc.createOrUpdate(corso);
			} catch (ClassNotFoundException | IOException e) {
				e.printStackTrace();
			}
			
			Corso corso2 = corsoBc.getById(6);
			System.out.println(corso2.toString());

		} catch (DAOException exc) {
			exc.printStackTrace();
			fail("GetByID / update fallito: " + exc.getMessage());
		}
	}
	
	@Test
    @Order(3)
    void testGetCorsi() throws Exception {
        try {
            Corso[] corsi= corsoBc.getCorsi();
            assertNotNull(corsi);
            System.out.println("tutti i corsi");
            System.out.println(corsi.length);

            for(Corso i: corsi) {
                System.out.println(i.toString());
            }

        } catch (DAOException exc) {
            exc.printStackTrace();
            fail("Eccezione dovuta al getCorsi: " + exc.getMessage());

        }
    }


	@AfterAll
	public static void tearDownAfterClass() throws Exception {
		try {
			corsoBc.delete(9);
			System.out.println("corso cancellato");

			DBAccess.closeConnection();

		} catch (DAOException exc) {
			exc.printStackTrace();
			fail("Metodo di cancellazione fallito: " + exc.getMessage());

		}
	}
}
