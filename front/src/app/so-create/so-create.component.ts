import { Component, OnInit } from '@angular/core';
import {SoDto} from '../soDto';
import {SoPartyDto} from '../SoPartyDto';
import {PoService} from '../po.service';
import {ActivatedRoute, Router} from '@angular/router';
import {SoService} from '../so.service';

@Component({
  selector: 'app-so-create',
  templateUrl: './so-create.component.html',
  styleUrls: ['./so-create.component.css']
})
export class SoCreateComponent implements OnInit {
  public soDto = new SoDto();
  showGeneralInfo = true;
  showDocuments = false;
  showContainers = false;
  showItems = false;
  showRoutes = false;
  soNum: string;
  disable = false;
  title = 'Create So';
  constructor(private soService: SoService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit() {
    this.getSoByNum();
    if (this.soNum == null){
      this.initSoDto();
    }
  }

  showGeneralInfoFun(): void {
    this.showGeneralInfo = true;
    this.showDocuments = false;
    this.showContainers = false;
    this.showItems = false;
    this.showRoutes = false;
  }
  showDocumentsFun(): void {
    this.showContainers = false;
    this.showDocuments = true;
    this.showGeneralInfo = false;
    this.showItems = false;
    this.showRoutes = false;
  }
  showContainersFun(): void {
    this.showContainers = true;
    this.showDocuments = false;
    this.showGeneralInfo = false;
    this.showItems = false;
    this.showRoutes = false;
  }
  showItemsFun(): void{
    this.showContainers = false;
    this.showDocuments = false;
    this.showGeneralInfo = false;
    this.showItems = true;
    this.showRoutes = false;
  }

  showRoutesFun(): void{
    this.showContainers = false;
    this.showDocuments = false;
    this.showGeneralInfo = false;
    this.showItems = false;
    this.showRoutes = true;
  }

  randomString(length) {
    const str = '0123456789';
    let result = '';
    for (let i = length; i > 0; --i)
      result += str[Math.floor(Math.random() * str.length)];
    return result;
  }

  initSoDto() {
    this.soDto.customer = 'Disney Theme Park Merchandise-CA';
    this.soDto.soNumber = 'HKG' + this.randomString(7);
    this.soDto.shipperPartyDto = new SoPartyDto();
    this.soDto.alsoNotifyPartyDto = new SoPartyDto();
    this.soDto.bookingPartyDto = new SoPartyDto();
    this.soDto.consigneeDto = new SoPartyDto();
    this.soDto.factoryDto = new SoPartyDto();
    this.soDto.notifyPartyDto = new SoPartyDto();
  }
  submit(): void {
    console.log(this.soDto);
    this.soService.createSo(this.soDto).subscribe();
    this.router.navigate(['/so/list']);
  }

  getSoByNum() {
    this.soNum = this.route.snapshot.paramMap.get('soNum');
    if (this.soNum !== null) {
      this.soService.getSo(this.soNum).subscribe(data => {this.soDto = data});
      this.disable = true;
      this.title = 'Update So'
    }

  }

}
