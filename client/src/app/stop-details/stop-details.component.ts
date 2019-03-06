import { Component, OnInit, Input } from '@angular/core';
import { Stop } from "../stop"
import { ActivatedRoute } from '@angular/router'
import { Location } from '@angular/common'
import { StopService } from '../stop.service'

@Component({
  selector: 'app-stop-details',
  templateUrl: './stop-details.component.html',
  styleUrls: ['./stop-details.component.scss']
})
export class StopDetailsComponent implements OnInit {

  @Input() stop: Stop;

  constructor(
    private route: ActivatedRoute,
    private stopService: StopService,
    private location: Location
    ) {}

  ngOnInit(): void {
    this.getStop();
  }

  getStop(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.stopService.getStop(id)
      .subscribe(stop => this.stop = stop);
  }

  updateStop(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.stopService.updateStop(this.stop, id).subscribe(() => this.goBack());
  }

  goBack(): void {
    this.location.back();
  }
}
