import { Component } from '@angular/core';
import { LatLong } from 'src/app/models/LatLong.model';
import { Property } from 'src/app/models/property.model';
import { PropertyService } from 'src/app/services/property.service';
import { NgbDropdownModule } from '@ng-bootstrap/ng-bootstrap';
import { PropertyType } from 'src/app/models/property.type.model';
import { Furnishing } from 'src/app/models/Furnishing.model';
import { Facing } from 'src/app/models/Facing.model';

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
    type: PropertyType['2 BHK'],
    city: '',
    address: '',
    pincode: 0,
    available: false,
    latitude: 0,
    longitude: 0,
    flatnumber: 0,
    floor: 0,
    building: '',
    street: '',
    furnishing: Furnishing['Fully-Furnished'],
    state: '',
    country: 'India',
    landmarks: '',
    descrption: '',
    baths: 0,
    balconies: 0,
    facing: Facing['EAST-SOUTH'],
    parkings: 0,
    area: 0,
    lift: true,
    age: 0,
    rent: 0,
    deposit: 0,
    maintenance: 0,
  };

  public propType: PropertyType = PropertyType['2 BHK'];
  propTypeKeys = Object.values(PropertyType).filter((v) => isNaN(Number(v)));

  public furnishing: Furnishing = Furnishing['Fully-Furnished'];
  furnishingKeys = Object.values(Furnishing).filter((v) => isNaN(Number(v)));

  constructor(private propertyService: PropertyService) {
    console.log(this.propTypeKeys);
  }

  saveProperty(): void {
    this.property.latitude = this.cordinates.lat as number;
    this.property.longitude = this.cordinates.long as number;

    this.propertyService.create(this.property).subscribe({
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
      type: PropertyType['2 BHK'],
      city: '',
      pincode: 0,
      address: '',
      available: true,
      latitude: 0,
      longitude: 0,
    };
  }
  onLocation(location: LatLong): void {
    this.cordinates = location;
  }
}
