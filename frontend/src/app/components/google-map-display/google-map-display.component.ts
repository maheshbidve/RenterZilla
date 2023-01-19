import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { LatLong } from 'src/app/models/LatLong.model';

@Component({
  selector: 'app-google-map-display',
  templateUrl: './google-map-display.component.html',
  styleUrls: ['./google-map-display.component.css'],
})
export class GoogleMapDisplayComponent implements OnInit {
  @Output() cordinates = new EventEmitter<LatLong>();
  @Input()
  markerPositions: google.maps.LatLngLiteral[] = [];
  propertyLocation: LatLong = {
    lat: 0,
    long: 0,
  };
  constructor() {}
  ngOnInit(): void {
  }
  center: google.maps.LatLngLiteral = {
    lat: 18.5088,
    lng: 73.8567,
  };
  zoom = 10;
  markerOptions: google.maps.MarkerOptions = {
    draggable: true,
  };
  addMarker(event: google.maps.MapMouseEvent) {
    if (event.latLng != null) {
      this.markerPositions.push(event.latLng.toJSON());
      this.propertyLocation = {
        lat: event.latLng.lat(),
        long: event.latLng.lng(),
      };
      this.cordinates.emit(this.propertyLocation);
      console.log(event.latLng.toJSON());
    }
  }
}
