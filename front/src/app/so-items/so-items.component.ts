import {Component, Input, OnInit} from '@angular/core';
import {SoDto} from '../soDto';
import {SoItemDto} from '../soItemDto';

@Component({
  selector: 'app-so-items',
  templateUrl: './so-items.component.html',
  styleUrls: ['./so-items.component.css']
})
export class SoItemsComponent implements OnInit {
  @Input() soDto: SoDto;
  addItem(): void {
    if (typeof this.soDto.itemDtos === 'undefined') {
      this.soDto.itemDtos = [];
    }
    this.soDto.itemDtos.push(new SoItemDto());
  }
  deleteItem(): void {
    this.soDto.itemDtos.pop();
  }
  constructor() { }

  ngOnInit() {
  }

}
