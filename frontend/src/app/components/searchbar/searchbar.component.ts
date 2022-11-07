import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Product } from 'src/app/models/Product';
import { ProductService } from 'src/app/services/product.service';
import { SearchbarService } from 'src/app/services/searchbar.service';
import { faMagnifyingGlass } from "@fortawesome/free-solid-svg-icons";

@Component({
  selector: 'app-searchbar',
  templateUrl: './searchbar.component.html',
  styleUrls: ['./searchbar.component.scss']
})
export class SearchbarComponent implements OnInit {
  @Input() value: String;
  results: Product[];
  searchIcon = faMagnifyingGlass;

  constructor(private service: SearchbarService, private ps: ProductService) { }

  ngOnInit(): void {
    this.valueChanged();
  }

  valueChanged() {
    // this.service.changeValue(this.value);
    this.ps.getSearchResult(this.value).subscribe(p => this.results = p);
  }
}
