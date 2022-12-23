package com.foodbox.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodbox.mvc.models.Categories;
import com.foodbox.mvc.services.Categoriesservices;

@RestController
@RequestMapping("/api/categories/")
@CrossOrigin
public class Categoriescontroller {

	@Autowired
	private Categoriesservices services;
	
	@GetMapping("{id}")
	public ResponseEntity<?> getcategoriesbyid(@PathVariable("id")Long id){
		Categories categories = services.getCategoriesbyid(id);
		if (categories!=null) {
			return ResponseEntity.ok().body(categories);			
		}
		return new ResponseEntity<String>("No records Avaliable",HttpStatus.NOT_FOUND);
	}
	@GetMapping("")
	public List<Categories> getallcategories(){
		return services.getallCategories();
//		if (categories.isEmpty()!=true) {
//			return new ResponseEntity<List<Categories>>((List<Categories>)categories,HttpStatus.FOUND);			
//		}
//		return new ResponseEntity<String>("No records Avaliable",HttpStatus.NOT_FOUND);
	}
			
	@PostMapping("")
	public ResponseEntity<?> addcategories(@RequestBody Categories categories) {
		Categories addcat = services.addCategories(categories);
		if (addcat != null) {
			return ResponseEntity.ok().body(addcat);
		}
		return new ResponseEntity<String>("This Category is already exists", HttpStatus.BAD_REQUEST);
	}

	@PutMapping("{id}")
	public ResponseEntity<String> updatecatbyid(@PathVariable("id") Long id, @RequestBody Categories categories) {	
		return new ResponseEntity<String>(services.updatecatbyid(categories, id), HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deletebyid(@PathVariable("id") Long id) {
		return new ResponseEntity<String>(services.deletebyid(id), HttpStatus.OK);
	}

}
