import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../../environments/environment'; // Make sure this path is correct
import { Country } from '../../model/Country/country.model'; // Adjust the import according to your project structure
import { Response } from '../../model/util/response.model'; // Adjust the import according to your project structure

@Injectable({
  providedIn: 'root'
})
export class CountryService {
  private apiUrl = `${environment.apiUrl}/country`; // Ensure apiUrl is defined in your environment files

  constructor(private http: HttpClient) { }

  getAllCountries(): Observable<Response<Country[]>> {
    return this.http.get<Response<Country[]>>(`${this.apiUrl}/getAll`);
  }
}

