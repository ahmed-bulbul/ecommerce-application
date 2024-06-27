package com.wsd.ecommerce.service;

import com.wsd.ecommerce.entity.Sale;
import com.wsd.ecommerce.repository.SaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

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
