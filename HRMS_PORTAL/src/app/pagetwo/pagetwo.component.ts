import { Component, OnInit } from '@angular/core';
import { UserAuthService } from '../_services/user-auth.service';
import { Router } from '@angular/router';
import { UserService } from '../_services/user.service';

@Component({
  selector: 'app-pagetwo',
  templateUrl: './pagetwo.component.html',
  styleUrls: ['./pagetwo.component.css']
})
export class PagetwoComponent implements OnInit{

  constructor(private userAuthService : UserAuthService , 
    private router: Router,
    public userService: UserService
    ){}

  ngOnInit(): void {
    
  }
  public isLoggedIn(){
    return this.userAuthService.isLoggedInBy();
  }

  
  public logout(){
    this.userAuthService.clear();
    this.router.navigate(['/home']);
  }

}
