import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { RouterLink } from '@angular/router';
import { ClothingItem } from '../../models/clothing-item.model';
import { WardrobeService } from '../../services/wardrobe.service';

@Component({
  selector: 'app-wardrobe',
  imports: [CommonModule, RouterLink],
  templateUrl: './wardrobe.component.html',
  styleUrl: './wardrobe.component.css'
})
export class WardrobeComponent implements OnInit {
  clothes: ClothingItem[] = [];
  isLoading = true;
  errorMessage = '';

  constructor(private readonly wardrobeService: WardrobeService) {}

  /** Loads wardrobe data once when the page opens. */
  ngOnInit(): void {
    this.wardrobeService.getClothes().subscribe({
      next: (items) => {
        this.clothes = items;
        this.isLoading = false;
      },
      error: () => {
        this.errorMessage = 'Could not load wardrobe items yet.';
        this.isLoading = false;
      }
    });
  }
}
