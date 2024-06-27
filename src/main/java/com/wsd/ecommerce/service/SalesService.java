package com.wsd.ecommerce.service;

import com.wsd.ecommerce.entity.Customer;
import com.wsd.ecommerce.entity.Item;
import com.wsd.ecommerce.entity.Sale;
import com.wsd.ecommerce.entity.WishlistItem;
import com.wsd.ecommerce.mapper.CustomerMapper;
import com.wsd.ecommerce.mapper.WishListItemMapper;
import com.wsd.ecommerce.payload.response.WishListItemResponse;
import com.wsd.ecommerce.repository.CustomerRepository;
import com.wsd.ecommerce.repository.ItemRepository;
import com.wsd.ecommerce.repository.SaleRepository;
import com.wsd.ecommerce.repository.WishListItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SalesService {
    private final SaleRepository saleRepository;
    private final ItemRepository itemRepository;
    private final CustomerRepository customerRepository;
    private final WishListItemRepository wishListItemRepository;

    private final CustomerMapper customerMapper;
    private final WishListItemMapper wishListItemMapper;


    public List<WishListItemResponse> getWishlist(Long customerId) {
        Optional<Customer> customerOptional = customerRepository.findById(customerId);

        if (customerOptional.isEmpty()) {
            // Handle the case when the customer doesn't exist
            return Collections.emptyList();  // Or throw a custom exception
        }

        Customer customer = customerOptional.get();
        List<WishlistItem> wishlistItems = wishListItemRepository.findByCustomerId(customer.getId());
        return wishlistItems.stream()
                .map(wishListItemMapper::toWishListItemResponse)
                .collect(Collectors.toList());
    }

    public Double getTotalSalesToday() {
        List<Sale> sales = saleRepository.findByCreatedDate(LocalDate.now());
        return sales.stream().mapToDouble(Sale::getAmount).sum();
    }

    public Double getMaxSalesInDateRange(LocalDate startDate, LocalDate endDate) {
        List<Sale> sales = saleRepository.findAll();
        return sales.stream()
                .filter(sale -> !sale.getSaleDate().isBefore(startDate) && !sale.getSaleDate().isAfter(endDate))
                .mapToDouble(Sale::getAmount)
                .max()
                .orElse(0.0);
    }

    public List<Item> getTopSellingItemsAllTime() {
        return itemRepository.findAll().stream()
                .sorted((i1, i2) -> Double.compare(i2.getSales().stream().mapToDouble(Sale::getAmount).sum(),
                        i1.getSales().stream().mapToDouble(Sale::getAmount).sum()))
                .limit(5)
                .toList();
    }

    public List<Item> getTopSellingItemsLastMonth() {
        LocalDate now = LocalDate.now();
        LocalDate startDate = now.minusMonths(1);

        return itemRepository.findAll().stream()
                .sorted((i1, i2) -> Long.compare(
                        i2.getSales().stream().filter(sale -> !sale.getSaleDate().isBefore(startDate) && !sale.getSaleDate().isAfter(now)).count(),
                        i1.getSales().stream().filter(sale -> !sale.getSaleDate().isBefore(startDate) && !sale.getSaleDate().isAfter(now)).count()))
                .limit(5)
                .toList();
    }

}
