import { Component, OnInit } from '@angular/core';
import {PoDto} from '../poDto';
import {PoService} from '../po.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-order',
  templateUrl: './order-list.component.html',
  styleUrls: ['./order-list.component.css']
})
export class OrderListComponent implements OnInit {
  // static showModal() {
  //   // @ts-ignore
  //   console.log($('#myModal'))
  //   $('#myModal').show();
  // }
  poDtos: PoDto[] = [];
  consignee = 'others';
  poNum = '7878';
  constructor(private poService: PoService, private router: Router) { }

  ngOnInit() {
    // OrderListComponent.showModal();
    this.getPoList();
  }
  getPoList(): void {
    this.poService.getPoList().subscribe(data => this.poDtos = data);
  }

  searchPo(e: KeyboardEvent): void {
    const keyCode = window.event ? e.keyCode : e.which;
    if (keyCode === 13) {
      console.log('调用了');
      console.log(this.poNum);
      this.router.navigate(['/order/detail/' + this.poNum]);
    }
  }

}
