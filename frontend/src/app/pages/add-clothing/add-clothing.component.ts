import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ClothingCategory } from '../../models/clothing-category.type';
import { WardrobeService } from '../../services/wardrobe.service';

@Component({
  selector: 'app-add-clothing',
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './add-clothing.component.html',
  styleUrl: './add-clothing.component.css'
})
export class AddClothingComponent {
  readonly categories: ClothingCategory[] = [
    'TOP',
    'BOTTOM',
    'DRESS',
    'OUTERWEAR',
    'FOOTWEAR',
    'ACCESSORY',
    'OTHER'
  ];

  isSubmitting = false;
  errorMessage = '';
  readonly form;

  constructor(
    private readonly fb: FormBuilder,
    private readonly wardrobeService: WardrobeService,
    private readonly router: Router
  ) {
    this.form = this.fb.nonNullable.group({
      name: ['', [Validators.required]],
      description: [''],
      category: 'TOP' as ClothingCategory,
      color: ['', [Validators.required]],
      brand: [''],
      imageUrl: ['']
    });
  }

  submit(): void {
    if (this.form.invalid) {
      this.form.markAllAsTouched();
      return;
    }

    this.isSubmitting = true;
    this.errorMessage = '';

    this.wardrobeService.createClothingItem(this.form.getRawValue()).subscribe({
      next: () => this.router.navigate(['/wardrobe']),
      error: () => {
        this.errorMessage = 'Failed to save clothing item.';
        this.isSubmitting = false;
      }
    });
  }
}
