package com.lti.SmartShop.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.lti.SmartShop.model.Product;

public interface ProductDAO extends JpaRepository<Product, Long> {

	@Query("SELECT data FROM Product data where data.category = ?1 AND data.name = ?2")
	public List<Product> findbycategory(String category, String name);

	@Transactional
	@Modifying
	@Query("delete from Product data where data.rating<2")
	public void deleteData();

	@Transactional
	@Modifying
	@Query("update Product data SET data.totalPrice = data.quantity*data.unitPrice")
	public void updateData();

}