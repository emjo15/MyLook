import { Routes } from '@angular/router';
import { AddClothingComponent } from './pages/add-clothing/add-clothing.component';
import { InspirationComponent } from './pages/inspiration/inspiration.component';
import { RecommendationComponent } from './pages/recommendation/recommendation.component';
import { WardrobeComponent } from './pages/wardrobe/wardrobe.component';

export const routes: Routes = [
  { path: '', redirectTo: 'wardrobe', pathMatch: 'full' },
  { path: 'wardrobe', component: WardrobeComponent },
  { path: 'add-clothing', component: AddClothingComponent },
  { path: 'inspiration', component: InspirationComponent },
  { path: 'recommendation', component: RecommendationComponent }
];
