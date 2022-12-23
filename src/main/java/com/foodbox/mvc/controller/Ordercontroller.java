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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodbox.mvc.models.Order;
import com.foodbox.mvc.services.Orderservices;

@RestController
@RequestMapping("/api/user/order/")
@CrossOrigin
public class Ordercontroller {

	@Autowired
	private Orderservices services;

	@GetMapping("{id}")
	public ResponseEntity<?> getbyid(@PathVariable("id") Long id){
		Order order = services.getbyid(id);
		if (order!=null) {
			return ResponseEntity.ok(order);
		}
		return new ResponseEntity<String>("No order placed with this id...",HttpStatus.NOT_FOUND);
	}
	@GetMapping("{uid}")
	public ResponseEntity<?> getallOrdersofuser(@PathVariable("uid")Long uid){
		List<Order> getallOrders = services.getallOrdersbyuid(uid);
		if (getallOrders.isEmpty()!=true) {
			return  ResponseEntity.ok(getallOrders);
		}
		return new ResponseEntity<String>("No order placed yet...",HttpStatus.NOT_FOUND);
	}
	@GetMapping("")
	public ResponseEntity<?> getallOrders(){
		List<Order> orders = services.getallOrders();
		if (orders.isEmpty()!=true) {
			return ResponseEntity.ok(orders);
		}
		return new ResponseEntity<String>("No order placed yet...",HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("{uid}/{pid}")
	public ResponseEntity<?> placeorder(@PathVariable("uid") Long uid,
										@PathVariable("pid") List<Long> pid,
										@RequestBody Order order){
		Order placeorder = services.placeorder(uid,pid,order);
		if (placeorder!=null) {
			return ResponseEntity.ok(placeorder);
		}
		return new ResponseEntity<String>("Something went wrong[check userid and productid]",HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deletebyid(@PathVariable("id") Long id){
		return ResponseEntity.ok(services.deletebyid(id));
	}
	
	@GetMapping("bydate/{date}")
	public ResponseEntity<?> getbydate(@PathVariable("date") String date){
		List<Order> orders = services.getbydate(date);
		if (orders.isEmpty()==false) {
			return ResponseEntity.ok(orders);
		}
		return new ResponseEntity<String>("No order placed with this date",HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("bycategory/{id}")
	public ResponseEntity<?> getbycate(@PathVariable("id") Long id){
		List<Order> orders = services.getbycate(id);
		if (orders.isEmpty()==false) {
			return ResponseEntity.ok(orders);
		}
		return new ResponseEntity<String>("No order placed with this categories",HttpStatus.NOT_FOUND);
	}
	

}
