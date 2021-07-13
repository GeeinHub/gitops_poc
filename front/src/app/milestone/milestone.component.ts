import { Component, OnInit } from '@angular/core';
import {MilestoneDto} from "../milestoneDto";

@Component({
  selector: 'app-milestone',
  templateUrl: './milestone.component.html',
  styleUrls: ['./milestone.component.css']
})
export class MilestoneComponent implements OnInit {

  milestones : MilestoneDto[];

  constructor() { }

  ngOnInit() {
  }

}
