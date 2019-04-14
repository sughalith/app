import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {EventService} from '../_services/eventService';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {EventObject} from '../_models/event';
import {HelperErrorStateMatcher} from '../_helpers/HelperErrorStateMatcher';
import {first} from 'rxjs/internal/operators';
import {MatSnackBar} from '@angular/material';

@Component({
  selector: 'app-event-create',
  templateUrl: './event-create.component.html',
  styleUrls: ['./event-create.component.css']
})
export class EventCreateComponent implements OnInit {

  lat: number;
  lon: number;
  event: EventObject;
  eventAddFormGroup: FormGroup;
  matcher = new HelperErrorStateMatcher();
  titleFormControl: FormControl;
  descriptionFormControl: FormControl;

  constructor(private formBuilder: FormBuilder,
              private route: ActivatedRoute,
              private eventService: EventService,
              private router: Router,
              private snackBar: MatSnackBar) {
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

    this.event = new EventObject(this.lat, this.lon);
    this.eventAddFormGroup = this.formBuilder.group({});
    this.titleFormControl = new FormControl('', [
      Validators.required,
    ]);
    this.descriptionFormControl = new FormControl('', [
      Validators.required,
    ]);
  }

  formValid() {
    if (this.titleFormControl.valid
      && this.descriptionFormControl.valid) {
      return true;
    } else {
      return false;
    }
  }

  redirectTabs() {
    this.router.navigate(['/mainPanel']);
  }

  createEventAction() {
    if (this.formValid()) {
      this.eventService.createEvent(this.event)
        .pipe(first())
        .subscribe(
          data => {
            this.redirectTabs();
            this.snackBar.open('sukces', 'pomyślnie stworzono', {
              duration: 3000,
            });
          },
          error => {
            this.snackBar.open('error', 'błąd przy tworzeniu', {
              duration: 3000,
            });
          });

    }
  }

}
