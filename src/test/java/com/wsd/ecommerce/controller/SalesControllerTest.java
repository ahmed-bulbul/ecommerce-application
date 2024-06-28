package com.wsd.ecommerce.controller;

import com.wsd.ecommerce.service.SalesService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class SalesControllerTest {

    @Mock
    private SalesService salesService;

    @InjectMocks
    private SalesController salesController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetTotalSalesToday() {
        // Mock service method
        when(salesService.getTotalSalesToday()).thenReturn(500.0);

        // Test controller method
        Double totalSales = salesController.getTotalSalesToday();

        // Verify
        assertEquals(500.0, totalSales); // Expected total sales amount
    }

    @Test
    public void testGetMaxSalesInDateRange() {
        // Mock service method
        LocalDate startDate = LocalDate.of(2024, 6, 1);
        LocalDate endDate = LocalDate.of(2024, 6, 30);
        when(salesService.getMaxSalesInDateRange(startDate, endDate)).thenReturn(1000.0);

        // Test controller method
        Double maxSales = salesController.getMaxSalesInDateRange(startDate, endDate);

        // Verify
        assertEquals(1000.0, maxSales); // Expected maximum sales amount in the date range
    }
}
