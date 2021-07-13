import {Component, Input, OnInit} from '@angular/core';
import {SoDto} from '../soDto';

@Component({
  selector: 'app-so-body',
  templateUrl: './so-body.component.html',
  styleUrls: ['./so-body.component.css']
})
export class SoBodyComponent implements OnInit {
  @Input() soDto: SoDto;
  @Input() disable: boolean;
  constructor() { }

  ngOnInit() {
  }

}
