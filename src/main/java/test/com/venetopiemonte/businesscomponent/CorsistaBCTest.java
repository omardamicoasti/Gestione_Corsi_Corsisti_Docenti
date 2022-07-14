package test.com.venetopiemonte.businesscomponent;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.venetopiemonte.businesscomponent.CorsistaBC;
import com.venetopiemonte.businesscomponent.model.Corsista;
import com.venetopiemonte.dbaccess.DBAccess;
import com.venetopiemonte.exceptions.DAOException;

@TestMethodOrder(OrderAnnotation.class)
class CorsistaBCTest {
	private static CorsistaBC cBC;
	
	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
		cBC = new CorsistaBC();
	}
	
	@Test
	@Order(1)
	void testCreate() throws Exception {
		try {
			Corsista corsista= new Corsista();
			corsista.setNome("Gianni");
			corsista.setCognome("Morandi");
			corsista.setPrecedentiFormativi(false);
			cBC.createOrUpdate(corsista);
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
			Corsista corsista= new Corsista();
			corsista.setNome("Gianni");
			corsista.setCognome("Morandino");
			corsista.setPrecedentiFormativi(false);
			corsista.setCodCorsista(22);
			//il valore dell'id cambia in base dell'id generator, per testare l'efficacia
			//del metodo update bisogna controllare il valore a cui è arrivvata la sequenza corsista_sq
			//e inserire come parametro a setCodCorsista il valore successivo
			try {
				cBC.createOrUpdate(corsista);
			} catch (ClassNotFoundException | IOException e) {
				e.printStackTrace();
			}
			
			Corsista corsista2 = cBC.getById(corsista.getCodCorsista());
			System.out.println(corsista2.toString());

		} catch (DAOException exc) {
			exc.printStackTrace();
			fail("GetByID / update fallito: " + exc.getMessage());
		}
	}
	
	
	@Test
	@Order(3)
	void testGetAll() {
		try {
			CorsistaBC cBC = new CorsistaBC();
			Corsista[] corsisti = cBC.getCorsisti();
			assertNotNull(corsisti);
			System.out.println("tutti i corsisti");
			for (Corsista c: corsisti) {
				System.out.println(c.toString());
			}
		} catch (DAOException | ClassNotFoundException | IOException exc) {
			exc.printStackTrace();
			fail("errore dovuto al getById: " + exc.getMessage());
		}
	}
	
	@AfterAll
	public static void tearDownAfterClass() throws Exception {
		try {
			cBC.delete(22);
			//il valore dell'id cambia in base dell'id generator, per testare l'efficacia
			//del metodo delete bisogna controllare il valore a cui è arrivvata la sequenza corsista_sq
			//e inserire come parametro a setCodCorsista il valore successivo
			System.out.println("corso cancellato");

			DBAccess.closeConnection();

		} catch (DAOException exc) {
			exc.printStackTrace();
			fail("Metodo di cancellazione fallito: " + exc.getMessage());

		}
	}
	
	

}