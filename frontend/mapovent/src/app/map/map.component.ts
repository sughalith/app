import {Component, OnInit} from '@angular/core';
import {MouseEvent} from '@agm/core';
import {ActivatedRoute, Router} from '@angular/router';
import {EventService} from '../_services/eventService';
import {first} from 'rxjs/internal/operators';
import {EventObject} from '../_models/event';


declare var google: any;

class Marker {
  id: number;
  lat: number;
  lng: number;
  label?: string;
  description?: string;
  draggable: boolean;
}

interface Location {
  lat: number;
  lng: number;
  viewport?: Object;
  zoom: number;
  address_level_1?: string;
  address_level_2?: string;
  address_country?: string;
  address_zip?: string;
  address_state?: string;
  marker?: Marker;
}

@Component({
  selector: 'app-map',
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.css']
})
export class MapComponent implements OnInit {

  initZoom = 10;
  initLat = 54.3439;
  initLng = 18.6406;
  events: EventObject[] = [];
  ableToAdd = true;
  marker: Marker;

  markers: Marker[] = [
    {
      id: 1,
      lat: 54.673858,
      lng: 18.815982,
      label: '2',
      description: 'TEST',
      draggable: true
    },
    {
      id: 2,
      lat: 54.373858,
      lng: 18.215982,
      label: '1',
      description: 'JAZDA',
      draggable: false
    },
    {
      id: 3,
      lat: 54.723858,
      lng: 18.895982,
      label: '3',
      description: 'JAZDA',
      draggable: true
    }
  ];


  constructor(private route: ActivatedRoute,
              private eventService: EventService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.getAllEvents();
  }


  clickedMarker(label: string, index: number) {
    console.log(`clicked the marker: ${label || index}`);
  }

  redirectEventDetails(id: number, xlat: number, xlon: number) {
    if (id === -1) {
      this.router.navigate(['/eventCreatePanel'], {queryParams: {lat: xlat, lon: xlon}});
    } else {
      this.router.navigate(['/eventPanel', id]);
    }
  }

  mapClicked($event: MouseEvent) {
    if (this.ableToAdd) {
      this.markers.push({
        id: -1,
        lat: $event.coords.lat,
        lng: $event.coords.lng,
        draggable: true
      });
      this.ableToAdd = false;
    }
  }

  markerDragEnd(m: Marker, $event: MouseEvent) {
    console.log('dragEnd', m, $event);
  }

  private getAllEvents() {
    this.eventService.getAll().pipe(first()).subscribe(events => {
      this.events = events;
      this.events.forEach((event: EventObject) => {
          this.marker = new Marker();
          this.marker.lng = event.lon;
          this.marker.lat = event.lat;
          this.marker.id = event.id;
          this.marker.description = event.description;
          this.marker.label = event.title;
          this.marker.draggable = false;
          this.markers.push(this.marker);
        }
      );
    });
  }
}
