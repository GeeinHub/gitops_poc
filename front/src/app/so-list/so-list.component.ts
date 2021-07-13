import { Component, OnInit } from '@angular/core';
import {SoService} from '../so.service';
import {SoDto} from '../soDto';

@Component({
  selector: 'app-so-list',
  templateUrl: './so-list.component.html',
  styleUrls: ['./so-list.component.css']
})
export class SoListComponent implements OnInit {

  soDtos: SoDto[] = [];

  constructor(private soService: SoService) { }

  getSoList(): void {
    this.soService.getSoList().subscribe(data => this.soDtos = data);
  }

  ngOnInit() {
    this.getSoList();
  }

}
