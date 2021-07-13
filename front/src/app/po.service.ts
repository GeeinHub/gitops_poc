import { Injectable } from '@angular/core';
import {PoDto} from './poDto';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Observable, of} from 'rxjs';
import {catchError} from 'rxjs/operators';
import {PoSearchDto} from './poSearchDto';

@Injectable({
  providedIn: 'root'
})
export class PoService {
  public serviceUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) {
  }
  httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
  };
  getPo(poNum: string): Observable<PoDto> {
    const poSearchDto = new PoSearchDto();
    poSearchDto.poNumber = poNum;
    return this.http.post<PoDto>(location.origin + '/customer/po/v1/searchPo', poSearchDto, this.httpOptions).pipe(
      catchError(this.handleError<PoDto>('Search Po'))
    );
  }
  getPoList(): Observable<PoDto[]> {
    return this.http.get<PoDto[]>(location.origin + '/customer/po/v1/list', this.httpOptions).pipe(
      catchError(this.handleError<PoDto[]>('Get Po List'))
    );
  }

  createPo(poDto: PoDto): Observable<any> {
    return this.http.post<PoDto>(this.serviceUrl + '/customer/po/v1/create', poDto, this.httpOptions).pipe(
      catchError(this.handleError<PoDto>('Create Po'))
    );
  }
  updatePo(poDto: PoDto): Observable<any> {
    return this.http.post<PoDto>(this.serviceUrl + '/customer/po/v1/update', poDto, this.httpOptions).pipe(
      catchError(this.handleError<PoDto>('Update Po'))
    );
  }

  test(): Observable<string> {
    return this.http.get<string>(this.serviceUrl + '/test/hello', this.httpOptions).pipe(
      catchError(this.handleError<string>('Test Error'))
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
