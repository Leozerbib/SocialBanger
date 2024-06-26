import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { BehaviorSubject, Observable, throwError, of } from 'rxjs';
import { catchError, map } from 'rxjs/operators';
import { Router } from '@angular/router';
import {  tap } from 'rxjs/operators';


import { environment } from '../../../environments/environment';
import { User } from '../../model/User/user.model';
import { Response } from '../../model/util/response.model';
import { LoginDto } from '../../model/User/login-dto.model';
import { RegisterDto } from '../../model/User/register-dto.model';
import { UserDto } from '../../model/User/user-dto.model';
import { UserInfo } from '../../model/User/user-info.class';
import { Userall } from '../../model/User/userall.model';
import { Subscription } from '../../model/Subscription/subscription.model';
import { SubscriptionSub } from '../../model/Sub/subscription-sub.model';

@Injectable({
  providedIn: 'root'
})
export class AccountService {
  private userSubject: BehaviorSubject<Userall | null>;
  public user: Observable<Userall | null>;

  constructor(
    private router: Router,
    private http: HttpClient
) {
    this.userSubject = new BehaviorSubject(JSON.parse(localStorage.getItem('user')!));
    this.user = this.userSubject.asObservable();
}

  public get userValue(): Userall | null {
    return this.userSubject.value;
  }

  login(loginDto: LoginDto): Observable<Response<Userall>> {
    return this.http.post<Response<Userall>>(`${environment.apiUrl}/user/Login`, loginDto)
      .pipe(
        map(response => {
          if (response.success) {
            localStorage.setItem('user', JSON.stringify(response.data));
            this.userSubject.next(response.data);
          }
          return response;
        }),
        catchError(this.handleError)
      );
  }

  logout() {
    // remove user from local storage and set current user to null
    localStorage.removeItem('user');
    this.userSubject.next(null);
    this.router.navigate(['/account/login']);
}
register(createUser: RegisterDto): Observable<Response<Userall>> {
  return this.http.post<Response<Userall>>(`${environment.apiUrl}/user/Register`, createUser)
    .pipe(
      map(response => {
        if (response.success) {
          localStorage.setItem('user', JSON.stringify(response.data));
          this.userSubject.next(response.data);
        }
        return response;
      }),
      catchError(this.handleError)
    );
}

communInterest(id: number): Observable<Response<UserInfo[]>> {
  return this.http.get<Response<UserInfo[]>>(`${environment.apiUrl}/user/Interest/Commun?id=${id}`)
    .pipe(
      map(response => {
        if (response.success) {
          localStorage.setItem('communinterest', JSON.stringify(response.data));
          console.log(response.data);
        }
        return response;
      }),
      catchError(this.handleError)
    );
}

communSub(id: number): Observable<Response<UserInfo[]>> {
  return this.http.get<Response<UserInfo[]>>(`${environment.apiUrl}/user/CommunSub?id=${id}`)
    .pipe(
      map(response => {
        if (response.success) {
          localStorage.setItem('communSub', JSON.stringify(response.data));
          console.log(response.data);
        }
        return response;
      }),
      catchError(this.handleError)
    );
}

Sub(id: number): Observable<Response<SubscriptionSub[]>> {
  return this.http.get<Response<SubscriptionSub[]>>(`${environment.apiUrl}/user/Sub?id=${id}`)
    .pipe(
      map(response => {
        if (response.success) {
          localStorage.setItem('Sub', JSON.stringify(response.data));
          console.log(response.data);
        }
        return response;
      }),
      catchError(this.handleError)
    );
}



  update(id: number, user: Userall): Observable<Response<boolean>> {
    return this.http.put<Response<boolean>>(`${environment.apiUrl}/user/update/${id}`, user)
      .pipe(
        map(response => {
          if (response.success) {
            localStorage.setItem('user', JSON.stringify(user));
            this.userSubject.next(user);
          }
          return response;
        }),
        catchError(this.handleError)
      );
  }

  delete(id: number): Observable<Response<boolean>> {
    return this.http.delete<Response<boolean>>(`${environment.apiUrl}/user/delete/${id}`)
      .pipe(
        map(response => {
          if (response.success && this.userValue?.id === id) {
            localStorage.removeItem('user');
            this.userSubject.next(null);
          }
          return response;
        }),
        catchError(this.handleError)
      );
  }

  getById(id: number): Observable<Response<Userall>> {
    return this.http.get<Response<Userall>>(`${environment.apiUrl}/user/getById?id=${id}`)
      .pipe(
        catchError(this.handleError)
      );
  }

  commonSub(id: number): Observable<Response<UserInfo[]>> {
    return this.http.get<Response<UserInfo[]>>(`${environment.apiUrl}/user/CommunSub?id=${id}`)
    .pipe(
      map(response => {
        if (response.success) {
          localStorage.setItem('communsub', JSON.stringify(response.data));
          console.log(response.data);
        }
        return response;
      }),
        catchError(this.handleError)
      );
  }

  getByName(name: string): Observable<Response<User>> {
    return this.http.get<Response<User>>(`${environment.apiUrl}/user/getByName/${name}`)
      .pipe(
        catchError(this.handleError)
      );
  }

  getAll(): Observable<Response<User[]>> {
    return this.http.get<Response<User[]>>(`${environment.apiUrl}/user/getAll`)
      .pipe(
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
