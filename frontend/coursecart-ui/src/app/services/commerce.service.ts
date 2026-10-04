import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Order, CheckoutRequest } from '../models/commerce.model';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CommerceService {
  private apiUrl = `${environment.apiBaseUrl}/commerce`;

  constructor(private http: HttpClient) { }

  checkout(request: CheckoutRequest): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/checkout`, request);
  }

    getAllOrders(page: number = 0, size: number = 5): Observable<any> {
    throw new Error('TODO[TRAINEE]: Fetch all orders from commerce-service (US 15).');
  }
  getRecentOrders(limit: number = 5): Observable<Order[]> {
    throw new Error('TODO[TRAINEE]: Fetch recent orders from commerce-service (US 15).');
  }

  getOrders(userId: number): Observable<Order[]> {
    const params = new HttpParams().set('userId', userId.toString());
    return this.http.get<Order[]>(`${this.apiUrl}/orders`, { params });
  }

  getRevenue(): Observable<{ totalRevenue: number }> {
    throw new Error('TODO[TRAINEE]: Fetch total revenue from commerce-service (US 15).');
  }
}






