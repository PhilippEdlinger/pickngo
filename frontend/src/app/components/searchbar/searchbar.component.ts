import {Component, EventEmitter, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-searchbar',
  templateUrl: './searchbar.component.html',
  styleUrls: ['./searchbar.component.scss']
})
export class SearchbarComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  searchValue: string = '';

  @Output()
  textChanged: EventEmitter<string> = new EventEmitter<string>();

  onSearchTextChanged() {
    this.textChanged.emit(this.searchValue);
  }

}
