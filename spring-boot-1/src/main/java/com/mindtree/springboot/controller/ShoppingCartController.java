package com.mindtree.springboot.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.springboot.Entities.Cart;
import com.mindtree.springboot.Entities.CartDetails;
import com.mindtree.springboot.Entities.Product;
import com.mindtree.springboot.Entities.ProductDetails;
import com.mindtree.springboot.Entities.User;
import com.mindtree.springboot.dto.CartDetailsDTO;
import com.mindtree.springboot.dto.CartDetailsProdList;
import com.mindtree.springboot.dto.UserProductDTO;
import com.mindtree.springboot.exceptionHandling.ServiceException.CartDetailsServiceException;
import com.mindtree.springboot.exceptionHandling.ServiceException.CartServiceException;
import com.mindtree.springboot.exceptionHandling.ServiceException.ProductDetailsServiceException;
import com.mindtree.springboot.exceptionHandling.ServiceException.ProductServiceException;
import com.mindtree.springboot.exceptionHandling.ServiceException.UserServiceException;
import com.mindtree.springboot.services.CartDetailsServices;
import com.mindtree.springboot.services.CartServices;
import com.mindtree.springboot.services.ProductDetailsServices;
import com.mindtree.springboot.services.ProductServices;
import com.mindtree.springboot.services.UserServices;

@RestController
@RequestMapping(value="/shoppingcart")
public class ShoppingCartController {
	
	@Autowired
	private UserServices userServ;
	@Autowired
	private CartServices cartServ;
	@Autowired
	private CartDetailsServices cartDetailsServ;
	@Autowired
	private ProductServices prodServ;
	@Autowired
	private ProductDetailsServices prodDetailsServ;
	

	public void addProductLists() throws ProductDetailsServiceException, ProductServiceException{
		Product prod1 = new Product();
		prod1.setPrice(200l);
		prod1.setProdName("Maluha");
		prod1.setProductId(1001l);
		ProductDetails prodDetails1 = new ProductDetails();
		prodDetails1.setProd(prod1);
		prodDetails1.setAuthor("Amit");
		prodDetails1.setGenre("fiction");
		prodDetails1.setType("Book");
		prodDetails1.setPublication("Shiva Trilogy");
		this.prodServ.addProduct(prod1);
		this.prodDetailsServ.addProductDetails(prodDetails1);
		
		Product prod2 = new Product();
		prod2.setPrice(15000l);
		prod2.setProdName("Coat");
		prod2.setProductId(1002l);
		ProductDetails prodDetails2 = new ProductDetails();
		prodDetails2.setProd(prod2);
		prodDetails2.setDesign("long full sleev");
		prodDetails2.setType("Apparle");
		prodDetails2.setBrand("MAX");
		this.prodServ.addProduct(prod2);
		this.prodDetailsServ.addProductDetails(prodDetails2);
		
		Product prod3 = new Product();
		prod3.setPrice(500l);
		prod3.setProdName("Block Heels");
		prod3.setProductId(1003l);		
		ProductDetails prodDetails3 = new ProductDetails();
		prodDetails3.setProd(prod3);
		prodDetails3.setDesign("pink");
		prodDetails3.setType("Apparle");
		prodDetails3.setBrand("Mochi");
		this.prodServ.addProduct(prod3);
		this.prodDetailsServ.addProductDetails(prodDetails3);

		Product prod4 = new Product();
		prod4.setPrice(1200l);
		prod4.setProdName("Batman Comic");
		prod4.setProductId(1004l);
		ProductDetails prodDetails4 = new ProductDetails();
		prodDetails4.setProd(prod4);
		prodDetails4.setType("Comics");
		prodDetails4.setBrand("Marvel");
		prodDetails4.setGenre("fiction");
		prodDetails4.setPublication("Marvel");
		this.prodServ.addProduct(prod4);
		this.prodDetailsServ.addProductDetails(prodDetails4);

		Product prod5 = new Product();
		prod5.setPrice(2000l);
		prod5.setProdName("Dress");
		prod5.setProductId(1005l);
		ProductDetails prodDetails5 = new ProductDetails();
		prodDetails5.setProd(prod5);
		prodDetails3.setDesign("Anarkali");
		prodDetails3.setType("Apparle");
		prodDetails3.setBrand("Dressberry");
		this.prodServ.addProduct(prod5);
		this.prodDetailsServ.addProductDetails(prodDetails5);
	}
	
	public void addUsersWithCart() throws UserServiceException, CartServiceException, CartDetailsServiceException{
		User user1 = new User();
		user1.setUserId(101);
		user1.setFirstName("Kalyani");
		user1.setLastName("Sharma");
		

		User user2 = new User();
		user2.setUserId(102);
		user2.setFirstName("shesahj");
		user2.setLastName("awasthi");
		

		User user3 = new User();
		user3.setUserId(103);
		user3.setFirstName("simran");
		user3.setLastName("agrawal");
		
		Cart cart1 = new Cart();
		cart1.setCartId(502l);
		cart1.setUser(user1);
		CartDetails cartDetails1 = new CartDetails();
		cartDetails1.setCart(cart1);
		cartDetails1.setProductId(1001);
		cartDetails1.setQuantity(2);
		
		Cart cart2 = new Cart();
		cart2.setCartId(503l);
		cart2.setUser(user2);
		CartDetails cartDetails2 = new CartDetails();
		cartDetails2.setCart(cart2);
		cartDetails2.setProductId(1002);
		cartDetails2.setQuantity(3);
		
		Cart cart3 = new Cart();
		cart3.setCartId(501l);
		cart3.setUser(user3);
		CartDetails cartDetails3 = new CartDetails();
		cartDetails3.setCart(cart3);
		cartDetails3.setProductId(1004);
		cartDetails3.setQuantity(5);
		
		
		this.userServ.addUser(user1);
		this.userServ.addUser(user2);
		this.userServ.addUser(user3);
		
		this.cartServ.addCart(cart1);
		this.cartServ.addCart(cart2);
		this.cartServ.addCart(cart3);
		
		this.cartDetailsServ.addCartDetails(cartDetails1);
		this.cartDetailsServ.addCartDetails(cartDetails2);
		this.cartDetailsServ.addCartDetails(cartDetails3);
	}


