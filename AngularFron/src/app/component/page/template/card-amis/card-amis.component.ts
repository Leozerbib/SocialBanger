import { Component, Input } from '@angular/core';


@Component({
  selector: 'app-card-amis',
  templateUrl: './card-amis.component.html',
  styleUrls: ['./card-amis.component.scss','../../../../../../node_modules/bootstrap-icons/font/bootstrap-icons.css'],
  
})
export class CardAmisComponent {
  @Input() friendName: string = '';
  @Input() isConnected: boolean = false;
}
