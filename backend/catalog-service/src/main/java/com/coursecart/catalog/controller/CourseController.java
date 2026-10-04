package com.coursecart.catalog.controller;

import com.coursecart.catalog.dto.*;
import com.coursecart.catalog.service.CatalogService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/catalog/courses")
public class CourseController {

    private final CatalogService catalogService;

    public CourseController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    // --- PUBLIC COURSE APIs ---

    @GetMapping
    public ResponseEntity<Page<CourseDTO>> getActiveCourses(
            Pageable pageable,
            @RequestParam(required = false) Long categoryId,
            @RequestParam(required = false) String title) {
        return ResponseEntity.ok(catalogService.getActiveCourses(pageable, categoryId, title));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDetailDTO> getCourseById(@PathVariable Long id) {
        return ResponseEntity.ok(catalogService.getActiveCourseById(id));
    }

    // --- ADMIN COURSE APIs ---

    @GetMapping("/admin")
    public ResponseEntity<List<CourseDTO>> getAllCoursesAdmin() {
        throw new UnsupportedOperationException("TODO[TRAINEE]: Implement getAllCoursesAdmin");
    }

    @PostMapping
    public ResponseEntity<CourseDTO> createCourse(@Valid @RequestBody CourseRequest request) {
        throw new UnsupportedOperationException("TODO[TRAINEE]: Implement createCourse");
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseDTO> updateCourse(@PathVariable Long id, @Valid @RequestBody CourseRequest request) {
        throw new UnsupportedOperationException("TODO[TRAINEE]: Implement updateCourse");
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<CourseDTO> updateCourseStatus(@PathVariable Long id, @Valid @RequestBody CourseStatusRequest request) {
        throw new UnsupportedOperationException("TODO[TRAINEE]: Implement updateCourseStatus");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        throw new UnsupportedOperationException("TODO[TRAINEE]: Implement deleteCourse");
    }

    @GetMapping("/count")
    public ResponseEntity<Map<String, Long>> countCourses() {
        throw new UnsupportedOperationException("TODO[TRAINEE]: Implement countCourses for Admin Dashboard");
    }

    // --- LESSON APIs ---

    @GetMapping("/{courseId}/lessons")
    public ResponseEntity<List<LessonDTO>> getLessons(@PathVariable Long courseId) {
        throw new UnsupportedOperationException("TODO[TRAINEE]: Implement getLessons");
    }

    @PostMapping("/{courseId}/lessons")
    public ResponseEntity<LessonDTO> createLesson(@PathVariable Long courseId, @Valid @RequestBody LessonRequest request) {
        throw new UnsupportedOperationException("TODO[TRAINEE]: Implement createLesson");
    }

    @PutMapping("/{courseId}/lessons/{lessonId}")
    public ResponseEntity<LessonDTO> updateLesson(@PathVariable Long courseId, @PathVariable Long lessonId, @Valid @RequestBody LessonRequest request) {
        throw new UnsupportedOperationException("TODO[TRAINEE]: Implement updateLesson");
    }

    @DeleteMapping("/{courseId}/lessons/{lessonId}")
    public ResponseEntity<Void> deleteLesson(@PathVariable Long courseId, @PathVariable Long lessonId) {
        throw new UnsupportedOperationException("TODO[TRAINEE]: Implement deleteLesson");
    }
}

