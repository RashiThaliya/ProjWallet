import { Component, OnInit } from '@angular/core';
import { Wallet, HttpClientService } from '../service/http-client.service';
import { Router } from '@angular/router';
import { AuthenticationService } from '../service/authentication.service';
import { HttpClient } from '@angular/common/http';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-fund-transfer',
  templateUrl: './fund-transfer.component.html',
  styleUrls: ['./fund-transfer.component.css']
})
export class FundTransferComponent implements OnInit {

  addForm: FormGroup
  submitted: boolean = false;
  
  receiver:'';
  amount:'';
  walletPin:'';
  explanation:'';
  wallet:Wallet;
  Message:String;
  
  constructor(private formBuilder: FormBuilder,  private router: Router,
    private loginservice: AuthenticationService,
    private httpClient:HttpClient,
    private service : HttpClientService) { }

    

  ngOnInit() {

    this.addForm = this.formBuilder.group({
      receiver: ['', [Validators.required, Validators.pattern("[6-9][0-9]{9}")]],
      amount: ['', [Validators.required,Validators.max(10000)]],
      explanation: ['', [Validators.required]],
      walletPin: ['', Validators.required]

    });
  }
  

  user = sessionStorage.getItem('username');
  wpin = sessionStorage.getItem('pin');
  
  
  

   fundtransferNow(){
    this.submitted = true;
    // if (this.addForm.invalid) {
    //   return;
    // }
    
    console.log(this.addForm.value);
       if (this.wpin === this.addForm.controls.walletPin.value)
    {
      this.service.trasfer(this.user,this.addForm.controls.receiver.value,this.addForm.controls.amount.value,this.addForm.controls.explanation.value).subscribe(data => {
        alert(`transfer record is added successfully..!`);
        this.router.navigate(['home']);
    
      }, err => {
        console.log(err.stack);
    
      })
    }
  }  

  

    }
    
  
