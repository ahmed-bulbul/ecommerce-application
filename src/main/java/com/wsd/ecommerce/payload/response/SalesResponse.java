package com.wsd.ecommerce.payload.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.wsd.ecommerce.entity.Item;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SalesResponse {

    private Long id;
    private Double amount;
    private LocalDate saleDate;
    private ItemResponse item;
    private CustomerResponse customer;
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;
    private Long createdBy;
    private Long lastModifiedBy;
    private Boolean isActive;
}
