import { Component, OnInit } from '@angular/core'
import { Stop } from '../Stop'
import { StopService} from '../stop.service'

@Component({
  selector: 'app-stops',
  templateUrl: './stops.component.html',
  styleUrls: ['./stops.component.scss']
})
export class StopsComponent implements OnInit {

  stops: Stop[];

  constructor(private stopService: StopService) { }
  

  ngOnInit() {
    this.getStops();
  }

  getStops(): void {
    this.stopService.getStops()
    .subscribe(stops => this.stops = stops);
  }
}
