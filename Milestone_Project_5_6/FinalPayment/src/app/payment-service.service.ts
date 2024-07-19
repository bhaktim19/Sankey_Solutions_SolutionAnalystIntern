import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PaymentServiceService {

  private apiUrl = 'http://localhost:8080/api/payment';

  constructor(private http: HttpClient) { }

  savePaymentInfo(paymentInfo: any): Observable<any> {
    return this.http.post(this.apiUrl, paymentInfo);
  }

}
