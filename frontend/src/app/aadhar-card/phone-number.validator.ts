import { AbstractControl } from "@angular/forms";

export class PhoneNumberValidator {
    static noRepeat(control: AbstractControl){
        let value:string = ""+control.value;
        console.log(value);
        if(value.match('^'+value[0]+'{'+value.length+'}$')){
            return {'noRepeat' : true}
        }
        return null;
    }
}