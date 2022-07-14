package test.com.venetopiemonte.security;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.venetopiemonte.security.AlgoritmoMD5;

class AlgoritmoMD5Test {

	@Test
	void testConversione() {
		String pass = AlgoritmoMD5.convertiMD5("Pass01$");
		assertNotNull(pass);
		System.out.println(pass);
	}
}

