import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-event-create',
  templateUrl: './event-create.component.html',
  styleUrls: ['./event-create.component.css']
})
export class EventCreateComponent implements OnInit {

  lat: number;
  lon: number;

  constructor(private route: ActivatedRoute,
              private router: Router) {
  }

  ngOnInit() {
    this.route
      .queryParams
      .subscribe(params => {
        this.lat = +params['lat'] || 0;
        this.lon = +params['lon'] || 0;
        console.log(this.lat);
        console.log(this.lon);
      });
  }

}
