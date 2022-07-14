package com.venetopiemonte.architecture.dao;

public interface DAOConstants {
	
	String SELECT_CORSISTA= "Select * from corsista";
	String SELECT_CORSO= "Select * from corso";
	String SELECT_ISCRIZIONE= "Select * from iscrizione";
	String SELECT_DOCENTE= "Select * from docente";
	
	String SELECT_CORSISTASEQ= "Select corsista_seq.nextval from dual";
	String SELECT_CORSOSEQ= "Select corso_seq.nextval from dual";
	
	String UPDATE_CORSISTA= "update corsista set nome=?, cognome=?, precedentiFormativi=? where codCorsista= ?";
	String UPDATE_CORSO= "update corso set nomecorso=?, inizio=?, fine=?, costo=?, commenti=?, aula=?, coddocente=? where codcorso=?";
	
	String DELETE_CORSISTA="delete from corsista where codcorsista=? ";
	String DELETE_CORSO="delete from corso where codcorso=?";
	String DELETE_ISCRIZIONE="delete from iscrizione where codcorsista=? and codcorso=?";
	
	String SELECT_CORSISTA_BYCOD= "Select * from corsista where codcorsista=?";
	String SELECT_CORSO_BYCOD= "Select * from corso where codcorso=?";
	String SELECT_ISCRIZIONE_BYCODCORSISTA= "Select * from iscrizione where codcorsista=?";
	String SELECT_ISCRIZIONE_BYCODCORSO= "Select * from iscrizione where codcorso=?";
	String SELECT_DOCENTE_BYCOD= "Select * from docente where coddocente=?";
	String SELECT_ISCRIZIONE_BYCODS	= "Select * from iscrizione where codcorsista = ? and codcorso = ?";
	
	String SELECT_ADMINPASS = "Select passAdmin from Admin where codAdmin = ?";
	
	String SELECT_CORSISTI_NONISCRITTI= "select codCorsista from corsista where codCorsista not in(select codCorsista from iscrizione where codCorso=?)";
	
}
