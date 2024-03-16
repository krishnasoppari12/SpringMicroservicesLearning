package com.spring.service;


import com.spring.exception.ProductServiceException;
import com.spring.model.ProductRequest;
import com.spring.model.ProductResponse;

public interface ProductService {

	Long addProduct(ProductRequest productRequest);

	ProductResponse getProductById(Long productId) throws ProductServiceException;

	void reduceQuantity(Long productId, int quantity)throws ProductServiceException;

}
