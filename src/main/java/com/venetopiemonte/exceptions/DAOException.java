package com.venetopiemonte.exceptions;

import java.sql.SQLException;

public class DAOException extends SQLException {

	private static final long serialVersionUID = -4124591697497848678L;
	
	// TODO aggiungere altre casistiche di errore
	private final static int ORA01017 = 1017;       // logon denied
	private final static int ORA17002 = 17002;      // no connessione
	private final static int ORA00001 = 0;          // constraint messaggio
	
	private String message;
	
	@Override
	public String getMessage() {
		return this.message;
	}

	public DAOException(SQLException sql) {
		String chiave = "";
		if (sql != null) {
			switch(sql.getErrorCode()) {
				case ORA01017:
					chiave = "Credenziali di accesso al DB errate";
					log(sql);
					break;
				case ORA17002:
					chiave = "Errore I/0 di Oracle DB, impossibile connettersi alla base dati";
					log(sql);
					break;
				case ORA00001:
					chiave = "Violazione di vincolo di tabella";
					log(sql);
					break;
				default:
					chiave = "Eccezione sql non prevista";
					log(sql);
			}
		}
		message = chiave;
	}
	
	private void log(SQLException sql) {
		sql.printStackTrace();
		System.err.println("motivo eccezione:   " + sql.getMessage());
		System.err.println("Stato applicazione: " + sql.getSQLState());
		System.err.println("Codice errore:      " + sql.getErrorCode());
		System.err.println("Causa eccezione:    " + sql.getCause());
	}
	
}
