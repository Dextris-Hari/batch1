import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  PATH_OF_API = "http://localhost:9900";
  requestHeader = new HttpHeaders(
    {"No-Auth":"True"}
  );

  constructor(private httpclient:HttpClient) { }
  public logIn(loginData: any){

    return this.httpclient.post(this.PATH_OF_API + "/Authenticate" , loginData,
     {headers:this.requestHeader}); 
  }
}
