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
      tel: [''],
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

    this.service.register(this.form.value).subscribe(u => {
      if (u.success) {
        console.log('Success')
        this.loading = true;
        this.router.navigate(['/']);
      } else {
        this.loading = false;
      }
    });
  }

  ngOnInit(): void {
  }

}
