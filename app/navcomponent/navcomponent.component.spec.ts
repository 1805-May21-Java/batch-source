import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NavcomponentComponent } from './navcomponent.component';

describe('NavcomponentComponent', () => {
  let component: NavcomponentComponent;
  let fixture: ComponentFixture<NavcomponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NavcomponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NavcomponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
