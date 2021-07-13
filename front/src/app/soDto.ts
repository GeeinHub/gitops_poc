import {SoPartyDto} from './SoPartyDto';
import {SoItemDto} from './soItemDto';
import {SoIntendedRouteDto} from './soIntendedRouteDto';

export class SoDto {
   soNumber:string;
   status:string;
   customer:string;
   receiveDate:string;
   affiliate:string;
   usci:string;
   businessType:string;
   cargoType:string;
   freight:string;
   tradingTerm:string;
   transportMode:string;
   placeOfReceiptCity:string;
   placeOfReceiptDate:string;
   placeOfReceiptSameAsPolEtd:string;
   placeOfDelivery:string;
   cargoReadyDateType:string;
   cargoReadyDate:string;
   baNum:string;
   finalReceiver:string;
   preAssignBlNum:string;
   notifyPartyDto:SoPartyDto;
   alsoNotifyPartyDto:SoPartyDto;
   bookingPartyDto:SoPartyDto;
   shipperPartyDto:SoPartyDto;
   consigneeDto:SoPartyDto;
   factoryDto:SoPartyDto;
   itemDtos:SoItemDto[];
   soIntendedRouteDtos:SoIntendedRouteDto[];
}
