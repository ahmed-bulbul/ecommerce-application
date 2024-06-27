package com.wsd.ecommerce.controller;

import com.wsd.ecommerce.payload.response.ItemResponse;
import com.wsd.ecommerce.payload.response.SalesResponse;
import com.wsd.ecommerce.service.ItemService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;



    @Mock
    private ItemService itemService;

    @InjectMocks
    private ItemController itemController;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(itemController).build();
    }

    @Test
    public void getTopSellingItemsAllTime_ShouldReturnTop5Items() throws Exception {
        List<ItemResponse> topSellingItems = Arrays.asList(
                new ItemResponse(1L, "Item1", LocalDateTime.now(), LocalDateTime.now(), 1L, 1L, true,
                        Arrays.asList(new SalesResponse(1L, 200.0, LocalDate.now(), null, null,
                                LocalDateTime.now(), LocalDateTime.now(), 2L, 2L, true))),
                new ItemResponse(2L, "Item2", LocalDateTime.now(), LocalDateTime.now(), 1L, 1L, true,
                        Arrays.asList(new SalesResponse(2L, 300.0, LocalDate.now(), null, null,
                                LocalDateTime.now(), LocalDateTime.now(), 2L, 2L, true)))
        );

        when(itemService.getTopSellingItemsAllTime()).thenReturn(topSellingItems);

        mockMvc.perform(get("/api/item/topSellingItemsAllTime")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].name").value("Item1"))
                .andExpect(jsonPath("$[1].id").value(2L))
                .andExpect(jsonPath("$[1].name").value("Item2"));
    }

    @Test
    public void getTopSellingItemsLastMonth_ShouldReturnTop5Items() throws Exception {
        List<ItemResponse> topSellingItems = Arrays.asList(
                new ItemResponse(1L, "Item1", LocalDateTime.now(), LocalDateTime.now(), 1L, 1L, true, null),
                new ItemResponse(2L, "Item2", LocalDateTime.now(), LocalDateTime.now(), 2L, 2L, true, null)
        );

        when(itemService.getTopSellingItemsLastMonth()).thenReturn(topSellingItems);

        mockMvc.perform(get("/api/item/topSellingItemsLastMonth")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].name").value("Item1"))
                .andExpect(jsonPath("$[1].id").value(2L))
                .andExpect(jsonPath("$[1].name").value("Item2"));
    }
}