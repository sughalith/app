import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {EventObject} from '../_models/event';
import {map} from 'rxjs/internal/operators';

@Injectable()
export class EventService {

  isCreated: boolean;

  constructor(private http: HttpClient) {
  }

  getAll() {
    return this.http.get<EventObject[]>('http://localhost:8080/api/event');
  }

  getById(id: number) {
    return this.http.get<EventObject>(`http://localhost:8080/api/event/` + id);
  }

  createEvent(event: EventObject) {
    this.isCreated = false;
    return this.http.post(`http://localhost:8080/api/public/account`, event, {observe: 'response'})
      .pipe(map(response => {
        this.isCreated = response.status === 200;
      }));
  }

}
