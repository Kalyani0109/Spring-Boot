package com.mindtree.springboot.services;

import java.util.Optional;

import com.mindtree.springboot.Entities.Product;
import com.mindtree.springboot.Entities.ProductDetails;
import com.mindtree.springboot.exceptionHandling.ServiceException.ProductDetailsServiceException;

public interface ProductDetailsServices {
	
	public boolean addProductDetails(ProductDetails prodDetails) throws ProductDetailsServiceException;
	
	public boolean deleteProductdetailsByProd(Optional<Product> prod) throws ProductDetailsServiceException;
	
	public ProductDetails getProductDetails(Optional<Product> prod) throws ProductDetailsServiceException;

}
