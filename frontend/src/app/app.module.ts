import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AadharCardComponent } from './aadhar-card/aadhar-card.component';
import { HttpModule } from '@angular/http';
import { AadharNumberPipe } from './aadhar-card/aadhar-number.pipe';
import { AadharCardService } from './aadhar-card/aadhar-card.service';

@NgModule({
  declarations: [
    AppComponent,
    AadharCardComponent,
    AadharNumberPipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpModule
  ],
  providers: [AadharCardService],
  bootstrap: [AppComponent]
})
export class AppModule { }
