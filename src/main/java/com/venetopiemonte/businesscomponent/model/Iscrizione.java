package com.venetopiemonte.businesscomponent.model;

public class Iscrizione {
	private long codCorso;
	private long codCorsista;
	
	public long getCodCorso() {
		return codCorso;
	}
	public void setCodCorso(long codCorso) {
		this.codCorso = codCorso;
	}
	public long getCodCorsista() {
		return codCorsista;
	}
	public void setCodCorsista(long codCorsista) {
		this.codCorsista = codCorsista;
	}
	@Override
	public String toString() {
		return "Iscrizione [codCorso=" + codCorso + ", codCorsista=" + codCorsista + "]";
	}	
	
}

//commento per push
