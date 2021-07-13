import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SoRoutesComponent } from './so-routes.component';

describe('SoRoutesComponent', () => {
  let component: SoRoutesComponent;
  let fixture: ComponentFixture<SoRoutesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SoRoutesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SoRoutesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
