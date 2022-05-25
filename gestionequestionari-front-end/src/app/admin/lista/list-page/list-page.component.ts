import { Component, OnInit } from '@angular/core';
import { AdminService } from '../../admin.service';

@Component({
  selector: 'app-list-page',
  templateUrl: './list-page.component.html',
  styleUrls: ['./list-page.component.css']
})

export class ListPageComponent implements OnInit {


  constructor(public admin:AdminService) {

  }

  userList:any
  dataSource:any

  ngOnInit(){

    this.admin.getUser(this.userList).subscribe(data=>{
      this.userList=data
      this.dataSource = this.userList;
      console.log(this.userList)
      },
      error=>{
        console.log(error)
      }
      )
  }

}
