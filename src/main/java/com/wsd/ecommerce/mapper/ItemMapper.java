package com.wsd.ecommerce.mapper;


import com.wsd.ecommerce.entity.Item;
import com.wsd.ecommerce.payload.response.ItemResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemMapper {
    public ItemResponse toItemResponse(Item item) {
        return ItemResponse.builder()
                .id(item.getId())
                .name(item.getName())
                .build();
    }
}
