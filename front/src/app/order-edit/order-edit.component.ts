import { Component, OnInit } from '@angular/core';
import {PoService} from '../po.service';
import {ActivatedRoute, Router} from '@angular/router';
import {PoDto} from '../poDto';
import {PoItemDto} from '../poItemDto';

@Component({
  selector: 'app-order-edit',
  templateUrl: './order-edit.component.html',
  styleUrls: ['./order-edit.component.css']
})
export class OrderEditComponent implements OnInit {
  public poDto: PoDto = new PoDto();
  public poItemDtos: PoItemDto[] = [];
  showCreateBody = true;
  poNum: string;
  constructor(private poService: PoService, private router: Router, private route: ActivatedRoute) { }
  showItemsBody(): void {
    this.showCreateBody = false;
  }
  showCreateContentBody(): void {
    this.showCreateBody = true;
  }
  ngOnInit() {
    this.getPoByNum();
  }
  getPoByNum() {
    this.poNum = this.route.snapshot.paramMap.get('poNum');
    this.poService.getPo(this.poNum).subscribe(data => {this.poDto = data; this.poItemDtos = data.poItemDtos; console.log(this.poDto.domestic)});

  }
  submit(): void {
    // console.log(this.poItemDtos);
    console.log(this.poDto);
    // this.poDto.poItemDtos = this.poItemDtos;
    this.poService.updatePo(this.poDto).subscribe();
    // this.poService.getPoList().subscribe(data => console.log(data));
    this.router.navigate(['/order/list']);
    // console.log(this.poService.getPo('3333').subscribe(data => this.poDto = data));

  }
}
