package com.foodbox.mvc.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.foodbox.mvc.models.Categories;
import com.foodbox.mvc.models.Products;
import com.foodbox.mvc.repository.Categoriesrepo;
import com.foodbox.mvc.repository.Productrepo;

@Repository
public class Productdao {

	@Autowired
	private Productrepo productrepo;

	@Autowired
	private Categoriesrepo categoriesrepo;

	//get all products
	public List<Products> getallproducts() {
		try {
			return productrepo.findAll();
		} catch (Exception e) {
			e.getStackTrace();
		}
		return null;
	}

//	get product by product id
	public Products getproductbyid(Long id) {
		try {
			Optional<Products> data = productrepo.findById(id);
			return data.get();
		} catch (Exception e) {
			e.getStackTrace();
		}
		return null;
	}

	public Products addproduct(Products product) {
		System.out.println(product.getCategories().getName());
		try {
			if (product.getCategories().getName() != null) {

				List<Products> check = productrepo.findByName(product.getName(), product.getCategories().getName());

				for (Products pro : check) {
					if (pro.getName().contains(product.getName())
							|| pro.getCategories().getName().contains(product.getCategories().getName())) {
						return null;
					}
				}
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return productrepo.save(product);

	}
	public Products addproduct(Long catid,Products product) {		
		try {
			Categories categories = categoriesrepo.findById(catid).get();
			List<Products> products = categories.getProducts();
			for(Products pro:products) {
				if (pro.getName().contains(product.getName())){
					return null;
				}
			}			
			product.setCategories(categories);
			productrepo.save(product);
			return product;
		} catch (Exception e) {
			e.getStackTrace();
		}
		return null;
		
	}

	public boolean updateproduct(Products product, Long id) {
		try {
			Products oldproduct = productrepo.findById(id).get();
			if (product.getName() != null) {
				oldproduct.setName(product.getName());
			}
			if (product.getPrice() != null) {
				oldproduct.setPrice(product.getPrice());
			}
			if (product.getDesc() != null) {
				oldproduct.setDesc(product.getDesc());
			}
			if (product.getImgurl() != null) {
				oldproduct.setImgurl(product.getImgurl());
			}
			if (product.getIsavailable() != null) {
				oldproduct.setIsavailable(product.getIsavailable());
			}
			productrepo.save(oldproduct);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public boolean deleteproductbyid(Long id) {
		boolean status=false;
		try {
			productrepo.deleteById(id);
			status=true;
		} catch (Exception e) {
			return false;
		}
		return status;
	}
}
