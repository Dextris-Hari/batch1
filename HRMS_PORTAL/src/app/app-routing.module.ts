import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { EmployeedetailsComponent } from './employeedetails/employeedetails.component';
import { AdmindetailsComponent } from './admindetails/admindetails.component';
import { ProjectdetailsComponent } from './projectdetails/projectdetails.component';
import { SalarydetailsComponent } from './salarydetails/salarydetails.component';
import { LeavereportComponent } from './leavereport/leavereport.component';
import { ProjectreportComponent } from './projectreport/projectreport.component';
import { AddprojectComponent } from './addproject/addproject.component';
import { AddsalaryComponent } from './addsalary/addsalary.component';
import { PageoneComponent } from './pageone/pageone.component';
import { PagethreeComponent } from './pagethree/pagethree.component';
import { PagetwoComponent } from './pagetwo/pagetwo.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'employee', component: EmployeedetailsComponent },
  { path: 'admin', component: AdmindetailsComponent },
  { path: 'project', component: ProjectdetailsComponent },
  { path: 'salary', component: SalarydetailsComponent },
  { path: 'leave', component: LeavereportComponent },
  { path: 'projectreport', component: ProjectreportComponent },
  { path: 'addproject', component: AddprojectComponent },
  { path: 'addsalary', component: AddsalaryComponent },
  { path: 'pageone', component: PageoneComponent },
  { path: 'pagethree', component: PagethreeComponent },
  { path: 'pagetwo', component: PagetwoComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
