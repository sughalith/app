export class EventObject {
  id: number;
  descreption: string;
  title: string;
  lat: number;
  lon: number;
  startDate: string;
  endDate: string;
  price: number;
  active: boolean;
  type: string;
  city: string;

  constructor(lat: number, lon: number) {
    this.lat = lat;
    this.lon = lon;
  }
}
