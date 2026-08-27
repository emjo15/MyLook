package com.mylook.wardrobe.service;

import com.mylook.wardrobe.dto.ClothingItemRequestDto;
import com.mylook.wardrobe.dto.ClothingItemResponseDto;
import com.mylook.wardrobe.model.ClothingCategory;
import com.mylook.wardrobe.model.ClothingItem;
import com.mylook.wardrobe.repository.ClothingItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClothingItemServiceImplTest {

    @Mock
    private ClothingItemRepository clothingItemRepository;

    @InjectMocks
    private ClothingItemServiceImpl clothingItemService;

    private ClothingItem entity;

    @BeforeEach
    void setUp() {
        entity = new ClothingItem();
        entity.setId(1L);
        entity.setName("Blue Denim Jacket");
        entity.setDescription("Casual denim");
        entity.setCategory(ClothingCategory.OUTERWEAR);
        entity.setColor("Blue");
        entity.setBrand("MyBrand");
        entity.setImageUrl("https://example.com/jacket.png");
        entity.setCreatedAt(Instant.parse("2026-01-01T00:00:00Z"));
    }

    @Test
    void getAllReturnsMappedDtos() {
        when(clothingItemRepository.findAll()).thenReturn(List.of(entity));

        List<ClothingItemResponseDto> result = clothingItemService.getAll();

        assertThat(result).hasSize(1);
        assertThat(result.get(0).name()).isEqualTo("Blue Denim Jacket");
    }

    @Test
    void createSavesAndReturnsMappedDto() {
        ClothingItemRequestDto request = new ClothingItemRequestDto(
                "White Tee",
                "Cotton tee",
                ClothingCategory.TOP,
                "White",
                "BrandX",
                "https://example.com/tee.jpg"
        );

        ClothingItem saved = new ClothingItem();
        saved.setId(2L);
        saved.setName(request.name());
        saved.setDescription(request.description());
        saved.setCategory(request.category());
        saved.setColor(request.color());
        saved.setBrand(request.brand());
        saved.setImageUrl(request.imageUrl());
        saved.setCreatedAt(Instant.parse("2026-01-02T00:00:00Z"));

        when(clothingItemRepository.save(any(ClothingItem.class))).thenReturn(saved);

        ClothingItemResponseDto result = clothingItemService.create(request);

        assertThat(result.id()).isEqualTo(2L);
        assertThat(result.category()).isEqualTo(ClothingCategory.TOP);
    }

    @Test
    void getByIdThrowsWhenMissing() {
        when(clothingItemRepository.findById(99L)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> clothingItemService.getById(99L))
                .isInstanceOf(ClothingItemNotFoundException.class)
                .hasMessageContaining("99");
    }
}
