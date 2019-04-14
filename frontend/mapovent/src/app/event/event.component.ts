import {Component, OnInit} from '@angular/core';
import {first} from 'rxjs/internal/operators';
import {MatSnackBar} from '@angular/material';
import {ActivatedRoute, Router} from '@angular/router';
import {EventService} from '../_services/eventService';
import {EventObject} from '../_models/event';

@Component({
  selector: 'app-event',
  templateUrl: './event.component.html',
  styleUrls: ['./event.component.css']
})
export class EventComponent implements OnInit {

  event: EventObject;
  eventId: string;


  constructor(private route: ActivatedRoute,
              private router: Router,
              private snackBar: MatSnackBar,
              private service: EventService) {
    this.eventId = this.route.snapshot.paramMap.get('id');
    service.getById(+this.eventId).pipe(first())
      .subscribe(event => {
        this.event = event;
      });
  }

  ngOnInit() {

  }

  redirectTabs() {
    this.router.navigate(['/mainPanel']);
  }

}
