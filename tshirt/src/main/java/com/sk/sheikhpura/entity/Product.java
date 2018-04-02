package com.sk.sheikhpura.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCTS")
public class Product implements Serializable {
 
    private static final long serialVersionUID = -1000119078147252957L;
 
    private Integer id;
    private String name;
    private double price;
    private int quantity;
    
    private String shortDesc;
    private String longDesc;
    private String category;

    private byte[] imageOne;
    private byte[] imageTwo;
    private byte[] imageThree;
    private byte[] imageFour;
 
    public Product() {
    }
 
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }
 
    public void setId(Integer id) {
        this.id = id;
    }
 
    @Column(name = "NAME", length = 50, nullable = false)
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    @Column(name = "PRICE", nullable = false)
    public double getPrice() {
        return price;
    }
 
    public void setPrice(double price) {
        this.price = price;
    }
 
	@Column(name = "QUANTITY",  nullable = false)
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	    
    @Column(name = "SHORT_DESC", length = 100, nullable = true)
	public String getShortDesc() {
		return shortDesc;
	}

	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

	@Column(name = "LONG_DESC", length = 255, nullable = true)
	public String getLongDesc() {
		return longDesc;
	}

	public void setLongDesc(String longDesc) {
		this.longDesc = longDesc;
	}

	@Column(name = "CATEGORY", length = 100, nullable = true)
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Lob
	@Column(name = "IMAGE_ONE", length = Integer.MAX_VALUE, nullable = true)
	public byte[] getImageOne() {
		return imageOne;
	}

	public void setImageOne(byte[] imageOne) {
		this.imageOne = imageOne;
	}

	@Lob
	@Column(name = "IMAGE_TWO", length = Integer.MAX_VALUE, nullable = true)
	public byte[] getImageTwo() {
		return imageTwo;
	}

	public void setImageTwo(byte[] imageTwo) {
		this.imageTwo = imageTwo;
	}

	@Lob
	@Column(name = "IMAGE_THREE", length = Integer.MAX_VALUE, nullable = true)
	public byte[] getImageThree() {
		return imageThree;
	}

	public void setImageThree(byte[] imageThree) {
		this.imageThree = imageThree;
	}

	@Lob
	@Column(name = "IMAGE_FOUR", length = Integer.MAX_VALUE, nullable = true)
	public byte[] getImageFour() {
		return imageFour;
	}

	public void setImageFour(byte[] imageFour) {
		this.imageFour = imageFour;
	}
    
    
}