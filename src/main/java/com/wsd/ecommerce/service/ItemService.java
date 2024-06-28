package com.wsd.ecommerce.service;


import com.wsd.ecommerce.entity.Item;
import com.wsd.ecommerce.mapper.ItemMapper;
import com.wsd.ecommerce.payload.response.ItemResponse;
import com.wsd.ecommerce.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ItemService {

    private final ItemRepository itemRepository;

    private final ItemMapper itemMapper;

    public List<ItemResponse> getTopSellingItemsAllTime() {
        log.info("Fetching top 5 selling items all time");
        List<Item> items = itemRepository.findTop5SellingItems();
        return items.stream()
                .sorted((i1, i2) -> Long.compare(i2.getSales().size(), i1.getSales().size()))
                .map(itemMapper::toItemResponse)
                .toList();
    }


    public List<ItemResponse> getTopSellingItemsLastMonth() {
            log.info("Fetching top selling item last month");
            LocalDate now = LocalDate.now();
            LocalDate startDate = now.minusMonths(1).withDayOfMonth(1); // First day of last month
            LocalDate endDate = now.withDayOfMonth(1).minusDays(1); // Last day of last month

            List<Item> top5Items = itemRepository.findTopSellingItemsLastMonth(startDate, endDate);

            return top5Items.stream()
                    .map(itemMapper::toItemResponse)
                    .toList();


    }
}
