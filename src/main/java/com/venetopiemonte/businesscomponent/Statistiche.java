package com.venetopiemonte.businesscomponent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import com.venetopiemonte.businesscomponent.model.Corso;
import com.venetopiemonte.businesscomponent.model.Docente;
import com.venetopiemonte.businesscomponent.model.Iscrizione;
import com.venetopiemonte.exceptions.DAOException;

public class Statistiche {
	
	public int numeroCorsisti() 
			throws DAOException, ClassNotFoundException, IOException {
		return (new CorsistaBC()).getCorsisti().length;	
	}
	
	public Corso corsoMaxFrequenze() throws ClassNotFoundException, DAOException, IOException {
		IscrizioneBC iBc = new IscrizioneBC();
		CorsoBC cBc = new CorsoBC();
		
		int max = 0;
		long corsoMaxFreqId = 0;
		Iscrizione[] iscrizioni = iBc.getIscrizioni();
		for (int i=0; i<iscrizioni.length; i++) {
			iBc = new IscrizioneBC();
			int nIscritti = iBc.getIscrittiByCorso(iscrizioni[i].getCodCorso()).length;
			if (nIscritti > max) {
				max = nIscritti;
				corsoMaxFreqId = iscrizioni[i].getCodCorso();
			}
		}
		cBc = new CorsoBC();
		return cBc.getById(corsoMaxFreqId);
	}
	
	public Date dataUltimoCorso() throws ClassNotFoundException, DAOException, IOException {
		CorsoBC cBc = new CorsoBC();
		Corso[] corsi = cBc.getCorsi();
		
		long ultimaMillis = 0;
		for (int i=0; i<corsi.length; i++) {
			long inizioMillis = corsi[i].getInizio().getTime();
			if (inizioMillis > ultimaMillis) {
				ultimaMillis = inizioMillis;
			}
		}
		return new Date(ultimaMillis); 
	}
	
	public double avgDurataCorsi() throws ClassNotFoundException, DAOException, IOException {
		CorsoBC cBc = new CorsoBC();
		Corso[] corsi = cBc.getCorsi();
		
		double somma=0;
	
		for (int i=0; i<corsi.length; i++) {
			long inizio = corsi[i].getInizio().getTime();
			long fine = corsi[i].getFine().getTime();
			long diff = TimeUnit.DAYS.convert(fine-inizio, TimeUnit.MILLISECONDS);
			somma+=diff;
		}
		return somma/corsi.length;
	}
	
	public int numeroCommenti() throws ClassNotFoundException, DAOException, IOException {
		CorsoBC cBc = new CorsoBC();
		Corso[] corsi = cBc.getCorsi();
		
		int numeroCommenti=0;
		for (int i=0; i<corsi.length; i++) {
			if(corsi[i]!=null) numeroCommenti++;
			
		}
		return numeroCommenti;
	}
	
	public Docente[] multiCorsoDocente() throws ClassNotFoundException, DAOException, IOException {
		CorsoBC cBc = new CorsoBC();
		Corso[] corsi = cBc.getCorsi();
		
		HashMap<Long, Integer> numeroCorsi= new HashMap<Long, Integer>();
		for(int i=0; i<corsi.length; i++) {
			if(numeroCorsi.containsKey(corsi[i].getCodDocente())) {
				numeroCorsi.put(corsi[i].getCodDocente(), numeroCorsi.get(corsi[i].getCodDocente())+1);
			}
			else numeroCorsi.put(corsi[i].getCodDocente(), 1);
		}
		
		ArrayList<Docente> docenti= new ArrayList<Docente>(new DocenteBC().getDocenti().length);
 		 for (Entry<Long, Integer> entry : numeroCorsi.entrySet()) {
			 if(entry.getValue()>=2) docenti.add(new DocenteBC().getDocenteById(entry.getKey()));
		 }
 		 
 		 return docenti.toArray(new Docente[docenti.size()]);
	}
	
	public Corso[] corsiPostiLiberi()  throws ClassNotFoundException, DAOException, IOException {
		IscrizioneBC iBC= new IscrizioneBC();
		CorsoBC cBc = new CorsoBC();
		Corso[] corsi = cBc.getCorsi();

		ArrayList<Corso> corsiDisp= new ArrayList<Corso>(corsi.length);
		for (int i=0; i<corsi.length; i++) {
			if(iBC.getIscrittiByCorso(corsi[i].getCodCorso()).length<12) {
				corsiDisp.add(corsi[i]);
			}
		}
		
		return corsiDisp.toArray(new Corso[corsiDisp.size()]);
	}
	
	
}
