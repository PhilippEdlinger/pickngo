import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from "@angular/router";
import {ApiService} from "../../services/api.service";
import {first} from "rxjs";
import {LogInDTO} from "../../models/LogInDTO";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  form: FormGroup;
  loading = false;
  submitted = false;
  login: LogInDTO = new LogInDTO();

  constructor(private fb: FormBuilder,
              private route: ActivatedRoute,
              private router: Router,
              private service: ApiService) {

        this.form = this.fb.group({
          username: ['',Validators.required],
          password: ['',Validators.required]
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

        this.service.login(this.f['username'].value, this.f['password'].value)
            .subscribe(u => {
                if (u.success) {
                    this.login.success = true;
                    this.router.navigate(['/']);
                    console.log('Success')
                } else {
                    this.login.success = false;
                }
            });
        console.log(this.login);
    }

    ngOnInit(): void {
    }

}
