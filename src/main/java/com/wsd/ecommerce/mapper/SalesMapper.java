package com.wsd.ecommerce.mapper;


import com.wsd.ecommerce.entity.Sale;
import com.wsd.ecommerce.payload.response.SalesResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SalesMapper {
    public SalesResponse toSalesResponse(Sale sale) {
        return SalesResponse.builder()
                .id(sale.getId())
                .saleDate(sale.getSaleDate())
                .amount(sale.getAmount())
                .build();
    }
}
