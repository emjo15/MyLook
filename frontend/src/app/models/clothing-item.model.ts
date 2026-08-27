import { ClothingCategory } from './clothing-category.type';

export interface ClothingItem {
  id: number;
  name: string;
  description?: string;
  category: ClothingCategory;
  color: string;
  brand?: string;
  imageUrl?: string;
  createdAt: string;
}

export interface CreateClothingItem {
  name: string;
  description?: string;
  category: ClothingCategory;
  color: string;
  brand?: string;
  imageUrl?: string;
}
