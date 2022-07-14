package test.com.venetopiemonte.businesscomponent.idgenerator;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.venetopiemonte.businesscomponent.idgenerator.CorsoIdGenerator;
import com.venetopiemonte.exceptions.DAOException;

class CorsoIdGeneratorTest {

	@Test
	void testGetNextId() {
		try {
			CorsoIdGenerator idGenerator = CorsoIdGenerator.getInstance();
			assertNotNull(idGenerator, "istanza creata correttamente");
			long valore = idGenerator.getNextId();
			assertEquals(valore, idGenerator.getNextId() - 1);
		} catch (ClassNotFoundException | DAOException | IOException exc) {
			exc.printStackTrace();
			fail("fallito corso idGenerator getNextId");
		}
	}
}