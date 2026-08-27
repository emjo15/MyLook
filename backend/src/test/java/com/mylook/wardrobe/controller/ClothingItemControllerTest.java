package com.mylook.wardrobe.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mylook.wardrobe.dto.ClothingItemRequestDto;
import com.mylook.wardrobe.dto.ClothingItemResponseDto;
import com.mylook.wardrobe.model.ClothingCategory;
import com.mylook.wardrobe.service.ClothingItemService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.Instant;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ClothingItemController.class)
class ClothingItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ClothingItemService clothingItemService;

    @Test
    void getAllReturns200() throws Exception {
        when(clothingItemService.getAll()).thenReturn(List.of(
                new ClothingItemResponseDto(
                        1L,
                        "Black Jeans",
                        "Slim fit",
                        ClothingCategory.BOTTOM,
                        "Black",
                        "BrandY",
                        "https://example.com/jeans.jpg",
                        Instant.parse("2026-01-01T00:00:00Z")
                )
        ));

        mockMvc.perform(get("/api/clothes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Black Jeans"));
    }

    @Test
    void createReturns201() throws Exception {
        ClothingItemRequestDto request = new ClothingItemRequestDto(
                "Red Dress",
                "Evening dress",
                ClothingCategory.DRESS,
                "Red",
                "BrandZ",
                "https://example.com/dress.jpg"
        );

        when(clothingItemService.create(any(ClothingItemRequestDto.class))).thenReturn(
                new ClothingItemResponseDto(
                        10L,
                        request.name(),
                        request.description(),
                        request.category(),
                        request.color(),
                        request.brand(),
                        request.imageUrl(),
                        Instant.parse("2026-01-03T00:00:00Z")
                )
        );

        mockMvc.perform(post("/api/clothes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(10L));
    }
}
