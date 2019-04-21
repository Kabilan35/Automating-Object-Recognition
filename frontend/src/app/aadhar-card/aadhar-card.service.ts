import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { AadharCard } from './aadhar-card';

@Injectable()
export class AadharCardService {

  constructor(private http: Http) { }

  getAadhar(data) : Promise<AadharCard> {
    return this.http.post('http://localhost:8080/tagsapi/tags1', data)
    .toPromise()
    .then(response => response.json())
    .catch(this.errorHandler)
  }

  // updatePhoneNumber(data): Promise<AadharCard> {
  //   return this.http.post('http://localhost:8080/tagsapi/tags', data)
  //   .toPromise()
  //   .then(response => response.json())
  //   .catch(this.errorHandler)
  // }

  errorHandler(error){
    return Promise.reject(error.json())
  }
}
