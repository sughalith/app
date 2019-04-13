import {Component, OnInit} from '@angular/core';
import {MouseEvent} from '@agm/core';
import {ActivatedRoute, Router} from '@angular/router';


declare var google: any;

interface Marker {
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
  markerToAdd: Marker;
  ableToAdd = true;

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
  ]


  constructor(private route: ActivatedRoute,
              private router: Router) {
  }

  ngOnInit(): void {
  }

  clickedMarker(label: string, index: number) {
    console.log(`clicked the marker: ${label || index}`)
  }

  redirectEventDetails(id: number) {
    this.router.navigate(['/eventPanel']);
  }


  mapClicked($event: MouseEvent) {
    if (this.ableToAdd) {
      this.markers.push({
        id: this.markers.length,
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
}
