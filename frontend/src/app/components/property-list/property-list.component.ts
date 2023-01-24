import { PropertyService } from './../../services/property.service';
import { Component, OnInit } from '@angular/core';
import { LatLong } from 'src/app/models/LatLong.model';
import { Property } from 'src/app/models/property.model';
import { PropertyType } from 'src/app/models/property.type.model';

@Component({
  selector: 'app-property-list',
  templateUrl: './property-list.component.html',
  styleUrls: ['./property-list.component.css'],
})
export class PropertyListComponent implements OnInit {
  properties?: Property[];
  currentProperty: Property = {
    latitude: 0,
    longitude: 0,
    type: PropertyType['2 BHK'],
  };
  currentIndex = -1;
  city = '';
  cor: google.maps.LatLngLiteral = {
    lat: 0,
    lng: 0,
  };
  propertyLocations: google.maps.LatLngLiteral[] = [];

  constructor(private propertyService: PropertyService) {}

  ngOnInit(): void {
    this.retrieveProperties();
  }

  retrieveProperties(): void {
    this.propertyService.getAll().subscribe({
      next: (data) => {
        this.properties = data;
        console.log(data);
        this.populateCordinates(data);
      },
      error: (e) => console.error(e),
    });
  }

  populateCordinates(data: Property[]): void {
    data.forEach((property) => {
      this.cor = {
        lat: property.latitude,
        lng: property.longitude,
      };
      this.propertyLocations.push(this.cor);
    });
  }
  refreshList(): void {
    this.retrieveProperties();
    this.currentProperty = {
      latitude: 0,
      type: PropertyType['2 BHK'],
      longitude: 0,
    };
    this.currentIndex = -1;
  }

  setActiveProperty(property: Property, index: number): void {
    this.currentProperty = property;
    this.currentIndex = index;
  }

  searchByCity(): void {
    this.currentProperty = {
      latitude: 0,
      longitude: 0,
      type: PropertyType['2 BHK'],
    };
    this.currentIndex = -1;

    this.propertyService.findByCity(this.city).subscribe({
      next: (data) => {
        this.properties = data;
        console.log(data);
      },
      error: (e) => console.error(e),
    });
  }
}
