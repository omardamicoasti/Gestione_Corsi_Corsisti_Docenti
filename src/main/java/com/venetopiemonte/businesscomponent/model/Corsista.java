package com.venetopiemonte.businesscomponent.model;

public class Corsista {
	private String nome;
	private String cognome;
	private long codCorsista;
	private boolean precedentiFormativi;
	
	public long getCodCorsista() {
		return codCorsista;
	}
	public void setCodCorsista(long codCorsista) {
		this.codCorsista = codCorsista;
	}
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
	public boolean getPrecedentiFormativi() {
		return precedentiFormativi;
	}
	public void setPrecedentiFormativi(boolean precedentiFormativi) {
		this.precedentiFormativi = precedentiFormativi;
	}
	
	@Override
	public String toString() {
		return "Corsista [codCorsista=" + codCorsista + ", nome=" + nome + ", cognome=" + cognome
				+ ", precedentiFormativi=" + precedentiFormativi + "]";
	}
	
	
	
}

//commento per push
