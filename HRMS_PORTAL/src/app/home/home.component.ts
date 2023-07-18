import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { UserService } from '../_services/user.service';
import { UserAuthService } from '../_services/user-auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  constructor(
    private userService: UserService, 
    private userAuthService:UserAuthService,
    private router: Router
   
    ) { }
  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }

  login(loginForm:NgForm){

    this.userService.logIn(loginForm.value).subscribe(
      (response: any) =>{
        
         this.userAuthService.setRoles(response.user.role);
         this.userAuthService.setToken(response.jwtToken);
         

         const role = response.user.role[0].roleName;
         if(role === 'Admin'){
           this.router.navigate(['/pagetwo']);
         }
         else{
           this.router.navigate(['/pagethree']);
         }
      },
      (error: any) => {
         console.log(error);
      }
      );
   }
  }


