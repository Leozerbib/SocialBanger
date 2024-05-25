import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../../environments/environment'; // Adjust this path according to your project structure
import { Interest } from '../../model/Interest/interest.model'; // Adjust the import according to your project structure
import { Response } from '../../model/util/response.model'; // Adjust the import according to your project structure

@Injectable({
  providedIn: 'root'
})
export class InterestService {
  private apiUrl = `${environment.apiUrl}/interest`; // Ensure apiUrl is defined in your environment files

  constructor(private http: HttpClient) { }

  getAllInterests(): Observable<Response<Interest[]>> {
    return this.http.get<Response<Interest[]>>(`${this.apiUrl}/getAll`);
  }

  // Add more methods as needed
}
