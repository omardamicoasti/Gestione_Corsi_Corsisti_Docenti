package com.venetopiemonte.businesscomponent.idgenerator;

import java.io.IOException;

import com.venetopiemonte.exceptions.DAOException;

public interface IdGeneratorInterface {
	long getNextId() throws ClassNotFoundException, DAOException, IOException;
}

