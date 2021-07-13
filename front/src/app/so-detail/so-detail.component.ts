import { Component, OnInit } from '@angular/core';
import {SoDto} from '../soDto';
import {ActivatedRoute, Router} from '@angular/router';
import {SoService} from '../so.service';

@Component({
  selector: 'app-so-detail',
  templateUrl: './so-detail.component.html',
  styleUrls: ['./so-detail.component.css']
})
export class SoDetailComponent implements OnInit {
  showGeneralInfo = true;
  showDocuments = false;
  showContainers = false;
  showItems = false;
  showRoutes = false;
  soDto: SoDto;

  initSoDto() {
    const poNum = this.route.snapshot.paramMap.get("soNumber");
    this.soService.getSo(poNum).subscribe(data => this.soDto = data);
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
  constructor(private route: ActivatedRoute, private soService: SoService, private router: Router) { }

  ngOnInit() {
    this.initSoDto();
  }

  toEdit(soNum: string) {
    //console.log('调用了');
    this.router.navigate(['./so/edit/' + soNum]);
  }

}
