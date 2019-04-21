import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'aadharNumber'
})
export class AadharNumberPipe implements PipeTransform {

  transform(value: string, args?: any): any {
    return value.substr(0,4)+"-"+value.substr(4,4)+"-"+value.substr(8);
  }

}
