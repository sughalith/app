import {RouterModule, Routes} from '@angular/router';
import {AuthGuard} from './_guards/auth-guard';
import {MapComponent} from './map/map.component';
import {LoginComponent} from './login/login.component';
import {RegisterComponent} from './register/register.component';
import {EventComponent} from './event/event.component';


const appRoutes: Routes = [
  {path: 'mapPanel', component: MapComponent, canActivate: [AuthGuard]},

  {path: 'loginPanel', component: LoginComponent, canActivate: [AuthGuard]},

  {path: 'registerPanel', component: RegisterComponent, canActivate: [AuthGuard]},

  {path: 'eventPanel', component: EventComponent, canActivate: [AuthGuard]},


  // otherwise redirect to home
  {path: '**', redirectTo: ''}
];

export const routing = RouterModule.forRoot(appRoutes);
