import { LatLong } from 'src/app/models/LatLong.model';
export class Property {
  property_id?: any;
  type?: string;
  city?: string;
  pincode?: number;
  address?: string;
  available?: boolean;
  cordinates?: LatLong;
}
