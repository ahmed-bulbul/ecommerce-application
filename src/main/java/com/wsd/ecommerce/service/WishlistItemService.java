package com.wsd.ecommerce.service;


import com.wsd.ecommerce.entity.Customer;
import com.wsd.ecommerce.entity.WishlistItem;
import com.wsd.ecommerce.mapper.CustomerMapper;
import com.wsd.ecommerce.mapper.WishListItemMapper;
import com.wsd.ecommerce.payload.response.WishListItemResponse;
import com.wsd.ecommerce.repository.CustomerRepository;
import com.wsd.ecommerce.repository.WishListItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class WishlistItemService {


    private final CustomerRepository customerRepository;
    private final WishListItemRepository wishListItemRepository;

    private final CustomerMapper customerMapper;
    private final WishListItemMapper wishListItemMapper;

    public List<WishListItemResponse> getWishlist(Long customerId) {
        Optional<Customer> customerOptional = customerRepository.findById(customerId);

        if (customerOptional.isEmpty()) {
            log.error("Customer with id {} not found", customerId);
            return Collections.emptyList();  // Or throw a custom exception
        }

        Customer customer = customerOptional.get();
        List<WishlistItem> wishlistItems = wishListItemRepository.findByCustomerId(customer.getId());
        return wishlistItems.stream()
                .map(wishListItemMapper::toWishListItemResponse)
                .collect(Collectors.toList());
    }
}
