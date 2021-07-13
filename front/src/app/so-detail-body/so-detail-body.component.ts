import {Component, Input, OnInit} from '@angular/core';
import {SoDto} from '../soDto';
import {ActivatedRoute} from '@angular/router';
import {SoService} from '../so.service';

@Component({
  selector: 'app-so-detail-body',
  templateUrl: './so-detail-body.component.html',
  styleUrls: ['./so-detail-body.component.css']
})
export class SoDetailBodyComponent implements OnInit {

  @Input() soDto: SoDto;

  constructor() { }



  ngOnInit() {
  }

}
