import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable()
export class EventService {


  constructor(private http: HttpClient) {
  }

  getAll() {
    return this.http.get<Event[]>('http://localhost:8080/api/event');
  }

  getById(id: number) {
    return this.http.get(`http://localhost:8080/api/event/` + id);
  }

}
