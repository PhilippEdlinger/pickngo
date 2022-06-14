import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {ApiService} from "../../services/api.service";
import {first} from "rxjs";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  form: FormGroup;
  loading = false;
  submitted = false;

  constructor(private fb: FormBuilder,
              private route: ActivatedRoute,
              private router: Router,
              private service: ApiService) {

    this.form = this.fb.group({
      email: ['', Validators.required],
      username: ['',Validators.required],
      tel: ['',Validators.required],
      password: ['',Validators.required],
      passwordRepeat: ['',Validators.required]
    });
  }

  // convenience getter for easy access to form fields
  get f() { return this.form.controls; }

  onSubmit() {
    this.submitted = true;

    // stop here if form is invalid
    if (this.form.invalid) {
      return;
    }

    this.loading = true;
    this.service.register(this.form.value)
        .pipe(first())
        .subscribe(
            data => {
              this.router.navigate(['../login'], { relativeTo: this.route });
            },
            error => {
              alert('Something went wrong')
              this.loading = false;
            });
  }

  ngOnInit(): void {
  }

}
