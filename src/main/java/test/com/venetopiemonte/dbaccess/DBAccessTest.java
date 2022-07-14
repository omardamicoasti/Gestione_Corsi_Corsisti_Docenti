package test.com.venetopiemonte.dbaccess;

import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.venetopiemonte.dbaccess.DBAccess;
import com.venetopiemonte.exceptions.DAOException;

class DBAccessTest {

	@Test
	void testConnection() {
		try {
			DBAccess.getConnection();
		} catch (ClassNotFoundException | DAOException | IOException exc) {
			exc.printStackTrace();
			fail("errore nel tentativo di connessione: " + exc.getMessage());
		} finally {
			try {				
				DBAccess.closeConnection();
			} catch (DAOException exc) {
				exc.printStackTrace();
				fail("errore nel tentativo di chiusura della connessione");
			}
		}
	}

}
