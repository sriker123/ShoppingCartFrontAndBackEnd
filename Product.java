package com.niit.shoppingcart.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "product")
@Component
public class Product {
@Id
	private String Prod_Id;

	private String Prod_Name;

	private String Prod_Description;

	private String Prod_Price;
	
	private String category_id;
	
	private String supplier_id;
	
	@ManyToOne
	@JoinColumn(name="category_id", updatable=false, insertable=false, nullable=false)
	private Category category;
	
	@ManyToOne
	@JoinColumn(name="supplier_id", updatable=false, insertable=false, nullable=false)
	private Category supplier;
	

	public String getCategory_id() {
		return category_id;
	}

	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}

	public String getSupplier_id() {
		return supplier_id;
	}

	public void setSupplier_id(String supplier_id) {
		this.supplier_id = supplier_id;
	}

	// Getter and Setter methods for the parameters
	public String getProd_Id() {
		return Prod_Id;
	}

	public void setProd_Id(String prod_Id) {
		Prod_Id = prod_Id;
	}

	public String getProd_Name() {
		return Prod_Name;
	}

	public void setProd_Name(String prod_Name) {
		Prod_Name = prod_Name;
	}

	public String getProd_Description() {
		return Prod_Description;
	}

	public void setProd_Description(String prod_Description) {
		Prod_Description = prod_Description;
	}

	public String getProd_Price() {
		return Prod_Price;
	}

	public void setProd_Price(String prod_Price) {
		Prod_Price = prod_Price;
	}



}
