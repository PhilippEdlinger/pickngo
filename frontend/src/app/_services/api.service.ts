import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Todolist} from '../_models';
import {Observable, throwError} from 'rxjs';
import {retry, catchError} from 'rxjs/operators';
import {environment} from '../../environments/environment';

const API_URL = environment.apiUrl;

const headers = new Headers();
headers.append('Content-Type', 'application/json');
headers.append('Access-Control-Allow-Origin', `*`);

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  // Define API
  apiURL = 'http://localhost:8080';

  constructor(private http: HttpClient) { }


  /*========================================
      CRUD Methods for consuming RESTful API
  =========================================*/

  // Http Options
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };



}
