package com.mylook.wardrobe.controller;

import com.mylook.wardrobe.dto.ClothingItemRequestDto;
import com.mylook.wardrobe.dto.ClothingItemResponseDto;
import com.mylook.wardrobe.service.ClothingItemNotFoundException;
import com.mylook.wardrobe.service.ClothingItemService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/clothes")
public class ClothingItemController {

    private final ClothingItemService clothingItemService;

    public ClothingItemController(ClothingItemService clothingItemService) {
        this.clothingItemService = clothingItemService;
    }

    @GetMapping
    public List<ClothingItemResponseDto> getAll() {
        return clothingItemService.getAll();
    }

    @GetMapping("/{id}")
    public ClothingItemResponseDto getById(@PathVariable Long id) {
        try {
            return clothingItemService.getById(id);
        } catch (ClothingItemNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage(), exception);
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClothingItemResponseDto create(@Valid @RequestBody ClothingItemRequestDto request) {
        return clothingItemService.create(request);
    }

    @PutMapping("/{id}")
    public ClothingItemResponseDto update(@PathVariable Long id, @Valid @RequestBody ClothingItemRequestDto request) {
        try {
            return clothingItemService.update(id, request);
        } catch (ClothingItemNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage(), exception);
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        try {
            clothingItemService.delete(id);
        } catch (ClothingItemNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage(), exception);
        }
    }
}
