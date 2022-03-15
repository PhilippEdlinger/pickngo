import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AppService {

  private currentSite: string | null = null;
  private  title = 'Todolist';


  constructor() {

  }

  public getTitle():string{
    let title = [this.title];
    if(this.currentSite!= null){
      title.push(this.currentSite);
    }
    return title.join(' - ');

  }

  public setCurrentSite(currentSite:string | null = null){
    this.currentSite = currentSite;
  }
}
