package com.sk.sheikhpura.dao.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.LobRetrievalFailureException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.AbstractLobCreatingPreparedStatementCallback;
import org.springframework.jdbc.core.support.AbstractLobStreamingResultSetExtractor;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.lob.LobCreator;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.util.FileCopyUtils;

import com.sk.sheikhpura.dao.ImageDao;
import com.sk.sheikhpura.model.ProductInfo;

public class DefaultImageDatabase extends JdbcDaoSupport implements ImageDao {

	private LobHandler lobHandler;

	public void setLobHandler(LobHandler lobHandler) {
		this.lobHandler = lobHandler;
	}

	@Override
	public List<ProductInfo> getImages() throws DataAccessException {
		String sql = "SELECT * FROM ProductInfo";
		List<ProductInfo> result = getJdbcTemplate().query(sql, new ProductRowMapper());
		return result;

	}

	private final class ProductRowMapper implements RowMapper<ProductInfo> {

		@Override
		public ProductInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
			//String description = lobHandler.getClobAsString(rs, 2);
			String id = rs.getString(1);
			String name = rs.getString(2);
			String shortDesc = rs.getString(3);
			String longdesc = rs.getString(4);
			String price = rs.getString(5);
			String quantity = rs.getString(6);
			String insDate = rs.getString(13);
			return new ProductInfo();
		}
	}

	@Override
	public void streamImage(String id, OutputStream os) throws DataAccessException {
		String sql = "SELECT P_THUMB FROM ProductInfo WHERE P_ID=?";

		getJdbcTemplate().query(sql, new Object[] { id }, new AbstractLobStreamingResultSetExtractor<ProductInfo>() {
			protected void handleNoRowFound() throws LobRetrievalFailureException {
				throw new IncorrectResultSizeDataAccessException("Image with id '" + id + "' not found in database", 11,
						0);
			}
			@Override
			public void streamData(ResultSet rs) throws SQLException, IOException {
				InputStream is = lobHandler.getBlobAsBinaryStream(rs, 11);
				if (is != null) {
					FileCopyUtils.copy(is, os);
				}
				
			}
		});

	}

	@Override
	public void storeImage(String id, String name, String shortDesc, String longDesc, int quantity, double price , Date insDate, InputStream thumb, int contentLength)
			throws DataAccessException {
		String sql = "INSERT INTO Products (p_id, p_name, p_short_desc, p_long_desc, p_quantity, p_price, p_thumb, ins_date ) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		getJdbcTemplate().execute(sql, new AbstractLobCreatingPreparedStatementCallback(this.lobHandler) {

			@Override
			protected void setValues(PreparedStatement ps, LobCreator lobCreator)
					throws SQLException, DataAccessException {
				ps.setString(1, id);
				ps.setString(2, name);
				ps.setString(3, shortDesc);
				ps.setString(4, longDesc);
				ps.setInt(5, quantity);
				ps.setDouble(6, price);
				ps.setDate(13, insDate);
				lobCreator.setBlobAsBinaryStream(ps, 11, thumb, contentLength);
				//lobCreator.setClobAsString(ps, 3, description);

			}
		});
	}

	@Override
	public void checkImages() throws DataAccessException {
		// Could implement consistency check here...
		logger.info("Checking images: not implemented but invoked by scheduling");
	}

	@Override
	public void clearDatabase() throws DataAccessException {
		getJdbcTemplate().update("DELETE FROM imagedb");

	}

}
