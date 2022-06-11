import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-menu-img',
  templateUrl: './menu-img.component.html',
  styleUrls: ['./menu-img.component.scss']
})
export class MenuImgComponent implements OnInit {
  @Input() url:String;
  constructor() { }

  ngOnInit(): void {
  }

}
