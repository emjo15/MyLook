package com.mylook.wardrobe.service;

public class ClothingItemNotFoundException extends RuntimeException {

    public ClothingItemNotFoundException(Long id) {
        super("Clothing item not found with id: " + id);
    }
}
