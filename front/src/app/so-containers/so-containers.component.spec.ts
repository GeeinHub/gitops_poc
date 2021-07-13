import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SoContainersComponent } from './so-containers.component';

describe('SoContainersComponent', () => {
  let component: SoContainersComponent;
  let fixture: ComponentFixture<SoContainersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SoContainersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SoContainersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
