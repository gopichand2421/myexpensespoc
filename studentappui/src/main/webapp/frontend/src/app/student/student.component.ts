import { Component } from "@angular/core";
import { FormControl, FormGroupDirective, NgForm, Validators } from "@angular/forms";
import { ErrorStateMatcher } from "@angular/material/core";


export class MyErrorStateMatcher implements ErrorStateMatcher{
    isErrorState(control: FormControl | null, form: FormGroupDirective | NgForm | null) : boolean {
        const isSubmitted = form && form.submitted;
        return !!(control && control.invalid && (control.dirty || control.touched || isSubmitted));
    }
}


@Component({
    selector: "student-component",
    templateUrl: "./student.component.html",
    styleUrls: ["./student.component.scss"]
})
export class StudentComponent{
    title = "student"
    isShowaddressform = false;
    hideButton = false;
    emailFormControl = new FormControl('',[Validators.required,Validators.email])
    matcher = new MyErrorStateMatcher();

    showForm(){
        this.isShowaddressform = true;
        this.hideButton = true;
        console.log("show form is triggered");
    }
    hideForm(){
        this.isShowaddressform = false;
        this.hideButton = false;
    }
}