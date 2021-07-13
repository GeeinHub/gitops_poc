import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable, of} from 'rxjs';
import {SoDto} from './soDto';
import {catchError} from 'rxjs/operators';
import {PoDto} from './poDto';

@Injectable({
  providedIn: 'root'
})
export class SoService {

  public serviceUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
  };

  getSoList(): Observable<SoDto[]> {
    return this.http.get<SoDto[]>(this.serviceUrl + '/vendor/so/v1/list', this.httpOptions).pipe(
      catchError(this.handleError<SoDto[]>('Get So List'))
    );
  }

  getSo(soNum: string): Observable<SoDto> {
    return this.http.get<SoDto>(this.serviceUrl + '/vendor/so/v1/detail/' + soNum, this.httpOptions).pipe(
      catchError(this.handleError<SoDto>('Search So'))
    );
  }

  createSo(soDto: SoDto): Observable<any> {
    return this.http.post<PoDto>(this.serviceUrl + '/vendor/so/v1/create', soDto, this.httpOptions).pipe(
      catchError(this.handleError<PoDto>('Create So'))
    );
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);
      this.log(`${operation} failed: ${error.message}`);
      return of(result as T);
    };
  }

  private log(message: string) {
    console.log(message);
  }

}
