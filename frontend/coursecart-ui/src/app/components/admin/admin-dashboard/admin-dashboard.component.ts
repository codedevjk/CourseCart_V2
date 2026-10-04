import { Component, OnInit } from '@angular/core';
import { CatalogService } from '../../../services/catalog.service';
import { EnrollmentService } from '../../../services/enrollment.service';
import { CommerceService } from '../../../services/commerce.service';
import { UserService } from '../../../services/user.service';

@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css']
})
export class AdminDashboardComponent implements OnInit {
  constructor(
    private catalogService: CatalogService,
    private enrollmentService: EnrollmentService,
    private commerceService: CommerceService,
    private userService: UserService
  ) { }

  ngOnInit(): void {
    // TODO[TRAINEE]: Load metrics and recent orders for admin dashboard (US 15)
  }
}