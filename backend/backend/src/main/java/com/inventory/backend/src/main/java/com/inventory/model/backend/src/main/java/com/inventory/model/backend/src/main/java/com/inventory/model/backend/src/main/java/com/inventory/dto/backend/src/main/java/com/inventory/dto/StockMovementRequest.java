package com.inventory.dto;

import com.inventory.model.StockMovement;
import jakarta.validation.constraints.*;

public class StockMovementRequest {
    @NotNull(message = "Product ID is required")
    private Long productId;
    
    @NotNull(message = "Movement type is required")
    private StockMovement.MovementType movementType;
    
    @NotNull(message = "Quantity is required")
    @Min(value = 1, message = "Quantity must be at least 1")
    private Integer quantity;
    
    @NotBlank(message = "Reference number is required")
    private String referenceNumber;
    
    private String notes;
    
    @NotBlank(message = "Created by is required")
    private String createdBy;
    
    // Constructors
    public StockMovementRequest() {}
    
    // Getters and Setters
    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }
    
    public StockMovement.MovementType getMovementType() { return movementType; }
    public void setMovementType(StockMovement.MovementType movementType) { this.movementType = movementType; }
    
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
    
    public String getReferenceNumber() { return referenceNumber; }
    public void setReferenceNumber(String referenceNumber) { this.referenceNumber = referenceNumber; }
    
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
    
    public String getCreatedBy() { return createdBy; }
    public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }
}
