package com.cetpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cetpa.entity.Product;
import com.cetpa.service.ProductService;

@RestController
@RequestMapping("product-service")
public class ProductController
{
	@Autowired
	private ProductService productService;
	
	//http://localhost:8080/product-service/add
	@PostMapping("add")
	public ResponseEntity<Product> addProduct(@RequestBody Product product)
	{
	  productService.saveProduct(product);
	  return ResponseEntity.status(HttpStatus.CREATED).body(product);
		
	}
	//http://localhost:8080/product-service/list
	@GetMapping("list")
	public ResponseEntity<List<Product>> getProductList()
	{
		List<Product> productList=productService.getList();
		return ResponseEntity.status(HttpStatus.OK).body(productList);
	}
	//http://localhost:8080/product-service/product/byid/pid
	@GetMapping("product/byid/{pid}")
	public ResponseEntity<Product> getProductById(@PathVariable int pid)
	{
		Product product=productService.findProductById(pid);
		if(product==null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(product);	
	}
	//http://localhost:8080/product-service/product/byid?pid=101
	@GetMapping("product/byid")
	public ResponseEntity<Product> getProductById1(@RequestParam int pid)
	{
		Product product=productService.findProductById(pid);
		if(product==null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(product);	
	}
	//http://localhost:8080/product-service/list/byname/name
	@GetMapping("list/byname/{name}")
	public ResponseEntity<List<Product>> getProductByName(@PathVariable String name)
	{
		List<Product> productList=productService.getListByName(name);
		if(productList==null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(productList);	
	}
	//http://localhost:8080/product-service/list/price-lessthan/price
	@GetMapping("list/price-lessthan/{price}")
	public ResponseEntity<List<Product>> getProductListByPriceLessThan(@PathVariable int price)
	{
		List<Product> productList=productService.getListByNameByPriceLessThan(price);
		if(productList==null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(productList);	
	}
	//http://localhost:8080/product-service/list/price-greaterthan/price
	@GetMapping("list/price-greaterthan/{price}")
	public ResponseEntity<List<Product>> getProductListByPriceGreaterThan(@PathVariable int price)
	{
		List<Product> productList=productService.getListByNameByPriceGreaterThan(price);
		if(productList==null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(productList);	
	}
	//http://localhost:8080/product-service/list/price-between/price1/price2
	@GetMapping("list/price-between/{price1}/{price2}")
	public ResponseEntity<List<Product>> getProductListByPriceetween(@PathVariable int price1,@PathVariable int price2)
	{
		List<Product> productList=productService.getListByNameByPriceBetween(price1,price2);
		if(productList==null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(productList);	
	}
	//http://localhost:8080/product-service/update/byid/pid
	@PutMapping("update/byid/{pid}")
	public ResponseEntity<Product> updateProductById(@PathVariable("pid") int pid,@RequestBody Product product)
	{
		Product producto=productService.findProductById(pid);
		if(producto==null)
		{
			  productService.saveProduct(product);
			  return ResponseEntity.status(HttpStatus.CREATED).body(product);
		}
		product.setPid(pid);
		productService.updateProduct(product);
		return ResponseEntity.status(HttpStatus.OK).body(product);	
	}
	//http://localhost:8080/product-service/update/byid?pid=110
	@PatchMapping("update/byid")
	public ResponseEntity<Product> pupdateProductById(@RequestParam("pid") int pid,@RequestBody Product product)
	{
		Product producto=productService.findProductById(pid);
		if(producto==null)
		{
			  return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		product.setPid(pid);
		productService.pupdateProduct(product,producto);
		return ResponseEntity.status(HttpStatus.OK).body(product);	
	}
	//http://localhost:8080/product-service/delete/byid/102
	@DeleteMapping("delete/byid/{pid}")
	public ResponseEntity<Product> deleteProductById(@PathVariable("pid") int pid)
	{
		Product product=productService.findProductById(pid);
		if(product==null)
		{
			  
			  return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		productService.deleteProductById(pid);
		return ResponseEntity.status(HttpStatus.OK).body(product);	
	}
	//http://localhost:8080/product-service/delete/bybrand/brand
	@DeleteMapping("delete/bybrand/{brand}")
	public ResponseEntity<List<Product>> deleteProductListByBrand(@PathVariable String brand)
	{
		List<Product> productList=productService.getListByBrand(brand);
		if(productList==null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		productService.deleteProductByBrand(brand);
		return ResponseEntity.status(HttpStatus.OK).body(productList);	
	}
}
