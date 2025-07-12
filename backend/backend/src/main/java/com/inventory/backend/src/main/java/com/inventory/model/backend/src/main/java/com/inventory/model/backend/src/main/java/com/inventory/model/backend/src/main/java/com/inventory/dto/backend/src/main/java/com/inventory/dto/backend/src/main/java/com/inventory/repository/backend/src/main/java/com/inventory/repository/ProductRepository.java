package com.inventory.repository;

import com.inventory.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findBySku(String sku);
    
    @Query("SELECT p FROM Product p WHERE p.productName LIKE %:name%")
    List<Product> findByProductNameContaining(@Param("name") String name);
    
    List<Product> findByCategory(String category);
    List<Product> findBySupplierId(Long supplierId);
    List<Product> findByStatus(Product.ProductStatus status);
    
    @Query("SELECT p FROM Product p WHERE p.currentStock <= p.minStockLevel")
    List<Product> findLowStockProducts();
    
    @Query("SELECT p FROM Product p WHERE p.currentStock >= p.maxStockLevel")
    List<Product> findOverStockProducts();
    
    boolean existsBySku(String sku);
}
