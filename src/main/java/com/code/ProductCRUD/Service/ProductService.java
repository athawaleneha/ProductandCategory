package com.code.ProductCRUD.Service;

import java.util.List;

import com.code.ProductCRUD.Model.Product;

public interface ProductService {

	Product saveProduct(Product product);
	List<Product> getAllProduct();
	Product getProductById(int id);
	Product updateProduct(Product product, int id);
	void deleteProduct(int id);
}
