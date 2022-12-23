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

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "products")
public class Products {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private Long id;

	@Column(name = "product_name", nullable = false)
	private String name;

	@Column(name = "product_img_name",nullable =true)
	private String imgurl;
	
	
	@Column(name = "product_price", nullable = false, precision = 2)
	private Double price;

	@Column(name = "product_desc", nullable = true)
	private String desc;

	@Column(name = "available", nullable = false)
	private Boolean isavailable;
	
//	@Column(name = "product_qty", nullable = true)
//	private Integer qty;
	

	@ManyToMany(mappedBy = "products", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JsonIgnore
	private List<Order> order;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "category_id")
	@JsonBackReference
	private Categories categories;

	@ManyToMany(mappedBy = "products", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JsonIgnore
	private List<Cart> cart;

	public Products() {
	}

	public Products(String name, Double price, String desc, Boolean isavailable, Categories categories) {
		super();
		this.name = name;
		this.price = price;
		this.desc = desc;
		this.isavailable = isavailable;
		this.categories = categories;
	}

	public Products(String name, String imgurl, Double price, String desc, Boolean isavailable) {
		super();
		this.name = name;
		this.imgurl = imgurl;
		this.price = price;
		this.desc = desc;
		this.isavailable = isavailable;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Boolean getIsavailable() {
		return isavailable;
	}

	public void setIsavailable(Boolean isavailable) {
		this.isavailable = isavailable;
	}

	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}

	public Categories getCategories() {
		return categories;
	}

	public void setCategories(Categories categories) {
		this.categories = categories;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	public List<Cart> getCart() {
		return cart;
	}

	public void setCart(List<Cart> cart) {
		this.cart = cart;
	}

}
