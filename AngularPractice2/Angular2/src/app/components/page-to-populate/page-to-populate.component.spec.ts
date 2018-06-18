import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PageToPopulateComponent } from './page-to-populate.component';

describe('PageToPopulateComponent', () => {
  let component: PageToPopulateComponent;
  let fixture: ComponentFixture<PageToPopulateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PageToPopulateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PageToPopulateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
