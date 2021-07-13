import {Component, Input, OnInit} from '@angular/core';
import {SoDto} from '../soDto';
import {SoIntendedRouteDto} from '../soIntendedRouteDto';

@Component({
  selector: 'app-so-routes',
  templateUrl: './so-routes.component.html',
  styleUrls: ['./so-routes.component.css']
})
export class SoRoutesComponent implements OnInit {
  @Input() soDto: SoDto;

  addItem(): void {
    if (typeof this.soDto.soIntendedRouteDtos === 'undefined') {
      this.soDto.soIntendedRouteDtos = [];
    }
    this.soDto.soIntendedRouteDtos.push(new SoIntendedRouteDto());
  }
  deleteItem(): void {
    this.soDto.soIntendedRouteDtos.pop();
  }

  constructor() { }

  ngOnInit() {
  }

}
