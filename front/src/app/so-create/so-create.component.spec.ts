import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SoCreateComponent } from './so-create.component';

describe('SoCreateComponent', () => {
  let component: SoCreateComponent;
  let fixture: ComponentFixture<SoCreateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SoCreateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SoCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
