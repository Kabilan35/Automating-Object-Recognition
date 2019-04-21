import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Validators } from '@angular/forms';
import { AadharCardService } from './aadhar-card.service';
import { PhoneNumberValidator } from './phone-number.validator';
import { AadharCard } from './aadhar-card';

@Component({
  selector: 'app-aadhar-card',
  templateUrl: './aadhar-card.component.html',
  styleUrls: ['./aadhar-card.component.css']
})
export class AadharCardComponent implements OnInit {
  successMessage: string;
  errorMessage: string;
  myAadhar: AadharCard;

  myJSON :any;
  sample:any;
  arrOfElements:string ;
  aarrOfXpath:string;
  e :any;
  x :any;
  xpath:boolean = false ;
  elements:boolean = false;
  tableelements: string[];
  tablenames: string[];

  

  constructor(private fb: FormBuilder, private adharService: AadharCardService) { }

  ngOnInit() {
  }

  getAadharForm = this.fb.group({
    url: ['', [Validators.required
    ]]
  })

  getAadhar() {
    this.errorMessage = null
    this.successMessage = null
    this.myAadhar = null
   
    this.adharService.getAadhar(this.getAadharForm.value).then(adhar => {
      this.myAadhar = adhar;
      
     // this.myJSON = JSON.stringify(this.myAadhar);
    
           // this.arrOfkeys =Object.keys(adhar)
           // this.aarrOfvalues = Object.values(adhar)
  
            // console.log(this.arrOfkeys[1]);
            interface MyObj {
              
              element: string;
              element1: string;
          }
          let obj:MyObj  = JSON.parse(JSON.stringify(adhar));
          
          this.arrOfElements = JSON.stringify(obj.element);
          console.log(this.arrOfElements);
          this.aarrOfXpath = JSON.stringify(obj.element1);
          console.log(this.aarrOfXpath);
           this.x = "Successful" 
            // console.log(Object.values(adhar));
            // console.log(Object.keys(adhar));
          
     
    }).catch(error => {
      this.errorMessage = error.message
    })
  } 

  getelements(){
    this.xpath = false;
    this.elements = true;
   // console.log(JSON.parse(this.arrOfElements));
    this.e = JSON.parse(this.arrOfElements);
    this.tableelements = Object.keys(this.e);
    this.tablenames = Object.values(this.e);
  }
   
  getxpaths(){
       this.xpath = true;
       this.elements = false;
       //console.log(JSON.parse(this.aarrOfXpath));
    this.e = JSON.parse(this.aarrOfXpath);
    this.tableelements = Object.keys(this.e);
    this.tablenames = Object.values(this.e);
   }

  
  
 
}
