package com.mindtree.springboot.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.springboot.Entities.Product;
import com.mindtree.springboot.exceptionHandling.ServiceException.ProductServiceException;
import com.mindtree.springboot.repository.ProductRepository;
import com.mindtree.springboot.services.ProductServices;

@Service
@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
public class ProductServicesImpl implements ProductServices {
	
	@Autowired
	private ProductRepository prodRepo;

	@Override
	public boolean addProduct(Product prod) throws ProductServiceException{
		try{
			this.prodRepo.saveAndFlush(prod);
			return true;
		}catch (Exception e){
			System.out.println(e.getStackTrace());
			throw new ProductServiceException();
		}
		
	}

	@Override
	public boolean deleteProductById(long prodId) throws ProductServiceException{
		try{
			this.prodRepo.deleteById(prodId);
			return true;
		}catch(Exception e){
			System.out.println(e.getStackTrace());
			throw new ProductServiceException();
		}
		
	}

	@Override
	public Optional<Product> getProductById(long prodId) throws ProductServiceException{
			Optional<Product> prodResp = this.prodRepo.findById(prodId);
			if(!prodResp.isPresent()){
				throw new ProductServiceException();
			}
			return prodResp;
	}

	@Override
	public List<Product> getAllProductList() throws ProductServiceException{
		List<Product> productList = this.prodRepo.findAll();
		if(productList.isEmpty()){
			throw new ProductServiceException();
		}
		return productList;
	}

}
