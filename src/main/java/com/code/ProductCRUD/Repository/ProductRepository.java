package com.code.ProductCRUD.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.code.ProductCRUD.Model.Product;


public interface ProductRepository extends JpaRepository<Product, Integer>{

}
