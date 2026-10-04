import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CatalogService } from '../../../services/catalog.service';

@Component({
  selector: 'app-lesson-management',
  templateUrl: './lesson-management.component.html',
  styleUrls: ['./lesson-management.component.css']
})
export class LessonManagementComponent implements OnInit {
  courseId: number = 0;
  
  constructor(private route: ActivatedRoute, private catalogService: CatalogService) { }

  ngOnInit(): void {
    // TODO[TRAINEE]: Implement lesson management initialization (US 06)
  }
}