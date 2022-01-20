import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CategoryComponent } from './category.component';

import { RouterTestingModule } from '@angular/router/testing';

describe('AppComponent', () => {
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RouterTestingModule],
      declarations: [CategoryComponent],
    }).compileComponents();
  });

  it('should create the app', () => {
    const fixture = TestBed.createComponent(CategoryComponent);
    const app = fixture.componentInstance;
    expect(app).toBeTruthy();
  });

  it(`should have as title 'category'`, () => {
    const fixture = TestBed.createComponent(CategoryComponent);
    const category = fixture.componentInstance;
    expect(category.title).toEqual('category');
  });

  it('should render title', () => {
    const fixture = TestBed.createComponent(CategoryComponent);
    fixture.detectChanges();
    const compiled = fixture.nativeElement as HTMLElement;
    expect(compiled.querySelector('.content span')?.textContent).toContain(
      'movies app is running!'
    );
  });
});
