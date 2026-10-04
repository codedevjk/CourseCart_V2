import { Component, OnInit } from '@angular/core';
import { CatalogService } from '../../../services/catalog.service';
import { Course, Category } from '../../../models/catalog.model';

@Component({
  selector: 'app-course-management',
  templateUrl: './course-management.component.html',
  styleUrls: ['./course-management.component.css']
})
export class CourseManagementComponent implements OnInit {

  courses: Course[] = [];
  categories: Category[] = [];
  
  isLoading = false;
  error = '';
  
  showForm = false;
  isEditing = false;
  currentCourse: any = { id: 0, categoryId: null, title: '', description: '', price: 0, status: 'DRAFT' };
  formError = '';
  
  showConfirmModal = false;
  confirmMessage = '';
  confirmAction: (() => void) | null = null;

  constructor(private catalogService: CatalogService) { }

  ngOnInit(): void {
    // TODO[TRAINEE]: Load categories and courses on init
  }

  loadCategories(): void {
    // TODO[TRAINEE]: Implement loadCategories
  }

  loadCourses(): void {
    // TODO[TRAINEE]: Implement loadCourses
  }

  openCreateModal(): void {
    // TODO[TRAINEE]: Implement openCreateModal
  }

  openEditModal(course: any): void {
    // TODO[TRAINEE]: Implement openEditModal
  }

  cancelEdit(): void {
    // TODO[TRAINEE]: Implement cancelEdit
  }

  saveCourse(): void {
    // TODO[TRAINEE]: Implement saveCourse (create or update)
  }

  changeStatus(course: Course, newStatus: string): void {
    // TODO[TRAINEE]: Implement changeStatus
  }

  getCategoryName(categoryId: number): string {
    // TODO[TRAINEE]: Implement getCategoryName
    return 'Unknown';
  }

  executeConfirm() {
    // TODO[TRAINEE]: Implement executeConfirm
  }
}

