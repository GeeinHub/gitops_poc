import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SoBodyComponent } from './so-body.component';

describe('SoBodyComponent', () => {
  let component: SoBodyComponent;
  let fixture: ComponentFixture<SoBodyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SoBodyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SoBodyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
