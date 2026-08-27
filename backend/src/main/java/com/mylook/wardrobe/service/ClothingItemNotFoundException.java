package com.mylook.wardrobe.service;

/**
 * Raised when a clothing item id does not exist.
 */
public class ClothingItemNotFoundException extends RuntimeException {

    public ClothingItemNotFoundException(Long id) {
        super("Clothing item not found with id: " + id);
    }
}
