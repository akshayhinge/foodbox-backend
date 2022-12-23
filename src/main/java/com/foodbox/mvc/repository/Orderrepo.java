package com.foodbox.mvc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.foodbox.mvc.models.Order;
import com.foodbox.mvc.models.Products;
import com.foodbox.mvc.models.User;

public interface Orderrepo extends JpaRepository<Order, Long> {

	public List<Order> findByDate(String date);

	@Transactional
	@Modifying
	@Query(nativeQuery = true, value = "insert into Order (date, paymentmode, users, products) VALUES (?1, ?2, ?3, ?4)")
	public Order saveorder(String date, String paymentmode, List<User> users, List<Products> products);

	@Query("select o from Order o inner join o.users u where u.id=?1 ")
	public List<Order> getorderbyuid(Long id);
}
