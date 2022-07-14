package com.venetopiemonte.businesscomponent.model;

import java.util.Date;

public class Corso {
	private long codCorso;
	private String nomeCorso;
	private Date inizio;
	private Date fine;
	private double costo;
	private String commenti;
	private String aula;
	private long codDocente;
	
	public long getCodDocente() {
		return codDocente;
	}
	public void setCodDocente(long codDocente) {
		this.codDocente = codDocente;
	}
	public long getCodCorso() {
		return codCorso;
	}
	public void setCodCorso(long codCorso) {
		this.codCorso = codCorso;
	}
	public String getNomeCorso() {
		return nomeCorso;
	}
	public void setNomeCorso(String nomeCorso) {
		this.nomeCorso = nomeCorso;
	}
	public Date getInizio() {
		return inizio;
	}
	public void setInizio(Date inizio) {
		this.inizio = inizio;
	}
	public Date getFine() {
		return fine;
	}
	public void setFine(Date fine) {
		this.fine = fine;
	}
	public double getCosto() {
		return costo;
	}
	public void setCosto(double costo) {
		this.costo = costo;
	}
	public String getCommenti() {
		return commenti;
	}
	public void setCommenti(String commenti) {
		this.commenti = commenti;
	}
	public String getAula() {
		return aula;
	}
	public void setAula(String aula) {
		this.aula = aula;
	}
	@Override
	public String toString() {
		return "Corso [codCorso=" + codCorso + ", nomeCorso=" + nomeCorso + ", inizio=" + inizio + ", fine=" + fine
				+ ", costo=" + costo + ", commenti=" + commenti + ", aula=" + aula + "]";
	}

	
	
	
}
