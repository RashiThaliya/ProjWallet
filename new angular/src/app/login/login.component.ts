import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../service/authentication.service';
import { Router } from '@angular/router';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm : FormGroup;

  submitted : boolean= false;

  //constructor dependency injection
  //FormBuilder to build form elements with default values and validations
  //Router service to navigate programmmatically from component to other
  constructor(private formBuilder: FormBuilder, private router : Router,private authservice:AuthenticationService) { }

  //Life Cycle Hook
  ngOnInit() {
    this.loginForm= this.formBuilder.group({
      mobileNo:['',[Validators.required,  Validators.pattern("[6-9][0-9]{9}")]],
      walletPin:['',[Validators.required,  Validators.pattern("[0-9]{1,5}")]]
    });
  }

  verifyLogin(){
    this.submitted=true;
    if(this.loginForm.invalid){
      return;
    }
   let  mb=this.loginForm.controls.mobileNo.value;

  let pw =this.loginForm.controls.walletPin.value;
  let status = this.authservice.authenticate(mb,pw);
  console.log(status)
   if(status){
    this.router.navigate(['/home'])
   } 
   else{
    alert(`Invalid Mobile Number or Pin. Please enter correct credentials.`);
    return;
   }
  
  }
  invalidLogin:boolean=false;

}
