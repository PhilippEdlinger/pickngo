import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-green-box',
  templateUrl: './green-box.component.html',
  styleUrls: ['./green-box.component.scss']
})
export class GreenBoxComponent implements OnInit {

  ngOnInit(): void {
  }

  config: any;
  fullpage_api: any;

  constructor() {

    // for more details on config options please visit fullPage.js docs
    this.config = {

      // fullpage options
      licenseKey: 'YOUR LICENSE KEY HERE',
      anchors: ['firstPage', 'secondPage', 'thirdPage', 'fourthPage', 'lastPage'],
      menu: '#menu',

      // fullpage callbacks
      afterResize: () => {
        console.log("After resize");
      },
      afterLoad: (origin: { index: any; }, destination: any, direction: any) => {
        console.log(origin.index);
      }
    };
  }

  getRef(fullPageRef: any) {
    this.fullpage_api = fullPageRef;
  }

}

