package com.sk.sheikhpura.dao;


import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.util.List;

import org.springframework.dao.DataAccessException;


public interface ImageDao {
	
	List<?> getImages() throws DataAccessException;

	void streamImage(String id, OutputStream os) throws DataAccessException;

	void storeImage(String id, String name, String shortDesc, String longDesc, int quantity, double price , Date insDate, InputStream is, int contentLength)
			throws DataAccessException;

	void checkImages() throws DataAccessException;

	void clearDatabase() throws DataAccessException;
}
