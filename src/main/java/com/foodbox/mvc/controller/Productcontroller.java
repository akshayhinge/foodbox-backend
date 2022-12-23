package com.foodbox.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.websocket.server.PathParam;

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
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.foodbox.mvc.models.Products;
import com.foodbox.mvc.services.Productservices;

@RestController
@RequestMapping("/api/product")
@CrossOrigin
public class Productcontroller {

	@Autowired
	private Productservices services;
	
	@GetMapping("{id}")
	public ResponseEntity<?> getproductbyid(@PathVariable("id")Long id){
		Products products = services.getproductsbyid(id);
		if (products!=null) {
			return ResponseEntity.ok().body(products);			
		}
		return new ResponseEntity<String>("No records Avaliable",HttpStatus.NOT_FOUND);
	}
	@GetMapping("")
	public List<Products> getallproducts(){		
		return services.getallproducts();
//		if (allproducts.isEmpty()!=true) {
//			return ResponseEntity(List<Products>). allproducts,HttpStatus.FOUND);			
//		}
//		return new ResponseEntity<String>("No records Avaliable",HttpStatus.NOT_FOUND);
	}
	
//	@PostMapping("")
//	public ResponseEntity<?> addproduct(@RequestBody Products product){
//		System.out.println(product.getCategories().getName());
//		Products addproduct = services.addproduct(product);
//		if (addproduct==null) {
//			return new ResponseEntity<String>("This product or category is already exists",HttpStatus.BAD_REQUEST);
//		}
//		return ResponseEntity.ok().body(addproduct);
//	}
	
//	add product into existing category
	@PostMapping("/{catid}")
	public ResponseEntity<?> addproductintoexistingcategory(@PathVariable("catid") Long catid, @RequestBody Products product){
		Products addproduct = services.addproduct(catid,product);
		if (addproduct==null) {
			return new ResponseEntity<String>("This product or category is already exists",HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok().body(addproduct);
	}
//	
//	@PostMapping("{catid}")
//	public ResponseEntity<?> addproductintoexistingcategory(@PathVariable("catid") Long catid,
//			@PathParam("file") MultipartFile file, 
//			@PathParam("product") String p) throws IOException{
////		if(file.isEmpty()) {
////			return ResponseEntity.ok().body("file is empty");
////		}
//		Products products=new Products();
//		products.setImg(file.getBytes());
//		products.setImgurl(file.getOriginalFilename());
//		products=new ObjectMapper().readValue(p, Products.class);
//		System.out.println(products);
//		Products addproduct = services.addproduct(catid,products);
//		
//		if (addproduct==null) {
//			return new ResponseEntity<String>("This product or category is already exists",HttpStatus.BAD_REQUEST);
//		}
//		return ResponseEntity.ok().body(addproduct);
//	}
	
	@PutMapping("{id}")
	public boolean updateproduct(@PathVariable("id") Long id, @RequestBody Products product){
		return services.updateproduct(product,id);
	}
	@DeleteMapping("{id}")
	public Boolean deleteproduct(@PathVariable("id") Long id){
		return services.deleteproduct(id);
	}
}
