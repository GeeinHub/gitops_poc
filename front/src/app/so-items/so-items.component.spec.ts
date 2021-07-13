import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SoItemsComponent } from './so-items.component';

describe('SoItemsComponent', () => {
  let component: SoItemsComponent;
  let fixture: ComponentFixture<SoItemsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SoItemsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SoItemsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
