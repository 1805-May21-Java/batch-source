import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UsergenComponent } from './user.component';

describe('UsergenComponent', () => {
  let component: UsergenComponent;
  let fixture: ComponentFixture<UsergenComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UsergenComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UsergenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});