package com.cetpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cetpa.entity.Product;


public interface ProductRepository extends JpaRepository<Product,Integer>
{

	List<Product> findByName(String name);
    @Query("from Product where price<:arg")
	List<Product> findByPriceLessThan(@Param("arg") int price);
    @Query("from Product where price>:arg1")
	List<Product> findByPriceGreaterThan(@Param("arg1") int price);
    
    @Query("from Product where price between :arg2 and :arg3")
	List<Product> findByPriceBetween(@Param("arg2") int price1,@Param("arg3") int price2);
    
	List<Product> findByBrand(String brand);
	@Modifying
	@org.springframework.transaction.annotation.Transactional
	@Query("delete from Product where brand=:arg")
	void deleteByBrand(@Param("arg") String brand);
	
}
