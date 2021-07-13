import { Component, OnInit, Input } from '@angular/core';
import {PoItemDto} from '../poItemDto';

@Component({
  selector: 'app-order-items',
  templateUrl: './order-items.component.html',
  styleUrls: ['./order-items.component.css']
})
export class OrderItemsComponent implements OnInit {
  @Input() poItemDtos: PoItemDto[];
  addItem(): void {
    if (typeof this.poItemDtos === 'undefined') {
      this.poItemDtos = [];
    }
    this.poItemDtos.push(new PoItemDto());
  }
  deleteItem(): void {
    this.poItemDtos.pop();
  }
  constructor() { }

  ngOnInit() {
  }

}
