package com.wsd.ecommerce.service;

import com.wsd.ecommerce.entity.Customer;
import com.wsd.ecommerce.entity.Item;
import com.wsd.ecommerce.entity.Sale;
import com.wsd.ecommerce.entity.WishlistItem;
import com.wsd.ecommerce.mapper.CustomerMapper;
import com.wsd.ecommerce.mapper.ItemMapper;
import com.wsd.ecommerce.mapper.WishListItemMapper;
import com.wsd.ecommerce.payload.response.ItemResponse;
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





    public Double getTotalSalesToday() {
        List<Sale> sales = saleRepository.findBySaleDate(LocalDate.now());
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



}
