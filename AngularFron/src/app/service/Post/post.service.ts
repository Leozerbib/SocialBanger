import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, map,catchError, throwError } from 'rxjs';
import { environment } from '../../../environments/environment'; // Adjust this path according to your project structure
import { Response } from '../../model/util/response.model'; // Adjust the import according to your project structure
import { Post } from '../../model/Post/post.model';
import { PostPlus } from '../../model/Post/post-plus.model';


@Injectable({
  providedIn: 'root'
})
export class PostService {
  private apiUrl = `${environment.apiUrl}/post`; // Ensure apiUrl is defined in your environment files
  userSubject: any;

  constructor(private http: HttpClient) { }

  getAllPostSub(id:number|null): Observable<Response<Post[]>> {
    return this.http.get<Response<Post[]>>(`${this.apiUrl}/getpostsub?id=` + id)
    .pipe(
      map(response => {
        if (response) {
          console.log(response.data.length);
        }
        return response;
      }),
      catchError(this.handleError)
    );
  }

  
  getAllPostLikeInterest(id:number): Observable<Response<PostPlus[]>> {
    return this.http.get<Response<PostPlus[]>>(`${this.apiUrl}/getUserLikesPostInterest?id=` + id)
    .pipe(
      map(response => {
        if (response) {
          console.log(response.data.length);
        }
        return response;
      }),
      catchError(this.handleError)
    );
  }

  private handleError(error: HttpErrorResponse) {
    let errorMessage = 'Unknown error!';
    if (error.error instanceof ErrorEvent) {
      // Client-side errors
      errorMessage = `Error: ${error.error.message}`;
    } else {
      // Server-side errors
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    console.error(errorMessage);
    return throwError(errorMessage);
  }
}
