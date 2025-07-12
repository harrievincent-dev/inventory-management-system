package com.inventory.repository;

import com.inventory.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    Optional<Supplier> findByEmail(String email);
    
    @Query("SELECT s FROM Supplier s WHERE s.supplierName LIKE %:name%")
    List<Supplier> findBySupplierNameContaining(@Param("name") String name);
    
    List<Supplier> findByStatus(Supplier.SupplierStatus status);
    
    boolean existsByEmail(String email);
}
