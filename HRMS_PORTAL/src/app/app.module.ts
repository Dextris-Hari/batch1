import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { EmployeedetailsComponent } from './employeedetails/employeedetails.component';
import { SalarydetailsComponent } from './salarydetails/salarydetails.component';
import { ProjectdetailsComponent } from './projectdetails/projectdetails.component';
import { AdmindetailsComponent } from './admindetails/admindetails.component';
import { LeavereportComponent } from './leavereport/leavereport.component';
import { ProjectreportComponent } from './projectreport/projectreport.component';
import { AddprojectComponent } from './addproject/addproject.component';
import { AddsalaryComponent } from './addsalary/addsalary.component';
import { AdduserComponent } from './adduser/adduser.component';
import { PageoneComponent } from './pageone/pageone.component';
import { PagethreeComponent } from './pagethree/pagethree.component';
import { PagetwoComponent } from './pagetwo/pagetwo.component';
import { FormsModule } from '@angular/forms';
import {HttpClientModule} from '@angular/common/http'; 
import { RouterModule } from '@angular/router';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    EmployeedetailsComponent,
    SalarydetailsComponent,
    ProjectdetailsComponent,
    AdmindetailsComponent,
    LeavereportComponent,
    ProjectreportComponent,
    AddprojectComponent,
    AddsalaryComponent,
    AdduserComponent,
    PageoneComponent,
    PagethreeComponent,
    PagetwoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    RouterModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
