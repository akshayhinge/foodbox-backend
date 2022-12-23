package com.foodbox.mvc.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private Long id;

	@Column( nullable = false)
	private String date;

	@Column( nullable = false)
	private Integer totalitems;

	@Column( nullable = false)
	private Integer totalamount;

	@Column( nullable = false)
	private String paymentmode;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(name = "user_order", joinColumns = { @JoinColumn(name = "order_id") }, inverseJoinColumns = {
			@JoinColumn(name = "user_id") })
	private List<User> users;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(name = "products_order", joinColumns = { @JoinColumn(name = "order_id") }, inverseJoinColumns = {
			@JoinColumn(name = "product_id") })
	private List<Products> products;

	public Order() {
	}

	public Order(String date, Integer totalitems, Integer totalamount, String paymentmode, List<User> users,
			List<Products> products) {
		super();
		this.date = date;
		this.totalitems = totalitems;
		this.totalamount = totalamount;
		this.paymentmode = paymentmode;
		this.users = users;
		this.products = products;
	}


	public Order(String date, Integer totalitems, Integer totalamount, String paymentmode) {
		super();
		this.date = date;
		this.totalitems = totalitems;
		this.totalamount = totalamount;
		this.paymentmode = paymentmode;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public Integer getTotalitems() {
		return totalitems;
	}


	public void setTotalitems(Integer totalitems) {
		this.totalitems = totalitems;
	}


	public Integer getTotalamount() {
		return totalamount;
	}


	public void setTotalamount(Integer totalamount) {
		this.totalamount = totalamount;
	}


	public String getPaymentmode() {
		return paymentmode;
	}


	public void setPaymentmode(String paymentmode) {
		this.paymentmode = paymentmode;
	}


	public List<User> getUsers() {
		return users;
	}


	public void setUsers(List<User> users) {
		this.users = users;
	}


	public List<Products> getProducts() {
		return products;
	}


	public void setProducts(List<Products> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", date=" + date + ", totalitems=" + totalitems + ", totalamount=" + totalamount
				+ ", paymentmode=" + paymentmode + ", users=" + users + ", products=" + products + "]";
	}


}
