package com.wsd.ecommerce.payload.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerResponse {
    private Long id;
    private String name;
    private List<WishListItemResponse> wishlistItems;
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;
    private Long createdBy;
    private Long lastModifiedBy;
    private Boolean isActive;
}
