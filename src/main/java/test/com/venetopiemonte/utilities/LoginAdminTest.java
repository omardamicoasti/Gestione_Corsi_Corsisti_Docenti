package test.com.venetopiemonte.utilities;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.venetopiemonte.exceptions.DAOException;
import com.venetopiemonte.utilities.LoginAdmin;

class LoginAdminTest {

	@Test
	void testLoginAdmin() {
		LoginAdmin logAdmin;
		String pass;
		try {
			logAdmin = new LoginAdmin();
			pass = logAdmin.controlloAdmin(1);
			assertNotNull(pass);
			assertNotEquals(pass, "");
			System.out.println(pass);
		} catch (ClassNotFoundException | DAOException | IOException exc) {
			exc.printStackTrace();
			fail("errore dovuto al login admin: " + exc.getMessage());
		}
		
	}

}
