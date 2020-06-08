import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../service/authentication.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor( public loginService:AuthenticationService) { }

  ngOnInit(): void {
    console.log("Working 101")
  }
  ngOnChanges(){
    console.log("Working 102")
  }

}
