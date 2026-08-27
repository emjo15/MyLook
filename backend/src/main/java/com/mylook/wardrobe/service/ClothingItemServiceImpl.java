package com.mylook.wardrobe.service;

import com.mylook.wardrobe.dto.ClothingItemRequestDto;
import com.mylook.wardrobe.dto.ClothingItemResponseDto;
import com.mylook.wardrobe.model.ClothingItem;
import com.mylook.wardrobe.repository.ClothingItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClothingItemServiceImpl implements ClothingItemService {

    private final ClothingItemRepository clothingItemRepository;

    public ClothingItemServiceImpl(ClothingItemRepository clothingItemRepository) {
        this.clothingItemRepository = clothingItemRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ClothingItemResponseDto> getAll() {
        return clothingItemRepository.findAll()
                .stream()
                .map(this::toResponseDto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public ClothingItemResponseDto getById(Long id) {
        ClothingItem clothingItem = findEntityById(id);
        return toResponseDto(clothingItem);
    }

    @Override
    public ClothingItemResponseDto create(ClothingItemRequestDto request) {
        ClothingItem entity = new ClothingItem();
        applyRequest(entity, request);
        return toResponseDto(clothingItemRepository.save(entity));
    }

    @Override
    public ClothingItemResponseDto update(Long id, ClothingItemRequestDto request) {
        ClothingItem entity = findEntityById(id);
        applyRequest(entity, request);
        return toResponseDto(clothingItemRepository.save(entity));
    }

    @Override
    public void delete(Long id) {
        ClothingItem entity = findEntityById(id);
        clothingItemRepository.delete(entity);
    }

    private ClothingItem findEntityById(Long id) {
        return clothingItemRepository.findById(id)
                .orElseThrow(() -> new ClothingItemNotFoundException(id));
    }

    private void applyRequest(ClothingItem entity, ClothingItemRequestDto request) {
        entity.setName(request.name());
        entity.setDescription(request.description());
        entity.setCategory(request.category());
        entity.setColor(request.color());
        entity.setBrand(request.brand());
        entity.setImageUrl(request.imageUrl());
    }

    private ClothingItemResponseDto toResponseDto(ClothingItem entity) {
        return new ClothingItemResponseDto(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getCategory(),
                entity.getColor(),
                entity.getBrand(),
                entity.getImageUrl(),
                entity.getCreatedAt()
        );
    }
}
