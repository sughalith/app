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
    return this.http.get<EventObject[]>('/api/event');
  }

  getById(id: number) {
    return this.http.get<EventObject>(`/api/event/` + id);
  }

  createEvent(event: EventObject) {
    this.isCreated = false;
    return this.http.post(`/api/event`, event, {observe: 'response'})
      .pipe(map(response => {
        this.isCreated = response.status === 200;
      }));
  }

}
