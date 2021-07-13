import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-left-bar',
  templateUrl: './left-bar.component.html',
  styleUrls: ['./left-bar.component.css']
})
export class LeftBarComponent implements OnInit {
  currentMenu = 'Order';
  constructor() { }

  setCurrentMenu(menu): void {
    this.currentMenu = menu;
  }

  ngOnInit() {
  }

}
