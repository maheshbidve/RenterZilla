import { PropertyService } from './../../services/property.service';
import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Property } from 'src/app/models/property.model';
import { PropertyType } from 'src/app/models/property.type.model';

@Component({
  selector: 'app-property-details',
  templateUrl: './property-details.component.html',
  styleUrls: ['./property-details.component.css'],
})
export class PropertyDetailsComponent implements OnInit {
  @Input() viewMode = false;

  @Input() currentProperty: Property = {
    type: PropertyType['2 BHK'],
    city: '',
    pincode: 0,
    address: '',
    available: false,
    latitude: 0,
    longitude: 0,
  };

  message = '';

  constructor(
    private propertyService: PropertyService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    if (!this.viewMode) {
      this.message = '';
      this.getProperty(this.route.snapshot.params['id']);
    }
  }

  getProperty(id: string): void {
    this.propertyService.get(id).subscribe({
      next: (data) => {
        this.currentProperty = data;
        console.log(data);
      },
      error: (e) => console.error(e),
    });
  }

  updateAvailable(status: boolean): void {
    const data = {
      typr: this.currentProperty.type,
      city: this.currentProperty.city,
      pincode: this.currentProperty.pincode,
      address: this.currentProperty.address,
      available: status,
    };

    this.message = '';

    this.propertyService
      .update(this.currentProperty.property_id, data)
      .subscribe({
        next: (res) => {
          console.log(res);
          this.currentProperty.available = status;
          this.message = res.message
            ? res.message
            : 'The status was updated successfully!';
        },
        error: (e) => console.error(e),
      });
  }

  updateProperty(): void {
    this.message = '';

    this.propertyService
      .update(this.currentProperty.property_id, this.currentProperty)
      .subscribe({
        next: (res) => {
          console.log(res);
          this.message = res.message
            ? res.message
            : 'This Property was updated successfully!';
        },
        error: (e) => console.error(e),
      });
  }

  deleteProperty(): void {
    this.propertyService.delete(this.currentProperty.property_id).subscribe({
      next: (res) => {
        console.log(res);
        this.router.navigate(['/properties']);
      },
      error: (e) => console.error(e),
    });
  }
}
