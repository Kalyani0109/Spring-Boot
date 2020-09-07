package com.mindtree.springboot.servicesImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.springboot.Entities.Product;
import com.mindtree.springboot.Entities.ProductDetails;
import com.mindtree.springboot.exceptionHandling.ServiceException.ProductDetailsServiceException;
import com.mindtree.springboot.repository.ProductDetailsRepository;
import com.mindtree.springboot.services.ProductDetailsServices;

@Service
@Transactional(propagation=Propagation.REQUIRES_NEW, readOnly=false)
public class ProductDetailsServicesImpl implements ProductDetailsServices {
	
	@Autowired
	private ProductDetailsRepository prodDetailsRepo;

	@Override
	public boolean addProductDetails(ProductDetails prodDetails) throws ProductDetailsServiceException {
		try{
			this.prodDetailsRepo.saveAndFlush(prodDetails);
			return true;
		}catch(Exception e){
			System.out.println(e.getStackTrace());
			throw new ProductDetailsServiceException();
		}
			
	}

	@Override
	public boolean deleteProductdetailsByProd(Optional<Product> prod) throws ProductDetailsServiceException {
		try{
			this.prodDetailsRepo.deleteByProduct(prod);
			return true;
		}catch(Exception e){
			System.out.println(e.getStackTrace());
			throw new ProductDetailsServiceException();
		}
			
	}

	@Override
	public ProductDetails getProductDetails(Optional<Product> prod) throws ProductDetailsServiceException {
			ProductDetails prodDetailsResp = this.prodDetailsRepo.findByProduct(prod);
			if(prodDetailsResp == null){
				throw new ProductDetailsServiceException();
			}
			return prodDetailsResp;
	}


}
