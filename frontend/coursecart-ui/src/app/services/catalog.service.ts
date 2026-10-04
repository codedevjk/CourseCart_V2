import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Course, CourseDetail, Category, Lesson, PageResponse } from '../models/catalog.model';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CatalogService {
  private apiUrl = `${environment.apiBaseUrl}/catalog`;

  constructor(private http: HttpClient) { }

  getCategories(): Observable<Category[]> {
    return this.http.get<Category[]>(`${this.apiUrl}/categories`);
  }

  createCategory(category: Category): Observable<Category> {
    return this.http.post<Category>(`${this.apiUrl}/categories`, category);
  }

  updateCategory(id: number, category: Category): Observable<Category> {
    return this.http.put<Category>(`${this.apiUrl}/categories/${id}`, category);
  }

  deleteCategory(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/categories/${id}`);
  }

  getCourses(categoryId?: number, search?: string, page?: number, size?: number): Observable<PageResponse<Course>> {
    let params = new HttpParams();
    if (categoryId !== undefined && categoryId !== null) params = params.set('categoryId', categoryId.toString());
    if (search) params = params.set('search', search);
    if (page !== undefined && page !== null) params = params.set('page', page.toString());
    if (size !== undefined && size !== null) params = params.set('size', size.toString());

    return this.http.get<PageResponse<Course>>(`${this.apiUrl}/courses`, { params });
  }

  getCourse(id: number): Observable<CourseDetail> {
    return this.http.get<CourseDetail>(`${this.apiUrl}/courses/${id}`);
  }

  getAdminCourses(): Observable<Course[]> {
    throw new Error('TODO[TRAINEE]: Fetch all courses for admin from catalog-service (US 05).');
  }

  createCourse(course: Course): Observable<Course> {
    throw new Error('TODO[TRAINEE]: Create new course via catalog-service (US 05).');
  }

  updateCourse(id: number, course: Course): Observable<Course> {
    throw new Error('TODO[TRAINEE]: Update existing course via catalog-service (US 05).');
  }

  updateCourseStatus(id: number, status: string): Observable<void> {
    throw new Error('TODO[TRAINEE]: Update course status via catalog-service (US 07).');
  }

  getCourseCount(): Observable<{ totalCourses: number }> {
    throw new Error('TODO[TRAINEE]: Fetch course count from catalog-service (US 15).');
  }

  getLessons(courseId: number): Observable<Lesson[]> {
    throw new Error('TODO[TRAINEE]: Fetch lessons for a course from catalog-service (US 06).');
  }

  createLesson(courseId: number, lesson: Lesson): Observable<Lesson> {
    throw new Error('TODO[TRAINEE]: Create lesson via catalog-service (US 06).');
  }

  updateLesson(courseId: number, lessonId: number, lesson: Lesson): Observable<Lesson> {
    throw new Error('TODO[TRAINEE]: Update lesson via catalog-service (US 06).');
  }

  deleteLesson(courseId: number, lessonId: number): Observable<void> {
    throw new Error('TODO[TRAINEE]: Delete lesson via catalog-service (US 06).');
  }
}
