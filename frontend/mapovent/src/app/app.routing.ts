import {RouterModule, Routes} from '@angular/router';
import {MapComponent} from './map/map.component';
import {LoginComponent} from './login/login.component';
import {RegisterComponent} from './register/register.component';
import {EventComponent} from './event/event.component';
import {MainComponent} from './main/main.component';


const appRoutes: Routes = [
  {path: 'mapPanel', component: MapComponent},

  {path: 'loginPanel', component: LoginComponent},

  {path: 'registerPanel', component: RegisterComponent},

  {path: 'eventCreatePanel', component: EventComponent}, // todo

  {path: 'eventPanel/:lat', component: EventComponent},

  {path: 'mainPanel/:id', component: MainComponent},


  // otherwise redirect to home
  {path: '**', component: MainComponent}
];

export const routing = RouterModule.forRoot(appRoutes);
