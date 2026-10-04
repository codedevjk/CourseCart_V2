import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Enrollment } from '../models/enrollment.model';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class EnrollmentService {
  private apiUrl = `${environment.apiBaseUrl}/enrollments`;

  constructor(private http: HttpClient) { }

  getEnrollments(userId: number): Observable<Enrollment[]> {
    throw new Error('TODO[TRAINEE]: Fetch enrollments for user from enrollment-service (US 12).');
  }

  getLessonProgress(enrollmentId: number): Observable<number[]> {
    throw new Error('TODO[TRAINEE]: Fetch lesson progress for enrollment from enrollment-service (US 13).');
  }

  completeLesson(enrollmentId: number, lessonId: number, completed: boolean = true): Observable<void> {
    throw new Error('TODO[TRAINEE]: Toggle lesson completion via enrollment-service (US 14).');
  }

  getEnrollmentCount(): Observable<{ totalEnrollments: number }> {
    throw new Error('TODO[TRAINEE]: Fetch enrollment count from enrollment-service (US 15).');
  }
}
