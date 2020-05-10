import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders} from '@angular/common/http'
import { Observable } from 'rxjs';

export class Wallet{
  constructor(
    public mobileNo:String,
		public emailId:String,
    public aadharNo:String,
    public custName:String,
    public walletAmount : string,
    public walletPin:string,
    public transaction : Transaction
  ){}
}

export class Transaction{
constructor(
  public transactionId : string,
  public transactionAmount:string,
  public explanation:string,
  public transactionDate :string,
 
){}

}



@Injectable({
  providedIn: 'root'
})
export class HttpClientService {

  constructor(
     private httpClient:HttpClient
  ) { }


  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':'application/json',
      
    })
    
  }

public doSignUp(wallet1):Observable<Wallet>{

  console.log(wallet1); //2nd

  return this.httpClient.post<Wallet>(`http://localhost:3333/createNewUser`,JSON.stringify(wallet1), this.httpOptions); //wallet1,{responseType:'text' as 'json'});  //
}

public addbal(user,amount):Observable<any>{


  return this.httpClient.put<any>("http://localhost:3333/addBalanceToWallet/"+user+"/"+amount,this.httpOptions, {responseType:'text' as 'json'});
}

public depositbal(user,amount):Observable<any>{

  return this.httpClient.put<any>("http://localhost:3333/BankDeposit/"+user+"/"+amount,this.httpOptions,{responseType:'text' as 'json'});

}

public trasfer(user, receiver, amount, explanation):Observable<any>{

  return this.httpClient.put<any>("http://localhost:3333/fundTransfer/"+user+"/"+receiver+"/"+amount+"/"+explanation,this.httpOptions,{responseType:'text' as 'json'});
  
}

public getTransactionList(user):Observable<any>{

  return this.httpClient.get("http://localhost:3333/getTransaction/"+user);
}
 

}