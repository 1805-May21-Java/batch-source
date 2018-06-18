import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HighlightcomponentComponent } from './highlightcomponent.component';

describe('HighlightcomponentComponent', () => {
  let component: HighlightcomponentComponent;
  let fixture: ComponentFixture<HighlightcomponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HighlightcomponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HighlightcomponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
