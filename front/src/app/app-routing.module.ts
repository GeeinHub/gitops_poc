import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {OrderListComponent} from './order-list/order-list.component';
import {OrderCreateComponent} from './order-create/order-create.component';
import {OrderDetailComponent} from './order-detail/order-detail.component';
import {OrderItemsComponent} from './order-items/order-items.component';
import {OrderComponent} from './order/order.component';
import {OrderEditComponent} from './order-edit/order-edit.component';
import {SoListComponent} from './so-list/so-list.component';
import {SoDetailComponent} from './so-detail/so-detail.component';
import {BookingListComponent} from './booking-list/booking-list.component';
import {SoCreateComponent} from './so-create/so-create.component';

const routes: Routes = [
  { path: 'order/list', component: OrderListComponent },
  { path: '', redirectTo: 'order/list', pathMatch: 'full' },
  { path: 'so/list', component: SoListComponent},
  { path: 'so/create', component: SoCreateComponent},
  {path: 'so/detail/:soNumber', component: SoDetailComponent},
  {path: 'booking/list', component: BookingListComponent},
  {path: 'order/detail/:poNum', component: OrderDetailComponent},
  {path: 'order/edit/:poNum', component: OrderEditComponent},
  {path: 'so/edit/:soNum', component: SoCreateComponent},
  {path: 'order/:consignee', component: OrderComponent, children: [
      {path: '', component: OrderCreateComponent},
      {path: 'items', component: OrderItemsComponent}
    ]}
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule { }
