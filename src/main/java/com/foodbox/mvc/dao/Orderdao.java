package com.foodbox.mvc.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.foodbox.mvc.models.Categories;
import com.foodbox.mvc.models.Order;
import com.foodbox.mvc.models.Products;
import com.foodbox.mvc.models.User;
import com.foodbox.mvc.repository.Categoriesrepo;
import com.foodbox.mvc.repository.Orderrepo;
import com.foodbox.mvc.repository.Productrepo;
import com.foodbox.mvc.repository.Userrepo;



@Repository
public class Orderdao {

	@Autowired
	private Orderrepo orderrepo;

	@Autowired
	private Productrepo productrepo;

	@Autowired
	private Userrepo userrepo;

	@Autowired
	private Categoriesrepo categoriesrepo;

	public Order placeorder(Long uid, List<Long> pid, Order order) {
		try {
			List<Products> products = new ArrayList<Products>();
			for (Long id : pid) {
				if(id==0) {
					products=null;
					break;
				}else {
				Products product = productrepo.findById(id).get();
				products.add(product);
				}
			}

			User user = userrepo.findById(uid).get();
			List<User> users = new ArrayList<User>();
			users.add(user);

			order.setUsers(users);
			order.setProducts(products);

			return orderrepo.save(order);

		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}

	public Order getbyid(Long id) {
		try {
			Optional<Order> data = orderrepo.findById(id);
			return data.get();
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}

	public List<Order> getallorders() {
		try {

			return orderrepo.findAll();
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}
	public List<Order> getallordersbyuid(Long uid) {
		try {
			return orderrepo.getorderbyuid(uid);
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}

	public String deletebyid(Long id) {
		try {
			orderrepo.deleteById(id);
			return "Order deleted successfully";
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	public List<Order> getbydate(String date) {
		try {
			return orderrepo.findByDate(date);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public List<Order> getbycat(Long id) {
		try {
			Optional<Categories> catedata = categoriesrepo.findById(id);
			Categories categories = catedata.get();
			List<Order> allorders = orderrepo.findAll();
			List<Order> orders = new ArrayList<Order>();
			for (Order o : allorders) {
				for (Products p : o.getProducts()) {
					if (p.getCategories().getId().equals(categories.getId())) {
						orders.add(o);
					}
				}
			}
			
			return orders;
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}
}
