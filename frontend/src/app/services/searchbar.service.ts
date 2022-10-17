import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SearchbarService {
  private searchValueSource = new BehaviorSubject<String>("");
  currentValue = this.searchValueSource.asObservable();

  constructor() { }

  changeValue(value: String) {
    this.searchValueSource.next(value);
    console.log(this.currentValue);
  }
}
