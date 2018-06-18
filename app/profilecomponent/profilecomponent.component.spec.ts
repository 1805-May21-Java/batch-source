import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfilecomponentComponent } from './profilecomponent.component';

describe('ProfilecomponentComponent', () => {
  let component: ProfilecomponentComponent;
  let fixture: ComponentFixture<ProfilecomponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProfilecomponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfilecomponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
