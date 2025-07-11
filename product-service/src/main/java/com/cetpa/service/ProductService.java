package com.cetpa.service;

import java.util.List;

import com.cetpa.entity.Product;

public interface ProductService 
{

	void saveProduct(Product product);

	List<Product> getList();

	Product findProductById(int pid);

	List<Product> getListByName(String name);

	List<Product> getListByNameByPriceLessThan(int price);

	List<Product> getListByNameByPriceGreaterThan(int price);

	List<Product> getListByNameByPriceBetween(int price1, int price2);

	void updateProduct(Product product);

	void pupdateProduct(Product product, Product producto);

	void deleteProductById(int pid);

	List<Product> getListByBrand(String brand);

	void deleteProductByBrand(String brand);

	

	

	
}
