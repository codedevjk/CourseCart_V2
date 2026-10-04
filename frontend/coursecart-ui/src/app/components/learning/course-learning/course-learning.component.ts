import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CatalogService } from '../../../services/catalog.service';
import { EnrollmentService } from '../../../services/enrollment.service';
import { AuthService } from '../../../services/auth.service';

@Component({
  selector: 'app-course-learning',
  templateUrl: './course-learning.component.html',
  styleUrls: ['./course-learning.component.css']
})
export class CourseLearningComponent implements OnInit {
  courseId: number = 0;
  
  constructor(
    private route: ActivatedRoute,
    private catalogService: CatalogService,
    private enrollmentService: EnrollmentService,
    private authService: AuthService
  ) { }

  ngOnInit(): void {
    // TODO[TRAINEE]: Initialize course learning view and load progress (US 13, US 14)
  }
}