package com.venetopiemonte.businesscomponent.model;

public class Docente {
	private String nome;
	private String cognome;
	private String cv;
	private long codDocente;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getCv() {
		return cv;
	}

	public void setCv(String cv) {
		this.cv = cv;
	}

	public long getCodDocente() {
		return codDocente;
	}

	public void setCodDocente(long codDocente) {
		this.codDocente = codDocente;
	}

	@Override
	public String toString() {
		return "Docente [nome=" + nome + ", cognome=" + cognome + ", cv=" + cv + ", codDocente=" + codDocente + "]";
	}
	
	
}
