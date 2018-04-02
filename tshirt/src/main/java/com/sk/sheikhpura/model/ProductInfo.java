package com.sk.sheikhpura.model;

import java.io.InputStream;
import java.io.Serializable;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class ProductInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name ;
	private String shortDesc;
	private String longDesc;
	private int quantity;
	private double price;
	
	private MultipartFile thumb;
	private MultipartFile image;
	private InputStream image2;
	private String fileName;
	private String fileType;
	
	private String insUser;
	private Date insDate;
	private String updUser;
	private Date updDate;
	

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getShortDesc() {
		return shortDesc;
	}
	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}
	public String getLongDesc() {
		return longDesc;
	}
	public void setLongDesc(String longDesc) {
		this.longDesc = longDesc;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName=fileName;
	}
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
	public String getInsUser() {
		return insUser;
	}
	public void setInsUser(String insUser) {
		this.insUser = insUser;
	}
	public Date getInsDate() {
		return insDate;
	}
	public void setInsDate(Date insDate) {
		this.insDate = insDate;
	}
	public String getUpdUser() {
		return updUser;
	}
	public void setUpdUser(String updUser) {
		this.updUser = updUser;
	}
	public Date getUpdDate() {
		return updDate;
	}
	public void setUpdDate(Date updDate) {
		this.updDate = updDate;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public boolean isNew() {
		return (this.id == null);
	}
	
	
	public MultipartFile getThumb() {
		return thumb;
	}
	public void setThumb(MultipartFile thumb) {
		this.thumb = thumb;
	}
	public InputStream getImage2() {
		return image2;
	}
	public void setImage2(InputStream image2) {
		this.image2 = image2;
	}
	@Override
	public String toString() {
		return "ProductInfo [id=" + id + ", name=" + name + ", shortDesc=" + shortDesc + ", longDesc=" + longDesc
				+ ", quantity=" + quantity + ", price=" + price + ", fileName=" + fileName + ", fileType=" + fileType
				+ ", imgContent=" +  ", thumb=" + thumb + ", image=" + image + ", insUser="
				+ insUser + ", insDate=" + insDate + ", updUser=" + updUser + ", updDate=" + updDate + "]";
	}
	
	
	
}