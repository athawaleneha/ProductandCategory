package com.code.ProductCRUD.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.code.ProductCRUD.Model.Product;
import com.code.ProductCRUD.Service.ProductService;
import com.code.ProductCRUD.ServiceImpl.ProductServiceImpl;

@RestController
@RequestMapping("/api/product")
public class ProductController {

	private ProductServiceImpl productService;
	
	public ProductController(ProductServiceImpl productService) {
		super();
		this.productService = productService;
	}
	
	//build create product REST API
	@PostMapping()
	public ResponseEntity<Product> saveProduct(@RequestBody Product product){
		System.out.println(product);
		return new ResponseEntity<Product>(productService.saveProduct(product),HttpStatus.CREATED);
	}
	
	//build get all employee REST API
	@GetMapping
	public List<Product> getAllProduct(){
		return productService.getAllProduct();
	}
	
	//build get product id by Rest API
	//http://localhost:8080/api/product/1
	@GetMapping("{id}")
	public ResponseEntity<Product> getProductById(@PathVariable("id") int productId){
	
	return new ResponseEntity<Product>(productService.getProductById(productId),HttpStatus.OK);
	}
	
	//build update employee Rest API
	//http://localhost:8080/api/product/2
	@PutMapping("{id}")               //path id daynamicaly change
	public ResponseEntity<Product> updateProduct(@PathVariable("id") int id
			                                     ,@RequestBody Product product){
	return new ResponseEntity<Product>(productService.updateProduct(product, id),HttpStatus.OK);	
	}
	
	//build delete product REST API
	//http://localhost:8080/api/product/2
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable("id") int id){
		productService.deleteProduct(id);   //delete product from db
		return new ResponseEntity<String>("Product delete successfully!",HttpStatus.OK);
		
	}
}
