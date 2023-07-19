import { Component,OnInit } from '@angular/core';
import { UserService } from '../_services/user.service';
import { UserAuthService } from '../_services/user-auth.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-pagethree',
  templateUrl: './pagethree.component.html',
  styleUrls: ['./pagethree.component.css']
})
export class PagethreeComponent  implements OnInit{
  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }

   constructor(
    private userService: UserService, 
    private userAuthService:UserAuthService,
    private router: Router
    ){


    }


    public signup(signupForm :NgForm) {
      console.log("hello");
      this.userService.registerNewUser(signupForm.value).subscribe(
         (response: any) =>{
           
          console.log("hello1");
            this.router.navigate(['/pagetwo']);
  
  console.log(response)
            
           
         },
         (error: any) => {
            console.log(error);
         }
         );
      }



  }


