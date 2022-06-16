package com.code.ProductCRUD.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.code.ProductCRUD.Exception.ResourceNotFound;
import com.code.ProductCRUD.Model.Product;
import com.code.ProductCRUD.Repository.ProductRepository;
import com.code.ProductCRUD.Service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	private ProductRepository productRepo;
	
	public ProductServiceImpl(ProductRepository productRepo) {
		super();
		this.productRepo = productRepo;
	}

	@Override
	public Product saveProduct(Product product) {
		// TODO Auto-generated method stub
		return productRepo.save(product);
	}

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return productRepo.findAll();
	}


	@Override
	public Product getProductById(int id) {
		// TODO Auto-generated method stub
		/*Optional<Product> product = productRepo.findById(id);
		if(product.isPresent())
		{
			return product.get();
		}
		else {
			throw new ResourceNotFound("Product","Id",id);
		}*/
		//or
		//lambda experssion
		return productRepo.findById(id).orElseThrow(() -> new ResourceNotFound("Product","Id",id));
	}

	@Override
	public Product updateProduct(Product product, int id) {
		// TODO Auto-generated method stub
		//we need to check whether product with given id is exist in DB or not
		
		Product existingProduct = productRepo.findById(id).orElseThrow(
				() -> new ResourceNotFound("Product","Id",id));  //lambda expression
			
		existingProduct.setProductName(product.getProductName());
		existingProduct.setProductPrice(product.getProductPrice());
		
		//save existing product to db
		productRepo.save(existingProduct);
		return existingProduct;
	}

	@Override
	public void deleteProduct(int id) {
		// TODO Auto-generated method stub
		
		//check product present in DB or not
		productRepo.findById(id).orElseThrow(() ->
							new ResourceNotFound("Product","Id",id));
		productRepo.deleteById(id);
	}

}
