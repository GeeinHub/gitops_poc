import {Component, Input, OnInit} from '@angular/core';
import {PoDto} from '../poDto';
import {ActivatedRoute} from '@angular/router';
import {PoService} from '../po.service';

@Component({
  selector: 'app-create-order',
  templateUrl: './order-create.component.html',
  styleUrls: ['./order-create.component.css']
})
export class OrderCreateComponent implements OnInit {
  @Input() poDto: PoDto;
  @Input() disable: boolean;
  @Input()choseShipVia;
  chooseShipVia(flag): void {
    this.choseShipVia = flag;
    this.poDto.shipVia = flag;
  }
  constructor(private route: ActivatedRoute, private poService: PoService) {
  }


  ngOnInit() {
  }

}
