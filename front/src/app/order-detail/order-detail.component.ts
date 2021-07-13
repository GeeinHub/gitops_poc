import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {PoDto} from '../poDto';
import {PoService} from '../po.service';
import {MilestoneDto} from "../milestoneDto";
import {MilestoneService} from "../service/milestone.service";

@Component({
  selector: 'app-order-detail',
  templateUrl: './order-detail.component.html',
  styleUrls: ['./order-detail.component.css']
})
export class OrderDetailComponent implements OnInit {
  poDto: PoDto = new PoDto();
  milestones : MilestoneDto[] = [];
  constructor(private route: ActivatedRoute, private poService: PoService, private router: Router,private milestoneService : MilestoneService) { }

  ngOnInit() {
    // const ms1  = new MilestoneDto();
    // ms1.expectedDate = new Date();
    // ms1.milestoneCode = 'PO Created';
    // const ms2  = new MilestoneDto();
    // ms2.expectedDate = new Date();
    // ms2.milestoneCode = 'DOC Uploaded';
    // this.milestones.push(ms1);
    // this.milestones.push(ms2);
    this.initPoDisneyDto();
  }
  initPoDisneyDto() {
    const poNum = this.route.snapshot.paramMap.get('poNum');
    this.poService.getPo(poNum).subscribe(data => {
      this.poDto = data
      }
    );

    this.milestoneService.searchMilestone(poNum,'PO').subscribe(msData =>{
      this.milestones = msData.map(m => {
        m.expectedDate = new Date(m.expectedDate)
        return m;
      });
    })
    //console.log(this.poDto);
  }
  toEdit(poNum: string) {
    //console.log('调用了');
    this.router.navigate(['./order/edit/' + poNum]);
  }

}
