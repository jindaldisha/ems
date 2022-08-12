import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';


@Component({
  selector: 'app-view-employee',
  templateUrl: './view-employee.component.html',
  styleUrls: ['./view-employee.component.css']
})
export class ViewEmployeeComponent implements OnInit {

  employee: Employee = new Employee();
  id: number;

  constructor(private employeeService: EmployeeService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.getEmployeeById();
  }

  getEmployee(id: number){
    this.router.navigate(['employee', id]);
  }

  getEmployeeById(){
    this.employeeService.getEmployeeById(this.id).subscribe(data => {
      this.employee = data;
    });
  }

  updateEmployeeById(){
    this.employeeService.updateEmployeeById(this.id, this.employee).subscribe(data =>{
      // this.goToEmployeeList();
    })
  }

  deleteEmployeeById(){
    this.employeeService.deleteEmployeeById(this.id).subscribe(data =>{
      this.goToEmployeeList();
    })
  }

  goToEmployeeList(){
    this.router.navigate(['/employees']);
    // window.location.reload();

  }

  onEdit(id: number){
    this.router.navigate(['update-employee', id]);
  }
  


}
