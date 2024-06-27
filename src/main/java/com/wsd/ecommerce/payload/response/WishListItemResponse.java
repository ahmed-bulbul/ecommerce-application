package com.wsd.ecommerce.payload.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WishListItemResponse {
    private Long id;
    private String name;
    private CustomerResponse customer;
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;
    private Long createdBy;
    private Long lastModifiedBy;
    private Boolean isActive;

}
