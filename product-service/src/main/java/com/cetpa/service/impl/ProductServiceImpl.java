package com.cetpa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetpa.entity.Product;
import com.cetpa.repository.ProductRepository;
import com.cetpa.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService
{
	@Autowired
   private ProductRepository productRepository;

	
	public void saveProduct(Product product) 
	{
		productRepository.save(product);
	}

	public List<Product> getList() {
		
		return productRepository.findAll();
	}

	
	public Product findProductById(int pid) {
		
		return productRepository.findById(pid).orElse(null);
	}


	public List<Product> getListByName(String name) {
		
		return productRepository.findByName(name);
	}


	public List<Product> getListByNameByPriceLessThan(int price) {
		
		return productRepository.findByPriceLessThan(price);
	}

	public List<Product> getListByNameByPriceGreaterThan(int price) {
		
		return productRepository.findByPriceGreaterThan(price);
	}


	public List<Product> getListByNameByPriceBetween(int price1, int price2) {
		
		return productRepository.findByPriceBetween(price1,price2);
	}


	public void updateProduct(Product product) 
	{
		productRepository.save(product);
		
	}


	public void pupdateProduct(Product product, Product producto) 
	{
		String name=product.getName();
		if(name!=null)
         producto.setName(name);
		String brand=product.getBrand();
		if(brand!=null)
         producto.setBrand(brand);
		int price=product.getPrice();
		if(price!=0)
         producto.setPrice(price);
		productRepository.save(producto);
	}


	public void deleteProductById(int pid)
	{
		productRepository.deleteById(pid);
	}

	
	public List<Product> getListByBrand(String brand) {
		
		return productRepository.findByBrand(brand);
	}


	public void deleteProductByBrand(String brand) {
	productRepository.deleteByBrand(brand);
		
	}


	

	

	
	
}
