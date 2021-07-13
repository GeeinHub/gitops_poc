import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AppComponent } from './app.component';
import { FlatpickrModule  } from 'angularx-flatpickr';
import {HttpClientModule} from '@angular/common/http';
import { NgbModalModule } from '@ng-bootstrap/ng-bootstrap';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { TopBarComponent } from './top-bar/top-bar.component';
import { LeftBarComponent } from './left-bar/left-bar.component';
import { MainBodyComponent } from './main-body/main-body.component';
import { OrderListComponent } from './order-list/order-list.component';
import { OrderCreateComponent } from './order-create/order-create.component';
import { AppRoutingModule } from './app-routing.module';
import { OrderDetailComponent } from './order-detail/order-detail.component';
import { OrderItemsComponent } from './order-items/order-items.component';
import { OrderComponent } from './order/order.component';
import {FormsModule} from '@angular/forms';
import { CalendarModule, DateAdapter } from 'angular-calendar';
import { adapterFactory } from 'angular-calendar/date-adapters/moment';
import * as moment from 'moment';
import { OrderEditComponent } from './order-edit/order-edit.component';
import {UploadComponent} from './upload/upload.component';
import {SoDetailComponent} from './so-detail/so-detail.component';
import {SoListComponent} from './so-list/so-list.component';
import {SoDocumentsComponent} from './so-documents/so-documents.component';
import {SoCreateComponent} from './so-create/so-create.component';
import {SoContainersComponent} from './so-containers/so-containers.component';
import {BookingListComponent} from './booking-list/booking-list.component';
import {MilestoneComponent} from './milestone/milestone.component';
import { SoBodyComponent } from './so-body/so-body.component';
import { SoItemsComponent } from './so-items/so-items.component';
import { SoRoutesComponent } from './so-routes/so-routes.component';
import {SoDetailBodyComponent} from './so-detail-body/so-detail-body.component';
import { SoComponent } from './so/so.component';


export function momentAdapterFactory() {
  return adapterFactory(moment);
}

@NgModule({
  declarations: [
    AppComponent,
    TopBarComponent,
    LeftBarComponent,
    MainBodyComponent,
    OrderListComponent,
    OrderCreateComponent,
    OrderDetailComponent,
    OrderItemsComponent,
    OrderComponent,
    OrderEditComponent,
    UploadComponent,
    SoDetailComponent,
    SoListComponent,
    SoDetailComponent,
    SoDocumentsComponent,
    SoCreateComponent,
    SoContainersComponent,
    BookingListComponent,
    SoBodyComponent,
    BookingListComponent,
    MilestoneComponent,
    SoItemsComponent,
    SoRoutesComponent,
    SoDetailBodyComponent,
    SoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModalModule,
    FlatpickrModule.forRoot(),
    BrowserAnimationsModule,
    HttpClientModule,
    FormsModule,
    CommonModule,
    CalendarModule.forRoot({ provide: DateAdapter, useFactory: momentAdapterFactory })
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
