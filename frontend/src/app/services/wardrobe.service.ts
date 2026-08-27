import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ClothingItem, CreateClothingItem } from '../models/clothing-item.model';

@Injectable({
  providedIn: 'root'
})
export class WardrobeService {
  // Centralized API base URL for wardrobe endpoints.
  private readonly apiUrl = 'http://localhost:8080/api/clothes';

  constructor(private readonly http: HttpClient) {}

  /** Fetches all clothing items for the wardrobe grid. */
  getClothes(): Observable<ClothingItem[]> {
    return this.http.get<ClothingItem[]>(this.apiUrl);
  }

  /** Creates one new clothing item. */
  createClothingItem(payload: CreateClothingItem): Observable<ClothingItem> {
    return this.http.post<ClothingItem>(this.apiUrl, payload);
  }
}
