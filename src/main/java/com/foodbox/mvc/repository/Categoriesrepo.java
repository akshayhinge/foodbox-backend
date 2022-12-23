package com.foodbox.mvc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.foodbox.mvc.models.Categories;
import com.foodbox.mvc.models.Products;

public interface Categoriesrepo extends JpaRepository<Categories, Long> {

	@Query("select c from Categories c where c.name=:n")
	public List<Categories> findByName(@Param("n") String name);

	@Query(nativeQuery = true, value = "update Categories c set c.products=?1 where c.id=?2")
	public Categories updateproducts(List<Products> products, Long id);

	@Transactional
	@Modifying
	@Query("update Categories c set c.name=?1, c.desc=?2 where c.id=?3 ")
	public void updatecat(String name, String desc, Long id);

}
