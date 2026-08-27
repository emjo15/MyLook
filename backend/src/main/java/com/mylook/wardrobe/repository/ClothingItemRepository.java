package com.mylook.wardrobe.repository;

import com.mylook.wardrobe.model.ClothingItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClothingItemRepository extends JpaRepository<ClothingItem, Long> {
}
