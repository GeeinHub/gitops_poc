import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SoDocumentsComponent } from './so-documents.component';

describe('SoDocumentsComponent', () => {
  let component: SoDocumentsComponent;
  let fixture: ComponentFixture<SoDocumentsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SoDocumentsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SoDocumentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
