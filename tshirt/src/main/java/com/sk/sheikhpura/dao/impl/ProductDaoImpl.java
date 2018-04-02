package com.sk.sheikhpura.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sk.sheikhpura.dao.ProductDao;
import com.sk.sheikhpura.model.ProductInfo;


@Repository
public class ProductDaoImpl implements ProductDao {

	NamedParameterJdbcTemplate template;

	private ProductDaoImpl(DataSource dataSource) {
		template = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public int addProduct(ProductInfo entity) {

		String sql = "INSERT INTO PRODUCTS (P_NAME, P_SHORT_DESC, P_LONG_DESC, P_QUANTITY, P_PRICE, P_THUMB, P_IMAGE, INS_USER, INS_DATE, FILE_NAME, THUMB_TYPE )"
				+ "VALUES (:name, :shortDesc, :longDesc, :quantity, :price, :thumb, :image, :insUser, :insDate, :fileName, :fileType) ";
		Map<String, Object> param = new HashMap<>();
		param.put("id", entity.getId());
		param.put("name", entity.getName());
		param.put("shortDesc", entity.getShortDesc());
		param.put("longDesc", entity.getLongDesc());
		param.put("quantity", entity.getQuantity());
		param.put("price", entity.getPrice());
		param.put("thumb", entity.getImage());
		//param.put("thumb", entity.getThumb());
		param.put("image", entity.getImage());
		param.put("insUser", entity.getInsUser());
		param.put("insDate", entity.getInsDate());
		param.put("fileName", entity.getFileName());
		param.put("fileType", entity.getFileType());
		return template.update(sql, param);

	}

	@SuppressWarnings("unused")
	@Override
	public ProductInfo findProductInfo(Integer id) {
		ProductInfo product=new ProductInfo();
        if (product == null) {
            return null;
        }
		String sql = "SELECT * FROM PRODUCTS WHERE P_ID= :id";
		Map<String, Object> map = new HashMap<>();
		map.put("id", id);
		return template.queryForObject(sql, map, new ProductRowMapper());
	}

	private static final class ProductRowMapper implements RowMapper<ProductInfo> {

		@Override
		public ProductInfo mapRow(ResultSet rs, int arg1) throws SQLException {
			ProductInfo entity = new ProductInfo();
			entity.setId(rs.getInt("P_ID"));
			entity.setName(rs.getString("P_NAME"));
			entity.setLongDesc(rs.getString("P_LONG_DESC"));
			entity.setShortDesc(rs.getString("P_SHORT_DESC"));
			entity.setPrice(rs.getDouble("P_PRICE"));
			entity.setQuantity(rs.getInt("P_QUANTITY"));
			entity.setImage2(rs.getBinaryStream("P_THUMB"));
			entity.setFileType(rs.getString("THUMB_TYPE"));
			
			return entity;
		}

	}

	@Override
	public List<ProductInfo> findAll() {
		String sql = "SELECT * FROM PRODUCTS";
		List<ProductInfo> result = template.query(sql, new ProductRowMapper());
		return result;
	}

	@Override
	public int updateProduct(ProductInfo entity) {
		String sql = "UPDATE PRODUCTS SET P_NAME=:name, P_SHORT_DESC=:shortDesc, P_LONG_DESC=:longDesc, P_QUANTITY=:quantity, P_PRICE=:price, P_THUMB=:thumb, UPD_USER=:updUser, UPD_DATE=:updDate"
				+ " WHERE P_ID=:id";
		Map<String, Object> param = new HashMap<>();
		param.put("id", entity.getId());
		param.put("name", entity.getName());
		param.put("shortDesc", entity.getShortDesc());
		param.put("longDesc", entity.getLongDesc());
		param.put("quantity", entity.getQuantity());
		param.put("price", entity.getPrice());
		//param.put("thumb", entity.getThumb());
		//param.put("image", entity.getImage());
		param.put("updUser", entity.getUpdUser());
		param.put("updDate", entity.getUpdDate());
		return template.update(sql, param);
	}

	@Override
	public int deleteProduct(Integer id) {
		String sql = "DELETE FROM PRODUCTS WHERE P_ID=:id";
		return template.update(sql, new MapSqlParameterSource("id", id));
	}

}
