package com.spring.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.Product;
import com.spring.exception.ProductServiceException;
import com.spring.model.ProductRequest;
import com.spring.model.ProductResponse;
import com.spring.repository.ProductRepository;

import lombok.extern.log4j.Log4j2;
@Service
@Log4j2
public class ProductServiceImpl implements ProductService{
  
	@Autowired
	private ProductRepository  productRepository;
	@Override
	public Long addProduct(ProductRequest productRequest) {
		// TODO Auto-generated method stub
		Product product =Product.builder()
				.productName(productRequest.getProductName())
				.price(productRequest.getPrice())
				.quantity(productRequest.getQuantity()).build();
		productRepository.save(product);
		return product.getProductId();
	}
	@Override
	public ProductResponse getProductById(Long productId) throws ProductServiceException {
		// TODO Auto-generated method stub
		//Product P=productRepository.findById(productId).get();
		Product P=productRepository.findById(productId).orElseThrow(()->new ProductServiceException("Product not Found","Product code not Found"));
		ProductResponse productResponse=ProductResponse.builder().productName(P.getProductName()).price(P.getPrice()).quantity(P.getQuantity()).build();
		return productResponse;
	}
	@Override
	public void reduceQuantity(Long productId, int quantity) throws ProductServiceException {
		// TODO Auto-generated method stub
		log.info("reducedQuantity");
		Product P=productRepository.findById(productId).orElseThrow(()->new ProductServiceException("Product not Found","Product code not Found"));
        if(P instanceof Product) {
        	log.info("checking Product Quantity");
        	if(P.getQuantity()<quantity) {
        		throw new ProductServiceException("not having enough quantity of products","NOT_ENOUGH_QUNAtity");
        	}
	        P.setQuantity(P.getQuantity()-quantity);
	        productRepository.save(P);
	        log.info("Product saved in DB");
}
	}

}

