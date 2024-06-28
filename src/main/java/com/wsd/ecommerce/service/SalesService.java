package com.wsd.ecommerce.service;

import com.wsd.ecommerce.entity.Sale;
import com.wsd.ecommerce.repository.SaleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SalesService {
    private final SaleRepository saleRepository;

    public Double getTotalSalesToday() {
        log.info("Fetching total sales today");
        List<Sale> sales = saleRepository.findBySaleDate(LocalDate.now());
        return sales.stream().mapToDouble(Sale::getAmount).sum();
    }

    public Double getMaxSalesInDateRange(LocalDate startDate, LocalDate endDate) {
        log.info("Fetching max sales in date range");
        List<Sale> sales = saleRepository.findAll();
        return sales.stream()
                .filter(sale -> !sale.getSaleDate().isBefore(startDate) && !sale.getSaleDate().isAfter(endDate))
                .mapToDouble(Sale::getAmount)
                .max()
                .orElse(0.0);
    }



}
