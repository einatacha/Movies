import { Router, ActivatedRoute } from '@angular/router';
import { FormGroup, FormBuilder } from '@angular/forms';
import { Component, OnInit } from '@angular/core';

import { UserService } from './../services/user.service';

@Component({
  selector: 'app-userpost',
  templateUrl: './user.post.component.html',
  styleUrls: ['./user.post.component.scss'],
})
export class UserPostComponent implements OnInit {
  title = 'userpost';

  public user: any;
  public userPost: any;
  userId: any;
  public form: FormGroup;
  // =
  // // this.formBuilder.group({
  //   active: true,
  //   cellphone: [null],
  //   cpf: [null],
  //   email: [null],
  //   name: [null],
  //   password: [null],
  // });

  constructor(
    private userService: UserService,
    private formBuilder: FormBuilder,
    private router: Router,
    private route: ActivatedRoute
  ) {
    this.form = this.formBuilder.group({
      id: [null],
      active: true,
      cellPhone: [null],
      cpf: [null],
      email: [null],
      name: [null],
      password: [null],
    });
  }

  ngOnInit(): void {
    this.userId = this.route.snapshot.params['id'];
    this.getById();
  }

  createUser() {
    this.userService.createUser(this.form.value).subscribe((data) => {
      alert('User salvo com sucesso');
      setTimeout(() => {
        this.router.navigate(['user']);
      }, 5000);
      console.log('salvou');
    });
  }

  getById() {
    this.userService.getById(this.userId).subscribe((data) => {
      this.user = data;
      this.form.patchValue(this.user);
      console.log('funciona', this.user);
    });
  }

  putUser() {
    this.userService.putUser(this.userId, this.form.value).subscribe((data) => {
      alert('Filme atualizado com sucesso');
      setTimeout(() => {
        this.router.navigate(['user']);
      }, 5000);
      console.log('atualizou');
    });
  }

  deleteUser() {
    this.userService
      .deleteUser(this.userId, this.form.value)
      .subscribe((data) => {
        alert('user deletado com sucesso');
        setTimeout(() => {
          this.router.navigate(['user']);
        }, 3000);
        console.log('deletado');
      });
  }
  compareFn(c1: any, c2: any): boolean {
    return c1 && c2 ? c1.id === c2.id : c1 === c2;
  }
}
