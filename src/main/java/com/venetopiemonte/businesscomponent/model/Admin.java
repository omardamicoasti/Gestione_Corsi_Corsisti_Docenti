package com.venetopiemonte.businesscomponent.model;

public class Admin {
	private String nome;
	private String cognome;
	private long codAdmin;
	private String password;

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

	public long getCodAdmin() {
		return codAdmin;
	}

	public void setCodAdmin(long codAdmin) {
		this.codAdmin = codAdmin;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [nome=" + nome + ", cognome=" + cognome + ", codAdmin=" + codAdmin + ", password=" + password
				+ "]";
	}
	
}
