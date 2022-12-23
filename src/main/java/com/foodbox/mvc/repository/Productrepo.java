package com.foodbox.mvc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.foodbox.mvc.models.Categories;
import com.foodbox.mvc.models.Products;

public interface Productrepo extends JpaRepository<Products, Long> {

	@Query("select p from Products p inner join p.categories c where p.name=:pname or c.name=:cname")
	public List<Products> findByName(@Param("pname") String pname, @Param("cname") String cname);

	@Transactional
	@Modifying
	@Query("update Products p set p.name=?1, p.price=?2, p.desc=?3, p.categories=?4 where p.id=?5")
	public void updateproductscat(String name,Double price,String desc,Categories categories, Long id);

	@Transactional
	@Modifying
	@Query("delete Products p where p.id=?1")
	public void deletebyid(Long id);
}
