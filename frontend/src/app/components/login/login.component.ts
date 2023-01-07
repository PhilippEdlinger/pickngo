import { Component, OnInit } from '@angular/core';
import {UntypedFormBuilder, UntypedFormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from "@angular/router";
import {ApiService} from "../../services/api.service";
import {first} from "rxjs";
import {LogInDTO} from "../../models/LogInDTO";
import {AuthService} from "../../services/auth.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  form: UntypedFormGroup;
  loading = false;
  submitted = false;
  login: LogInDTO = new LogInDTO();
  loggedIn: boolean = false;

  constructor(private fb: UntypedFormBuilder,
              private route: ActivatedRoute,
              private router: Router,
              private service: ApiService,
              private authService: AuthService) {

        this.form = this.fb.group({
          username: ['',Validators.required],
          password: ['',Validators.required]
        });
  }

    ngOnInit(): void {
      if(localStorage.getItem('id_token') !== null) {
          this.loggedIn = true;
      }
    }


    // convenience getter for easy access to form fields
    get f() { return this.form.controls; }

    onSubmit() {
        this.submitted = true;

        // stop here if form is invalid
        if (this.form.invalid) {
            return;
        }

        // Already logged in
        if(this.loggedIn) {
            console.log('Already logged in');
            this.router.navigate(['/']);
        } else {
            this.authService.login(this.f['username'].value, this.f['password'].value)
                .subscribe(u => {
                    if (u.success) {
                        this.login.success = true;
                        localStorage.setItem('id_token', u.token);
                        localStorage.setItem('expires_at', u.expires_at);
                        this.router.navigate(['/']);
                        this.loggedIn = true;
                        console.log('Success');
                    } else {
                        this.login.success = false;
                        this.loggedIn = false;
                        console.log('Error');
                    }
                });
        }
    }
}
