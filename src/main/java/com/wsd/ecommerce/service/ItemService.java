package com.wsd.ecommerce.service;


import com.wsd.ecommerce.entity.Item;
import com.wsd.ecommerce.mapper.ItemMapper;
import com.wsd.ecommerce.payload.response.ItemResponse;
import com.wsd.ecommerce.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    private final ItemMapper itemMapper;

    public List<ItemResponse> getTopSellingItemsAllTime() {
        return itemRepository.findTop5SellingItems().stream()
                .limit(5)
                .map(itemMapper::toItemResponse)
                .collect(Collectors.toList());
    }

    public List<ItemResponse> getTopSellingItemsLastMonth() {
        LocalDate now = LocalDate.now();
        LocalDate startDate = now.minusMonths(1);

        return   itemRepository.findAll().stream()
                .sorted((i1, i2) -> Long.compare(
                        i2.getSales().stream().filter(sale -> !sale.getSaleDate().isBefore(startDate) && !sale.getSaleDate().isAfter(now)).count(),
                        i1.getSales().stream().filter(sale -> !sale.getSaleDate().isBefore(startDate) && !sale.getSaleDate().isAfter(now)).count()))
                .limit(5)
                .map(itemMapper::toItemResponse)
                .toList();
    }
}
