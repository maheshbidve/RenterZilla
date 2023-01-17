import { Component } from '@angular/core';
import { LatLong } from 'src/app/models/LatLong.model';
import { Property } from 'src/app/models/property.model';
import { PropertyService } from 'src/app/services/property.service';

@Component({
  selector: 'app-add-property',
  templateUrl: './add-property.component.html',
  styleUrls: ['./add-property.component.css'],
})
export class AddPropertyComponent {
  submitted = false;
  cordinates: LatLong = {
    lat: 0,
    long: 0,
  };

  property: Property = {
    type: '',
    city: '',
    address: '',
    pincode: 0,
    available: false,
    cordinates: this.cordinates,
  };

  constructor(private propertyService: PropertyService) {}

  saveProperty(): void {
    const data = {
      type: this.property.type,
      city: this.property.city,
      pincode: this.property.pincode,
      address: this.property.address,
      latitude: this.cordinates.lat,
      longitude: this.cordinates.long,
    };

    this.propertyService.create(data).subscribe({
      next: (res) => {
        console.log(res);
        this.submitted = true;
      },
      error: (e) => console.error(e),
    });
  }

  newProperty(): void {
    this.submitted = false;
    this.property = {
      type: '',
      city: '',
      pincode: 0,
      address: '',
      available: true,
    };
  }
  onLocation(location: LatLong): void {
    this.cordinates = location;
  }
}
