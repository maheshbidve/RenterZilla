import { PropertyService } from './../../services/property.service';
import { Component, OnInit } from '@angular/core';
import { Property } from 'src/app/models/property.model';

@Component({
  selector: 'app-property-list',
  templateUrl: './property-list.component.html',
  styleUrls: ['./property-list.component.css'],
})
export class PropertyListComponent implements OnInit {
  properties?: Property[];
  currentProperty: Property = {};
  currentIndex = -1;
  city = '';

  constructor(private propertyService: PropertyService) {}

  ngOnInit(): void {
    this.retrieveProperties();
  }

  retrieveProperties(): void {
    this.propertyService.getAll().subscribe({
      next: (data) => {
        this.properties = data;
        console.log(data);
      },
      error: (e) => console.error(e),
    });
  }

  refreshList(): void {
    this.retrieveProperties();
    this.currentProperty = {};
    this.currentIndex = -1;
  }

  setActiveProperty(property: Property, index: number): void {
    this.currentProperty = property;
    this.currentIndex = index;
  }

  searchByCity(): void {
    this.currentProperty = {};
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
