import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable, of} from "rxjs";
import {MilestoneDto} from "../milestoneDto";
import {MilestoneSearchDto} from "../milestoneSearchDto";
import {PoDto} from "../poDto";
import {catchError} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class MilestoneService {

  constructor(private httpClient : HttpClient) { }

  httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
  };

  searchMilestone(refId : string, refType : string) : Observable<MilestoneDto[]>{
    const criteria = new MilestoneSearchDto(refId,refType);
    return this.httpClient.post<MilestoneDto[]>(location.origin + '/milestone/v1/search', criteria, this.httpOptions).pipe(
      catchError(
        (error : any , result: Observable<MilestoneDto[]>) :Observable<MilestoneDto[]> => {
          console.error(error);
          return result;
        }
      )
    );
  }
}
