import { Injectable } from '@angular/core';
import { HttpClient, HttpEvent, HttpRequest, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UploadService {
  private uploadUrl = location.origin+"/upload/doc";

  constructor(private http: HttpClient) {}

  // getUploadedFiles() {
  //   return this.http.get(this.uploadUrl);
  // }

  upload(data: FileList, refId: string, refType: string): Observable<HttpEvent<{}>> {
    const formData = new FormData();

    formData.append('refId', refId);
    formData.append('refType', refType);
    Array.from(data).forEach(file => {
      formData.append('data', file);
    });

    const request = new HttpRequest('POST', this.uploadUrl, formData, {
      reportProgress: true,
      responseType: 'text'
    });

    return this.http.request(request);
  }
}
