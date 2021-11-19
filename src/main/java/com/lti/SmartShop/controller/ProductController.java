package com.lti.SmartShop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.SmartShop.DAO.ProductDAO;
import com.lti.SmartShop.model.Product;
import com.lti.SmartShop.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private ProductDAO productDAO;

	@PostMapping(path = "/addProduct")
	public @ResponseBody String addProduct(@RequestBody Product product) {

		Product n = new Product();

		n.setProductId(product.productId);
		n.setName(product.name);
		n.setCategory(product.category);
		n.setQuantity(product.quantity);
		n.setRating(product.rating);
		n.setTotalPrice(product.totalPrice);
		n.setUnitPrice(product.unitPrice);

		productService.save(n);
		return "Product Successfully Added";
	}

	@PostMapping(path = "/updateProduct")
	public @ResponseBody String updateProduct(@RequestBody Product product) {

		Product n = new Product();
		n.setProductId(product.productId);

		n.setName(product.name);
		n.setCategory(product.category);
		n.setQuantity(product.quantity);
		n.setRating(product.rating);
		n.setTotalPrice(product.totalPrice);
		n.setUnitPrice(product.unitPrice);

		productService.save(n);
		return "Product Successfully Updated";
	}

	@GetMapping("/displayProduct")
	public Optional<Product> findByName(@RequestBody Product product) {
		return productService.findById(product.productId);
	}

	@GetMapping("/searchProduct")
	public List<Product> searchProduct(@RequestBody Product product) {
		return productDAO.findbycategory(product.category.toString(), product.name.toString());
	}

	@DeleteMapping("/deleteProduct")
	public void DeleteProducts() {
		productDAO.deleteData();
	}

	@PutMapping("/updatePrice")
	public void updatePrice() {
		productDAO.updateData();
	}

	@GetMapping(path = "/getAllProducts")
	public @ResponseBody Iterable<Product> getAllProducts() {
		return productService.findAll();
	}

}