import {Component, AfterContentChecked, Input} from '@angular/core';
import { HttpEventType, HttpResponse } from '@angular/common/http';
import { UploadService } from '../service/upload.service';

@Component({
  selector: 'app-upload',
  templateUrl: './upload.component.html',
  styleUrls: ['./upload.component.scss']
})
export class UploadComponent implements AfterContentChecked {
  selected: FileList;
  public label: string = 'Select a file or two...';
  progress: { percentage: number } = { percentage: 0 };
  public uploadedFiles: Array<string>;
  constructor(private uploadService: UploadService) {}
  @Input() refId : string;
  @Input() refType : string;

  ngAfterContentChecked() {

  }

  selectFile(event: any) {
    this.selected = event.target.files;
    this.label = this.selected.length > 1 ? this.selected.length + ' files selected' : '1 file selected';
  }

  upload() {
    this.progress.percentage = 0;

    this.uploadService.upload(this.selected,this.refId,this.refType).subscribe(event => {
      if (event.type === HttpEventType.UploadProgress) {
        this.progress.percentage = Math.round(100 * event.loaded / event.total);
      } else if (event instanceof HttpResponse) {
        console.log('File successfully uploaded!');
      }
    })

    this.selected = undefined;
  }


}
