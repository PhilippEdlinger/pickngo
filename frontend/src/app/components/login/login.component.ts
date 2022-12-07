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

    // convenience getter for easy access to form fields
    get f() { return this.form.controls; }

    onSubmit() {
        this.submitted = true;

        // stop here if form is invalid
        if (this.form.invalid) {
            return;
        }

        this.authService.login(this.f['username'].value, this.f['password'].value)
            .subscribe(u => {
                if (u.success) {
                    this.login.success = true;
                    localStorage.setItem('id_token', u.token);
                    localStorage.setItem('expires_at', u.expires_at);
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
