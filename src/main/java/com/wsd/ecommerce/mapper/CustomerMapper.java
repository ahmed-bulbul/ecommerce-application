package com.wsd.ecommerce.mapper;


import com.wsd.ecommerce.entity.Customer;
import com.wsd.ecommerce.payload.response.CustomerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerMapper {
    public CustomerResponse getWishlist(Customer customer) {
        return CustomerResponse.builder()
                .id(customer.getId())
                .build();
    }

    public CustomerResponse toCustomerResponse(Customer customer) {
        return CustomerResponse.builder()
                .id(customer.getId())
                .name(customer.getName())
                .build();
    }
}
