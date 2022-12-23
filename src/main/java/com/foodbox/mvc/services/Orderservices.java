package com.foodbox.mvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodbox.mvc.dao.Orderdao;
import com.foodbox.mvc.models.Order;

@Service
public class Orderservices {

	@Autowired
	private Orderdao dao;
	
	public Order placeorder(Long uid,List<Long> pid, Order order) {
		return dao.placeorder(uid,pid,order);
	}
	
	public Order getbyid(Long id) {
		return dao.getbyid(id);
	}
	
	public List<Order> getallOrders(){
		return dao.getallorders();
	}
	public List<Order> getallOrdersbyuid(Long uid){
		return dao.getallordersbyuid(uid);
	}
	
	public String deletebyid(Long id) {
		return dao.deletebyid(id);
	}
	
	public List<Order> getbydate(String date){
		return dao.getbydate(date);
	}
	public List<Order> getbycate(Long id){
		return dao.getbycat(id);
	}
}
