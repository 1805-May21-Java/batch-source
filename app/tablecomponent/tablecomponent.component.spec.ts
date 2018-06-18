import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TablecomponentComponent } from './tablecomponent.component';

describe('TablecomponentComponent', () => {
  let component: TablecomponentComponent;
  let fixture: ComponentFixture<TablecomponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TablecomponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TablecomponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
