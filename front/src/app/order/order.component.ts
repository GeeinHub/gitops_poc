import { Component, OnInit } from '@angular/core';
import {PoItemDto} from '../poItemDto';
import {PoDto} from '../poDto';
import {PoService} from '../po.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {
  public poItemDtos: PoItemDto[] = [];
  public poDto = new PoDto();
  showCreateBody = true;
  constructor(private poService: PoService, private router: Router, private route: ActivatedRoute) { }
  showItemsBody(): void {
    this.showCreateBody = false;
  }
  showCreateContentBody(): void {
    this.showCreateBody = true;
  }
  initPoDisneyDto() {
    this.poDto.consignee = this.route.snapshot.paramMap.get('consignee');
  }
  submit(): void {
    // console.log(this.poDisneyItemDtos);
    console.log(this.poDto);
    this.poDto.poItemDtos = this.poItemDtos;
    this.poService.createPo(this.poDto).subscribe();
    this.poService.getPoList().subscribe(data => console.log(data));
    this.router.navigate(['/order/list']);
    // console.log(this.poService.getPo('3333').subscribe(data => this.poDisneyDto = data));

  }
  ngOnInit() {
    this.initPoDisneyDto();
  }

}
