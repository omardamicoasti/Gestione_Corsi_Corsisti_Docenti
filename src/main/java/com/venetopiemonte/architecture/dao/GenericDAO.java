package com.venetopiemonte.architecture.dao;

import java.sql.Connection;

import com.venetopiemonte.exceptions.DAOException;

public interface GenericDAO<T> {
	void create(Connection conn, T entity) throws DAOException;
	void update(Connection conn, T entity) throws DAOException;
	void delete(Connection conn, long id) throws DAOException;
	T getById(Connection conn, long id) throws DAOException;
	T[] getAll(Connection conn) throws DAOException;
}

