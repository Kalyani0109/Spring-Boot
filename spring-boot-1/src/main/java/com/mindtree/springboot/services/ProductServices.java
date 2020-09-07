package com.mindtree.springboot.services;

import java.util.List;
import java.util.Optional;

import com.mindtree.springboot.Entities.Product;
import com.mindtree.springboot.exceptionHandling.ServiceException.ProductServiceException;

public interface ProductServices {
	
	public boolean addProduct(Product prod) throws ProductServiceException;
	
	public boolean deleteProductById (long prodId) throws ProductServiceException;
	
	public Optional<Product> getProductById (long prodId) throws ProductServiceException;
	
	public List<Product> getAllProductList () throws ProductServiceException;

}
