import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-acessibilidade',
  templateUrl: './acessibilidade.component.html',
  styleUrls: ['./acessibilidade.component.scss'],
})
export class AcessibilidadeComponent implements OnInit {
  title = 'acessibilidade';
  font_size = 16;
  tamanho = 16;
  classList: any;

  constructor() {}

  ngOnInit(): void {
    // this.aumentar();
    // this.aumentar();
  }

  getFocus() {
    const element = document.getElementById('ob')?.focus();
    console.log(document.getElementById('ob'));

    // var ob = document.getElement['ob'].value;
  }

  setFontSize(idd: string) {
    if (idd === 'a+') {
      this.font_size += 1;
    } else if (idd === 'a-') {
      this.font_size += 1;
    } else {
      this.font_size = 16;
    }

    let htmlRoot: HTMLLIElement = <HTMLLIElement>(
      document.getElementsByName('body')[0]
    );
    if (htmlRoot != null) {
      htmlRoot.style.fontSize = `${this.font_size}px`;
    }
  }

  diminuir() {
    this.tamanho--;
    document.body.style.fontSize = this.tamanho + 'px';
  }
  aumentar() {
    this.tamanho++;
    document.body.style.fontSize = this.tamanho + 'px';
    // document.body.style.fontSize = this.tamanho + 'rem';

    // let body: any = document.getElementsByName('h3');
    // body = this.tamanho + 'px';
  }
  contraste() {
    let contraste: HTMLElement = document.getElementById('body') as HTMLElement;
    contraste.classList.toggle('contrast');
  }
}
// setFontSizee(idd: string) {
//   if (idd == 'a+') {
//     this.font_size += 1;
//   } else if (idd === 'a-') {
//     this.font_size -= 1;
//   } else {
//     this.font_size = 16;
//   }
// }

// aumentarLetra() {
//   var font = document.getElementsByName('id').style.fontSize;
//   font = font.replace('px', '');
//   if (font == '') {
//     document.getElementsByName('id').style.fontSize = '13px';
//   } else {
//     document.getElementsByName('conteudo').style.fontSize =
//       parseInt(font) + 1 + 'px';
//   }
// }

//   }
// }
// diminuirLetra() {
//   var font = document.getElementsByTagName('Conteudo').style.fontSize;
//   font = font.replace('px', '');
//   if (font == '') {
//     document.getElementsByTagName('Conteudo').style.fontSize = '11px';
//   } else {
//     (document.getElementsByTagName('Conteudo').style.fontSize =
//       parseInt(font) - 1 + 'px');
// }
