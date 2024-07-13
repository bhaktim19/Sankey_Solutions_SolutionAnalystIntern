import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})

export class AppComponent {
  constructor(private http: HttpClient) {}


  validateForm(form: NgForm): { isValid: boolean; errorMessages: string[] } {
    const { firstName, lastName, phoneNumber, cardNumber, cvc, expDate } = form.value;

    const nameRegex = /^[a-zA-Z\s]+$/;
    const phoneRegex = /^\d{10}$/;
    const cardRegex = /^\d{16}$/;
    const cvcRegex = /^\d{3}$/;
    const expRegex = /^(0[1-9]|1[0-2])\/\d{2}$/;

    let isValid = true;
    const errorMessages: string[] = [];

    if (!nameRegex.test(firstName)) {
      isValid = false;
      errorMessages.push('Please enter a valid first name.');
    }

    if (!nameRegex.test(lastName)) {
      isValid = false;
      errorMessages.push('Please enter a valid last name.');
    }

    if (!phoneRegex.test(phoneNumber)) {
      isValid = false;
      errorMessages.push('Please enter a valid phone number.');
    }

    if (!cardRegex.test(cardNumber)) {
      isValid = false;
      errorMessages.push('Please enter a valid card number.');
    }

    if (!cvcRegex.test(cvc)) {
      isValid = false;
      errorMessages.push('Please enter a valid CVC.');
    }

    if (!expRegex.test(expDate)) {
      isValid = false;
      errorMessages.push('Please enter a valid expiry date (MM/YY).');
    }

    return { isValid, errorMessages };
  }

  onConfirmAndPay(form: NgForm): void {
    if (!form.valid) {
      alert('Please fill out the form correctly.');
      return;
    }

    const validation = this.validateForm(form);

    if (!validation.isValid) {
      alert(validation.errorMessages.join('\n'));
      return;
    }

    alert('Payment done successfully...');
    form.resetForm();
  }

  onSaveIfYouLikeIt(form: NgForm): void {
    if (!form.valid) {
      alert('Please fill out the form correctly.');
      return;
    }

    const validation = this.validateForm(form);

    if (!validation.isValid) {
      alert(validation.errorMessages.join('\n'));
      return;
    }

    const { firstName, lastName, phoneNumber, cardNumber, cvc, expDate } = form.value;
    const formData = { firstName, lastName, phoneNumber, cardNumber, cvc, expDate };

    this.http.post('http://localhost:8080/api/payment', formData)
      .subscribe(response => {
        console.log('Response from server:', response);
        alert('Details saved successfully!');
        form.resetForm();
      }, error => {
        console.error('Error saving details:', error);
        alert('An error occurred while saving the details. Please try again.');
      });
  }





  onSubscribe(form: any): void {
    if (!form.valid) {
      alert('Please enter a valid email address.');
      return;
    }

    const email = form.value.email;
    alert('Subscription successful! Thank you for subscribing.');
    form.resetForm();
  }
}