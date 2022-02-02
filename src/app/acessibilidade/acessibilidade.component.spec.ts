import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RouterTestingModule } from '@angular/router/testing';
import { AcessibilidadeComponent } from './acessibilidade.component';

describe('AppComponent', () => {
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RouterTestingModule],
      declarations: [AcessibilidadeComponent],
    }).compileComponents();
  });

  it('should create the app', () => {
    const fixture = TestBed.createComponent(AcessibilidadeComponent);
    const app = fixture.componentInstance;
    expect(app).toBeTruthy();
  });

  it(`should have as title 'acessibilidade'`, () => {
    const fixture = TestBed.createComponent(AcessibilidadeComponent);
    const acessibilidade = fixture.componentInstance;
    expect(acessibilidade.title).toEqual('acessibilidade');
  });

  it('should render title', () => {
    const fixture = TestBed.createComponent(AcessibilidadeComponent);
    fixture.detectChanges();
    const compiled = fixture.nativeElement as HTMLElement;
    expect(compiled.querySelector('.content span')?.textContent).toContain(
      'movies app is running!'
    );
  });
});
