import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserAuthService {

  constructor() { }
  public setRoles(roles:[]){
    localStorage.setItem("roles",JSON.stringify(roles));
  }

  public getRoles():[]{
    return JSON.parse(localStorage.getItem('roles')as any);
  }
  public setToken(jwtToken:any){
    localStorage.setItem('jwtToken', jwtToken );
  }

  public getToken() :String{
    return localStorage.getItem("jwtToken")||'{}';
  }
  
  public clear(){
    localStorage.clear();
  }
  
  public isLoggedInBy(){
    return this.getRoles() && this.getToken();
  }

}
