import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ClothingItem, CreateClothingItem } from '../models/clothing-item.model';

@Injectable({
  providedIn: 'root'
})
export class WardrobeService {
  private readonly apiUrl = 'http://localhost:8080/api/clothes';

  constructor(private readonly http: HttpClient) {}

  getClothes(): Observable<ClothingItem[]> {
    return this.http.get<ClothingItem[]>(this.apiUrl);
  }

  createClothingItem(payload: CreateClothingItem): Observable<ClothingItem> {
    return this.http.post<ClothingItem>(this.apiUrl, payload);
  }
}
