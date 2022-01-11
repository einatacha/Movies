import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserComponent } from './user.component';

import { RouterTestingModule } from '@angular/router/testing';


describe('AppComponent', () => {
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [
        RouterTestingModule
      ],
      declarations: [
        UserComponent
      ],
    }).compileComponents();
  });

  it('should create the app', () => {
    const fixture = TestBed.createComponent(UserComponent);
    const app = fixture.componentInstance;
    expect(app).toBeTruthy();
  });

  it(`should have as title 'user'`, () => {
    const fixture = TestBed.createComponent(UserComponent);
    const user = fixture.componentInstance;
    expect(user.title).toEqual('user');
  });

  it('should render title', () => {
    const fixture = TestBed.createComponent(UserComponent);
    fixture.detectChanges();
    const compiled = fixture.nativeElement as HTMLElement;
    expect(compiled.querySelector('.content span')?.textContent).toContain('movies app is running!');
  });
});
