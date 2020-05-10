import { Component, OnInit } from '@angular/core';
import { HttpClientService, Wallet } from '../service/http-client.service';
import { Router } from '@angular/router';

import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  addForm: FormGroup;
  submitted: boolean = false;

  message : any;

  constructor(private formBuilder: FormBuilder, private router: Router,
    private service : HttpClientService) { }

  ngOnInit() {
    
      this.addForm = this.formBuilder.group({
        custName: ['', [Validators.required, Validators.pattern("[A-Z][a-z]{2,14}")]],
        aadharNo: ['', [Validators.required, Validators.pattern("[6-9][0-9]{11}")]],
        mobileNo: ['', [Validators.required, Validators.pattern("[6-9][0-9]{9}")]],
        emailId: ['', [Validators.required, Validators.email]],
        walletPin: ['', Validators.required]

      });
      
  }
    
  

   signupNow(){
    this.submitted = true;

    if (this.addForm.invalid) {
      return;
    }

  console.log(this.addForm.value);

  this.service.doSignUp(this.addForm.value).subscribe(data => {
    alert(`${this.addForm.controls.custName.value} record is added successfully..!`);
    this.router.navigate(['login']);

  // }; err => {
  //    console.log(err.stack);
 
   }
  )
}}