	@RequestMapping(value="/addData", method=RequestMethod.GET)
	public String addDataIntoDB() throws ProductDetailsServiceException, ProductServiceException, UserServiceException, CartServiceException, CartDetailsServiceException{
		this.addProductLists();
		this.addUsersWithCart();
		return "Data added in data base";
	}

	public long calculateTotalPrice(List<CartDetailsProdList> cartProdList) throws ProductServiceException {
		long totalSum = 0l;
		Iterator<CartDetailsProdList> prodListIterator = cartProdList.iterator();
		while(prodListIterator.hasNext()){
			CartDetailsProdList ProductInfo = prodListIterator.next();
			Optional<Product> prod = this.prodServ.getProductById(ProductInfo.getProdId());
			totalSum += (prod.get().getPrice() * ProductInfo.getQuantity());
		}
		return totalSum;
	}
	
	@RequestMapping(value="/getCartDetails", method=RequestMethod.GET)
	public CartDetailsDTO getCartDetails(@RequestParam("userId") long userId ) throws UserServiceException, CartServiceException, CartDetailsServiceException, ProductServiceException{
			Optional<User> userReq = this.userServ.getUser(userId);
			Optional<Cart> cart = this.cartServ.getCartInfo(userReq);
			List<CartDetails> cartDetailsInfo = this.cartDetailsServ.getCartDetailsList(cart);			
			List<CartDetailsProdList> cartProdList = new ArrayList<CartDetailsProdList>();			
			for(int i=0; i<cartDetailsInfo.size();i++){
				CartDetailsProdList cartDetailsprod = new CartDetailsProdList(cartDetailsInfo.get(i).getProductId(), cartDetailsInfo.get(i).getQuantity());
				cartProdList.add(cartDetailsprod);				
			}
			Cart cartInfo = cart.get();
			CartDetailsDTO cartDetailsResp = new CartDetailsDTO();
			cartDetailsResp.setUserId(userId);
			cartDetailsResp.setCartId(cartInfo.getCartId());
			cartDetailsResp.setCartProdList(cartProdList);
			cartDetailsResp.setTotalAmountPending(this.calculateTotalPrice(cartProdList));
			
			return cartDetailsResp;
	}
	
	@RequestMapping(value="/updateProduct", method=RequestMethod.POST)
	public CartDetailsDTO updateProductToCart(@RequestBody UserProductDTO requestBody) throws UserServiceException, CartServiceException, CartDetailsServiceException, ProductServiceException{
			Optional<User> userReq = this.userServ.getUser(requestBody.getUserId());
			Optional<Cart> cart = this.cartServ.getCartInfo(userReq);
			
			//update product in Cart
			CartDetails requestCartDetails = new CartDetails();
			Cart cartInfo = cart.get();
			requestCartDetails.setCart(cartInfo);
			requestCartDetails.setProductId(requestBody.getCartProdList().getProdId());
			requestCartDetails.setQuantity(requestBody.getCartProdList().getQuantity());
			this.cartDetailsServ.updateCartDetails(cart, requestCartDetails);
			
			
			//response for the updated Cart
			List<CartDetails> cartDetailsInfo = this.cartDetailsServ.getCartDetailsList(cart);			
			List<CartDetailsProdList> cartProdList = new ArrayList<CartDetailsProdList>();			
			for(int i=0; i<cartDetailsInfo.size();i++){
				CartDetailsProdList cartDetailsprod = new CartDetailsProdList(cartDetailsInfo.get(i).getProductId(), cartDetailsInfo.get(i).getQuantity());
				cartProdList.add(cartDetailsprod);				
			}

			CartDetailsDTO cartDetailsResp = new CartDetailsDTO();
			cartDetailsResp.setUserId(requestBody.getUserId());
			cartDetailsResp.setCartId(cartInfo.getCartId());
			cartDetailsResp.setCartProdList(cartProdList);
			cartDetailsResp.setTotalAmountPending(this.calculateTotalPrice(cartProdList));
			
			return cartDetailsResp;
	}
	
	@RequestMapping(value="/getuserDetails/{userId}", method=RequestMethod.GET)
	public Optional<User> getuserDetails(@PathVariable("userId") long userId) throws UserServiceException{
			Optional<User> userInfo = this.userServ.getUser(userId);
			return userInfo;
	}
	
	@RequestMapping(value="/getAllUser")
	public List<User> getAllUser() throws UserServiceException {
			List<User> userList = this.userServ.getAllUserList();
			return userList;
	}
	
	@RequestMapping(value="/getAllProducts")
	public List<Product> getAllProduct() throws ProductServiceException{
			List<Product> prodList = this.prodServ.getAllProductList();
			return prodList;
	}

}
