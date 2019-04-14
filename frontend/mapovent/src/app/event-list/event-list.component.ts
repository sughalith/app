import {Component, OnInit} from '@angular/core';
import {EventService} from '../_services/eventService';
import {first} from 'rxjs/internal/operators';
import {EventObject} from '../_models/event';

@Component({
  selector: 'app-event-list',
  templateUrl: './event-list.component.html',
  styleUrls: ['./event-list.component.css']
})
export class EventListComponent implements OnInit {

  events: EventObject[] = [];

  constructor(private eventService: EventService) {
  }

  ngOnInit() {
    this.getAllEvents();
  }

  private getAllEvents() {
    this.eventService.getAll().pipe(first()).subscribe(events => {
      this.events = events;
    });
  }
}
