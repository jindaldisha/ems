import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateEmployeeComponent } from './create-employee/create-employee.component';

import { EmployeeListComponent } from './employee-list/employee-list.component';
import { UpdateEmployeeComponent } from './update-employee/update-employee.component';
import { ViewEmployeeComponent } from './view-employee/view-employee.component';

const routes: Routes = [
  // {path: '', redirectTo: 'employees', pathMatch: 'full'},
  {path: 'employees', component: EmployeeListComponent},
  {path: 'add', component: CreateEmployeeComponent},
  {path: 'employee/:id', component: ViewEmployeeComponent},
  {path: 'update-employee/:id', component: UpdateEmployeeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
