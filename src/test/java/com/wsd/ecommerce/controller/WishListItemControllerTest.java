package com.wsd.ecommerce.controller;
import com.wsd.ecommerce.payload.response.WishListItemResponse;
import com.wsd.ecommerce.service.WishlistItemService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = WishListItemController.class)
class WishListItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WishlistItemService wishlistItemService;

    @Test
    public void getWishlist_ShouldReturnWishlistForCustomer() throws Exception {
        Long customerId = 1L;
        List<WishListItemResponse> wishList = Arrays.asList(
                new WishListItemResponse(1L, "Item1", null, LocalDateTime.now(), LocalDateTime.now(), 1L, 1L, true),
                new WishListItemResponse(2L, "Item2", null, LocalDateTime.now(), LocalDateTime.now(), 1L, 1L, true)
        );

        Mockito.when(wishlistItemService.getWishlist(customerId)).thenReturn(wishList);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/wishlistItem/wishlist/{customerId}", customerId)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].name").value("Item1"))
                .andExpect(jsonPath("$[1].id").value(2L))
                .andExpect(jsonPath("$[1].name").value("Item2"));
    }
}