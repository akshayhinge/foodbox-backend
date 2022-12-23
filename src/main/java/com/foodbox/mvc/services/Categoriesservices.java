package com.foodbox.mvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodbox.mvc.dao.Categoriesdao;
import com.foodbox.mvc.models.Categories;

@Service
public class Categoriesservices {

	@Autowired
	private Categoriesdao dao;
	
	public List<Categories> getallCategories(){
		return dao.getallcategories();
	}
	
	public Categories getCategoriesbyid(Long id){
		return dao.getCategoriesbyid(id);
	}
	
	public Categories addCategories(Categories categories) {
		return dao.addcategories(categories);
	}
	
	public String updatecatbyid(Categories categories,Long id) {
		return dao.updatecatbyid(categories,id);
	}
	public String deletebyid(Long id) {
		return dao.deletebyid(id);
	}
}
