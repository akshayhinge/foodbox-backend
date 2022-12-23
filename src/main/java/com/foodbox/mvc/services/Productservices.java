package com.foodbox.mvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodbox.mvc.dao.Productdao;
import com.foodbox.mvc.models.Products;

@Service
public class Productservices {

	@Autowired
	private Productdao dao;
	
	public List<Products> getallproducts(){
		return dao.getallproducts();
	}
	
	public Products getproductsbyid(Long id) {
		return dao.getproductbyid(id);
	}
	
	public Products addproduct(Products product) {
		return dao.addproduct(product);
	}
	public Products addproduct(Long catid,Products product) {
		return dao.addproduct(catid,product);
	}
	
	public boolean updateproduct(Products product,Long id) {
		return dao.updateproduct(product, id);
	}
	public boolean deleteproduct(Long id) {
		return dao.deleteproductbyid(id);
	}
}
