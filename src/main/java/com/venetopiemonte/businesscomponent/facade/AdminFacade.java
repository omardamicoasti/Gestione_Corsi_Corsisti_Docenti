package com.venetopiemonte.businesscomponent.facade;

import java.io.IOException;

import com.venetopiemonte.businesscomponent.CorsistaBC;
import com.venetopiemonte.businesscomponent.CorsoBC;
import com.venetopiemonte.businesscomponent.DocenteBC;
import com.venetopiemonte.businesscomponent.IscrizioneBC;
import com.venetopiemonte.businesscomponent.model.Corsista;
import com.venetopiemonte.businesscomponent.model.Corso;
import com.venetopiemonte.businesscomponent.model.Docente;
import com.venetopiemonte.businesscomponent.model.Iscrizione;
import com.venetopiemonte.exceptions.DAOException;

public class AdminFacade {
	private static AdminFacade cF;
	private CorsoBC corsoBC;
	private CorsistaBC corsistaBC;
	private IscrizioneBC iscrizioneBC;
	private DocenteBC docenteBC;
	
	public AdminFacade() {
		super();
	}
	
	public static AdminFacade getInstance() {
		if(cF == null)
			cF = new AdminFacade();
		return cF;
	}
	
	public void createOrUpdateCorso(Corso corso) 
			throws ClassNotFoundException, DAOException, IOException {
		corsoBC = new CorsoBC();
		corsoBC.createOrUpdate(corso);
	}
	
	public void createOrUpdateCorsista(Corsista corsista) 
			throws ClassNotFoundException, DAOException, IOException {
		corsistaBC = new CorsistaBC();
		corsistaBC.createOrUpdate(corsista);
	}
	
	public void createIscrizione(Iscrizione iscrizione) 
			throws ClassNotFoundException, DAOException, IOException {
		iscrizioneBC = new IscrizioneBC();
		iscrizioneBC.create(iscrizione);
	} 
	
	public long[] getCorsiByIscritto(long id) throws ClassNotFoundException, DAOException, IOException {
		iscrizioneBC = new IscrizioneBC();
		return iscrizioneBC.getCorsiByIscritto(id);
	}
	
	public long[] getIscrittiByCorso(long id) throws ClassNotFoundException, DAOException, IOException {
		iscrizioneBC = new IscrizioneBC();
		return iscrizioneBC.getIscrittiByCorso(id);
	}
	
	public long[] getNonIscrittiByCorso(long id) throws ClassNotFoundException, DAOException, IOException {
		iscrizioneBC = new IscrizioneBC();
		return iscrizioneBC.getNonIscrittiByCorso(id);
	}
	
	public void deleteCorso(long id) 
			throws ClassNotFoundException, DAOException, IOException {
		corsoBC = new CorsoBC();
		corsoBC.delete(id);
	}
	
	public void deleteCorsista(long id) 
			throws ClassNotFoundException, DAOException, IOException {
		corsistaBC = new CorsistaBC();
		corsistaBC.delete(id);
	}
	
	public void deleteIscrizione(long idCorsista, long idCorso) 
			throws ClassNotFoundException, DAOException, IOException {
		iscrizioneBC = new IscrizioneBC();
		iscrizioneBC.delete(idCorsista, idCorso);
	}
	
	public Corso getCorsoByID(long id) throws ClassNotFoundException, DAOException, IOException {
		corsoBC = new CorsoBC();
		return corsoBC.getById(id);
	}
	
	public Corso[] getCorsi() throws ClassNotFoundException, DAOException, IOException {
		corsoBC = new CorsoBC();
		return corsoBC.getCorsi();
	}
	
	public Corsista getCorsistaByID(long id) throws ClassNotFoundException, DAOException, IOException {
		corsistaBC = new CorsistaBC();
		return corsistaBC.getById(id);
	}
	
	public Corsista[] getCorsisti() throws ClassNotFoundException, DAOException, IOException {
		corsistaBC = new CorsistaBC();
		return corsistaBC.getCorsisti();
	}
	
	public Corso[] searchCorsi(String query) throws ClassNotFoundException, DAOException, IOException {
		corsoBC = new CorsoBC();
		return corsoBC.searchCorsi(query);
	}
	
	public Corsista[] searchCorsista(String query) throws ClassNotFoundException, DAOException, IOException {
		corsistaBC = new CorsistaBC();
		return corsistaBC.searchCorsista(query);
	}
	
	public Docente getDocenteById(long id) throws ClassNotFoundException, DAOException, IOException {
		docenteBC = new DocenteBC();
		return docenteBC.getDocenteById(id);
	}
	
	public Docente[] getDocenti() throws ClassNotFoundException, DAOException, IOException {
		docenteBC = new DocenteBC();
		return docenteBC.getDocenti();
	}
}
