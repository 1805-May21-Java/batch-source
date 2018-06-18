import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SelectcomponentComponent } from './selectcomponent.component';

describe('SelectcomponentComponent', () => {
  let component: SelectcomponentComponent;
  let fixture: ComponentFixture<SelectcomponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SelectcomponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SelectcomponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
