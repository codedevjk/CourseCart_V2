import { Component, OnInit } from '@angular/core';
import { EnrollmentService } from '../../../services/enrollment.service';
import { AuthService } from '../../../services/auth.service';

@Component({
  selector: 'app-learning-dashboard',
  templateUrl: './learning-dashboard.component.html',
  styleUrls: ['./learning-dashboard.component.css']
})
export class LearningDashboardComponent implements OnInit {
  constructor(private enrollmentService: EnrollmentService, private authService: AuthService) { }

  ngOnInit(): void {
    // TODO[TRAINEE]: Load enrollments for learning dashboard (US 12)
  }
}