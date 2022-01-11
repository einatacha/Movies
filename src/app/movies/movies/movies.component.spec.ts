import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MoviesComponent } from './movies.component';

import { RouterTestingModule } from '@angular/router/testing';



describe('AppComponent', () => {
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [
        RouterTestingModule
      ],
      declarations: [
        MoviesComponent
      ],
    }).compileComponents();
  });

  it('should create the app', () => {
    const fixture = TestBed.createComponent(MoviesComponent);
    const app = fixture.componentInstance;
    expect(app).toBeTruthy();
  });

  it(`should have as title 'movies'`, () => {
    const fixture = TestBed.createComponent(MoviesComponent);
    const movies = fixture.componentInstance;
    expect(movies.title).toEqual('movies');
  });

  it('should render title', () => {
    const fixture = TestBed.createComponent(MoviesComponent);
    fixture.detectChanges();
    const compiled = fixture.nativeElement as HTMLElement;
    expect(compiled.querySelector('.content span')?.textContent).toContain('movies app is running!');
  });
});
