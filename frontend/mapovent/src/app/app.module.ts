import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { MapComponent } from './map/map.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { EventComponent } from './event/event.component';
import {CommonModule} from "@angular/common";
import {FormsModule} from "@angular/forms";
import {AgmCoreModule} from "@agm/core";

@NgModule({
  declarations: [
    AppComponent,
    MapComponent,
    LoginComponent,
    RegisterComponent,
    EventComponent
  ],
  imports: [
    BrowserModule,
    CommonModule,
    FormsModule,
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyAaidD-ftX0Wy__fWgSKfcUUO-Jfu34QBg'
    })
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
