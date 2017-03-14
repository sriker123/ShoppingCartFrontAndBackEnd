package com.niit.shoppingcart.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "category") // if the class name and table name are different
@Component // if you want to create instance of class category - category

public class Category {
	// add simple properties - same as Category table
	// generate getter setter methods
	@Id
	private String Cat_Id;

	@Column(name = "Cat_Name") // if the field name and property name are
								// different
	private String Cat_Name;

	private String Cat_Description;
	
	private Set<Product> products;

	@OneToMany(mappedBy="category",fetch= FetchType.EAGER)
	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public String getCat_Name() {
		return Cat_Name;
	}

	public void setCat_Name(String cat_Name) {
		Cat_Name = cat_Name;
	}

	public String getCat_Description() {
		return Cat_Description;
	}

	public void setCat_Description(String cat_Description) {
		Cat_Description = cat_Description;
	}

	public String getCat_Id() {
		return Cat_Id;
	}

	public void setCat_Id(String cat_Id) {
		Cat_Id = cat_Id;
	}

}
