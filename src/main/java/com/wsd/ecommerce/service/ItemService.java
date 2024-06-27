package com.wsd.ecommerce.service;


import com.wsd.ecommerce.entity.Item;
import com.wsd.ecommerce.mapper.ItemMapper;
import com.wsd.ecommerce.payload.response.ItemResponse;
import com.wsd.ecommerce.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    private final ItemMapper itemMapper;

    public List<ItemResponse> getTopSellingItemsAllTime() {
        List<Item> items = itemRepository.findAll();
        return items.stream()
                .sorted((i1, i2) -> Long.compare(i2.getSales().size(), i1.getSales().size()))
                .limit(5)
                .map(itemMapper::toItemResponse)
                .toList();
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
