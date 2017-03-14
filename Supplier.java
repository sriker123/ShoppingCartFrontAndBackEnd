package com.niit.shoppingcart.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="supplier")
@Component
public class Supplier
{
	@Id
	private String Supp_Id;
	private String Supp_name;
	private String Supp_Desc;
	private Set<Supplier> suppliers;
	
	@OneToMany(mappedBy="suppliers",fetch= FetchType.EAGER)
	public Set<Supplier> getSupplier() {
		return suppliers;
	}
	public void setSupplier(Set<Supplier> supplier) {
		this.suppliers = supplier;
	}
	public String getSupp_Id() {
		return Supp_Id;
	}
	public void setSupp_Id(String supp_Id) {
		Supp_Id = supp_Id;
	}
	public String getSupp_name() {
		return Supp_name;
	}
	public void setSupp_name(String supp_name) {
		Supp_name = supp_name;
	}
	public String getSupp_Desc() {
		return Supp_Desc;
	}
	public void setSupp_Desc(String supp_Desc) {
		Supp_Desc = supp_Desc;
	}
	
	
}
